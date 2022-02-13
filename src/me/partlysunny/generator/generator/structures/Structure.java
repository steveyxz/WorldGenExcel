package me.partlysunny.generator.generator.structures;

import me.partlysunny.Main;
import me.partlysunny.generator.Chunk;
import me.partlysunny.generator.TileType;
import me.partlysunny.generator.World;
import me.partlysunny.generator.generator.biomes.Biome;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

public abstract class Structure {

    private final float rarity;
    private final Biome[] canBeFoundIn;

    public Structure(float rarity, Biome[] canBeFoundIn) {
        this.rarity = rarity;
        this.canBeFoundIn = canBeFoundIn;
    }

    public float getRarity() {
        return rarity;
    }

    public Biome[] getCanBeFoundIn() {
        return canBeFoundIn;
    }

    public abstract StructureModel getModel();

    public void generateInto(World w) {
        try {
            //Load the model
            TileType[][] loaded = getModel().getTiles();
            if (loaded == null) {
                Main.logger.log(Level.SEVERE, "An error occurred while generating structure tiles");
                return;
            }
            Random r = new Random();
            //Loop through chunks
            for (int i = 0; i < w.getWidth(); i++) {
                for (int j = 0; j < w.getHeight(); j++) {
                    if (!List.of(canBeFoundIn).contains(w.getChunk(i, j).getBiome())) {
                        continue;
                    }
                    //If this chunk is chosen for this structure
                    if (r.nextDouble() < rarity) {
                        //Place it in a random position in the chunk
                        int xPos = r.nextInt(Chunk.chunkWidth - (loaded.length % Chunk.chunkWidth));
                        int yPos = r.nextInt(Chunk.chunkHeight - (loaded[0].length % Chunk.chunkHeight));
                        //Loop through the structure
                        for (int k = 0; k < loaded.length; k++) {
                            int y = j + (k + yPos) / Chunk.chunkHeight;
                            if (y >= w.getHeight()) {
                                break;
                            }
                            for (int l = 0; l < loaded[0].length; l++) {
                                int x = i + (l + xPos) / Chunk.chunkWidth;
                                if (x >= w.getWidth()) {
                                    break;
                                }
                                if (loaded[k][l] != null) {
                                    w.getChunk(x, y).setTileAt((l + xPos) % Chunk.chunkWidth, (k + yPos) % Chunk.chunkHeight, loaded[k][l]);
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package me.partlysunny.chunks.generator.generators;

import me.partlysunny.chunks.Chunk;
import me.partlysunny.chunks.TileType;
import me.partlysunny.chunks.generator.Generator;
import me.partlysunny.chunks.generator.biomes.Biome;

import java.util.Random;

public class DesertGenerator implements Generator {
    @Override
    public Chunk generate(Biome b) {
        Chunk c = new Chunk(Biome.DESERT);
        Random r = new Random();
        for (int i = 0; i < Chunk.chunkWidth; i++) {
            for (int j = 0; j < Chunk.chunkHeight; j++) {
                //If there is not already a tile there
                if (c.getTileAt(i, j) == null) {
                    c.setTileAt(i, j, TileType.SAND);
                    //Check if there is enough room to place a cactus
                    if (i < Chunk.chunkWidth - 1 && j < Chunk.chunkHeight - 1) {
                        //1 / 100 chance
                        if (r.nextInt(100) < 1) {
                            //Place a cactus (2 by 2)
                            c.setTileAt(i, j, TileType.CACTUS);
                            c.setTileAt(i + 1, j, TileType.CACTUS);
                            c.setTileAt(i + 1, j + 1, TileType.CACTUS);
                            c.setTileAt(i, j + 1, TileType.CACTUS);
                        }
                    }
                }
            }
        }
        return c;
    }
}

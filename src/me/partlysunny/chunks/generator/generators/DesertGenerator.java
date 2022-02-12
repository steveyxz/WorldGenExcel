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
                }
            }
        }
        return c;
    }
}

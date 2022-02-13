package me.partlysunny.generator.generator.generators;

import me.partlysunny.generator.Chunk;
import me.partlysunny.generator.TileType;
import me.partlysunny.generator.generator.Generator;
import me.partlysunny.generator.generator.biomes.Biome;

public class ForestGenerator implements Generator {
    @Override
    public Chunk generate(Biome b) {
        Chunk c = new Chunk(Biome.OAK_FOREST);
        for (int i = 0; i < Chunk.chunkWidth; i++) {
            for (int j = 0; j < Chunk.chunkHeight; j++) {
                c.setTileAt(i, j, TileType.GRASS);
            }
        }
        return c;
    }
}

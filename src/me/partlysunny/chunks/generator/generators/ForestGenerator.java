package me.partlysunny.chunks.generator.generators;

import me.partlysunny.chunks.Chunk;
import me.partlysunny.chunks.TileType;
import me.partlysunny.chunks.generator.Generator;
import me.partlysunny.chunks.generator.biomes.Biome;

public class ForestGenerator implements Generator {
    @Override
    public Chunk generate(Biome b) {
        Chunk c = new Chunk(Biome.FOREST);
        for (int i = 0; i < Chunk.chunkWidth; i++) {
            for (int j = 0; j < Chunk.chunkHeight; j++) {
                c.setTileAt(i, j, TileType.GRASS);
            }
        }
        return c;
    }
}

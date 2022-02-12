package me.partlysunny.chunks.generator.generators;

import me.partlysunny.chunks.Chunk;
import me.partlysunny.chunks.TileType;
import me.partlysunny.chunks.generator.Generator;
import me.partlysunny.chunks.generator.biomes.Biome;

public class PrairieGenerator implements Generator {
    @Override
    public Chunk generate(Biome b) {
        Chunk c = new Chunk(Biome.PRAIRIE);
        for (int i = 0; i < Chunk.chunkWidth; i++) {
            for (int j = 0; j < Chunk.chunkHeight; j++) {
                //If there is not already a tile there
                if (c.getTileAt(i, j) == null) {
                    c.setTileAt(i, j, TileType.DRY_GRASS);
                }
            }
        }
        return c;
    }
}

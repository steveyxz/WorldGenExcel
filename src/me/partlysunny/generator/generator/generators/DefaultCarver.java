package me.partlysunny.generator.generator.generators;

import me.partlysunny.generator.Chunk;
import me.partlysunny.generator.generator.biomes.Biome;

public class DefaultCarver {

    private static final int CARVE_DISTANCE = 4;

    public static Chunk carve(Chunk original, Biome topLeft, Biome topRight, Biome bottomLeft, Biome bottomRight) {
        if (topLeft != null && original.getBiome() != topLeft) {
            for (int i = 0; i < Chunk.chunkWidth / 2; i++) {
                for (int j = 0; j < Chunk.chunkHeight / 2; j++) {
                    if (Math.sqrt(i * i + j * j) <= CARVE_DISTANCE) {
                        original.setTileAt(i, j, topLeft.getDefaultTileType());
                    }
                }
            }
        }
        if (topRight != null && original.getBiome() != topRight) {
            for (int i = 0; i < Chunk.chunkWidth / 2; i++) {
                for (int j = 0; j < Chunk.chunkHeight / 2; j++) {
                    if (Math.sqrt(i * i + j * j) <= CARVE_DISTANCE) {
                        original.setTileAt(Chunk.chunkWidth - 1 - i, j, topRight.getDefaultTileType());
                    }
                }
            }
        }
        if (bottomLeft != null && original.getBiome() != bottomLeft) {
            for (int i = 0; i < Chunk.chunkWidth / 2; i++) {
                for (int j = 0; j < Chunk.chunkHeight / 2; j++) {
                    if (Math.sqrt(i * i + j * j) <= CARVE_DISTANCE) {
                        original.setTileAt(i, Chunk.chunkHeight - 1 - j, bottomLeft.getDefaultTileType());
                    }
                }
            }
        }
        if (bottomRight != null && original.getBiome() != bottomRight) {
            for (int i = 0; i < Chunk.chunkWidth / 2; i++) {
                for (int j = 0; j < Chunk.chunkHeight / 2; j++) {
                    if (Math.sqrt(i * i + j * j) <= CARVE_DISTANCE) {
                        original.setTileAt(Chunk.chunkWidth - 1 - i, Chunk.chunkHeight - 1 - j, bottomRight.getDefaultTileType());
                    }
                }
            }
        }
        return original;
    }

}

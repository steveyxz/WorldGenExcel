package me.partlysunny.generator;

import me.partlysunny.generator.generator.biomes.Biome;

public class Chunk {

    public static final int chunkWidth = 10;
    public static final int chunkHeight = 10;
    private final Biome biome;
    private final TileType[][] colors = new TileType[chunkWidth][chunkHeight];

    public Chunk(Biome biome) {
        this.biome = biome;
    }

    public void setTileAt(int x, int y, TileType type) {
        colors[x][y] = type;
    }

    public TileType getTileAt(int x, int y) {
        return colors[x][y];
    }

    public Biome getBiome() {
        return biome;
    }
}

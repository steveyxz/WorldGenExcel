package me.partlysunny.generator.generator.biomes;

import me.partlysunny.generator.Chunk;
import me.partlysunny.generator.TileType;
import me.partlysunny.generator.generator.Generator;
import me.partlysunny.generator.generator.generators.*;
import me.partlysunny.utils.RandomCollection;

public enum Biome {

    DESERT(6, 0.7f, 340, new DesertGenerator(), TileType.SAND),
    OCEAN(5, 0.9f, 640, new OceanGenerator(), TileType.WATER),
    GRASSLANDS(6, 0.6f, 250, new GrasslandGenerator(), TileType.GRASS),
    OAK_FOREST(3, 0.5f, 150, new ForestGenerator(), TileType.GRASS),
    MOUNTAINS(4, 0.5f, 100, new MountainGenerator(), TileType.ROCK),
    SNOWY_PLAINS(1, 0.8f, 250, new SnowGenerator(), TileType.SNOW),
    SNOWY_FOREST(1, 0.8f, 250, new SnowGenerator(), TileType.SNOW),
    BIRCH_FOREST(3, 0.5f, 150, new ForestGenerator(), TileType.GRASS);

    private static final RandomCollection<Biome> randomChoicer = new RandomCollection<>();

    static {
        for (Biome b : values()) {
            randomChoicer.add(b.getWeight(), b);
        }
    }

    private final float spreadChance;
    //In chunks
    private final float maxSize;
    private final int weight;
    private final Generator generator;
    private final TileType defaultTileType;

    Biome(int weight, float spreadChance, float maxSize, Generator generator, TileType defaultTileType) {
        this.maxSize = maxSize;
        this.spreadChance = spreadChance;
        this.weight = weight;
        this.generator = generator;
        this.defaultTileType = defaultTileType;
    }

    public static Biome getRandomBiome() {
        return randomChoicer.next();
    }

    public float getSpreadChance() {
        return spreadChance;
    }

    public float getMaxSize() {
        return maxSize;
    }

    public int getWeight() {
        return weight;
    }

    public Generator getGenerator() {
        return generator;
    }

    public TileType getDefaultTileType() {
        return defaultTileType;
    }

    public Chunk generate() {
        return generator.generate(this);
    }
}

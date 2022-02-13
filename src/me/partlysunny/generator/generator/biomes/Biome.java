package me.partlysunny.generator.generator.biomes;

import me.partlysunny.generator.Chunk;
import me.partlysunny.generator.TileType;
import me.partlysunny.generator.generator.Generator;
import me.partlysunny.generator.generator.biomes.restrictions.*;
import me.partlysunny.generator.generator.generators.*;
import me.partlysunny.utils.RandomCollection;

import java.util.List;

public enum Biome {

    DESERT(6, 0.7f, 340, new DesertGenerator(), TileType.SAND, new DesertRestrictions()),
    OCEAN(5, 0.9f, 640, new OceanGenerator(), TileType.WATER, new GrasslandRestrictions()),
    GRASSLANDS(6, 0.6f, 250, new GrasslandGenerator(), TileType.GRASS, new GrasslandRestrictions()),
    OAK_FOREST(3, 0.5f, 150, new ForestGenerator(), TileType.GRASS, new ForestRestrictions()),
    MOUNTAINS(4, 0.5f, 100, new MountainGenerator(), TileType.ROCK, new MountainRestrictions()),
    SNOWY_PLAINS(1, 0.8f, 250, new SnowGenerator(), TileType.SNOW, new SnowRestrictions()),
    SNOWY_FOREST(1, 0.8f, 250, new SnowGenerator(), TileType.SNOW, new SnowRestrictions()),
    BIRCH_FOREST(3, 0.5f, 150, new ForestGenerator(), TileType.GRASS, new ForestRestrictions());

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
    private final Restriction restrictions;

    Biome(int weight, float spreadChance, float maxSize, Generator generator, TileType defaultTileType, Restriction restrictions) {
        this.maxSize = maxSize;
        this.spreadChance = spreadChance;
        this.weight = weight;
        this.generator = generator;
        this.defaultTileType = defaultTileType;
        this.restrictions = restrictions;
    }

    public static Biome getRandomBiome(Biome nextTo) {
        Biome next = randomChoicer.next();
        if (List.of(nextTo.restrictions.generationRestrictions()).contains(next)) {
            return next;
        } else {
            return getRandomBiome(nextTo);
        }
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

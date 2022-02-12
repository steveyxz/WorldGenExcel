package me.partlysunny.chunks.generator.biomes;

import me.partlysunny.chunks.Chunk;
import me.partlysunny.chunks.generator.Generator;
import me.partlysunny.chunks.generator.generators.*;
import me.partlysunny.utils.RandomCollection;

public enum Biome {

    DESERT(4, 0.7f, 100, new DesertGenerator()),
    OCEAN(2, 0.7f, 120, new OceanGenerator()),
    GRASSLANDS(8, 0.6f, 90, new GrasslandGenerator()),
    PRAIRIE(3, 0.6f, 70, new PrairieGenerator()),
    MOUNTAINS(4, 0.5f, 40, new MountainGenerator());

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

    Biome(int weight, float spreadChance, float maxSize, Generator generator) {
        this.maxSize = maxSize;
        this.spreadChance = spreadChance;
        this.weight = weight;
        this.generator = generator;
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

    public Chunk generate() {
        return generator.generate(this);
    }
}

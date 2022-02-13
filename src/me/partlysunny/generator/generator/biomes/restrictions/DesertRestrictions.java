package me.partlysunny.generator.generator.biomes.restrictions;

import me.partlysunny.generator.generator.biomes.Biome;

public class DesertRestrictions implements Restriction {
    @Override
    public Biome[] generationRestrictions() {
        return new Biome[] {Biome.GRASSLANDS, Biome.DESERT, Biome.OAK_FOREST, Biome.OCEAN, Biome.BIRCH_FOREST};
    }
}

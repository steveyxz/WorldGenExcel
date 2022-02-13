package me.partlysunny.generator.generator.biomes.restrictions;

import me.partlysunny.generator.generator.biomes.Biome;

public class SnowRestrictions implements Restriction {
    @Override
    public Biome[] generationRestrictions() {
        return new Biome[] {Biome.GRASSLANDS, Biome.MOUNTAINS, Biome.SNOWY_PLAINS, Biome.SNOWY_FOREST, Biome.OAK_FOREST};
    }
}

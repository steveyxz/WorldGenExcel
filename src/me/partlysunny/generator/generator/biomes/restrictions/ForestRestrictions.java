package me.partlysunny.generator.generator.biomes.restrictions;

import me.partlysunny.generator.generator.biomes.Biome;

public class ForestRestrictions implements Restriction {
    @Override
    public Biome[] generationRestrictions() {
        return new Biome[] {Biome.GRASSLANDS, Biome.OAK_FOREST, Biome.SNOWY_FOREST, Biome.SNOWY_PLAINS, Biome.MOUNTAINS, Biome.BIRCH_FOREST};
    }
}

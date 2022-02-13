package me.partlysunny.generator.generator.biomes.restrictions;

import me.partlysunny.generator.generator.biomes.Biome;

public class MountainRestrictions implements Restriction {
    @Override
    public Biome[] generationRestrictions() {
        return new Biome[] {Biome.GRASSLANDS, Biome.OCEAN, Biome.DESERT, Biome.SNOWY_PLAINS};
    }
}

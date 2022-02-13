package me.partlysunny.generator.generator.biomes.restrictions;

import me.partlysunny.generator.generator.biomes.Biome;

public class EmptyRestrictions implements Restriction {
    @Override
    public Biome[] generationRestrictions() {
        return new Biome[0];
    }
}

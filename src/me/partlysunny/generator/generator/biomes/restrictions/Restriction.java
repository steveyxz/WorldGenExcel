package me.partlysunny.generator.generator.biomes.restrictions;

import me.partlysunny.generator.generator.biomes.Biome;

public interface Restriction {
    //Where the biome can spawn in
    Biome[] generationRestrictions();
}

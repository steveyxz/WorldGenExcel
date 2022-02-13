package me.partlysunny.generator.generator;

import me.partlysunny.generator.Chunk;
import me.partlysunny.generator.generator.biomes.Biome;

public interface Generator {
    //Default method to generate a chunk in a biome
    Chunk generate(Biome b);
}

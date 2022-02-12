package me.partlysunny.chunks.generator;

import me.partlysunny.chunks.Chunk;
import me.partlysunny.chunks.generator.biomes.Biome;

public interface Generator {
    //Default method to generate a chunk in a biome
    Chunk generate(Biome b);
}

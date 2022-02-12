package me.partlysunny.chunks.generator.structures.rocks;

import me.partlysunny.chunks.generator.biomes.Biome;
import me.partlysunny.chunks.generator.structures.Structure;
import me.partlysunny.chunks.generator.structures.StructureModel;

public class LargeRock extends Structure {
    public LargeRock() {
        super(0.004f, new Biome[] {Biome.GRASSLANDS, Biome.DESERT});
    }

    @Override
    public StructureModel getModel() {
        return new StructureModel("models/largeRock.mdl");
    }
}
package me.partlysunny.chunks.generator.structures.cactus;

import me.partlysunny.chunks.generator.biomes.Biome;
import me.partlysunny.chunks.generator.structures.Structure;
import me.partlysunny.chunks.generator.structures.StructureModel;

public class Cactus extends Structure {
    public Cactus() {
        super(0.05f, new Biome[]{Biome.DESERT});
    }

    @Override
    public StructureModel getModel() {
        return new StructureModel("models/cactus.mdl");
    }
}

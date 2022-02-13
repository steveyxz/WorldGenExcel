package me.partlysunny.generator.generator.structures.cactus;

import me.partlysunny.generator.generator.biomes.Biome;
import me.partlysunny.generator.generator.structures.Structure;
import me.partlysunny.generator.generator.structures.StructureModel;

public class Cactus extends Structure {
    public Cactus() {
        super(0.05f, new Biome[]{Biome.DESERT});
    }

    @Override
    public StructureModel getModel() {
        return new StructureModel("models/cactus.mdl");
    }
}

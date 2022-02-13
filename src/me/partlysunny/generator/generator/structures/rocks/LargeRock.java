package me.partlysunny.generator.generator.structures.rocks;

import me.partlysunny.generator.generator.biomes.Biome;
import me.partlysunny.generator.generator.structures.Structure;
import me.partlysunny.generator.generator.structures.StructureModel;

import static me.partlysunny.generator.generator.biomes.Biome.OAK_FOREST;

public class LargeRock extends Structure {
    public LargeRock() {
        super(0.004f, new Biome[]{Biome.GRASSLANDS, Biome.DESERT, OAK_FOREST});
    }

    @Override
    public StructureModel getModel() {
        return new StructureModel("models/largeRock.mdl");
    }
}

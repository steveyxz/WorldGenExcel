package me.partlysunny.generator.generator.structures.tree;

import me.partlysunny.generator.generator.biomes.Biome;
import me.partlysunny.generator.generator.structures.Structure;
import me.partlysunny.generator.generator.structures.StructureModel;

public class BirchTree extends Structure {
    public BirchTree() {
        super(0.9f, new Biome[] {Biome.BIRCH_FOREST});
    }

    @Override
    public StructureModel getModel() {
        return new StructureModel("models/birchTree.mdl");
    }
}

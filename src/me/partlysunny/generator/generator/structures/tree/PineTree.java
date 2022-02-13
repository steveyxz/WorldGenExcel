package me.partlysunny.generator.generator.structures.tree;

import me.partlysunny.generator.generator.biomes.Biome;
import me.partlysunny.generator.generator.structures.Structure;
import me.partlysunny.generator.generator.structures.StructureModel;

public class PineTree extends Structure {
    public PineTree() {
        super(0.7f, new Biome[] {Biome.SNOWY_FOREST});
    }

    @Override
    public StructureModel getModel() {
        return new StructureModel("models/pineTree.mdl");
    }
}

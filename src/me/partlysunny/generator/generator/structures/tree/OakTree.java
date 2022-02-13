package me.partlysunny.generator.generator.structures.tree;

import me.partlysunny.generator.generator.biomes.Biome;
import me.partlysunny.generator.generator.structures.Structure;
import me.partlysunny.generator.generator.structures.StructureModel;

public class OakTree extends Structure {
    public OakTree() {
        super(0.9f, new Biome[]{Biome.OAK_FOREST});
    }

    @Override
    public StructureModel getModel() {
        return new StructureModel("models/oak_tree.mdl");
    }
}

package me.partlysunny.chunks.generator.structures.tree;

import me.partlysunny.chunks.generator.biomes.Biome;
import me.partlysunny.chunks.generator.structures.Structure;
import me.partlysunny.chunks.generator.structures.StructureModel;

public class Tree extends Structure {
    public Tree() {
        super(0.9f, new Biome[]{Biome.FOREST});
    }

    @Override
    public StructureModel getModel() {
        return new StructureModel("models/tree.mdl");
    }
}

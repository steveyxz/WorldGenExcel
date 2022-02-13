package me.partlysunny.generator.generator.structures.tree;

import me.partlysunny.generator.generator.biomes.Biome;
import me.partlysunny.generator.generator.structures.Structure;
import me.partlysunny.generator.generator.structures.StructureModel;

public class GrasslandTree extends Structure {
    public GrasslandTree() {
        super(0.1f, new Biome[] {Biome.GRASSLANDS});
    }

    @Override
    public StructureModel getModel() {
        return new StructureModel("models/grasslandTree.mdl");
    }
}

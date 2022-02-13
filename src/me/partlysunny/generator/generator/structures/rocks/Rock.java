package me.partlysunny.generator.generator.structures.rocks;

import me.partlysunny.generator.generator.biomes.Biome;
import me.partlysunny.generator.generator.structures.Structure;
import me.partlysunny.generator.generator.structures.StructureModel;

public class Rock extends Structure {
    public Rock() {
        super(0.01f, new Biome[]{Biome.GRASSLANDS, Biome.DESERT, Biome.OAK_FOREST});
    }

    @Override
    public StructureModel getModel() {
        return new StructureModel("models/rock.mdl");
    }
}

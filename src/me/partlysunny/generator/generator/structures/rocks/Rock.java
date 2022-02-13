package me.partlysunny.generator.generator.structures.rocks;

import me.partlysunny.generator.generator.biomes.Biome;
import me.partlysunny.generator.generator.structures.Structure;
import me.partlysunny.generator.generator.structures.StructureModel;

import static me.partlysunny.generator.generator.biomes.Biome.BIRCH_FOREST;
import static me.partlysunny.generator.generator.biomes.Biome.SNOWY_PLAINS;

public class Rock extends Structure {
    public Rock() {
        super(0.01f, new Biome[]{Biome.GRASSLANDS, Biome.DESERT, Biome.OAK_FOREST, BIRCH_FOREST, SNOWY_PLAINS});
    }

    @Override
    public StructureModel getModel() {
        return new StructureModel("models/rock.mdl");
    }
}

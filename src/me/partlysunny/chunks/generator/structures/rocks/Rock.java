package me.partlysunny.chunks.generator.structures.rocks;

import me.partlysunny.chunks.generator.biomes.Biome;
import me.partlysunny.chunks.generator.structures.Structure;
import me.partlysunny.chunks.generator.structures.StructureModel;

public class Rock extends Structure {
    public Rock() {
        super(0.01f, new Biome[]{Biome.GRASSLANDS, Biome.DESERT, Biome.OAK_FOREST});
    }

    @Override
    public StructureModel getModel() {
        return new StructureModel("models/rock.mdl");
    }
}

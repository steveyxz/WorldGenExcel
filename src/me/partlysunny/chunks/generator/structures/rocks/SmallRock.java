package me.partlysunny.chunks.generator.structures.rocks;

import me.partlysunny.chunks.generator.biomes.Biome;
import me.partlysunny.chunks.generator.structures.Structure;
import me.partlysunny.chunks.generator.structures.StructureModel;

import static me.partlysunny.chunks.generator.biomes.Biome.OAK_FOREST;

public class SmallRock extends Structure {
    public SmallRock() {
        super(0.03f, new Biome[]{Biome.GRASSLANDS, Biome.DESERT, OAK_FOREST});
    }

    @Override
    public StructureModel getModel() {
        return new StructureModel("models/smallRock.mdl");
    }
}

package me.partlysunny.generator.generator.structures;

import me.partlysunny.Main;
import me.partlysunny.generator.World;
import me.partlysunny.generator.generator.structures.cactus.Cactus;
import me.partlysunny.generator.generator.structures.rocks.LargeRock;
import me.partlysunny.generator.generator.structures.rocks.Rock;
import me.partlysunny.generator.generator.structures.rocks.SmallRock;
import me.partlysunny.generator.generator.structures.tree.GrasslandTree;
import me.partlysunny.generator.generator.structures.tree.OakTree;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;

public enum StructureType {
    SMALL_ROCK(SmallRock.class),
    ROCK(Rock.class),
    LARGE_ROCK(LargeRock.class),
    CACTUS(Cactus.class),
    OAK_TREE(OakTree.class),
    GRASSLAND_TREE(GrasslandTree.class)
    ;

    private final Class<? extends Structure> clazz;
    private Structure impl;

    StructureType(Class<? extends Structure> clazz) {
        this.clazz = clazz;
        try {
            this.impl = clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void loadStructures(World w) {
        Main.logger.log(Level.INFO, "Generating structures...");
        for (StructureType t : values()) {
            t.addThis(w);
        }
    }

    public Class<? extends Structure> getClazz() {
        return clazz;
    }

    public void addThis(World world) {
        impl.generateInto(world);
    }
}

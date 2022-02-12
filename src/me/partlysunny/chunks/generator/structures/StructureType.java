package me.partlysunny.chunks.generator.structures;

import me.partlysunny.Main;
import me.partlysunny.chunks.World;
import me.partlysunny.chunks.generator.structures.cactus.Cactus;
import me.partlysunny.chunks.generator.structures.rocks.LargeRock;
import me.partlysunny.chunks.generator.structures.rocks.Rock;
import me.partlysunny.chunks.generator.structures.rocks.SmallRock;
import me.partlysunny.chunks.generator.structures.tree.Tree;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;

public enum StructureType {
    SMALL_ROCK(SmallRock.class),
    ROCK(Rock.class),
    LARGE_ROCK(LargeRock.class),
    CACTUS(Cactus.class),
    TREE(Tree.class);

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

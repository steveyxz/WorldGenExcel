package me.partlysunny.chunks.generator.generators;

import me.partlysunny.chunks.World;
import me.partlysunny.chunks.generator.biomes.Biome;
import me.partlysunny.chunks.generator.biomes.BiomeGenerator;
import me.partlysunny.chunks.generator.structures.StructureType;
import me.partlysunny.utils.Pair;

public class WorldGenerator {

    public static final int worldWidth = 200;
    public static final int worldHeight = 200;
    private final Biome[][] biomeMap;

    public WorldGenerator() {
        biomeMap = new BiomeGenerator().generateBiomeMap();
    }

    public World generateWorld() {
        World w = new World(worldWidth, worldHeight);
        for (int i = 0; i < worldWidth; i++) {
            for (int j = 0; j < worldHeight; j++) {
                Biome biome = biomeMap[i][j];
                //top, bottom, left, right tiles
                Pair<Integer> top = new Pair<>(i, j - 1);
                Pair<Integer> bottom = new Pair<>(i, j + 1);
                Pair<Integer> left = new Pair<>(i - 1, j);
                Pair<Integer> right = new Pair<>(i + 1, j);
                if (biome == null) {
                    //Check if top is allowed and it is empty
                    if (!(top.getA() < 0 || top.getA() > worldHeight - 1 || top.getB() < 0 || top.getB() > worldWidth - 1 || biomeMap[top.getA()][top.getB()] == null)) {
                        biome = biomeMap[top.getA()][top.getB()];
                    }
                    //Check if bottom is allowed and it is empty
                    else if (!(bottom.getA() < 0 || bottom.getA() > worldHeight - 1 || bottom.getB() < 0 || bottom.getB() > worldWidth - 1 || biomeMap[bottom.getA()][bottom.getB()] == null)) {
                        biome = biomeMap[bottom.getA()][bottom.getB()];
                    }
                    //Check if left is allowed and it is empty
                    else if (!(left.getA() < 0 || left.getA() > worldHeight - 1 || left.getB() < 0 || left.getB() > worldWidth - 1 || biomeMap[left.getA()][left.getB()] == null)) {
                        biome = biomeMap[left.getA()][left.getB()];
                    }
                    //Check if right is allowed and it is empty
                    else if (!(right.getA() < 0 || right.getA() > worldHeight - 1 || right.getB() < 0 || right.getB() > worldWidth - 1 || biomeMap[right.getA()][right.getB()] == null)) {
                        biome = biomeMap[right.getA()][right.getB()];
                    } else {
                        biome = Biome.GRASSLANDS;
                    }
                }
                w.setChunk(i, j, biome.generate());
            }
        }
        for (int i = 0; i < worldWidth; i++) {
            for (int j = 0; j < worldHeight; j++) {
                //top, bottom, left, right tiles
                Pair<Integer> top = new Pair<>(i, j - 1);
                Pair<Integer> bottom = new Pair<>(i, j + 1);
                Pair<Integer> left = new Pair<>(i - 1, j);
                Pair<Integer> right = new Pair<>(i + 1, j);
                Biome topRight = null, topLeft = null, bottomRight = null, bottomLeft = null;
                if (getBiomeAt(left) != null) {
                    if (getBiomeAt(top) == getBiomeAt(left)) {
                        topLeft = getBiomeAt(top);
                    }
                    if (bottom == left) {
                        bottomLeft = getBiomeAt(bottom);
                    }
                }
                if (getBiomeAt(right) != null) {
                    if (getBiomeAt(top) == getBiomeAt(right)) {
                        topRight = getBiomeAt(top);
                    }
                    if (getBiomeAt(bottom) == getBiomeAt(right)) {
                        bottomRight = getBiomeAt(bottom);
                    }
                }
                w.setChunk(i, j, DefaultCarver.carve(w.getChunk(i, j), topLeft, topRight, bottomLeft, bottomRight));
            }
        }
        StructureType.loadStructures(w);
        return w;
    }

    private Biome getBiomeAt(Pair<Integer> location) {
        if (!(location.getA() < 0 || location.getA() > worldHeight - 1 || location.getB() < 0 || location.getB() > worldWidth - 1 || biomeMap[location.getA()][location.getB()] == null)) {
            return biomeMap[location.getA()][location.getB()];
        }
        return null;
    }


}

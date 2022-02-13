package me.partlysunny.generator.generator.biomes;

import me.partlysunny.Main;
import me.partlysunny.utils.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

import static me.partlysunny.generator.generator.generators.WorldGenerator.worldHeight;
import static me.partlysunny.generator.generator.generators.WorldGenerator.worldWidth;

public class BiomeGenerator {

    private static final int MIN_BIOME_SIZE = 9;
    private final Biome[][] biomeMap = new Biome[worldWidth][worldHeight];

    public Biome[][] generateBiomeMap() {
        Main.logger.log(Level.INFO, "Generating biomes...");
        ArrayDeque<Pair<Integer>> generationQueue = new ArrayDeque<>(generateChunks(new Pair<>(worldWidth / 2, worldHeight / 2)));
        //Keep generating
        while (!generationQueue.isEmpty()) {
            Pair<Integer> position = generationQueue.poll();
            generationQueue.addAll(generateChunks(position));
        }
        return biomeMap;
    }

    private List<Pair<Integer>> generateChunks(Pair<Integer> root) {
        //If there already is a tile there (say that tile is filled before it gets to this), return
        if (biomeMap[root.getA()][root.getB()] != null) {
            return new ArrayList<>();
        }
        List<Pair<Integer>> returned = new ArrayList<>();
        ArrayDeque<Pair<Integer>> toGenerate = new ArrayDeque<>();
        toGenerate.add(root);
        Biome biome = Biome.getRandomBiome();
        Random r = new Random();
        List<Pair<Integer>> chunksGenerated = new ArrayList<>();
        //Keep going until either we have generated max chunks or until toGenerate is empty
        while (!toGenerate.isEmpty() && chunksGenerated.size() < biome.getMaxSize()) {
            Pair<Integer> chunkPos = toGenerate.poll();
            biomeMap[chunkPos.getA()][chunkPos.getB()] = biome;
            //top, bottom, left, right tiles
            Pair<Integer> top = new Pair<>(chunkPos.getA(), chunkPos.getB() - 1);
            Pair<Integer> bottom = new Pair<>(chunkPos.getA(), chunkPos.getB() + 1);
            Pair<Integer> left = new Pair<>(chunkPos.getA() - 1, chunkPos.getB());
            Pair<Integer> right = new Pair<>(chunkPos.getA() + 1, chunkPos.getB());
            //Check if top is allowed and it is empty
            if (!(top.getA() < 0 || top.getA() > worldHeight - 1 || top.getB() < 0 || top.getB() > worldWidth - 1 || biomeMap[top.getA()][top.getB()] != null)) {
                if (r.nextDouble() < biome.getSpreadChance()) {
                    //Spreads
                    toGenerate.add(top);
                    returned.remove(top);
                } else {
                    //Add new biome
                    returned.add(top);
                }
            }
            //Check if bottom is allowed and it is empty
            if (!(bottom.getA() < 0 || bottom.getA() > worldHeight - 1 || bottom.getB() < 0 || bottom.getB() > worldWidth - 1 || biomeMap[bottom.getA()][bottom.getB()] != null)) {
                if (r.nextDouble() < biome.getSpreadChance()) {
                    //Spreads
                    toGenerate.add(bottom);
                    returned.remove(bottom);
                } else {
                    //Add new biome
                    returned.add(bottom);
                }
            }
            //Check if left is allowed and it is empty
            if (!(left.getA() < 0 || left.getA() > worldHeight - 1 || left.getB() < 0 || left.getB() > worldWidth - 1 || biomeMap[left.getA()][left.getB()] != null)) {
                if (r.nextDouble() < biome.getSpreadChance()) {
                    //Spreads
                    toGenerate.add(left);
                    returned.remove(left);
                } else {
                    //Add new biome
                    returned.add(left);
                }
            }
            //Check if right is allowed and it is empty
            if (!(right.getA() < 0 || right.getA() > worldHeight - 1 || right.getB() < 0 || right.getB() > worldWidth - 1 || biomeMap[right.getA()][right.getB()] != null)) {
                if (r.nextDouble() < biome.getSpreadChance()) {
                    //Spreads
                    toGenerate.add(right);
                    returned.remove(right);
                } else {
                    //Add new biome
                    returned.add(right);
                }
            }
            chunksGenerated.add(chunkPos);
        }
        if (chunksGenerated.size() < MIN_BIOME_SIZE) {
            returned.clear();
            for (Pair<Integer> p : chunksGenerated) {
                //top, bottom, left, right tiles
                Pair<Integer> top = new Pair<>(p.getA(), p.getB() - 1);
                Pair<Integer> bottom = new Pair<>(p.getA(), p.getB() + 1);
                Pair<Integer> left = new Pair<>(p.getA() - 1, p.getB());
                Pair<Integer> right = new Pair<>(p.getA() + 1, p.getB());
                //Check if top is allowed and it is empty
                if (!(top.getA() < 0 || top.getA() > worldHeight - 1 || top.getB() < 0 || top.getB() > worldWidth - 1 || biomeMap[top.getA()][top.getB()] == null) && !chunksGenerated.contains(top)) {
                    biomeMap[p.getA()][p.getB()] = biomeMap[top.getA()][top.getB()];
                }
                //Check if bottom is allowed and it is empty
                else if (!(bottom.getA() < 0 || bottom.getA() > worldHeight - 1 || bottom.getB() < 0 || bottom.getB() > worldWidth - 1 || biomeMap[bottom.getA()][bottom.getB()] == null) && !chunksGenerated.contains(bottom)) {
                    biomeMap[p.getA()][p.getB()] = biomeMap[bottom.getA()][bottom.getB()];
                }
                //Check if left is allowed and it is empty
                else if (!(left.getA() < 0 || left.getA() > worldHeight - 1 || left.getB() < 0 || left.getB() > worldWidth - 1 || biomeMap[left.getA()][left.getB()] == null) && !chunksGenerated.contains(left)) {
                    biomeMap[p.getA()][p.getB()] = biomeMap[left.getA()][left.getB()];
                }
                //Check if right is allowed and it is empty
                else if (!(right.getA() < 0 || right.getA() > worldHeight - 1 || right.getB() < 0 || right.getB() > worldWidth - 1 || biomeMap[right.getA()][right.getB()] == null) && !chunksGenerated.contains(right)) {
                    biomeMap[p.getA()][p.getB()] = biomeMap[right.getA()][right.getB()];
                } else {
                    //Check if top is allowed and it is empty
                    if (!(top.getA() < 0 || top.getA() > worldHeight - 1 || top.getB() < 0 || top.getB() > worldWidth - 1 || biomeMap[top.getA()][top.getB()] != null)) {
                        biomeMap[p.getA()][p.getB()] = biomeMap[top.getA()][top.getB()];
                    }
                    //Check if bottom is allowed and it is empty
                    else if (!(bottom.getA() < 0 || bottom.getA() > worldHeight - 1 || bottom.getB() < 0 || bottom.getB() > worldWidth - 1 || biomeMap[bottom.getA()][bottom.getB()] != null)) {
                        biomeMap[p.getA()][p.getB()] = biomeMap[bottom.getA()][bottom.getB()];
                    }
                    //Check if left is allowed and it is empty
                    else if (!(left.getA() < 0 || left.getA() > worldHeight - 1 || left.getB() < 0 || left.getB() > worldWidth - 1 || biomeMap[left.getA()][left.getB()] != null)) {
                        biomeMap[p.getA()][p.getB()] = biomeMap[left.getA()][left.getB()];
                    }
                    //Check if right is allowed and it is empty
                    else if (!(right.getA() < 0 || right.getA() > worldHeight - 1 || right.getB() < 0 || right.getB() > worldWidth - 1 || biomeMap[right.getA()][right.getB()] != null)) {
                        biomeMap[p.getA()][p.getB()] = biomeMap[right.getA()][right.getB()];
                    } else {
                        biomeMap[p.getA()][p.getB()] = Biome.GRASSLANDS;
                    }
                }
            }
        }
        return returned;
    }
}

package me.partlysunny.chunks;

public class World {

    private final Chunk[][] chunks;
    private final int width, height;

    public World(int width, int height) {
        this.chunks = new Chunk[width][height];
        this.width = width;
        this.height = height;
    }

    public void setChunk(int x, int y, Chunk chunks) {
        this.chunks[x][y] = chunks;
    }

    public Chunk getChunk(int x, int y) {
        return chunks[x][y];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
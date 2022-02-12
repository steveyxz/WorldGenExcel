package me.partlysunny;

import me.partlysunny.chunks.Chunk;
import me.partlysunny.chunks.TileType;
import me.partlysunny.chunks.World;
import me.partlysunny.chunks.generator.generators.WorldGenerator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static me.partlysunny.chunks.Chunk.chunkHeight;

public class Main {

    public static Logger logger = Logger.getLogger("main");
    public static XSSFWorkbook workbook = new XSSFWorkbook();

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            throw new IllegalArgumentException("Requires one argument: file to generate in");
        }
        String path = args[0];

        XSSFWorkbook w = new XSSFWorkbook();
        workbook = w;
        Sheet sheet = w.createSheet("World");
        logger.log(Level.INFO, "Generating world...");
        WorldGenerator worldGenerator = new WorldGenerator();
        World world = worldGenerator.generateWorld();

        loadWorldInto(world, sheet);

        try (FileOutputStream outputStream = new FileOutputStream(path)) {
            w.write(outputStream);
        }
    }

    private static void loadWorldInto(World world, Sheet sheet) {
        logger.log(Level.INFO, "Creating rows...");
        for (int i = 0; i < world.getHeight() * chunkHeight; i++) {
            sheet.createRow(i);
        }
        logger.log(Level.INFO, "Resizing columns...");
        for (int i = 0; i < world.getWidth() * Chunk.chunkWidth; i++) {
            sheet.setColumnWidth(i, 660);
        }
        logger.log(Level.INFO, "Writing values...");
        for (int i = 0; i < world.getHeight(); i++) {
            for (int j = 0; j < world.getWidth(); j++) {
                Chunk c = world.getChunk(i, j);
                for (int k = 0; k < chunkHeight; k++) {
                    Row r = sheet.getRow(i * chunkHeight + k);
                    for (int l = 0; l < Chunk.chunkWidth; l++) {
                        TileType t = c.getTileAt(k, l);
                        Cell cell = r.createCell(j * Chunk.chunkWidth + l);
                        t.apply(cell);
                    }
                }
            }
        }
    }

}

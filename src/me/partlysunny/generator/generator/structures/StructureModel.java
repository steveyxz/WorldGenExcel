package me.partlysunny.generator.generator.structures;

import me.partlysunny.Main;
import me.partlysunny.generator.TileType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

public record StructureModel(String path) {

    public String getPath() {
        return path;
    }

    public TileType[][] getTiles() throws IOException {
        InputStream resourceAsStream = StructureModel.class.getClassLoader().getResourceAsStream(path);
        if (resourceAsStream == null) {
            Main.logger.log(Level.SEVERE, "Structure file " + path + " does not exist!");
            return null;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));
        //This first line will be the meta (width and height of the structure)
        String meta = reader.readLine();
        if (meta == null) {
            Main.logger.log(Level.SEVERE, "Structure file " + path + " is invalid!");
            return null;
        }
        //Get the width and height of the structure
        int width = Integer.parseInt(meta.split(" ")[0]);
        int height = Integer.parseInt(meta.split(" ")[1]);
        TileType[][] returned = new TileType[width][height];
        int a = 0, b;
        while (true) {
            b = 0;
            //Read the line
            String s = reader.readLine();
            //Break if end of file
            if (s == null) {
                break;
            }
            //Split the string
            String[] strings = s.split(" ");
            for (String type : strings) {
                //Add the tile type to the array
                if (!type.equalsIgnoreCase("null")) {
                    returned[b][a] = TileType.valueOf(type.toUpperCase());
                }
                b++;
            }
            a++;
        }
        return returned;
    }
}

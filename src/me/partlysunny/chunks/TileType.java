package me.partlysunny.chunks;

import me.partlysunny.Main;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;

import java.awt.*;

public enum TileType {

    GRASS(new Color(95, 208, 67), new Color(95, 208, 67), FillPatternType.SOLID_FOREGROUND),
    SAND(new Color(255, 255, 156), new Color(255, 255, 156), FillPatternType.SOLID_FOREGROUND),
    ROCK(IndexedColors.GREY_50_PERCENT.getIndex(), IndexedColors.GREY_50_PERCENT.getIndex(), FillPatternType.SOLID_FOREGROUND),
    CACTUS(IndexedColors.GREEN.getIndex(), IndexedColors.GREEN.getIndex(), FillPatternType.SOLID_FOREGROUND),
    OAK_LEAF(new Color(52, 129, 32), new Color(52, 129, 32), FillPatternType.SOLID_FOREGROUND),
    GRASSLAND_LEAF(new Color(73, 150, 84), new Color(73, 150, 84), FillPatternType.SOLID_FOREGROUND),
    WOOD(IndexedColors.BROWN.getIndex(), IndexedColors.BROWN.getIndex(), FillPatternType.SOLID_FOREGROUND),
    WATER(new Color(92, 171, 247), new Color(92, 171, 247), FillPatternType.SOLID_FOREGROUND);

    private final short foreground;
    private final short background;
    private final FillPatternType type;
    private final XSSFCellStyle cs;

    TileType(short foreground, short background, FillPatternType type) {
        this.foreground = foreground;
        this.background = background;
        this.type = type;
        XSSFCellStyle cs = Main.workbook.createCellStyle();
        cs.setFillForegroundColor(foreground);
        cs.setFillBackgroundColor(background);
        cs.setFillPattern(type);
        this.cs = cs;
    }

    TileType(Color foreground, Color background, FillPatternType type) {
        XSSFColor foregroundColor = new XSSFColor(foreground, new DefaultIndexedColorMap());
        XSSFColor backgroundColor = new XSSFColor(background, new DefaultIndexedColorMap());
        this.foreground = foregroundColor.getIndex();
        this.background = backgroundColor.getIndex();
        this.type = type;
        XSSFCellStyle cs = Main.workbook.createCellStyle();
        cs.setFillForegroundColor(foregroundColor);
        cs.setFillBackgroundColor(backgroundColor);
        cs.setFillPattern(type);
        this.cs = cs;
    }

    public static short getColorIndexOf(Color c) {
        return new XSSFColor(c, new DefaultIndexedColorMap()).getIndex();
    }

    public short getForeground() {
        return foreground;
    }

    public short getBackground() {
        return background;
    }

    public FillPatternType getType() {
        return type;
    }

    public void apply(Cell c) {
        c.setCellStyle(cs);
    }
}

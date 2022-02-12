package me.partlysunny.chunks;

import me.partlysunny.Main;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

public enum TileType {

    GRASS(IndexedColors.LIGHT_GREEN.getIndex(), IndexedColors.LIGHT_GREEN.getIndex(), FillPatternType.SOLID_FOREGROUND),
    SAND(IndexedColors.YELLOW.getIndex(), IndexedColors.YELLOW.getIndex(), FillPatternType.SOLID_FOREGROUND),
    DRY_GRASS(IndexedColors.OLIVE_GREEN.getIndex(), IndexedColors.GREEN.getIndex(), FillPatternType.SOLID_FOREGROUND),
    ROCK(IndexedColors.GREY_50_PERCENT.getIndex(), IndexedColors.GREY_50_PERCENT.getIndex(), FillPatternType.SOLID_FOREGROUND),
    CACTUS(IndexedColors.DARK_GREEN.getIndex(), IndexedColors.DARK_GREEN.getIndex(), FillPatternType.SOLID_FOREGROUND),
    DIRT(IndexedColors.BROWN.getIndex(), IndexedColors.BROWN.getIndex(), FillPatternType.SOLID_FOREGROUND),
    WATER(IndexedColors.BLUE.getIndex(), IndexedColors.BLUE.getIndex(), FillPatternType.SOLID_FOREGROUND);

    private final short foreground;
    private final short background;
    private final FillPatternType type;
    private final CellStyle cs;

    TileType(short foreground, short background, FillPatternType type) {
        this.foreground = foreground;
        this.background = background;
        this.type = type;
        CellStyle cs = Main.workbook.createCellStyle();
        cs.setFillForegroundColor(foreground);
        cs.setFillBackgroundColor(background);
        cs.setFillPattern(type);
        this.cs = cs;
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

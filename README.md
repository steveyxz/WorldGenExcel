## Basic world generation for Excel!
### How to use (For windows):
1. Make sure you have **Java 16** installed on your computer
2. Download the file WorldGenExcel.jar located in src
3. Open command prompt and navigate to the file where you put WorldGenExcel.jar and run the command `java -jar WorldGenExcel.jar "path to the file"` (e.g. `java -jar WorldGenExcel.jar "C:/Users/Me/world.xlsx"` would make the file at that directory.)
4. Open your generated world!

### How to add new biomes
1. Create a generator which implements the Generator interface. This will return a Chunk which will be a generated chunk of that biome.
2. You can add the biome to the Biome enum located in `me.partlysunny.chunks.generator.biomes`
3. The `weight` will be the probability of the biome appearing, the `spreadChance` is the change it will spread (lower means the biome will be generally smaller), `maxSize` is the largest size of the biome in chunks and the `generator` will be the generator that you created in step 1.

### How to create new tiles
1. Add your tile to the TileType enum located in `me.partlysunny.chunks`
2. The color of the tile will be located in the `foreground` attribute usually unless you are using a pattern other than `FillPatternType.SOLID_FOREGROUND`
3. Generate your tile in an existing biome generation class or make your own (see *How to add new biomes*)
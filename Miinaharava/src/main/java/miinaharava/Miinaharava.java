
package miinaharava;

import java.util.Random;

public class Miinaharava {
    
    private int[][] table;
    private int mines;
    private int width;
    private int height;
    
    public Miinaharava(int width, int height, int mines) {
        this.width = width;
        this.height = height;
        this.mines = mines;
        
        table = new int [width][height];
    }
    //placing mines into field
    public void randomMines() {
        Random random = new Random();
        int minesInField = 0;
        while (minesInField < mines) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            //10 = mine
             if (table[x][y] != 10) {
                 table[x][y] = 10;
                 minesInField ++;
             }
        }
        

    }
    //adding numbers in tiles
    public void numbers() {
        int[][] copy = new int[this.table.length][this.table[0].length];
        
        for (int x = 0; x < copy.length; x++) {
            for (int y = 0; y < copy.length; y++) {
                if(table[x][y] != 10) {
                    table[x][y] = minesAroundTile(x, y);
                }
                
            }
        }
    
    
    }
    //counting mines around the tile
    public int minesAroundTile( int x, int y) {
        int mines = 0;
        
        for (int xM = -1; xM <= 1; xM++) {
            if (xM + x < 0 || xM + x >= this.table.length) {
                continue;
            }

            for (int yM = -1; yM <= 1; yM++) {
                if (yM + y < 0 || yM + y >= this.table[x].length) {
                continue;
                }
                if (table[xM + x][yM + y] == 10) {
                    mines++;
                }
            }
        }       
        return mines;
    }
    
}
    

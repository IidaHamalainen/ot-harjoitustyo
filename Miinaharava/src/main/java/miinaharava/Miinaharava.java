
package miinaharava;

import java.util.Random;

public class Miinaharava {
    
    private int[][] table;
    
    public Miinaharava(int width, int height) {
        this.table = new int[width][height];
    }
    public void randomBombs() {
        Random random = new Random();
        
        //todo: selvitä miten saat tietyn määrän 
        //miinoja arvottua taulukkoon
    }
    //adding numbers in tiles
    public void numbers() {
        int[][] copy = new int[this.table.length][this.table[0].length];
        
        for (int x = 0; x < copy.length; x++) {
            for (int y = 0; y < copy.length; y++) {
                int mines = minesAround(table, x,y);
                
                //todo numeroiden sijoitus
            }
        }
    
    
    }
    //counting mines around the tile
    public int minesAround(int[][] table, int x, int y) {
        int mines = 0;
        
        for (int xM = -1; xM <= 1; xM++) {
            if (xM + x < 0 || xM + x >= this.table.length) {
                continue;
            }

            for (int yM = -1; yM <= 1; yM++) {
                if (yM + y < 0 || yM + y >= this.table[x].length) {
                continue;
                }
                if (table[xM + x][yM + y] == 1) {
                    mines++;
                }
            }
        }       
        return mines;
    }
    
}
    

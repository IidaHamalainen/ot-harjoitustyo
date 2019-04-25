package miinaharava.model;

import java.util.Random;

/**
 * Creates the class responsible for minefield, eg. game board
 */
public class Minefield {
     
    private int mines;
    private int width;
    private int height;
    private Tile[][] field;
    
    public Minefield(int width, int height, int mines) {
        this.width = width;
        this.height = height;
        this.mines = mines;
        
        initField();
    }
    
    public int returnWidth() {
              
        return this.width;
    }
    
    public int returnHeight() {
       
        return this.height;
    }
    /**
     * Sets mines in random tiles
     */
    public void initField() {
        Random random = new Random();
        
        this.field = initTiles();
        
        int mineAmount = 0;
        while (mineAmount < mines) {
            int x = random.nextInt(this.width);
            int y = random.nextInt(this.height);
            if (!field[x][y].getContent() == true) { //no mine in tile already
                this.field[x][y].setMine(); 
                mineAmount++;
            }
        }
    }
    /**
     * Creates table (field) with safe tiles
     * @return the field
     */
    private Tile[][] initTiles() {
        Tile[][] result = new Tile[this.width][this.height];
        
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                result[x][y] = new Tile();
            }
        }
        return result;
    }
    /**
     * Counts mines around the opened tile
     * @param x x-position
     * @param y y-position
     * @return returns the amount of mines
     */
    public int minesAroundTile(int x, int y) {
        int mines = 0;
        
        for (int xM = -1; xM <= 1; xM++) {
            if (xM + x < 0 || xM + x >= returnWidth()) {
                continue;
            }

            for (int yM = -1; yM <= 1; yM++) {
                if (yM + y < 0 || yM + y >= returnHeight()) {
                    continue;
                }
                if (field[xM + x][yM + y].hasMine()) {
                    mines++;
                }
            }
        }       
        return mines;
    }
    /**
     * Sets tile open, and checks if it has mine. If there isn't mine, opens surrounding tiles.
     * @param x
     * @param y 
     */
    public void sweep(int x, int y) {
        Tile opened = this.field[x][y];
        
        if (opened.hasMine()) {
            revealAll();  
        
        } else {
            opened.setNumber(minesAroundTile(x, y));
            opened.setOpen();
            openNeighbours(x, y);
        }
        
        
    }
    /**
     * Opens safe tiles around the tile in x, y coordinate
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public void openNeighbours(int x, int y) {
          
        int[] limits = selectAround(x, y);
        int xMin = limits[0];
        int xMax = limits[1];
        int yMin = limits[2];
        int yMax = limits[3];

        for (int i = xMin; i <= xMax; i++) {
            for (int j = yMin; j <= yMax; j++) {
                    
                if (!this.field[i][j].hasMine()) { 
                    this.field[i][j].setOpen();
                    this.field[i][j].setNumber(minesAroundTile(i, j));                             
                }

            }                
            
        }
    }
   
        
    /**
     * Sets flag to selected tile
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public void flag(int x, int y) {
        Tile flagged = this.field[x][y];
        flagged.setFlag();
    }
    /**
     * sets all tiles open
     */
    public void revealAll() {
        for (int i = 0; i < this.field.length; i++) {
            for (int j = 0; j < this.field[0].length; j++) {
                this.field[i][j].setOpen();
            }
        }
    }
    /**
     * Goes through tile which coordinates are given in params
     * @param x
     * @param y
     * @return 
     */
    private int[] selectAround(int x, int y) {
        int xMin = Math.max(0, x - 1);
        int xMax = Math.min(this.width - 1, x + 1);

        int yMin = Math.max(0, y - 1);
        int yMax = Math.min(this.height - 1, y + 1);

        return new int[]{xMin, xMax, yMin, yMax};
    }
    
    public Tile[][] getMinefield() {
        return this.field;
    }   
    /**
     * counts opened tiles, and if all safe tiles have been opened, sets victory to be true
     * @return true if all safe tiles have been opened
     */
    public boolean isVictory() {
        int tile = 0;
        boolean victory = false;
        int safeTiles = this.height * this.width - this.mines;
        
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j].tileIsOpen() == true) {
                    tile++;
                }
            }
        }
        if (tile == safeTiles) {
            victory = true;
        }   
        return victory;
    
    }
}



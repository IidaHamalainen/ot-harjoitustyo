
package miinaharava.logic;

import miinaharava.model.Minefield;
import miinaharava.model.Tile;

/**
 * Class creates the logic by which minesweeper works
 */
public class MiinaharavaLogic {
    public Minefield minefield;
    Boolean win;
    Boolean lost;
    private String difficulty;
    
    
    public MiinaharavaLogic(int width, int height, int mines) {
        this.minefield = new Minefield(width, height, mines);
        this.win = false;
        this.lost = false;
       
    }
    /**
     * Method to open tile on click, checks if clicked tile has mine and whether game is running or not.
     * @param x coordinate
     * @param y coordinate
     */
    public void sweep(int x, int y) {
        this.minefield.sweep(x, y);
        
        updateGameStatus();
        isVictory();
        
        if (!gameRunning()) {
            this.minefield.revealAll();
        }
    }
    
    public void setFlag(int x, int y) {
        this.minefield.flag(x, y);
        
    }
    /**
     * Checks if game is lost or won
     */
    public void updateGameStatus() {
        Tile[][] field = minefield.getMinefield();
        Boolean mineSweeped = false;
        
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                mineSweeped = mineSweeped || field[i][j].hasMineSweeped();
            }
        }
        this.lost = mineSweeped;
        
    }
    public boolean gameRunning() {
        return !(lost || win);
    }
    /**
     * Returns X if tile has mine, otherwise returns number
     * @param tile the tile which is targeted
     * @return returns the tile symbol
     */
    public String getTileSymbol(Tile tile) {
        if (tile.getContent() == true) {
            return "X";
        } else if (tile.getContent() == false) {
            return tile.getSymbol();
        }
        return tile.getSymbol() + "";
    }
    
    public boolean isVictory() {
        return this.minefield.isVictory();
    }
    
    public boolean isLost() {
        return this.lost;
    }
    
    public void setEasy() {
        this.minefield = new Minefield(9, 9, 16);
        this.difficulty = "helppo";
    }
    
    public void setNormal() {
        this.minefield = new Minefield(16, 16, 40);
        this.difficulty = "normaali";
    }
    
    public void setHard() {
        this.minefield = new Minefield(20, 20, 60);
        this.difficulty = "vaikea";
    }
    
    public String getDifficulty() {
        return this.difficulty;
    }
    
    
    
    
}


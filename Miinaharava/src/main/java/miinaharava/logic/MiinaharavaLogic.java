
package miinaharava.logic;

import miinaharava.model.Minefield;
import miinaharava.model.Tile;

public class MiinaharavaLogic {
    public Minefield minefield;
    Boolean win;
    Boolean lost;
    
    public MiinaharavaLogic(int width, int height, int mines) {
        this.minefield = new Minefield(width, height, mines);
        this.win = false;
        this.lost = false;
    }
    public void sweep(int x, int y) {
        this.minefield.sweep(x, y);
        
        updateGameStatus();
        isVictory();
        
        if (!gameRunning()) {
            this.minefield.revealAll();
        }
    }
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
    
    
}


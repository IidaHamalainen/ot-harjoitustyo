
package miinaharava.logic;

import miinaharava.model.Minefield;
import miinaharava.model.Tile;

public class MiinaharavaLogic {
    Minefield minefield;
    Boolean win;
    Boolean lost;
    
    public MiinaharavaLogic(int width, int height, int mines) {
        this.minefield = new Minefield(width, height, mines);
        this.win = false;
        this.lost = false;
    }
    public void sweep(int x, int y) {
        this.minefield.open(x, y);
        
    }
}

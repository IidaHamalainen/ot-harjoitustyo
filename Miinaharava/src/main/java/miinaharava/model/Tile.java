package miinaharava.model;

/**
 * Class responsible for single tile and it's functions
 */
public class Tile {
    
    private boolean mine; //false: no mine
    private boolean visible; //false: not visible
    private String minesNear;
    private boolean flagged;
  
    
    public Tile() {
        this.mine = false;
        this.visible = false;
        this.minesNear = " ";
        this.flagged = false;
        
    }
    public boolean getContent() {
        return mine;
    }
    public boolean hasMine() {
        return mine == true;
    }
    /**
     * Check if tile is opened
     * @return true if tile is opened, false if not opened
     */
    public boolean tileIsOpen() {
        return visible;
    }
    /**
     * Check if tile is flagged
     * @return true if tile is flagged, otherwise false
     */
    public boolean isFlagged() {
        return flagged;
    }
    
    public void setOpen() {
        this.visible = true;
       
    }
    public void setFlag() {
        this.flagged = true;
    }
    
    public void setMine() {
        this.mine = true;
    }
    
    public String setNumber(int clue) {
        
        this.minesNear = " " + clue;
        
        return this.minesNear;
    }
    public String getSymbol() {
        return this.minesNear;
    }

    /**
     * Check if tile has been opened and has mine
     * @return 
     */
    public Boolean hasMineSweeped() {
        return this.mine == true && this.visible;
    }
   
}



package miinaharava.model;


public class Tile {
    
    private boolean mine; //false: no mine
    private boolean visible; //false: not visible
    private String minesNear;
    
    public Tile() {
        this.mine = false;
        this.visible = false;
        this.minesNear = " ";
        
    }
    public boolean getContent() {
        return mine;
    }
    public boolean hasMine() {
        return mine == true;
    }
    
    public boolean tileIsOpen() {
        return visible;
    }
    
    public void setOpen() {
        this.visible = true;
       
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

    public Boolean hasMineSweeped() {
        return this.mine == true && this.visible;
    }
   
}



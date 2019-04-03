package miinaharava.model;


public class Tile {
    
    private boolean mine; //false: no mine
    private boolean visible; //false: not visible
    private String minesNear;
    
    public Tile () {
        this.mine = false;
        this.visible = false;
        this.minesNear = "";
        
    }
    public boolean tileHasMine() {
        return mine;
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
    
    public void setNumber(int clue) {
        this.minesNear = "" +clue;
    }
   
}



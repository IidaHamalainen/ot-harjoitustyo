


import miinaharava.logic.MiinaharavaLogic;
import miinaharava.model.Minefield;
import miinaharava.model.Tile;
import miinaharava.model.Timer;
import miinaharava.model.GameTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MiinaharavaTest {
    MiinaharavaLogic m;
    Minefield f;
    Timer t;
    Tile tile;
    Tile[][] field;


    public MiinaharavaTest() {
    } 
    
    @Test
    public void minefieldExist() {
        m = new MiinaharavaLogic(10, 10, 5);
        assertTrue(m != null);
    }
    @Test
    public void countingMinesWorks() {
        f = new Minefield(3,3,5);
        int mines = f.minesAroundTile(1, 1);
        //the number is either 4 or 5 depending whether tile 1,1 has mine or not   
        assertTrue(mines == 4 || mines == 5);
        
    }
    @Test
    public void gameLostTest() {
        m = new MiinaharavaLogic(3,3,9);
        m.sweep(0, 0);
        assertFalse(m.gameRunning());
    }
    @Test 
    public void gameWinTest() {
        m = new MiinaharavaLogic(5, 5, 0);
        m.sweep(0, 0);
        assertTrue(m.gameRunning());
    }
    
    @Test
    public void tileFlaggingTest() {
        Tile tile = new Tile();
        assertFalse(tile.isFlagged());
        
        tile.setFlag();
        assertTrue(tile.isFlagged());
    }
    @Test
    public void logicFlagged() {
        m = new MiinaharavaLogic(5, 5, 5);
        m.setFlag(0, 0);
        Tile[][] field = m.minefield.getMinefield();
        Tile tile = field[0][0];
        assertTrue(tile.isFlagged());
    }
    @Test
    public void logicNotFlagged() {
        m = new MiinaharavaLogic(5, 5, 5);
        m.setFlag(0, 0);
        Tile[][] field = m.minefield.getMinefield();
        Tile tile = field[2][2];
        assertFalse(tile.isFlagged());
    }
    @Test
    public void timerSet() {
        t = new Timer();
        String time = t.getCurrentTime();
        assertEquals(time, "0");
    }
    
   
 }

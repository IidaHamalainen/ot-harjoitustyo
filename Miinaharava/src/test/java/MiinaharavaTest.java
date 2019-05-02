

import miinaharava.logic.MiinaharavaLogic;
import miinaharava.model.GameTime;
import miinaharava.model.Minefield;
import miinaharava.model.Tile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MiinaharavaTest {
    MiinaharavaLogic m;
    Minefield f;
    Tile tile;
    Tile[][] field;
    GameTime time;

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
    public void gameRunningTest() {
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
    public void getXSymbolTest() {
        m = new MiinaharavaLogic(5, 5, 5);
        Tile tile = new Tile();
        tile.setMine();
        String symbol = m.getTileSymbol(tile);
        assertEquals("X", symbol);
        
    }
    @Test
    public void getNumberSymbolTest() {
        m = new MiinaharavaLogic(5, 5, 5);
        Tile tile = new Tile();
        tile.setNumber(3);
        String symbol = m.getTileSymbol(tile);
        assertEquals(" 3", symbol);
    }
    
    @Test
    public void logicSetslagged() {
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
    public void createGametimeCorrect() {
        time = new GameTime("0");
        assertEquals("0", time.getTime());
       
    }
    @Test
    public void setTimeCorrectly() {
        time = new GameTime("0");
        time.setTime("5");
        assertEquals("5", time.getTime());
    }
    @Test
    public void setEasyCorrectly() {
        m = new MiinaharavaLogic(10, 10, 10);
        m.setEasy();
        assertEquals("helppo", m.getDifficulty());
          
    }
    @Test
    public void setNormalCorrectly() {
        m = new MiinaharavaLogic(10, 10, 10);
        m.setNormal();
        assertEquals("normaali", m.getDifficulty());
    }
    @Test
    public void setHardCorrectly() {
        m = new MiinaharavaLogic(10, 10, 10);
        m.setHard();
        assertEquals("vaikea", m.getDifficulty());
    }
   
 }

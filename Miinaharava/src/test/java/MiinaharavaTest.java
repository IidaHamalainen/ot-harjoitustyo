


import miinaharava.logic.MiinaharavaLogic;
import miinaharava.model.Minefield;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MiinaharavaTest {
     MiinaharavaLogic m;
     Minefield f;


    public MiinaharavaTest() {
    }
    
    @Before
    public void setUp() {
         
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
}

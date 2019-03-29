

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import miinaharava.Miinaharava;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MiinaharavaTest {
     Miinaharava m;


    public MiinaharavaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void minefieldExist() {
        m = new Miinaharava(10,10,5);
        assertTrue(m != null);
    }
    @Test
    public void MinesAroundTileWorks() {
        m = new Miinaharava(3,3,2);
        m.randomMines();
        int i = m.minesAroundTile(1, 1);
        assertTrue(i >= 0 && i <=2);
    }
}

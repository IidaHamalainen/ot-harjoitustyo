

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import miinaharava.logic.MiinaharavaLogic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MiinaharavaTest {
     MiinaharavaLogic m;


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
        m = new MiinaharavaLogic(10, 10, 5);
        assertTrue(m != null);
    }
    @Test
    public void MinesAroundTileWorks() {
       
    }
}

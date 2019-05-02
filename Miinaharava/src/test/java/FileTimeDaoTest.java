import java.io.File;
import java.io.FileWriter;
import java.util.List;
import miinaharava.dao.FileTimeDao;
import miinaharava.dao.TimeDao;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import miinaharava.model.GameTime;

public class FileTimeDaoTest {
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder(); 
    File timeFile;
    TimeDao dao;
    
    @Before
    public void setUp() throws Exception {
        timeFile = testFolder.newFile("testfile_times.txt");  
        
        try (FileWriter file = new FileWriter(timeFile.getAbsolutePath())) {
            file.write("07");
        }
        dao = new FileTimeDao(timeFile.getAbsolutePath());
    }
    @Test
    public void timesAreReadCorrectly() {
        List<GameTime> times = dao.getAll();
        assertEquals(1, times.size());
        GameTime time = times.get(0);
        assertEquals("07", time.getTime());
    }
    @Test
    public void newTimesAreListed() throws Exception {
        dao.create(new GameTime("221"));
        List<GameTime> times = dao.getAll();
        assertEquals(2, times.size());
        GameTime time = times.get(1);
        assertEquals("221", time.getTime());
    }
    @After
    public void tearDown() {
    timeFile.delete();
    }
        
        
}

import java.util.List;
import miinaharava.logic.TimeService;
import miinaharava.model.GameTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimeServiceTest {
    
    FakeTimeDao timeDao;
    TimeService service;
    
    @Before
    public void setUp() {
        timeDao = new FakeTimeDao();
        service = new TimeService(timeDao);
        timeDao.create(new GameTime("123"));
    }
    private void addTime(String time) {
        service.createTime(time);
    }
    
    @Test
    public void listContainsTimes() {
        List<GameTime> times = service.getTimes();
        
        assertEquals(1, times.size());
        GameTime time = times.get(0);
        assertEquals("123", time.getTime());
    }
    @Test
    public void listContainsAddedTime() {
        addTime("42");
        
        List<GameTime> times = service.getTimes();
        assertEquals(2, times.size());
        GameTime time = times.get(1);
        assertEquals("42", time.getTime());
    }
}


import java.util.ArrayList;
import java.util.List;
import miinaharava.dao.TimeDao;
import miinaharava.model.GameTime;


public class FakeTimeDao implements TimeDao {
    
    List<GameTime> times;
    
    public FakeTimeDao() {
        times = new ArrayList<>();
    }
    @Override
    public List<GameTime> getAll() {
        return times;
    }
    @Override
    public GameTime create(GameTime time) {
        times.add(time);
        return time;
    }
}

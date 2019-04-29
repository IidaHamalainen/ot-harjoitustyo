
package miinaharava.logic;

import java.util.List;
import miinaharava.dao.TimeDao;
import miinaharava.model.GameTime;


public class TimeService {
    private TimeDao timeDao;
    
    public TimeService(TimeDao timeDao) {
        this.timeDao = timeDao;
    }
    /**
     * creating new gametime
     * @param time the time of created gametime
     * @return 
     */
    public boolean createTime(String time) {
        GameTime gameTime = new GameTime(time);
        try {
            timeDao.create(gameTime);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    public List<GameTime> getTimes() {
        return timeDao.getAll();
    }
}

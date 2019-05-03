
package miinaharava.logic;

import java.util.List;
import miinaharava.dao.TimeDao;
import miinaharava.model.GameTime;
/**
 * Class which handles saving time to DAO
 */

public class TimeService {
    private TimeDao timeDao;
    
    public TimeService(TimeDao timeDao) {
        this.timeDao = timeDao;
    }
    /**
     * creating new entry to times.txt file
     * @param time the time, result and difficulty of game 
     * @return true if there are no exceptions
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


package miinaharava.dao;

import java.util.List;
import miinaharava.model.GameTime;

/**
 * Interface to save time data
 */
public interface TimeDao {
    
    GameTime create(GameTime time) throws Exception;
    
    List<GameTime> getAll();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

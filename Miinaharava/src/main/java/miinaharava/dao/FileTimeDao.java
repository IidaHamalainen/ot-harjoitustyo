
package miinaharava.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import miinaharava.model.GameTime;
/**
 * Class to create file for saving game times
 */
public class FileTimeDao implements TimeDao {
    
    public List<GameTime> times;
    private String file;
    
    public FileTimeDao(String file) throws Exception {
        times = new ArrayList<>();
        this.file = file;
        
        try {
            Scanner reader = new Scanner(new File(file));
            
            while (reader.hasNextLine()) {
                String time = reader.nextLine();
                GameTime t = new GameTime(time);
                times.add(t);
            }
            
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }
    
    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (GameTime time : times) {
                writer.write(time.getTime() + "\n");
            }
        }
    }
    /**
     * Creates new GameTime object and saves time to list
     * @param time the time, difficulty and result of game
     * @return returns the time object
     * @throws Exception 
     */
    @Override
    public GameTime create(GameTime time) throws Exception {
        times.add(time);
        save();
        return time;
    }
    
    @Override
    public List<GameTime> getAll() {
        return times;
    }
}
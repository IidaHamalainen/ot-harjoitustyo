
package miinaharava.model;

/**
 * Class which takes the count of seconds when game ends
 */
public class GameTime {
    
    private String time;
    
    public GameTime(String time) {
        this.time = time;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
}
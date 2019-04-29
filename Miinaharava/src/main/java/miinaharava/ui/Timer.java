
package miinaharava.ui;

import java.text.DecimalFormat;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import miinaharava.model.GameTime;
import miinaharava.dao.TimeDao;
import miinaharava.logic.TimeService;

/**
* Class that creates the timer animation
*/
public class Timer extends Pane {
  
    private static Label currentTime = new Label();
    private int seconds;
    private static Timeline timer;
    private String endTime;
    private TimeDao timeDao;
    private TimeService timeService;
    
    
    public Timer() {
        seconds = 0;
        getChildren().add(currentTime); 
        
    }
    /**
     * Starts the timer from 0 in every new game
     */
    public void start() {
        
        seconds = 0;
        timer = new Timeline();
        timer.setCycleCount(Animation.INDEFINITE);
        timer.getKeyFrames().add(new KeyFrame(Duration.seconds(1), e -> {
            seconds++;
            changeCurrentTime();
        }));
        timer.play();
    }
    
    /**
     * Changes the seconds in timer
     */
    public void changeCurrentTime() {
        DecimalFormat df = new DecimalFormat("00");
        currentTime.setText(df.format(seconds));
    }

    public String getCurrentTime() {
        return currentTime.getText();
    }
    /**
     * Stops the timer and saves end time to GameTime object
     */
    public void stop() {
        timer.stop();
        endTime = currentTime.getText();
        
        
        
    }
    public String getEndTime() {
        
        return endTime;
    }
   

   
    
}

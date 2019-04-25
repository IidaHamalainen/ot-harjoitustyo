
package miinaharava.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class Timer extends Pane {
  
    private static Label currentTime = new Label();
    private int seconds = 0;
    private static Timeline timer;
    private String endTime;
    private List<String> times;
    
    /**
     * Class to create timer
     */
    public Timer() {
        
        getChildren().add(currentTime); 
        times = new ArrayList<>();
    }
    
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
    

    private void changeCurrentTime() {
        DecimalFormat df = new DecimalFormat("00");
        currentTime.setText(df.format(seconds));
    }

    public String getCurrentTime() {
        return currentTime.getText();
    }

    public void stop() {
        timer.stop();
        endTime = currentTime.getText();
        
    }
    public String getEndTime() {
        return endTime;
    }
    public void addTime() {
        times.add(endTime);
    }
    public List<String> getTimes() {
        return times;
    }
    
}
    


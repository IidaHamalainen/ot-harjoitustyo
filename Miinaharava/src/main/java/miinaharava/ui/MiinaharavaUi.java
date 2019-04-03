
package miinaharava.ui;


import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import miinaharava.logic.MiinaharavaLogic;



public class MiinaharavaUi extends Application {
    
    private MiinaharavaLogic miinaharava;
    
    private Scene menuScene;
    private Scene gameScene;
   

    @Override
    public void start(Stage stage) {
        
        //menu window
        BorderPane menuPane = new BorderPane();
        Label title = new Label("Tervetuloa pelaamaan miinaharavaa!");
        Button startButton = new Button("Aloita");
        
        
        VBox results = new VBox();
        results.getChildren().add(new Label("Tulokset"));
        results.getChildren().add(new Label("toteuta listaus tähän"));
        
        
        menuPane.setTop(title);
        menuPane.setBottom(startButton);
        menuPane.setRight(results);
        
        
        menuPane.setPrefSize(500, 400);
        BorderPane.setMargin(title, new Insets(10,10,10,50));
        BorderPane.setMargin(startButton, new Insets(10,10,10,10));
        BorderPane.setMargin(results, new Insets(10,10,10,10));
        
        startButton.setOnAction((event) -> {
           stage.setScene(gameScene);
           
        });
        
        menuScene = new Scene(menuPane);        
        
        //game window
        
        BorderPane gamePane = new BorderPane();
        Label label = new Label("peli tulee tähän");
        Button backButton = new Button("Palaa valikkoon");
        
        gamePane.setTop(label);
        gamePane.setBottom(backButton);
        gamePane.setPrefSize(500, 400);
        BorderPane.setMargin(backButton, new Insets(10,10,10,10));
        
        backButton.setOnAction((event) -> {
            stage.setScene(menuScene);
        });
        
        gameScene = new Scene(gamePane);
        
        stage.setTitle("Miinaharava");
        stage.setScene(menuScene);
        stage.show();
                   
        
    }
    
    public static void main(String[] args) {
        launch(MiinaharavaUi.class);
    }
    
    
            
 
}


        
    
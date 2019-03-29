
package miinaharava;

import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MiinaharavaSovellus extends Application {
    
    @Override
    public void start(Stage stage) {
        
        //Starting window or menu
        BorderPane layout = new BorderPane();
        Label text = new Label("Tervetuloa pelaamaan miinaharavaa!");
        Button startButton = new Button("Aloita");
        
        
        VBox results = new VBox();
        results.getChildren().add(new Label("Tulokset"));
        results.getChildren().add(new Label("toteuta listaus tähän"));
        
        
        layout.setTop(text);
        layout.setBottom(startButton);
        layout.setRight(results);
        
        
        layout.setPrefSize(500, 400);
        BorderPane.setMargin(text, new Insets(10,10,10,50));
        BorderPane.setMargin(startButton, new Insets(10,10,10,10));
        BorderPane.setMargin(results, new Insets(10,10,10,10));
        
        Scene menu = new Scene(layout);
        
        //game window-------------------
        
        int SIZE = 10;
            int length = SIZE;
            int width = SIZE;

            GridPane root = new GridPane();    

            for(int y = 0; y < length; y++){
                for(int x = 0; x < width; x++){

                    Random rand = new Random();
                    int rand1 = rand.nextInt(2);
                    
                    TextField tf = new TextField();
                    tf.setPrefHeight(50);
                    tf.setPrefWidth(50);
                    tf.setAlignment(Pos.CENTER);
                    tf.setEditable(false);
                    tf.setText( "" + rand1 );

                    // Iterate the Index using the loops
                    root.setRowIndex(tf,y);
                    root.setColumnIndex(tf,x);    
                    root.getChildren().add(tf);
                
                }
            }
        
        Label label = new Label("Etsi pommit, mutta älä räjähdä!");
        
        
        Scene gameview = new Scene(root, 500, 500);
        
        Miinaharava sweeper = new Miinaharava(40,50,10);
        sweeper.randomMines();
        
        //Aloita button
        startButton.setOnAction((event) -> {
            stage.setScene(gameview);
        });
        
        stage.setTitle("Miinaharava");
        stage.setScene(menu);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(MiinaharavaSovellus.class);
    }
}

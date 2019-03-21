
package miinaharava;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
        Group root = new Group();
        Label label = new Label("Etsi pommit, mutta älä räjähdä!");
        Canvas canvas = new Canvas(400,300);
        GraphicsContext draw = canvas.getGraphicsContext2D();
        draw.setFill(Color.WHITE);
        
        BorderPane game = new BorderPane();
        game.setCenter(canvas);
        game.setTop(label);
        root.getChildren().add(game);
        
        
        Scene gameview = new Scene(root);
        
        
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

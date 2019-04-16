
package miinaharava.ui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import miinaharava.logic.MiinaharavaLogic;
import miinaharava.model.Tile;
import miinaharava.model.Timer;

public class MiinaharavaUi extends Application {
    
    
    private Scene menuScene;
    private Scene gameScene;
    private MiinaharavaLogic logic;
    private Timer gameTimer;
    
   

    @Override
    public void start(Stage stage) {
        
        logic = new MiinaharavaLogic(16, 16, 40);
        
        //menu window
        BorderPane menuPane = new BorderPane();
        Label title = new Label("Tervetuloa pelaamaan miinaharavaa!");
        
        Label difficulty = new Label("Valitse vaikeustaso:");
        Button normal = new Button("Normaali");
        Button easy = new Button("Helppo");
        Button hard = new Button("Vaikea");
        Button startButton = new Button("Aloita");
        
        HBox level = new HBox();
        level.setSpacing(20);
        level.getChildren().add(easy);
        level.getChildren().add(normal);
        level.getChildren().add(hard);
        
        VBox selectLevel = new VBox();
        selectLevel.setSpacing(20);
        selectLevel.getChildren().add(difficulty);
        selectLevel.getChildren().add(level);
        selectLevel.getChildren().add(startButton);

        
        VBox results = new VBox();
        results.getChildren().add(new Label("Tulokset"));
        results.getChildren().add(new Label("toteuta listaus tähän"));
        
        
        menuPane.setTop(title);
        menuPane.setRight(results);
        menuPane.setCenter(selectLevel);
        
        
        menuPane.setPrefSize(500, 400);
        BorderPane.setMargin(title, new Insets(10,10,10,50));
        BorderPane.setMargin(results, new Insets(10,10,10,10));
        BorderPane.setMargin(selectLevel, new Insets(100, 10, 10, 10));
        
        Canvas fieldCanvas = new Canvas(300, 300);
        drawMineField(fieldCanvas, logic);
        Label label = new Label("");
        Font font = new Font(20);
        label.setFont(font);
        Timer gameTimer = new Timer(); //To do: reset timer for every game
         
        easy.setOnAction((event) -> {
            logic = new MiinaharavaLogic(10, 10, 20);
            difficulty.setText("Valittu: Helppo");
        });
               
        normal.setOnAction((event) -> {
           logic = new MiinaharavaLogic(16, 16, 40);
           difficulty.setText("Valittu: Normaali");
        });
        
        hard.setOnAction((event) -> {
            logic = new MiinaharavaLogic(22, 22, 60);
            difficulty.setText("Valittu: Vaikea");
        });
        
        startButton.setOnAction((event) -> {
            drawMineField(fieldCanvas, logic);
            label.setText("Game is on!");
            stage.setScene(gameScene);
        });
        
        
        menuScene = new Scene(menuPane);        
        
        //game window
        
        BorderPane gamePane = new BorderPane();
        
        
        
        Button backButton = new Button("Palaa valikkoon");
        
        
        fieldCanvas.setOnMouseClicked((event) -> {
            handleMouseClick(event, fieldCanvas, logic);
            drawMineField(fieldCanvas, logic);
            if (logic.isVictory()) {
                label.setText("VOITIT! JEE");
                Timer.stop();
                
                
            } else if (logic.isLost()) {
                label.setText("HÄVISIT!");
                Timer.stop();
                
            }
        });
        
        gamePane.setTop(label);
        gamePane.setRight(gameTimer);
        gamePane.setBottom(backButton);
        gamePane.setPrefSize(500, 400);
        gamePane.setCenter(fieldCanvas);
        
        
        BorderPane.setMargin(backButton, new Insets(10,10,10,10));
        BorderPane.setMargin(label, new Insets(20, 10, 10, 40));
        BorderPane.setMargin(gameTimer,new Insets(20, 40, 10, 40) );
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
    private int locationInGrid(Double locationInCanvas, Double canvasSize, int gridSize) {
        double threshold = 0.5;
        long location = Math.round(
                (locationInCanvas / canvasSize) * (gridSize - 1) - threshold
        );

        return (int) location;
    }

    private void drawMineField(Canvas canvas, MiinaharavaLogic logic) {
        Tile[][] mineField = logic.minefield.getMinefield();
        int fieldX = mineField.length;
        int fieldY = mineField[0].length;

        double squareWidth = canvas.getWidth() / fieldX;
        double squareHeight = canvas.getHeight() / fieldY;

        GraphicsContext brush = canvas.getGraphicsContext2D();

        for (int i = 0; i < fieldX; i++) {
            for (int j = 0; j < fieldY; j++) {
                double startX = i * squareWidth;
                double startY = j * squareHeight;
                Tile tile = mineField[i][j];

                if (tile.tileIsOpen()) {
                    // Background
                    brush.setFill(Color.WHITE);
                    brush.fillRect(startX, startY, squareWidth, squareHeight);

                    // Desired text
                    brush.setFill(Color.BLACK);
                    brush.setTextAlign(TextAlignment.CENTER);
                    brush.setTextBaseline(VPos.CENTER);
                    

                    String symbol = logic.getTileSymbol(tile);

                    brush.fillText(
                            symbol,
                            Math.round(startX) + squareWidth / 2,
                            Math.round(startY) + squareHeight / 2
                    );
                } else if(tile.isFlagged() ) {
                    brush.setFill(Color.DARKRED);
                    brush.fillRect(startX, startY, squareWidth, squareHeight);
                    
                } else {
                    brush.setFill(Color.DARKSEAGREEN);
                    brush.fillRect(startX, startY, squareWidth, squareHeight);
                    brush.setFill(Color.DARKGREEN);
                    brush.fillRect(startX-1, startY-1, squareWidth-1, squareHeight-1);
                    
                    
                }
            }
        }
        
    }
    

    private void handleMouseClick (MouseEvent event, Canvas canvas, MiinaharavaLogic logic) {
        double mouseX = event.getX();
        double width = canvas.getWidth();
        int fieldWidth = logic.minefield.getMinefield().length;

        double mouseY = event.getY();
        double height = canvas.getWidth();
        int fieldHeight = logic.minefield.getMinefield()[0].length;

        int x = locationInGrid(mouseX, width, fieldWidth);
        int y = locationInGrid(mouseY, height, fieldHeight);

      
        if ((event.getButton().equals(MouseButton.PRIMARY))) {
                
            logic.sweep(x, y);
        }
        
        
        if ((event.getButton().equals(MouseButton.SECONDARY))) {
            
            logic.setFlag(x, y);
        }
       
        
        
    }
    
}

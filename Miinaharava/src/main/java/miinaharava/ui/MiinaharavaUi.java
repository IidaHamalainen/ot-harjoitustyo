
package miinaharava.ui;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
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
import miinaharava.dao.FileTimeDao;
import miinaharava.dao.TimeDao;
import miinaharava.logic.MiinaharavaLogic;
import miinaharava.model.GameTime;
import miinaharava.model.Tile;
import miinaharava.ui.Timer;

/**
 * Class responsible for User Interface
 */
public class MiinaharavaUi extends Application {
    
    
    private Scene menuScene;
    private Scene gameScene;
    private MiinaharavaLogic logic;
    private Timer gameTimer;
    private VBox timeNodes;
    private TimeDao timeDao;
    private GameTime gameTime;
    
    @Override
    public void init() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("config.properties"));
        String timeFile = properties.getProperty("timeFile");
        FileTimeDao timeDao = new FileTimeDao(timeFile);
        
    }
    public  Node createTimeNode(GameTime time) {
        VBox box = new VBox(10);
        Label label = new Label(time.getTime());
        box.getChildren().addAll(label);
        return box;
    } 
    public void redrawTimelist() {
        timeNodes.getChildren().clear();
        List<GameTime> times = timeDao.getAll();
        times.forEach(time->{
            timeNodes.getChildren().add(createTimeNode(time));
        });
    }

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
        
        timeNodes = new VBox(10);
        
        results.getChildren().add(timeNodes);
      
        
        menuPane.setTop(title);
        menuPane.setRight(results);
        menuPane.setCenter(selectLevel);
        
        
        menuPane.setPrefSize(500, 400);
        BorderPane.setMargin(title, new Insets(10,10,10,50));
        BorderPane.setMargin(results, new Insets(10,10,10,10));
        BorderPane.setMargin(selectLevel, new Insets(100, 10, 10, 10));
        
        Canvas fieldCanvas = new Canvas(350, 350);
        drawMineField(fieldCanvas, logic);
        Label label = new Label("");
        Font font = new Font(20);
        label.setFont(font);
        gameTimer = new Timer(); 
         
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
            gameTimer.start();
            
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
                gameTimer.stop();
                
                
            } else if (logic.isLost()) {
                label.setText("HÄVISIT!");
                gameTimer.stop();
                
                
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
            gameTimer.stop();
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
        double threshold = 0.1;
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

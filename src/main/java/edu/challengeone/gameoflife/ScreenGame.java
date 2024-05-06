package edu.challengeone.gameoflife;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public class ScreenGame extends Application {

    private final int width = 500;
    private final int height = 500;
    private static int rows;
    private static int cols;
    private static int cellSize;
    private static int aliveCells;

    public ScreenGame(int rows, int cols, int aliveCells) {
        this.rows = rows;
        this.cols = cols;
        this.aliveCells = aliveCells;
    }

    @Override
    public void start(Stage primaryStage) {

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, width, height + 100);
        final Canvas canvas = new Canvas(width, height);

        Button reset = new Button("Reset");
        Button step = new Button("Step");
        Button run = new Button("Run");
        Button stop = new Button("Stop");

        HBox buttonBox = new HBox(10, reset, step, run, stop);
        buttonBox.setAlignment(Pos.CENTER);

        root.getChildren().addAll(canvas, buttonBox);
        primaryStage.setScene(scene);
        primaryStage.show();

        if (rows > cols)
            cellSize = height / rows;
        else
            cellSize = width / cols;

        GraphicsContext graphics = canvas.getGraphicsContext2D();

        GameOfLife game = new GameOfLife(width, height, cellSize, rows, cols, aliveCells, graphics);
        game.initializerBoard();

        AnimationTimer runAnimation = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                // update every 0.5 seconds
                if ((now - lastUpdate) >= TimeUnit.MILLISECONDS.toNanos(500)) {
                    game.nextGeneration();
                    lastUpdate = now;
                }
            }
        };

        reset.setOnAction(l -> game.initializerBoard());
        run.setOnAction(  l -> runAnimation.start());
        step.setOnAction( l -> game.nextGeneration());
        stop.setOnAction( l -> runAnimation.stop());
    }
}

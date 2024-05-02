package edu.challengeone.gameoflife;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScreenConfig extends Application {

    private static final int CONFIG_WIDTH = 500;
    private static final int CONFIG_HEIGHT = 600;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox configRoot = new VBox(10);
        configRoot.setAlignment(Pos.CENTER); // Centraliza verticalmente



        Scene configScene = new Scene(configRoot, CONFIG_WIDTH, CONFIG_HEIGHT);

        Label titleLabel = new Label("GAME OF LIFE");
        titleLabel.setStyle("-fx-font-size: 62px; -fx-text-fill: darkcyan;");


        Label rowsLabel = new Label("Enter the number of rows for the grid (10 to 50):");
        TextField rowsInput = new TextField();
        rowsInput.setMaxWidth(80);

        Label colsLabel = new Label("Enter the number of columns for the grid (10 to 50):");
        TextField colsInput = new TextField();
        colsInput.setMaxWidth(80);

        Label aliveCellsLabel = new Label("Enter the number of cells that should start alive (30 to total cells):");
        TextField aliveCellsInput = new TextField();
        aliveCellsInput.setMaxWidth(80);


        Button playButton = new Button("Play");
        playButton.setOnAction(e -> {
            try {
                int rows = Integer.parseInt(rowsInput.getText());
                int cols = Integer.parseInt(colsInput.getText());
                int aliveCells = Integer.parseInt(aliveCellsInput.getText());

                if (rows >= 10 && rows <= 50 && cols >= 10 && cols <= 50 && aliveCells >= 30 && aliveCells <= (rows * cols)) {

                    ((Stage) titleLabel.getScene().getWindow()).close();

                    ScreenGame screenGame = new ScreenGame(rows, cols, aliveCells);
                    try {
                        screenGame.start(primaryStage);
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("The values must be within the specified range.");
                    alert.showAndWait();
                }
            }
            catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid input format. Please enter an integer value.");
                alert.showAndWait();
            }

        });

        configRoot.getChildren().addAll(
                titleLabel,
                rowsLabel, rowsInput,
                colsLabel, colsInput,
                aliveCellsLabel, aliveCellsInput,
                playButton
        );

        primaryStage.setScene(configScene);
        primaryStage.setTitle("Game of Life Configuration");
        primaryStage.show();
    }
}
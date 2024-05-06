package edu.challengeone.gameoflife;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class GameOfLife {

    private static int width;
    private static int height;
    private static int cellSize;
    private static int rows;
    private static int cols;
    private static int[][] board;
    private static int aliveCells;
    private static GraphicsContext graphics;

    public GameOfLife(int width, int height, int cellSize, int rows, int cols, int aliveCells, GraphicsContext graphics) {
        this.width = width;
        this.height = height;
        this.cellSize = cellSize;
        this.rows = rows;
        this.cols = cols;
        this.board = new int[rows][cols];
        this.aliveCells = aliveCells;
        this.graphics = graphics;
    }

    public void initializerBoard() {

        Random random = new Random();

        // Fills all the board with dead cells
        for (int m = 0; m < rows; m++) {
            for (int n = 0; n < cols; n++) {
                board[m][n] = 0;
            }
        }

        // Distributes live cells randomly
        for (int aliveCellCount = 0; aliveCellCount < aliveCells; aliveCellCount++) {
            int chosenRow = random.nextInt(rows);
            int chosenCol = random.nextInt(cols);

            if (board[chosenRow][chosenCol] == 0)
                board[chosenRow][chosenCol] = 1;
            else
                // If the chosen cell is already live, try again
                aliveCellCount--;
        }

        draw();
    }

    public void nextGeneration() {

        int[][] nextBoard = new int[rows][cols];

        for (int m = 0; m < rows; m++) {
            for (int n = 0; n < cols; n++) {

                int aliveNeighbours = countAliveNeighbours(m, n);

                // Cell dies by lonely or over population if it's alive or remains dead
                if (aliveNeighbours < 2 || aliveNeighbours > 3)
                    nextBoard[m][n] = 0;
                // A cell is born if it's dead or remains alive
                else if (aliveNeighbours == 3)
                    nextBoard[m][n] = 1;
                // Remains in the same state
                else
                    nextBoard[m][n] = board[m][n];
            }
        }

        board = nextBoard;
        draw();
    }

    private int countAliveNeighbours(int m, int n) {
        int count = 0;

        for (int i = -1; i < 2; i++) {
            int newRow = m + i;

            for (int j = -1; j < 2; j++) {
                int newCol = n + j;

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    if (i == 0 && j == 0)
                        continue;
                    else
                        count += board[newRow][newCol];
                }
            }
        }

        return count;
    }

    private void draw() {
        // clear graphics
        graphics.setFill(Color.LIGHTCYAN);
        graphics.fillRect(0, 0, width, height);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    // first rect will end up becoming the border
                    graphics.setFill(Color.gray(0.5, 0.5));
                    graphics.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
                    graphics.setFill(Color.DARKCYAN);
                    graphics.fillRect((i * cellSize) + 1, (j * cellSize) + 1, cellSize - 2, cellSize - 2);
                }else {
                    graphics.setFill(Color.gray(0.5, 0.5));
                    graphics.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
                    graphics.setFill(Color.LIGHTCYAN);
                    graphics.fillRect((i * cellSize) + 1, (j * cellSize) + 1, cellSize - 2, cellSize - 2);
                }
            }
        }
    }
}

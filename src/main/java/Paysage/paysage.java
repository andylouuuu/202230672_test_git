package Paysage;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class paysage extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Paysage de Andy");

        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Dessiner le ciel
        gc.setFill(Color.CYAN);
        gc.fillRect(0, 0, 800, 400);

        // Dessiner les montagnes
        gc.setFill(Color.DARKGRAY);
        gc.beginPath();
        gc.moveTo(0, 400);
        gc.lineTo(200, 200);
        gc.lineTo(400, 400);
        gc.closePath();
        gc.fill();

        gc.setFill(Color.GRAY);
        gc.beginPath();
        gc.moveTo(200, 400);
        gc.lineTo(300, 250);
        gc.lineTo(400, 400);
        gc.closePath();
        gc.fill();

        // Dessiner le sol
        gc.setFill(Color.GREEN);
        gc.fillRect(0, 400, 800, 200);

        // Dessiner un papayer
        drawPapayaTree(gc, 600, 450);

        Group root = new Group();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawPapayaTree(GraphicsContext gc, double x, double y) {
        // Dessiner le tronc
        gc.setFill(Color.SADDLEBROWN);
        gc.fillRect(x - 10, y - 100, 20, 100);

        // Dessiner les feuilles
        gc.setFill(Color.DARKGREEN);
        for (int i = 0; i < 6; i++) {
            double angle = i * 60;
            double leafX = x + 50 * Math.cos(Math.toRadians(angle));
            double leafY = y - 100 + 50 * Math.sin(Math.toRadians(angle));
            gc.beginPath();
            gc.moveTo(x, y - 100);
            gc.lineTo(leafX, leafY);
            gc.arcTo(leafX, leafY, x, y - 100, 20);
            gc.closePath();
            gc.fill();
        }

        // Ajouter des fruits
        gc.setFill(Color.ORANGE);
        gc.fillOval(x - 15, y - 130, 10, 10);
        gc.fillOval(x + 5, y - 120, 10, 10);
        gc.fillOval(x - 5, y - 110, 10, 10);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

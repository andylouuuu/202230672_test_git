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

        // Dessiner des fleurs
        drawFlowers(gc);

        // Dessiner une maison
        drawHouse(gc, 300, 350);
    }

    private void drawHouse(GraphicsContext gc, double x, double y) {
        // Dessiner le corps de la maison
        gc.setFill(Color.BEIGE);
        gc.fillRect(x, y, 100, 100);

        // Dessiner le toit
        gc.setFill(Color.DARKRED);
        gc.beginPath();
        gc.moveTo(x, y);
        gc.lineTo(x + 50, y - 50);
        gc.lineTo(x + 100, y);
        gc.closePath();
        gc.fill();

        // Dessiner la porte
        gc.setFill(Color.BROWN);
        gc.fillRect(x + 40, y + 50, 20, 50);

        // Dessiner une fenêtre
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(x + 10, y + 20, 30, 30);
        gc.fillRect(x + 60, y + 20, 30, 30);
    }

    private void drawFlowers(GraphicsContext gc) {
        // Dessiner quelques fleurs avec une taille augmentée
        gc.setFill(Color.RED);
        gc.fillOval(50, 450, 20, 20); // Fleur 1 (taille augmentée)
        gc.fillOval(70, 460, 20, 20); // Fleur 2 (taille augmentée)
        gc.fillOval(150, 480, 20, 20); // Fleur 3 (taille augmentée)
        gc.fillOval(300, 450, 20, 20); // Fleur 4 (taille augmentée)
        gc.fillOval(400, 470, 20, 20); // Fleur 5 (taille augmentée)
        gc.fillOval(500, 460, 20, 20); // Fleur 6 (taille augmentée)

        // Dessiner les tiges des fleurs
        gc.setStroke(Color.GREEN);
        gc.setLineWidth(2);
        gc.strokeLine(60, 455, 60, 470); // Tige 1
        gc.strokeLine(80, 465, 80, 480); // Tige 2
        gc.strokeLine(160, 485, 160, 500); // Tige 3
        gc.strokeLine(310, 455, 310, 470); // Tige 4
        gc.strokeLine(410, 475, 410, 490); // Tige 5
        gc.strokeLine(510, 465, 510, 480); // Tige 6
    }

    public static void main(String[] args) {
        launch(args);
    }
}
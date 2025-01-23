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

        Group root = new Group();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

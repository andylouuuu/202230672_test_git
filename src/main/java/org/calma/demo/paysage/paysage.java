package org.calma.demo.paysage;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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

        // Dessiner un lac
        drawLake(gc);

        // Dessiner un papayer
        drawPapayaTree(gc, 600, 450);

        // Ajouter une fille qui dit "Bonjour, je suis Annabelle"
        drawAnnabelle(gc, 150, 450);

        // Dessiner une maison
        drawHouse(gc, 300, 350);

        // Ajouter un texte de bienvenue
        addWelcomeText(gc);

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

        // Dessiner les feuilles du papayer
        gc.setFill(Color.DARKGREEN);
        for (int i = 0; i < 6; i++) {
            double angle = i * 60;
            double leafBaseX = x + 30 * Math.cos(Math.toRadians(angle));
            double leafBaseY = y - 100 + 30 * Math.sin(Math.toRadians(angle));
            gc.beginPath();
            gc.moveTo(x, y - 100); // Centre où les feuilles se rejoignent
            gc.bezierCurveTo(
                    x, y - 150,          // Contrôle supérieur (courbe vers le haut)
                    leafBaseX, leafBaseY, // Contrôle extérieur (étendre la feuille)
                    x, y - 100           // Retour au centre
            );
            gc.closePath();
            gc.fill();
        }

        // Ajouter des fruits
        gc.setFill(Color.ORANGE);
        gc.fillOval(x - 15, y - 130, 10, 10);
        gc.fillOval(x + 5, y - 120, 10, 10);
        gc.fillOval(x - 5, y - 110, 10, 10);
    }

    private void drawLake(GraphicsContext gc) {
        gc.setFill(Color.BLUE);
        gc.fillOval(400, 450, 300, 100); // Dessine un lac ovale
    }

    private void drawAnnabelle(GraphicsContext gc, double x, double y) {
        // Dessiner le corps
        gc.setFill(Color.PEACHPUFF);
        gc.fillOval(x, y - 30, 20, 20); // Tête
        gc.setFill(Color.BLUE);
        gc.fillRect(x - 5, y - 10, 30, 40); // Corps
        gc.setFill(Color.BLACK);
        gc.fillRect(x - 10, y + 30, 10, 30); // Jambe gauche
        gc.fillRect(x + 10, y + 30, 10, 30); // Jambe droite

        // Ajouter les bras
        gc.setStroke(Color.PEACHPUFF);
        gc.setLineWidth(5);
        gc.strokeLine(x - 10, y, x - 30, y + 20); // Bras gauche
        gc.strokeLine(x + 30, y, x + 50, y + 20); // Bras droit

        // Ajouter le texte
        gc.setFill(Color.BLACK);
        gc.setFont(Font.font("Arial", 14));
        gc.fillText("Bonjour, je suis Annabelle", x - 50, y - 40);
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

    private void addWelcomeText(GraphicsContext gc) {
        // Définir la couleur et la police du texte
        gc.setFill(Color.BLACK);
        gc.setFont(Font.font("Arial", 24));

        // Dessiner le texte de bienvenue
        gc.fillText("Bienvenue dans le paysage de Andy!", 250, 50);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

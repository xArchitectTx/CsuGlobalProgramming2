package com.example.javafx_gui;

//JavaFX Imports
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UserInterface2 extends Application {
    //UI Components
    private TextArea textArea;
    private Random random = new Random();
    private BorderPane root;

    //Main Entry Point
    @Override
    public void start(Stage primaryStage) {
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");

        //Menu Items
        MenuItem showDateTimeItem = new MenuItem("Show Date/Time");
        MenuItem saveToFileItem = new MenuItem("Save to File");
        MenuItem changeColorItem = new MenuItem("Orange Background Color");
        MenuItem exitItem = new MenuItem("Exit");

        fileMenu.getItems().addAll(showDateTimeItem, saveToFileItem, changeColorItem, exitItem);
        menuBar.getMenus().add(fileMenu);

        // Create Text Area With Transparent Background
        textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setStyle(
                "-fx-control-inner-background: transparent;" +
                        "-fx-background-color: transparent;" +
                        "-fx-text-fill: black;" +
                        "-fx-background-insets: 0;" +
                        "-fx-padding: 0;"
        );

        //Layout Container 
        root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(textArea);

        Scene scene = new Scene(root, 600, 400);

        // Event handlers
        showDateTimeItem.setOnAction(e -> appendDateTime());
        saveToFileItem.setOnAction(e -> saveToFile());
        changeColorItem.setOnAction(e -> changeBackgroundColor());
        exitItem.setOnAction(e -> primaryStage.close());

        //Primary Stage
        primaryStage.setTitle("Creating a User Interface II");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Post-Display Adjustment
        Platform.runLater(() -> {
            Region viewport = (Region) textArea.lookup(".viewport");
            if (viewport != null) {
                viewport.setStyle("-fx-background-color: transparent;");
            }
        });
    }

    // Helper Method (Date/Time)
    private void appendDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        textArea.appendText("Current Date/Time: " + now.format(formatter) + "\n");
    }

    // Helper Method (Text to File)
    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"))) {
            writer.write(textArea.getText());
            textArea.appendText("Contents saved to log.txt\n");
        } catch (IOException ex) {
            textArea.appendText("Error saving to file: " + ex.getMessage() + "\n");
        }
    }

    //Change Background Color
    private void changeBackgroundColor() {
        double hue = 25 + random.nextDouble() * 10; // 25°-35° orange range
        Color color = Color.hsb(hue, 1.0, 1.0);
        root.setStyle("-fx-background-color: " + toRGBCode(color) + ";");
        textArea.appendText("Background color changed to random orange hue.\n");
    }

    // Convert Color Object to Hexadecimal CSS Color Code
    private String toRGBCode(Color color) {
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }

    // Main Method to Launch Application
    public static void main(String[] args) {
        launch(args);
    }
}
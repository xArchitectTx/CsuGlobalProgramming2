package com.example.javafx_gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class MenuApp extends Application {

    private TextArea textArea;
    private Random random = new Random();
    private BorderPane root;

    @Override
    public void start(Stage primaryStage) {
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem showDateTimeItem = new MenuItem("Show Date/Time");
        MenuItem saveToFileItem = new MenuItem("Save to File");
        MenuItem changeColorItem = new MenuItem("Change Background Color");
        MenuItem exitItem = new MenuItem("Exit");

        fileMenu.getItems().addAll(showDateTimeItem, saveToFileItem, changeColorItem, exitItem);
        menuBar.getMenus().add(fileMenu);

        // Create text area with valid CSS
        textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setStyle(
                "-fx-control-inner-background: transparent;" +
                        "-fx-background-color: transparent;" +
                        "-fx-text-fill: black;" +
                        "-fx-background-insets: 0;" +
                        "-fx-padding: 0;"
        );

        root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(textArea);

        Scene scene = new Scene(root, 600, 400);

        // Event handlers (unchanged)
        showDateTimeItem.setOnAction(e -> appendDateTime());
        saveToFileItem.setOnAction(e -> saveToFile());
        changeColorItem.setOnAction(e -> changeBackgroundColor());
        exitItem.setOnAction(e -> primaryStage.close());

        primaryStage.setTitle("JavaFX Menu Application");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Fix viewport AFTER stage is shown
        Platform.runLater(() -> {
            Region viewport = (Region) textArea.lookup(".viewport");
            if (viewport != null) {
                viewport.setStyle("-fx-background-color: transparent;");
            }
        });
    }

    private void appendDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        textArea.appendText("Current Date/Time: " + now.format(formatter) + "\n");
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"))) {
            writer.write(textArea.getText());
            textArea.appendText("Contents saved to log.txt\n");
        } catch (IOException ex) {
            textArea.appendText("Error saving to file: " + ex.getMessage() + "\n");
        }
    }

    private void changeBackgroundColor() {
        double hue = 25 + random.nextDouble() * 10; // 25°-35° orange range
        Color color = Color.hsb(hue, 1.0, 1.0);
        root.setStyle("-fx-background-color: " + toRGBCode(color) + ";");
        textArea.appendText("Background color changed to random orange hue.\n");
    }

    private String toRGBCode(Color color) {
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
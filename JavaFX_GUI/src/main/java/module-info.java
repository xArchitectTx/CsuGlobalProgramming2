module com.example.javafx_gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx_gui to javafx.fxml;
    exports com.example.javafx_gui;
}
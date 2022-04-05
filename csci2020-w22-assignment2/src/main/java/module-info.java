module com.example.csci2020w22assignment2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens com.example.csci2020w22assignment2 to javafx.fxml;
    exports com.example.csci2020w22assignment2;
}
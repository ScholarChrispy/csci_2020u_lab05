module com.lab05.lab05 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lab05.lab05 to javafx.fxml;
    exports com.lab05.lab05;
}
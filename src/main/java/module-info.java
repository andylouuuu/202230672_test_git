module org.calma.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.calma.demo to javafx.fxml;
    exports org.calma.demo;
    exports org.calma.demo.paysage;
    opens org.calma.demo.paysage to javafx.fxml;
}
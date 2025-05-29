module com.pulsomental {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.pulsomental to javafx.fxml;
    exports com.pulsomental;
}

module com.pulsomental {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    opens com.pulsomental.controllers to javafx.fxml;

    exports com.pulsomental;

    // Para Javafx 17 y posterior, es posible que deba agregar la siguiente línea
    // para garantizar que los módulos Javafx se exporten correctamente.
    requires transitive javafx.graphics;
}

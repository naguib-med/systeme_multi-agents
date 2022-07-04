module fr.univlyon.tianegociation {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens fr.univlyon.tianegociation to javafx.fxml;
    exports fr.univlyon.tianegociation;
    opens fr.univlyon.tianegociation.controller to javafx.fxml;
    exports fr.univlyon.tianegociation.controller;
}
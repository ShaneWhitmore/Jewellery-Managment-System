module com.example.jewellerystore {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires xstream;

    opens com.example.jewellerystore to javafx.fxml;
    exports com.example.jewellerystore;
}
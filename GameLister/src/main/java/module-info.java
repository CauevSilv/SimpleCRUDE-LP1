module com.devminds.gamelister {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.devminds.gamelister to javafx.base,javafx.fxml;
    opens com.devminds.gamelister.dbacces to javafx.base;
    opens com.devminds.gamelister.objects to javafx.base;
    opens com.devminds.gamelister.css to javafx.base;
    exports com.devminds.gamelister;
}
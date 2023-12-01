module com.devminds.gamelister {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.devminds.gamelister to javafx.fxml;
    exports com.devminds.gamelister;
    exports com.devminds.gamelister.controllers;
    opens com.devminds.gamelister.controllers to javafx.fxml;
}
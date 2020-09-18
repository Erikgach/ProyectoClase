module org.una {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires gson;
    requires org.apache.httpcomponents.httpclient;
    requires org.apache.httpcomponents.httpcore;
    requires java.logging;



    opens org.una.controllers to javafx.fxml;
    opens org.una.util to javafx.fxml;
    exports org.una;
    exports org.una.controllers;
    exports org.una.util;
    exports org.una.dto;

}
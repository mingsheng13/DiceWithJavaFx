module com.example.dicewithjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dicewithjavafx to javafx.fxml;
    exports com.example.dicewithjavafx;
}
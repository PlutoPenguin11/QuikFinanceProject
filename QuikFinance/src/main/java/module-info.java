module com.example.quikfinance {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.quikfinance to javafx.fxml;
    exports com.example.quikfinance;
}
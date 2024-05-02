module edu.challengeone.gameoflife {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.challengeone.gameoflife to javafx.fxml;
    exports edu.challengeone.gameoflife;
}
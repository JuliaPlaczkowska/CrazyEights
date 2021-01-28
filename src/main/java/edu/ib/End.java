

package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class End {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text txtWin;

    @FXML
    private Button btnPlayAgain;

    @FXML
    void onPlayAgain(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/start.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 800, 600);

        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        assert txtWin != null : "fx:id=\"txtWin\" was not injected: check your FXML file 'end.fxml'.";
        assert btnPlayAgain != null : "fx:id=\"btnPlayAgain\" was not injected: check your FXML file 'end.fxml'.";
        txtWin.setText(Controller.getWin());

    }
}

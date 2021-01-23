package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Start {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuButton menu;

    @FXML
    private MenuItem twoPlayers;

    @FXML
    private MenuItem threePlayers;

    @FXML
    private MenuItem fourPlayers;

    @FXML
    private Text text;

    @FXML
    private Button btnStart;

    private int nOfPlayers;

    @FXML
    void onStartGame(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/table.fxml"));
        Parent root = loader.load();

        Scene scene= new Scene(root,1200,800);

        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void set2Players(ActionEvent event) {
        nOfPlayers = 2;
        text.setText(String.valueOf(nOfPlayers));
    }

    @FXML
    void set3Players(ActionEvent event) {
        nOfPlayers = 3;
        text.setText(String.valueOf(nOfPlayers));
    }

    @FXML
    void set4Players(ActionEvent event) {
        nOfPlayers = 4;
        text.setText(String.valueOf(nOfPlayers));
    }

    @FXML
    void initialize() {
        assert menu != null : "fx:id=\"menu\" was not injected: check your FXML file 'start.fxml'.";
        assert twoPlayers != null : "fx:id=\"twoPlayers\" was not injected: check your FXML file 'start.fxml'.";
        assert threePlayers != null : "fx:id=\"threePlayers\" was not injected: check your FXML file 'start.fxml'.";
        assert fourPlayers != null : "fx:id=\"fourPlayers\" was not injected: check your FXML file 'start.fxml'.";
        assert btnStart != null : "fx:id=\"btnStart\" was not injected: check your FXML file 'start.fxml'.";

    }
}

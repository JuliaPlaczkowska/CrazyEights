package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.prism.paint.Gradient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Start {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Image CPUHand;

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

    private static int nOfPlayers;

    /**
     * Metoda onStartGame
     * Metoda ta wywołuję pierwszą scenę po uruchomieniu aplikacji. Zawiera ona wybór ilości graczy i przycisk start.
     * **/
    @FXML
    void onStartGame(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/table.fxml"));
        Parent root = loader.load();

        Scene scene= new Scene(root,1200,800);

        scene.getStylesheets().addAll(this.getClass().getResource("/fxml/background.css").toExternalForm());

        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);

        stage.show();

    }
    /**
     * Metoda set2Players
     * Metoda ta ustawia liczbe graczy na 2.
     * **/
    @FXML
    void set2Players(ActionEvent event) {
        nOfPlayers = 2;
        text.setText(String.valueOf(nOfPlayers));
    }
    /**
     * Metoda set3Players
     * Metoda ta ustawia liczbe graczy na 3.
     * **/
    @FXML
    void set3Players(ActionEvent event) {
        nOfPlayers = 3;
        text.setText(String.valueOf(nOfPlayers));
    }
    /**
     * Metoda set4Players
     * Metoda ta ustawia liczbe graczy na 4.
     * **/
    @FXML
    void set4Players(ActionEvent event) {
        nOfPlayers = 4;
        text.setText(String.valueOf(nOfPlayers));
    }
    /**
     * Metoda nop
     * Metoda ta zwraca liczbę wybranych graczy. Została stworzona aby można było znać tą wartość w innych klasach.
     * **/
   public static int nop(){
        return nOfPlayers;
   }

    /**
     * This method is called by the FXMLLoader when initialization is complete
     */
    @FXML
    void initialize() {
        assert menu != null : "fx:id=\"menu\" was not injected: check your FXML file 'start.fxml'.";
        assert twoPlayers != null : "fx:id=\"twoPlayers\" was not injected: check your FXML file 'start.fxml'.";
        assert threePlayers != null : "fx:id=\"threePlayers\" was not injected: check your FXML file 'start.fxml'.";
        assert fourPlayers != null : "fx:id=\"fourPlayers\" was not injected: check your FXML file 'start.fxml'.";
        assert btnStart != null : "fx:id=\"btnStart\" was not injected: check your FXML file 'start.fxml'.";

    }



}

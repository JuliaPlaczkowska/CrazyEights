package edu.ib;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.naming.ldap.Control;


public class Osemka  {
Deck deckeights = new Deck();


    @FXML
    private Button btnH;

    @FXML
    private Button btnC;

    @FXML
    private Button btnS;

    @FXML
    private Button btnD;

    @FXML
    private Button btnConfirm;

    private String suit = "";


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        setIcon(btnH, "Hearts.png");
        setIcon(btnC, "Clubs.png");
        setIcon(btnS, "Spades.png");
        setIcon(btnD, "Diamonds.png");

    }

    private void setIcon(Button button,String name){
        Image icon = new Image("images/PNG/"+name);
        ImageView imageView = new ImageView(icon);
        int size = 65;
        imageView.setFitWidth(size);
        imageView.setFitHeight((int)(size * icon.getHeight() / icon.getWidth()));
        button.setText(null);
        button.setGraphic(imageView);


    }

    @FXML
    void onClub(ActionEvent event) {
        suit = "CLUB";

    }

    @FXML
    void onDiamond(ActionEvent event) {
        suit = "DIAMOND";
    }

    @FXML
    void onHeart(ActionEvent event) {
        suit = "HEART";
    }

    @FXML
    void onSpade(ActionEvent event) {
        suit = "SPADE";
    }


    @FXML
    void onConfirm(ActionEvent event) {
//event.

    }



}

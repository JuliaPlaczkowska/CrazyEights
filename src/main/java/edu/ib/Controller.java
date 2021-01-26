package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import animatefx.animation.Bounce;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.sound.midi.Track;

public class Controller {


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private Button btnDealCards;

    @FXML
    private Button btnConfirm;

    @FXML // fx:id="btnCard"
    private Button btnCard; // Value injected by FXMLLoader

    @FXML
    private List<Button> btnList = new ArrayList<>();

    @FXML
    private Button btnCard1;

    @FXML
    private Button btnCard2;

    @FXML
    private Button btnCard3;

    @FXML
    private Button btnCard4;

    @FXML
    private Button btnCard5;

    @FXML
    private Button btnCard6;

    @FXML
    private Button btnCard7;

    @FXML
    private Button btnCard8;

    @FXML
    private Button btnCard9;

    @FXML
    private Button btnCard10;

    @FXML
    private Button btnCard11;

    @FXML
    private Button btnCard12;

    @FXML
    private Button btnTopCard;

    @FXML
    private ImageView CPU1;

    @FXML
    private ImageView CPU2;

    @FXML
    private ImageView CPU3;


    private Gameplay gameplay;
    private int nOfPlayers= Start.nop();
    private Deck cardsClicked;
    private ArrayList<String> buttons = new ArrayList<>();;


    @FXML
    void onDeck1(ActionEvent event) {

        gameplay.getPlayers().get(0).takeACard(gameplay.getDeck1());
        showHandGPU();

    }

    public void initData(int nOfPlayers){

        this.nOfPlayers = nOfPlayers;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        btnTopCard.setVisible(false);
        btnConfirm.setVisible(false);
        assert btnCard != null : "fx:id=\"btnCard\" was not injected: check your FXML file 'table.fxml'.";
        setIcon(btnCard, "back.jpg");

    }

    @FXML
    void onDealCards(ActionEvent event) {

        btnDealCards.setText("RESTART");
        if(nOfPlayers == 0)
            nOfPlayers = 2;
        gameplay = new Gameplay(nOfPlayers);

        gameplay.dealCards();
        cardsClicked = new Deck();
        //cardsClicked.add(gameplay.getPlayers().get(0).getHandCards().get(0));
        showHandGPU();
    }

    @FXML
    void onHand(ActionEvent e) {

        if ( e.getSource().equals(btnCard1)) {
            btnList.add(btnCard1);
            cardsClicked.addCard(gameplay.getPlayers().get(0).getHandCards().get(0));
            btnCard1.setTranslateY(-300);
        } else if (e.getSource().equals(btnCard2)) {
            btnList.add(btnCard2);
            cardsClicked.addCard(gameplay.getPlayers().get(0).getHandCards().get(1));
            btnCard2.setTranslateY(-300);
        } else if (e.getSource().equals(btnCard3)) {
            btnList.add(btnCard3);
            cardsClicked.addCard(gameplay.getPlayers().get(0).getHandCards().get(2));
            btnCard3.setTranslateY(-300);
        } else if (e.getSource().equals(btnCard4) ){
            btnList.add(btnCard4);
            cardsClicked.addCard(gameplay.getPlayers().get(0).getHandCards().get(3));
            btnCard4.setTranslateY(-300);
        } else if (e.getSource().equals(btnCard5)) {
            btnList.add(btnCard5);
            cardsClicked.addCard(gameplay.getPlayers().get(0).getHandCards().get(4));
            btnCard5.setTranslateY(-300);
        } else if (e.getSource().equals(btnCard6)) {
            btnList.add(btnCard6);
            cardsClicked.addCard(gameplay.getPlayers().get(0).getHandCards().get(5));
            btnCard6.setTranslateY(-300);
        } else if (e.getSource().equals(btnCard7)) {
            btnList.add(btnCard7);
            cardsClicked.addCard(gameplay.getPlayers().get(0).getHandCards().get(6));
            btnCard7.setTranslateY(-300);
        } else if (e.getSource().equals(btnCard8)) {
            btnList.add(btnCard8);
            cardsClicked.addCard(gameplay.getPlayers().get(0).getHandCards().get(7));
            btnCard8.setTranslateY(-300);
        } else if (e.getSource().equals(btnCard9)) {
            btnList.add(btnCard9);
            cardsClicked.addCard(gameplay.getPlayers().get(0).getHandCards().get(8));
            btnCard9.setTranslateY(-300);
        } else if (e.getSource().equals(btnCard10)) {
            btnList.add(btnCard10);
            cardsClicked.addCard(gameplay.getPlayers().get(0).getHandCards().get(9));
            btnCard10.setTranslateY(-300);
        } else if (e.getSource().equals(btnCard11)) {
            btnList.add(btnCard11);
            cardsClicked.addCard(gameplay.getPlayers().get(0).getHandCards().get(10));
            btnCard11.setTranslateY(-300);
        }
        else if (e.getSource().equals(btnCard12)) {
            btnList.add(btnCard12);
            cardsClicked.addCard(gameplay.getPlayers().get(0).getHandCards().get(11));
            btnCard12.setTranslateY(-300);
        }
    }

    @FXML
    void onConfirm(ActionEvent event){


        Deck cards = cardsClicked;

        int ok = gameplay.getPlayers().get(0).getMove(cards, gameplay.getDeck2());

        if(ok == 2){
            for (int i = 0; i < cardsClicked.size() ; i++) {


                gameplay.setTopCard(gameplay.getDeck2().get(gameplay.getDeck2().size()-1));
                showHandGPU();
                bounceBTN(btnTopCard);
                ok = 0;
                cardsClicked = new Deck();

                gameplay.turn(1);
                gameplay.setTopCard(gameplay.getDeck2().get(gameplay.getDeck2().size()-1));
                showHandGPU();
                bounceBTN(btnTopCard);

                if (gameplay.getPlayers().size()>=3){
                    gameplay.turn(2);
                    gameplay.setTopCard(gameplay.getDeck2().get(gameplay.getDeck2().size()-1));
                    bounceBTN(btnTopCard);
                showHandGPU();}

                if (gameplay.getPlayers().size()>=4) {
                    gameplay.turn(3);
                    gameplay.setTopCard(gameplay.getDeck2().get(gameplay.getDeck2().size()-1));
                    bounceBTN(btnTopCard);
                }

                showHandGPU();
            }

        }else if(ok == 0){
            for (int i = 0; i < btnList.size(); i++) {
            }
            showHandGPU();
        }
        else {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/osemka.fxml"));
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Scene scene= new Scene(root,1200,800);

            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();

            stage.setScene(scene);
            stage.show();

            // tutaj obslugujemy crazy eights
        }
    }

    private void bounceBTN(Button button){
        new Bounce(button).setSpeed(0.1).play();
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

    private void showHandGPU(){

        btnConfirm.setVisible(true);

        Card c = gameplay.getDeck2().get(gameplay.getDeck2().size()-1);
        btnTopCard.setVisible(true);
        setIcon(btnTopCard,(c.getRankIMG()+c.getSuitIMG()+".png") );

        //GPU initial cards

        if(gameplay.getPlayers().get(0).getHandCards().size()>=1){
        c = gameplay.getPlayers().get(0).getHandCards().get(0);
        btnCard1.setTranslateY(-250);
        setIcon(btnCard1,(c.getRankIMG()+c.getSuitIMG()+".png"));
        }
        else
            btnCard1.setTranslateY(0);

        if(gameplay.getPlayers().get(0).getHandCards().size()>=2){
        c = gameplay.getPlayers().get(0).getHandCards().get(1);

        setIcon(btnCard2,(c.getRankIMG()+c.getSuitIMG()+".png"));
        btnCard2.setTranslateY(-250);
        }
        else
            btnCard2.setTranslateY(0);




        if(gameplay.getPlayers().get(0).getHandCards().size()>=3) {
            c = gameplay.getPlayers().get(0).getHandCards().get(2);

            setIcon(btnCard3, (c.getRankIMG() + c.getSuitIMG() + ".png"));
            btnCard3.setTranslateY(-250);
        }else
            btnCard3.setTranslateY(0);

        if(gameplay.getPlayers().get(0).getHandCards().size()>=4) {
            c = gameplay.getPlayers().get(0).getHandCards().get(3);

            setIcon(btnCard4, (c.getRankIMG() + c.getSuitIMG() + ".png"));
            btnCard4.setTranslateY(-250);
        }else
            btnCard4.setTranslateY(0);

        if(gameplay.getPlayers().get(0).getHandCards().size()>=5) {
            c = gameplay.getPlayers().get(0).getHandCards().get(4);

            setIcon(btnCard5, (c.getRankIMG() + c.getSuitIMG() + ".png"));
            btnCard5.setTranslateY(-250);
        }else
            btnCard5.setTranslateY(0);

        if(gameplay.getPlayers().get(0).getHandCards().size()>=6) {
            c = gameplay.getPlayers().get(0).getHandCards().get(5);

            setIcon(btnCard6, (c.getRankIMG() + c.getSuitIMG() + ".png"));
            btnCard6.setTranslateY(-250);
        }else
            btnCard6.setTranslateY(0);

        if(gameplay.getPlayers().get(0).getHandCards().size()>=7) {
            c = gameplay.getPlayers().get(0).getHandCards().get(6);

            setIcon(btnCard7, (c.getRankIMG() + c.getSuitIMG() + ".png"));
            btnCard7.setTranslateY(-250);
        }else
            btnCard7.setTranslateY(0);

        if(gameplay.getPlayers().get(0).getHandCards().size()>=8) {
            c = gameplay.getPlayers().get(0).getHandCards().get(7);

            setIcon(btnCard8, (c.getRankIMG() + c.getSuitIMG() + ".png"));
            btnCard8.setTranslateY(-250);
        }else
            btnCard8.setTranslateY(0);

        if(gameplay.getPlayers().get(0).getHandCards().size()>=9) {
            c = gameplay.getPlayers().get(0).getHandCards().get(8);

            setIcon(btnCard9, (c.getRankIMG() + c.getSuitIMG() + ".png"));
            btnCard9.setTranslateY(-250);
        }else
            btnCard9.setTranslateY(0);

        if(gameplay.getPlayers().get(0).getHandCards().size()>=10) {
            c = gameplay.getPlayers().get(0).getHandCards().get(9);

            setIcon(btnCard10, (c.getRankIMG() + c.getSuitIMG() + ".png"));
            btnCard10.setTranslateY(-250);
        }else
            btnCard10.setTranslateY(0);

        if(gameplay.getPlayers().get(0).getHandCards().size()>=11) {
            c = gameplay.getPlayers().get(0).getHandCards().get(10);

            setIcon(btnCard11, (c.getRankIMG() + c.getSuitIMG() + ".png"));
            btnCard11.setTranslateY(-250);
        }else
            btnCard11.setTranslateY(0);

        if(gameplay.getPlayers().get(0).getHandCards().size()>=12) {
            c = gameplay.getPlayers().get(0).getHandCards().get(11);

            setIcon(btnCard12, (c.getRankIMG() + c.getSuitIMG() + ".png"));
            btnCard12.setTranslateY(-250);
        }else
            btnCard12.setTranslateY(0);

        if (gameplay.getPlayers().size() >= 2) {

            switch (gameplay.getPlayers().get(1).getHandCards().size()) {
                case 1:
                    CPU1.setImage(new Image("images/PNG/back.jpg"));
                    break;
                case 2:
                    CPU1.setImage(new Image("2karty.png"));
                    break;
                case 3:
                    CPU1.setImage(new Image("3karty.png"));
                    break;
                case 4:
                    CPU1.setImage(new Image("4karty.png"));
                    break;
                case 5:
                    CPU1.setImage(new Image("5kart.png"));
                    break;
                case 6:
                    CPU1.setImage(new Image("6kart.png"));
                    break;
                case 7:
                    CPU1.setImage(new Image("7kart.png"));
                    break;
                case 8:
                    CPU1.setImage(new Image("8kart.png"));
                    break;
                case 9:
                    CPU1.setImage(new Image("9kart.png"));
                    break;
                case 10:
                    CPU1.setImage(new Image("10kart.png"));
                    break;
                case 11:
                    CPU1.setImage(new Image("11kart.png"));
                    break;
            }
            CPU1.setRotate(90);
            CPU1.setFitHeight(150);
            CPU1.setFitWidth(190);
        }


        if (gameplay.getPlayers().size() >= 3) {
            switch (gameplay.getPlayers().get(2).getHandCards().size()) {
                case 1:
                    CPU2.setImage(new Image("images/PNG/back.jpg"));
                    break;
                case 2:
                    CPU2.setImage(new Image("2karty.png"));
                    break;
                case 3:
                    CPU2.setImage(new Image("3karty.png"));
                    break;
                case 4:
                    CPU2.setImage(new Image("4karty.png"));
                    break;
                case 5:
                    CPU2.setImage(new Image("5kart.png"));
                    break;
                case 6:
                    CPU2.setImage(new Image("6kart.png"));
                    break;
                case 7:
                    CPU2.setImage(new Image("7kart.png"));
                    break;
                case 8:
                    CPU2.setImage(new Image("8kart.png"));
                    break;
                case 9:
                    CPU2.setImage(new Image("9kart.png"));
                    break;
                case 10:
                    CPU2.setImage(new Image("10kart.png"));
                    break;
                case 11:
                    CPU2.setImage(new Image("11kart.png"));
                    break;
            }
        }

        CPU2.setRotate(180);
        CPU2.setFitHeight(150);
        CPU2.setFitWidth(190);

        if (gameplay.getPlayers().size() >= 4) {
            switch (gameplay.getPlayers().get(3).getHandCards().size()) {
                case 1:
                    CPU3.setImage(new Image("images/PNG/back.jpg"));
                    break;
                case 2:
                    CPU3.setImage(new Image("2karty.png"));
                    break;
                case 3:
                    CPU3.setImage(new Image("3karty.png"));
                    break;
                case 4:
                    CPU3.setImage(new Image("4karty.png"));
                    break;
                case 5:
                    CPU3.setImage(new Image("5kart.png"));
                    break;
                case 6:
                    CPU3.setImage(new Image("6kart.png"));
                    break;
                case 7:
                    CPU3.setImage(new Image("7kart.png"));
                    break;
                case 8:
                    CPU3.setImage(new Image("8kart.png"));
                    break;
                case 9:
                    CPU3.setImage(new Image("9kart.png"));
                    break;
                case 10:
                    CPU3.setImage(new Image("10kart.png"));
                    break;
                case 11:
                    CPU3.setImage(new Image("11kart.png"));
                    break;
            }

            CPU3.setRotate(-90);
            CPU3.setFitHeight(150);
            CPU3.setFitWidth(190);
        }

    }

}

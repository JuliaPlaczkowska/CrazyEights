package edu.ib;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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
    private List<Button> btnList;

    @FXML
    private Button btnCard1;

    @FXML
    private Button btnCard11;

    @FXML
    private Button btnCard12;

    @FXML
    private Button btnCard13;

    @FXML
    private Button btnCard14;

    @FXML
    private Button btnCard15;

    @FXML
    private Button btnCard16;

    @FXML
    private Button btnCard17;

    @FXML
    private Button btnCard18;

    @FXML
    private Button btnCard19;

    @FXML
    private Button btnCard110;

    @FXML
    private Button btnTopCard;

    private Gameplay gameplay;
    private int nOfPlayers = 4;
    private ArrayList<String> buttons;

    @FXML
    void onDeck1(ActionEvent event) {

        switch(gameplay.getPlayers().get(0).getHandCards().size()){
            case 1 :
        };

    }

    public void initData(int nOfPlayers){
        this.nOfPlayers = nOfPlayers;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCard != null : "fx:id=\"btnCard\" was not injected: check your FXML file 'table.fxml'.";
        setIcon(btnCard, "back.jpg");

    }

    @FXML
    void onDealCards(ActionEvent event) {

        btnDealCards.setText("RESTART");
        gameplay = new Gameplay(2);

        gameplay.dealCards();

//        btnCard1.setTranslateY(500);
//        btnCard1.setText(String.valueOf(gameplay.getPlayers().get(0).getHandCards().size()));
        //System.out.println(gameplay.getPlayers());
        Card c = gameplay.getTopCard();
        btnTopCard.setTranslateY(200);
        btnTopCard.setText(c.getValue()+"-"+c.getSuitValue());
        setIcon(btnTopCard,(c.getRankIMG()+c.getSuitIMG()+".png") );

        //GPU initial cards

        c = gameplay.getPlayers().get(0).getHandCards().get(0);
        //Card c = gameplay.getDeck1().getCard(0);

        btnCard1.setTranslateY(500);
        btnCard1.setText(String.valueOf(gameplay.getPlayers().size()));
        btnCard1.setText(c.getValue()+"-"+c.getSuitValue());
        setIcon(btnCard1,(c.getRankIMG()+c.getSuitIMG()+".png"));

        c = gameplay.getPlayers().get(0).getHandCards().get(1);
        c = gameplay.getDeck1().getCard(1);
        setIcon(btnCard11,(c.getRankIMG()+c.getSuitIMG()+".png"));
        btnCard11.setText(c.getValue()+"-"+c.getSuitValue());
        btnCard11.setTranslateY(500);
//        btnCard12.setText(String.valueOf(gameplay.getPlayers().get(0).getHandCards().size()));
//
        c = gameplay.getPlayers().get(0).getHandCards().get(2);
        setIcon(btnCard12,(c.getRankIMG()+c.getSuitIMG()+".png"));
        btnCard12.setText(c.getValue()+"-"+c.getSuitValue());
        btnCard12.setTranslateY(500);


        c = gameplay.getPlayers().get(0).getHandCards().get(3);
        setIcon(btnCard13,(c.getRankIMG()+c.getSuitIMG()+".png"));
        btnCard13.setText(c.getValue()+"-"+c.getSuitValue());
        btnCard13.setTranslateY(500);

        c = gameplay.getPlayers().get(0).getHandCards().get(4);
        setIcon(btnCard14,(c.getRankIMG()+c.getSuitIMG()+".png"));
        btnCard14.setText(c.getValue()+"-"+c.getSuitValue());
        btnCard14.setTranslateY(500);

        c = gameplay.getPlayers().get(0).getHandCards().get(5);
        setIcon(btnCard15,(c.getRankIMG()+c.getSuitIMG()+".png"));
        btnCard15.setText(c.getValue()+"-"+c.getSuitValue());
        btnCard15.setTranslateY(500);

        c = gameplay.getPlayers().get(0).getHandCards().get(6);
        setIcon(btnCard16,(c.getRankIMG()+c.getSuitIMG()+".png"));
        btnCard16.setText(c.getValue()+"-"+c.getSuitValue());
        btnCard16.setTranslateY(500);


    }

    @FXML
    void onHand(ActionEvent event) {
        Button b = (Button) event.getSource();
        btnList.add(b);
        buttons.add(b.getText());
    }

    @FXML
    void onConfirm(ActionEvent event) {

        Deck cards = new Deck();
        String[] card = new String[2];
        for (int i = 0; i < buttons.size(); i++) {
            card = buttons.get(i).split("-");
            cards.add(new Card(Integer.parseInt(card[0]), Integer.parseInt(card[1])));
        }
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

}

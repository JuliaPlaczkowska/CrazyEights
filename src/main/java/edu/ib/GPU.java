package edu.ib;

public class GPU extends Player {


    public GPU(Deck hand, int id) {
        super(hand, id);
    }

    @Override
    public void makeMove(Deck deck1, Deck deck2, Card topCard) {

    }

//    @Override
//    public void makeMove(Deck deck1, Deck deck2, Card topCard, boolean firstMove) {
//
//
//    }

    public int getMove(Deck hand2, Deck deck2){

        int ok = 0; // 0 - nieprawidlowy wybor, 1 - osemka, 2 - prawidlowy wybor, ale nie osemka

        Card firstCard = hand2.getCard(0);
        Card topCard = deck2.getCard(deck2.size()-1);
        int count = hand2.size();

       if(firstCard.getValue() != topCard.getValue() && !firstCard.getSuit().equals(topCard.getSuit()) && firstCard.getValue()!=8) {
           ok = 0;
       }else if(firstCard.getValue()==8){
           ok = 1;
           for (int i = 1; i < count; i++) {
               if(hand2.getCard(i).getValue()!=8)
                   ok = 0;
           }

       }else {
           for (int i = 0; i < hand2.size(); i++) {
               playACard(deck2, hand2.getCard(i));
           }
       }

        return ok;
    }






}

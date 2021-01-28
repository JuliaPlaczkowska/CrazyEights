package edu.ib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GPU extends Player {


    public GPU(Deck hand, int id) {
        super(hand, id);
    }

    @Override
    public void makeMove(Deck deck1, Deck deck2, Card topCard) {
        int ok;
        Deck possibleRanks = new Deck();
        Deck possibleSuits = new Deck();
        Deck possibleEights = new Deck();
        Deck possibleSuitsRanks = new Deck();
        int i1 = a++;
        //System.out.println("Numer przejścia: " + a);
        System.out.println("ID GRACZA:" + getID());
     //  if(a==1) {
      //     for (int i = 0; i < getHandCards().size(); i++) {
      //         System.out.println("Ręka startowa " + a + " " + getHandCards().getCard(i).value + " " + getHandCards().getCard(i).getSuit());


         //  }
      // }


        //System.out.println("ID GRACZA " + getID());

        Deck fourDeck = new Deck();
        Deck threeDeck = new Deck();
        Deck twoDeck = new Deck();



        Integer[] ranks2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};


        for (int i = 0; i < deck1.size(); i++) {
            if (deck1.get(i).getSuit().equals(deck2.get(deck2.size()-1).getSuit())) {
                possibleSuits.addCard(deck1.get(i));


            }
            if (deck1.get(i).getRank().equals(deck2.get(deck2.size()-1).getRank())) {
                possibleRanks.addCard(deck1.get(i));

            }

            if (deck1.get(i).getValue() == 8) {
                possibleEights.addCard(deck1.get(i));

            }

        }



        for (int i = 0; i < deck1.size(); i++) {
            for (int j = 0; j < possibleSuits.size(); j++) {
                if (possibleSuits.getCard(j).getValue() == deck1.get(i).getValue()) {
                    possibleSuitsRanks.addCard(deck1.get(i));

                }
            }

        }


        for (int i = 0; i < possibleSuitsRanks.size(); i++) {

            if (possibleSuitsRanks.get(i).getValue() == 2) {
                ranks2[2]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 3) {
                ranks2[3]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 4) {
                ranks2[4]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 5) {
                ranks2[5]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 6) {
                ranks2[6]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 7) {
                ranks2[7]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 9) {
                ranks2[9]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 10) {
                ranks2[10]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 11) {
                ranks2[11]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 12) {
                ranks2[12]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 13) {
                ranks2[13]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 14) {
                ranks2[14]++;
            }
        }



        if (Arrays.asList(ranks2).contains(4)) {
            for (int i = 0; i < 4; i++) {

                for (int j = 0; j < possibleSuitsRanks.size(); j++) {
                    if (possibleSuitsRanks.get(j).getValue() == (Arrays.asList(ranks2).indexOf(4))) {
                        fourDeck.addCard(possibleSuitsRanks.get(j));
                    }
                }

                playACard(deck2, fourDeck.get(i));
            }

        }
        else if (possibleRanks.size() == 4) {
            for (int i = 0; i < possibleRanks.size(); i++) {

                playACard(deck2, possibleRanks.get(i));
            }


        } else if (Arrays.asList(ranks2).contains(3)) {
            for (int i = 0; i < 3; i++) {

                for (int j = 0; j < possibleSuitsRanks.size(); j++) {
                    if (possibleSuitsRanks.get(j).getValue() == (Arrays.asList(ranks2).indexOf(3))) {
                        threeDeck.addCard(possibleSuitsRanks.get(j));
                    }
                }

                playACard(deck2, threeDeck.get(i));
            }

        } else if (possibleRanks.size() == 3) {
            for (int i = 0; i < possibleRanks.size(); i++) {
                playACard(deck2, possibleRanks.get(i));
            }


        } else if (Arrays.asList(ranks2).contains(2)) {
            for (int i = 0; i < 2; i++) {

                for (int j = 0; j < possibleSuitsRanks.size(); j++) {
                    if (possibleSuitsRanks.get(j).getValue() == (Arrays.asList(ranks2).indexOf(2))) {
                        twoDeck.addCard(possibleSuitsRanks.get(j));
                    }
                }

                playACard(deck2, twoDeck.get(i));
            }

        } else if (possibleRanks.size() == 2) {
            for (int i = 0; i < possibleRanks.size(); i++) {

                playACard(deck2, possibleRanks.get(i));
            }
        } else if (possibleRanks.size() == 1) {

            playACard(deck2, possibleRanks.get(0));
        } else if (!possibleSuits.isEmpty()) {

            // playACard(deck2, getHandCards().get(getHandCards().indexOf(possibleSuits.get(0))));
            playACard(deck2, possibleSuits.get(0));
        }


        //ÓSEMKI:

        else if (possibleEights.size() == 4) {
            for (int i = 0; i < possibleEights.size(); i++) {

                playACard(deck2, possibleEights.get(i));

            }
        } else if (possibleEights.size() == 3) {
            for (int i = 0; i < possibleEights.size(); i++) {

                playACard(deck2, possibleEights.get(i));
            }
        } else if (possibleEights.size() == 2) {
            for (int i = 0; i < possibleEights.size(); i++) {

                playACard(deck2, possibleEights.get(i));


            }
        } else if (possibleEights.size() == 1) {

            playACard(deck2, possibleEights.get(0));


        }
        else {
            //System.out.println("");


        }


    }
//    @Override
//    public void makeMove(Deck deck1, Deck deck2, Card topCard, boolean firstMove) {
//
//
//    }



    public int getMove(Deck deck1, Deck deck2) {


        Card topCard = deck2.getCard(deck2.size()-1);
        int ok;
        Deck possibleRanks = new Deck();
        Deck possibleSuits = new Deck();
        Deck possibleEights = new Deck();
        Deck possibleSuitsRanks = new Deck();
        int i1 = a++;
        //.out.println("Numer przejścia: " + a);
      //  for (int i = 0; i < getHandCards().size(); i++) {
           // System.out.println("Ręka " + a + " " + getHandCards().getCard(i).value + " " + getHandCards().getCard(i).getSuit());
        //}

        //System.out.println("ID GRACZA " + getID());



        Deck fourDeck = new Deck();
        Deck threeDeck = new Deck();
        Deck twoDeck = new Deck();

        int[] ranks = new int[12];

        Integer[] ranks2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ArrayList ranks23 = new ArrayList<>();

        Random picksuit = new Random();


        for (int i = 0; i < deck1.size(); i++) {
            if (deck1.get(i).getSuit().equals(deck2.get(deck2.size()-1).getSuit()) && deck1.get(i).getValue() != 8) {
                possibleSuits.addCard(deck1.get(i));


            }
            if (deck1.get(i).getRank().equals(deck2.get(deck2.size()-1).getRank()) && deck1.get(i).getValue() != 8) {
                possibleRanks.addCard(deck1.get(i));

            }

            if (deck1.get(i).getValue() == 8) {
                possibleEights.addCard(deck1.get(i));

            }

        }



        for (int i = 0; i < deck1.size(); i++) {
            for (int j = 0; j < possibleSuits.size(); j++) {
                if (possibleSuits.getCard(j).getValue() ==deck1.get(i).getValue()) {
                    possibleSuitsRanks.addCard(deck1.get(i));

                }
            }

        }


        for (int i = 0; i < possibleSuitsRanks.size(); i++) {

            if (possibleSuitsRanks.get(i).getValue() == 2) {
                ranks2[2]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 3) {
                ranks2[3]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 4) {
                ranks2[4]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 5) {
                ranks2[5]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 6) {
                ranks2[6]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 7) {
                ranks2[7]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 9) {
                ranks2[9]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 10) {
                ranks2[10]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 11) {
                ranks2[11]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 12) {
                ranks2[12]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 13) {
                ranks2[13]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 14) {
                ranks2[14]++;
            }
        }



        if (Arrays.asList(ranks2).contains(4)) {
            if (possibleSuitsRanks.size()==deck1.size()){
                ok=1;
            }
            else{
                ok=0;
            }


        }
        else if (possibleRanks.size() == 4) {
            if (possibleRanks.size()==deck1.size()){
                ok=1;
            }
            else{
                ok=0;
            }


        } else if (Arrays.asList(ranks2).contains(3)) {
            if (possibleSuitsRanks.size()==deck1.size()){
                ok=1;
            }
            else{
                ok=0;
            }

        } else if (possibleRanks.size() == 3) {
            if (possibleRanks.size()==deck1.size()){
                ok=1;
            }
            else{
                ok=0;
            }

        } else if (Arrays.asList(ranks2).contains(2)) {
            if (possibleSuitsRanks.size()==deck1.size()){
                ok=1;
            }
            else{
                ok=0;
            }

        } else if (possibleRanks.size() == 2) {
            if (possibleRanks.size()==deck1.size()){
                ok=1;
            }
            else{
                ok=0;
            }
        } else if (possibleRanks.size() == 1) {
            if (possibleRanks.size()==deck1.size()){
                ok=1;
            }
            else{
                ok=0;
            }

        } else if (possibleSuits.size() ==1) {
            if (possibleSuits.size()==deck1.size()){
                ok=1;
            }
            else{
                ok=0;
            }
            // playACard(deck2, getHandCards().get(getHandCards().indexOf(possibleSuits.get(0))));

        }


        //ÓSEMKI:

        else if (possibleEights.size() == 4) {
            if (possibleEights.size()==deck1.size()){
                ok=2;
            }
            else{
                ok=0;
            }


        } else if (possibleEights.size() == 3) {
            if (possibleEights.size()==deck1.size()){
                ok=2;
            }
            else{
                ok=0;
            }

        } else if (possibleEights.size() == 2) {
            if (possibleEights.size()==deck1.size()){
                ok=2;
            }
            else{
                ok=0;
            }

        } else if (possibleEights.size() == 1) {
            if (possibleEights.size()==deck1.size()){
                ok=2;
            }
            else{
                ok=0;
            }
        }
        else {
            ok =0;
        }

        return ok;


    }

/*
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

*/
}

package edu.ib;

import org.w3c.dom.ls.LSOutput;

import java.text.DecimalFormat;
import java.util.*;

public class CPU extends Player {


    public CPU(Deck hand, int id) {
        super(hand, id);
    }

    @Override
    public void makeMove(Deck deck1, Deck deck2, Card topCard) {
        Deck possibleRanks = new Deck();
        Deck possibleSuits = new Deck();
        Deck possibleEights = new Deck();
        Deck possibleSuitsRanks = new Deck();
        int i1 = a++;
        System.out.println("Numer przejścia: " + a);
        for (int i = 0; i < getHandCards().size(); i++) {
            System.out.println("Ręka " + a + " " + getHandCards().getCard(i).value + " " + getHandCards().getCard(i).getSuit());
        }

        System.out.println("ID GRACZA " + getID());



        Deck fourDeck = new Deck();
        Deck threeDeck = new Deck();
        Deck twoDeck = new Deck();

        int[] ranks = new int[12];

        Integer[] ranks2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ArrayList ranks23 = new ArrayList<>();

        Random picksuit = new Random();

        //System.out.println("pierwsze karta " + getHandCards().get(0).getValue());
        //System.out.println("top karta " + topCard.getValue() + " " +topCard.getSuit());


        for (int i = 0; i < getHandCards().size(); i++) {
            if (getHandCards().get(i).getSuit().equals(topCard.getSuit())) {
                possibleSuits.addCard(getHandCards().get(i));


            }
            if (getHandCards().get(i).getRank().equals(topCard.getRank())) {
                possibleRanks.addCard(getHandCards().get(i));

            }

            if (getHandCards().get(i).getValue() == 8) {
                possibleEights.addCard(getHandCards().get(i));

            }

            //ranks[getHandCards().get(i).getValue() - 2] = ranks[getHandCards().get(i).getValue() - 2] + 1;
        }
        //  for (int i = 0; i < possibleSuits.size(); i++) {
        //     System.out.println("suity " + possibleSuits.getCard(i).getValue() + " " + possibleSuits.getCard(i).getSuit());
        //}

        //for (int i = 0; i < possibleRanks.size(); i++) {
        //  System.out.println("ranki " + possibleRanks.getCard(i).getValue() + " " + possibleRanks.getCard(i).getSuit());
        //}


        //System.out.println("suity " + possibleSuits.get(0).getValue());
        //System.out.println("ranki" + possibleRanks.get(0).getValue());


        for (int i = 0; i < getHandCards().size(); i++) {
            for (int j = 0; j < possibleSuits.size(); j++) {
                if (possibleSuits.getCard(j).getValue() == getHandCards().get(i).getValue()) {
                    possibleSuitsRanks.addCard(getHandCards().get(i));

                }
            }

        }


        //  for (int i = 0; i < possibleSuitsRanks.size(); i++) {
        //    System.out.println("suity ranks " + possibleSuitsRanks.getCard(i).getValue() + " " + possibleSuitsRanks.getCard(i).getSuit());
        //}

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

        //for (int i = 0; i < ranks2.length; i++) {
        //    System.out.println(ranks2[i]);
        //  }


//[0,0,3,1,0,4,2,0]
        //ZAGRYWANIE(OD NAJWAZNIEJSZYCH WARUNKOW) :


        if (Arrays.asList(ranks2).contains(4)) {
            for (int i = 0; i < 4; i++) {

                for (int j = 0; j < possibleSuitsRanks.size(); j++) {
                    if (possibleSuitsRanks.get(j).getValue() == (Arrays.asList(ranks2).indexOf(4))) {
                        fourDeck.addCard(possibleSuitsRanks.get(j));
                    }
                }
                playACard(deck2, fourDeck.get(i));
            }

        } else if (possibleRanks.size() == 4) {
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

        } else {
            if (a <= 4) {
                takeACard(deck1);
                makeMove(deck1, deck2, topCard);
            } else {
                System.out.println("koniec");

            }
        }


    }
    @Override
    public int getMove(Deck hand2, Deck deck2) {
        return 0;
    }


}




/*

package edu.ib;

import java.util.Arrays;

public class CPU extends Player {


    public CPU(Deck hand, int id) {
        super(hand, id);
    }

    @Override
    public void makeMove(Deck deck1, Deck deck2, Card topCard, boolean firstMove) {
        Deck possibleRanks = new Deck();
        Deck possibleSuits = new Deck();
        Deck possibleEights = new Deck();
        Deck possibleSuitsRanks = new Deck();

        Deck fourDeck = new Deck();
        Deck threeDeck = new Deck();
        Deck twoDeck = new Deck();

        Deck numberof2 = new Deck();
        Deck numberof3 = new Deck();
        Deck numberof4 = new Deck();
        Deck numberof5 = new Deck();
        Deck numberof6 = new Deck();
        Deck numberof7 = new Deck();
        Deck numberof8 = new Deck();
        Deck numberof9 = new Deck();
        Deck numberof10 = new Deck();
        Deck numberof11 = new Deck();
        Deck numberof12 = new Deck();
        Deck numberof13 = new Deck();
        Deck numberof14 = new Deck();
        int[] ranks = new int[12];

        int[] ranks2 = new int[15];



        for (int i = 0; i < getHandCards().size(); i++) {
            if (getHandCards().get(i).getSuit().equals(topCard.getSuit()) && getHandCards().get(i).getValue() != 8) {
                possibleSuits.add(getHandCards().get(i));
            }
            if (getHandCards().get(i).getRank().equals(topCard.getRank()) && getHandCards().get(i).getValue() != 8) {
                possibleRanks.add(getHandCards().get(i));
            }

            if (getHandCards().get(i).getValue() == 8) {
                possibleEights.add(getHandCards().get(i));

            }

            ranks[getHandCards().get(i).getValue() - 2] = ranks[getHandCards().get(i).getValue() - 2] + 1;
        }


        for (int i = 0; i < getHandCards().size(); i++) {
            for (int j = 0; j < possibleSuits.size(); j++) {
                if (getHandCards().get(i).getRank().equals(possibleSuits.get(j).getRank())) {
                    possibleSuitsRanks.add(getHandCards().get(i));
                }
            }
        }

        for (int i = 0; i < possibleSuitsRanks.size(); i++) {

            if (possibleSuitsRanks.get(i).getValue() == 2) {
                numberof2.add(possibleSuitsRanks.get(i));
                ranks2[2]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 3) {
                numberof3.add(possibleSuitsRanks.get(i));
                ranks2[3]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 4) {
                numberof4.add(possibleSuitsRanks.get(i));
                ranks2[4]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 5) {
                numberof5.add(possibleSuitsRanks.get(i));
                ranks2[5]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 6) {
                numberof6.add(possibleSuitsRanks.get(i));
                ranks2[6]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 7) {
                numberof7.add(possibleSuitsRanks.get(i));
                ranks2[7]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 9) {
                numberof9.add(possibleSuitsRanks.get(i));
                ranks2[9]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 10) {
                numberof10.add(possibleSuitsRanks.get(i));
                ranks2[10]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 11) {
                numberof11.add(possibleSuitsRanks.get(i));
                ranks2[11]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 12) {
                numberof12.add(possibleSuitsRanks.get(i));
                ranks2[12]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 13) {
                numberof13.add(possibleSuitsRanks.get(i));
                ranks2[13]++;
            } else if (possibleSuitsRanks.get(i).getValue() == 14) {
                numberof14.add(possibleSuitsRanks.get(i));
                ranks2[14]++;
            }
        }


        //ZAGRYWANIE(OD NAJWAZNIEJSZYCH WARUNKOW) :


        if (Arrays.asList(ranks2).contains(4)) {
            for (int i = 0; i < 4; i++) {

                for (int j = 0; j < possibleSuitsRanks.size(); j++) {
                    if (possibleSuitsRanks.get(j).getValue() == (Arrays.asList(ranks2).indexOf(4))) {
                        fourDeck.add(possibleSuitsRanks.get(j));
                    }
                }
                playACard(deck2, fourDeck.get(i));
            }

        } else if (possibleRanks.size() == 4) {
            for (int i = 0; i < possibleRanks.size(); i++) {
                playACard(deck2, possibleRanks.get(i));
            }

        } else if (Arrays.asList(ranks2).contains(3)) {
            for (int i = 0; i < 3; i++) {

                for (int j = 0; j < possibleSuitsRanks.size(); j++) {
                    if (possibleSuitsRanks.get(j).getValue() == (Arrays.asList(ranks2).indexOf(3))) {
                        threeDeck.add(possibleSuitsRanks.get(j));
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
                        twoDeck.add(possibleSuitsRanks.get(j));
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
        }


        //ÓSEMKI:

        else if (possibleEights.size() == 4) {
            for (int i = 0; i < possibleEights.size(); i++) {
                playACard(deck2, possibleEights.get(i));

         //       int nofSuits =
                // for(int j = 0; j< getHandCards().e)


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

        } else if (!possibleSuits.isEmpty()) {
            playACard(deck2, getHandCards().get(getHandCards().indexOf(possibleSuits.get(0))));

        }
        else {
            takeACard(deck1);
            if (firstMove)
                makeMove(deck1, deck2, topCard, false);
        }

    }



/*
        Deck finalCards = new Deck();
        if(!possibleRanks.isEmpty()) {
            int[] ranks3 = new int[12];

            if(possibleRanks.size()==4){
                for (int i = 0; i < possibleRanks.size(); i++) {
                    playACard(deck2, possibleRanks.get(i));
                }
            }
            else if(possibleRanks.size()==3){
                for (int i = 0; i < possibleRanks.size(); i++) {
                    playACard(deck2, possibleRanks.get(i));
                }
            }
            else if(possibleRanks.size()==2){
                for (int i = 0; i < possibleRanks.size(); i++) {
                    playACard(deck2, possibleRanks.get(i));
                }
            }
            else {
                playACard(deck2, possibleRanks.get(0));
            }





            for (int i = 0; i < possibleRanks.size() - 1; i++) {
                ranks2[possibleRanks.get(i).getValue()-2]=ranks2[possibleRanks.get(i).getValue()-2]+1;
            }

            for (int i = 0; i < ranks.length - 1; i++) {


            }



        else if(!possibleSuits.isEmpty()){
            playACard(deck2, getHandCards().get(getHandCards().indexOf(possibleSuits.get(0))));
        }
        else if(!possibleEights.isEmpty()){

            if(possibleEights.size()==4){
                for (int i = 0; i < possibleEights.size(); i++) {
                    playACard(deck2, possibleEights.get(i));

                }
            }
            else if(possibleEights.size()==3){
                for (int i = 0; i < possibleEights.size(); i++) {
                    playACard(deck2,possibleEights.get(i));
                }
            }
            else if(possibleEights.size()==2){
                for (int i = 0; i < possibleEights.size(); i++) {
                    playACard(deck2, possibleEights.get(i));
                }
            }
            else {
                playACard(deck2, possibleEights.get(0));
            }

        }
        else {
            takeACard(deck1);
            if (firstMove)
                makeMove(deck1, deck2, topCard, false);
        }

        */


/*



    @Override
    public int getMove(Deck hand2, Deck deck2) {
        return 0;
    }


*/

/*

package edu.ib;

import java.text.DecimalFormat;
import java.util.List;

public class CPU extends Player {


    public CPU(Deck hand, int id) {
        super(hand, id);
    }

    @Override
    public void makeMove(Deck deck1, Deck deck2, Card topCard, boolean firstMove) {
        Deck possibleRanks =  new Deck();
        Deck possibleSuits = new Deck();
        int[] ranks = new int[12];


        boolean osiem = false;
        int ilosc8 =0;
        int tesame = 0;

        for (int i = 0; i < getHandCards().size(); i++) {
            if(getHandCards().get(i).getSuit().equals(topCard.getSuit())) {
                possibleSuits.add(getHandCards().get(i));
            }
            if(getHandCards().get(i).getRank().equals(topCard.getRank())) {
                possibleRanks.add(getHandCards().get(i));
            }

            if(getHandCards().get(i).getRank().equals(8)){
                osiem=true;
                ilosc8++;
            }

            ranks[getHandCards().get(i).getValue()-2]=ranks[getHandCards().get(i).getValue()-2]+1;
        }

        Deck finalCards = new Deck();
        if(!possibleRanks.isEmpty()) {
            int[] ranks2 = new int[12];
            int ile4=0;
            int ile3=0;
            int ile2=0;
            for (int i = 0; i < ranks.length; i++) {
                if(i==4){
                    ile4++;
                    a=i;
                }
                else if(i==3){
                    ile3++;
                }
                else if(i==2){
                    ile2++;
                }

            }

            for (int i = 0; i < possibleRanks.size() - 1; i++) {
                ranks2[possibleRanks.get(i).getValue()-2]=ranks2[possibleRanks.get(i).getValue()-2]+1;
            }

            for (int i = 0; i < ranks.length - 1; i++) {


            }
        }
        else if(!possibleSuits.isEmpty()){
                playACard(deck2, getHandCards().get(getHandCards().indexOf(possibleRanks.get(0))));
        }
        else if(ilosc8>0){

        }
        else {
            takeACard(deck1);
            if (firstMove)
                makeMove(deck1, deck2, topCard, false);
        }
    }


}
*/
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

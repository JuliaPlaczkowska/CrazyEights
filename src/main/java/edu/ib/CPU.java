package edu.ib;

import org.w3c.dom.ls.LSOutput;

import java.text.DecimalFormat;
import java.util.*;

/**
 * ta klasa zawiera strategię gry komputera
 */

public class CPU extends Player {


    public CPU(Deck hand, int id) {
        super(hand, id);
    }



    /**
     * @Override metoda z klasy Player dla komputera(CPU)
     * @parametr deck1 reprezentuje deck z którego dobierane są karty
     * @param deck2 reprezentuję deck na który karty są kładzone
     * @param topCard reprezentuję ostatnią kartę z decku2 (ta która jest odwrócone do góry)
     * Metoda ta zawiera logikę komputera. Najpierw soruję on karty wg rang, znaków oraz ósemek. Następnie wykonuję on ruch a priorytet mają ruchy które pozwolą na pozbycie się
     * jak największej ilości kart. Jeżeli nie będzie miał dostępnej żadnej kombinacji dobiera on karte i jeszcze raz próbuję wykonać ruch.
     */
    @Override
    public void makeMove(Deck deck1, Deck deck2, Card topCard) {
        Deck possibleRanks = new Deck();
        Deck possibleSuits = new Deck();
        Deck possibleEights = new Deck();
        Deck possibleSuitsRanks = new Deck();

        Deck fourDeck = new Deck();
        Deck threeDeck = new Deck();
        Deck twoDeck = new Deck();

        Integer[] ranks2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};




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

        }


        for (int i = 0; i < getHandCards().size(); i++) {
            for (int j = 0; j < possibleSuits.size(); j++) {
                if (possibleSuits.getCard(j).getValue() == getHandCards().get(i).getValue()) {
                    possibleSuitsRanks.addCard(getHandCards().get(i));
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

                    playACard(deck2, twoDeck.get(i));
                }

            }
        }else if (possibleRanks.size() == 2) {
                for (int i = 0; i < possibleRanks.size(); i++) {
                    playACard(deck2, possibleRanks.get(i));
                }
            } else if (possibleRanks.size() == 1) {
                playACard(deck2, possibleRanks.get(0));
            } else if (possibleSuits.size() >= 1) {
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

                if (a < 4) {
                    System.out.println("dobralem");
                    takeACard(deck1);
                    makeMove(deck1, deck2, topCard);

                }
                a = 0;

            }

        }


    @Override
    public int getMove(Deck hand2, Deck deck2) {
        return 0;
    }


}



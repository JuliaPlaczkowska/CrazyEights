package edu.ib;

import java.text.DecimalFormat;
import java.util.*;

import static java.util.Collections.emptyList;

public class Gameplay {

	private Deck deck1;
	private Deck deck2;
	private Card topCard;
	private List<Player> players;


	public Gameplay(int nOfPlayers) {

		deck1 = new Deck();
		deck2 = new Deck();
		players = new ArrayList<>();

		deck1.makeADeck();

		for (int i = 0; i < nOfPlayers; i++) {
			if(i==0){
				Player p = new GPU(new Deck(), i);
				players.add(p);}
			else{
				players.add(new CPU(new Deck(), i));
			}
		}

		//Collections.shuffle(players);

	}



	public Deck getDeck1() {
		return deck1;
	}

	public void dealCards() {

		for (int i = 0; i < players.size(); i++) {
			for (int j = 0; j < 7 ; j++) {
				players.get(i).takeACard(deck1);
			}
		}

		deck2.addCard(deck1.get(deck1.size()-1));
		deck1.remove(deck1.get(deck1.size()-1));
		topCard = deck2.get(deck2.size()-1);

	}

	public void turn(int i) {
		players.get(i).makeMove(deck1, deck2, topCard);
	}


	public Card getTopCard() {
		return topCard;
	}



	public Deck getDeck2() {
		return deck2;
	}

	/**
	 * 
	 * @param topCard
	 */
	public void setTopCard(Card topCard) {

		this.topCard = topCard;
	}

	public void getAttribute() {
		// TODO - implement Gameplay.getAttribute
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attribute
	 */
	public void setAttribute(int attribute) { //?? nw co to
		// TODO - implement Gameplay.setAttribute
		throw new UnsupportedOperationException();
	}

	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * 
	 * @param players
	 */
	public void setPlayers(Player[] players) {
		// TODO - implement Gameplay.setPlayers
		throw new UnsupportedOperationException();
	}

}
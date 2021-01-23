package edu.ib;

import java.util.Random;


public abstract class Player {

	private Deck hand;
	private int id;

	public Player(Deck hand, int id) {
		this.hand = hand;
		this.id = id;
	}

	public abstract void makeMove(Deck deck1, Deck deck2, Card topCard, boolean firstMove);

	Random losowe = new Random();
	int a=0;


	public void takeACard(Deck deckName){
		Card c = deckName.getCard(deckName.size()-1);
		hand.addCard(c);
		deckName.remove(c);
	}

	public void playACard(Deck deckName, Card card){
		deckName.addCard(card);
		getHandCards().remove(card);

	}

	public void addCard() {
		// TODO - implement Player.addCard
		throw new UnsupportedOperationException();
	}

	public void subCard() {
		// TODO - implement Player.subCard
		throw new UnsupportedOperationException();
	}

	public Deck getHandCards() {
		return hand;

	}

	public void dealOneCard() {
		// TODO - implement Player.dealOneCard
		throw new UnsupportedOperationException();
	}


}
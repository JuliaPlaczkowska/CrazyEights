package edu.ib;

import javafx.event.ActionEvent;

import java.util.Random;


public abstract class Player {

	private Deck hand;
	private int id;
	private Card kartapulapka;

	public Player(Deck hand, int id) {
		this.hand = hand;
		this.id = id;
	}

	public abstract void makeMove(Deck deck1, Deck deck2, Card topCard);

	public abstract int getMove(Deck hand2, Deck deck2);

	Random losowe = new Random();
	int liczniklosowy;
	int a = 0;
	int losowySuit;


	public void takeACard(Deck deckName) {

		Card c = deckName.getCard(deckName.size() - 1);
		hand.addCard(c);
		deckName.remove(c);
	}

	public void playACard(Deck deckName, Card card) {
		for (int i = 0; i < getHandCards().size(); i++){
			System.out.println("Ręka " + a + " " + getHandCards().getCard(i).getValue() + " " + getHandCards().getCard(i).getSuit());
		}

		System.out.println("klade:");

		deckName.addCard(card);
		getHandCards().remove(card);
	}


	/*
	public void playACardEight(Deck deckName, Card card, int id ) {
		deckName.addCard(card);
		getHandCards().remove(card);

		liczniklosowy = losowe.nextInt(4);








	 */



	public  int getID(){
		return id;
	}
	public Card getKartapulapka(){
		return kartapulapka;
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
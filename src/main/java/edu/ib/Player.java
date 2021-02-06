package edu.ib;

import javafx.event.ActionEvent;

import java.util.Random;

/**
 * klasa abstrakcyjna służąca do tworzenia graczy
 */

public abstract class Player {

	private Deck hand;
	private int id;


	public Player(Deck hand, int id) {
		this.hand = hand;
		this.id = id;
	}

/**
 * Metoda makeMove która wykłada karty komputera lub gracza na deck2.
 * @parametr deck1 reprezentuje deck kart które zostały kliknięte przez gracza
 * @parametr deck2 reprezentuję deck na który karty są kładzone
 * @parametr topCard reprezentuję ostatnią kartę z decku2 (ta która jest odwrócone do góry)
 *
 * **/
	public abstract void makeMove(Deck deck1, Deck deck2, Card topCard);


	/**
	 * Metoda getMove która sprawdza czy dany ruch jest dozwolony
	 * @parametr deck1 reprezentuje deck kart które zostały kliknięte przez gracza
	 * @parametr deck2 reprezentuję deck na który karty są kładzone
	 * **/
	public abstract int getMove(Deck hand2, Deck deck2);

	Random losowe = new Random();
	int liczniklosowy;
	int a = 0;
	int losowySuit;



	/**
	 * Metoda takeACard
	 * @parametr deckName reprezentuję deck z którego dobrana zostanie karta
	 * Metoda ta pozwala na dobranie jednej karty z danego decku. Dodaje ona ostatnią kartę z danego decku do ręki gracza i jednoczenie usuwa ona daną kartę z decku.
	 * **/
	public void takeACard(Deck deckName) {

		if(deckName.size()==0)
			deckName.makeADeck();

		Card c = deckName.getCard(deckName.size() - 1);
		hand.addCard(c);
		deckName.remove(c);
	}
	/**
	 * Metoda playACard
	 * @parametr deckName reprezentuję deck na który karta zostaniee zagrana
	 * @parametr card reprezenuję kartę która ma zostać zagrana
	 * Metoda ta pozwala na zagranie karty. Wybrana karta zostaje dodana do danego decku i jednocześnie usunięta z jego reki.
	 * **/
	public void playACard(Deck deckName, Card card) {


		deckName.addCard(card);
		getHandCards().remove(card);


		if(getID()>=1) {
			System.out.println("ID: " + getID());
			System.out.println(card.getValue() + " " + card.getSuit());
		}
	}



	public  int getID(){
		return id;
	}



	public Deck getHandCards() {
		return hand;

	}





}
package edu.ib;

/**
 * This class is used for creating card object
 */
public class Card {

	/**
	 * Rank represents rank of the card
	 */

	enum Rank {

		TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),
		EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13),ACE(14);

		int value;

		Rank(int value){
			this.value=value;
		}

	}
	/**
	 * Suit represents suit of the card
	 */
	enum Suit {
		HEART,DIAMOND,SPADE,CLUB
	}


	public Suit suit;
	public Rank rank;
	public int value;

	/**
	 * constructor which parameters are:
	 * @param suit represents the suit of the card
	 * @param rank represents the rank of the card
	 *
	 * it assigns value based on the given rank
	 */

	public Card(Suit suit, Rank rank){
		this.suit=suit;
		this.rank=rank;
		this.value=rank.value;
	}

	/**
	 * second constructor
	 * @param rank
	 * @param suit
	 */
	public Card(int rank, int suit){
		switch (suit){
			case 1 : this.suit = Suit.HEART; break;
			case 2 : this.suit = Suit.DIAMOND; break;
			case 3 : this.suit = Suit.SPADE; break;
			case 4 : this.suit = Suit.CLUB; break;
		}

		this.value=rank;
	}

	/**
	 * here are some of getters and setter
	 * @return
	 */
	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * it's used for gettink value of the rank with representation in string
	 * @return rank
	 */
	public String getRankIMG(){
		String rank =String.valueOf(getValue());

		switch (getValue()){
			case 14 : rank = "A"; break;
			case 13 : rank = "K"; break;
			case 12 : rank = "Q"; break;
			case 11 : rank = "J"; break;
		}
		return rank;
	}

	/**
	 * it's used for gettink value of the suit with representation in string
	 * @return suit
	 */

	public String getSuitIMG(){
		String suit = "";

		switch (getSuit()){
			case HEART : suit = "H"; break;
			case DIAMOND : suit = "D"; break;
			case SPADE : suit = "S"; break;
			case CLUB : suit = "C"; break;
		}

		return suit;
	}



}
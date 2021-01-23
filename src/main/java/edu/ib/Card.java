package edu.ib;

public class Card {

	enum Rank {

		TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),
		EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13),ACE(14);

		int value;

		Rank(int value){
			this.value=value;
		}

	}
	enum Suit {
		HEART,DIAMOND,SPADE,CLUB
	}


	public Suit suit;
	public Rank rank;
	public int value;

	public Card(Suit suit, Rank rank){
		this.suit=suit;
		this.rank=rank;
		this.value=rank.value;
	}

	public Card(int rank, int suit){
		switch (suit){
			case 1 : this.suit = Suit.HEART; break;
			case 2 : this.suit = Suit.DIAMOND; break;
			case 3 : this.suit = Suit.SPADE; break;
			case 4 : this.suit = Suit.CLUB; break;
		}

		this.value=rank;
	}

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

	public int getSuitValue(){
		int suit = 0;
		switch (getSuit()){
			case HEART : suit = 1; break;
			case DIAMOND : suit = 2; break;
			case SPADE : suit = 3; break;
			case CLUB : suit = 4; break;
		}

		return suit;
	}

}
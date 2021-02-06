package edu.ib;

import java.util.*;

/**
 * Klasa słuząca do tworzenia talii kart, ręki gracza orazkomputera, implementuje interfejs List.
 */

public class Deck implements List<Card> {

	private List<Card> cards;

	/**
	 * Metoda makeADeck
	 * Metoda ta iteruję po każdym dostępnym ranku oraz suicie tworząc talie kart. Karty są dodane do listy. Na końcu następuję polecenie shuffle które tasuję karty.
	 * **/
	public void makeADeck(){
		for(Card.Suit suit: Card.Suit.values()){
			for (Card.Rank rank : Card.Rank.values()){
				cards.add(new Card(suit, rank));
			}
		}
		Collections.shuffle(cards);
	}

	public Deck() {
		cards = new ArrayList<>();
	}

	/**
	 * Konstruktor Deck
	 * @parametr card reprezentuję listę kart które stworzą dany deck
	 * Pozwala na stworzenie obiektu klasy Deck
	 * **/
	public Deck(List<Card> cards) {
		this.cards = cards;
	}

	/**
	 * Metoda addCard
	 * @parametr card reprezentuję daną kartę
	 * Metoda ta pozwala na dodanie karty do wybranego decku.
	 * **/
	public void addCard(Card c) {
		cards.add(c);
	}

	/**
	 * Metoda remove
	 * * @parametr card reprezentuję daną kartę
	 * Metoda ta pozwala na usunięcie danej karty z wybranego decku.
	 * **/
	public void remove(Card c){
		cards.remove(c);
	}

	public Deck getSubDeck(int[] i){

		Deck subDeck = new Deck();

		for (int j = 0; j < i.length; j++) {
			subDeck.add(cards.get(i[j]));
		}

		return subDeck;
	}
	/**
	 * Metoda getCard
	 * @parametr i reprezentuję dany indeks
	 * Metoda ta pozwala na pobranie informacji o karcie któa znadjuję się na danym indeksie i
	 * **/
	public Card getCard(int i){
		//TODO
		return  cards.get(i);
	}

	@Override
	public int size() {
		return cards.size();
	}

	@Override
	public boolean isEmpty() {
		return cards.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Iterator<Card> iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return new Object[0];
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean add(Card card) {
		return false;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Card> c) {
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends Card> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {

	}

	@Override
	public boolean equals(Object o) {
		return false;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public Card get(int index) {
		return cards.get(index);
	}

	@Override
	public Card set(int index, Card element) {
		return null;
	}

	@Override
	public void add(int index, Card element) {
		cards.add(element);
	}

	@Override
	public Card remove(int index) {
		return null;
	}

	@Override
	public int indexOf(Object o) {
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}

	@Override
	public ListIterator<Card> listIterator() {
		return null;
	}

	@Override
	public ListIterator<Card> listIterator(int index) {
		return null;
	}

	@Override
	public List<Card> subList(int fromIndex, int toIndex) {
		return null;
	}
}
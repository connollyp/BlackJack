package card_class;

import java.util.Random;

/**
 * 
 * @author connollyp2
 *
 */
public class Deck extends Card {
	// Deck data
	static Random rand = new Random();
	private Card[] deck;

	/**
	 * Default deck constructor
	 * 
	 * @param none
	 * @return none
	 */
	public Deck() {
		this.deck = createDeck();
	}

	/**
	 * Creates either a populated or empty deck of length 52
	 * 
	 * @param empty,
	 *            boolean value for whether the deck should be populated or not
	 * @return none
	 */
	public Deck(boolean empty) {
		if (empty == true) {
			this.deck = createEmptyDeck();
		} else if (empty == false) {
			this.deck = createDeck();
		}

	}

	/**
	 * Creates an empty deck of a given length
	 * 
	 * @param length,
	 *            the desired length of the empty desk
	 * @return none
	 */
	public Deck(int length) {
		this.deck = createEmptyDeck(length);
	}

	/**
	 * Populates a deck with 52 unique cards in a random order
	 * 
	 * @param deck,
	 *            the deck to be shuffled
	 * @return none
	 */
	public static void shuffle(Deck deck) {
		for (int i = 0; i < deck.deck.length; i++) {
			Card card = new Card(rand.nextInt(13) + 1, rand.nextInt(4) + 1);
			if (i == 0) {
				deck.deck[i] = card;
				continue;
			} else {
				if (deck.contains(card) == true) {
					continue;
				} else if (deck.contains(card) == false) {
					deck.deck[i] = card;
					if (i == 0) {
						continue;
					}
					if ((0 < i) && (i < deck.deck.length - 1)) {
						card.setPrevious(deck.deck[i - 1]);
						deck.deck[i - 1].setNext(deck.deck[i]);
					}
					if (i == deck.deck.length - 1) {
						deck.deck[i].setPrevious(deck.deck[i - 1]);
					}
				}
			}
		}
	}

	/**
	 * Iterates through a given deck to see if the given card is contained in one of
	 * its indices
	 * 
	 * @param card,
	 *            card to be searched for
	 * @return boolean value of whether the given card is contained within deck
	 */
	public boolean contains(Card card) {
		if (this.getSize() == 0) {
			return false;
		} else {
			for (int i = 0; i < this.getSize(); i++) {
				if (card.equalTo(this.deck[i]) == true) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Draws a random card from a given deck, removes that card from the deck
	 * 
	 * @param none
	 * @return C, the card that is drawn
	 */
	public Card draw() {
		int pick = rand.nextInt(this.deck.length) + 0;
		Card c = this.deck[pick];
		remove(c, this);
		return c;

	}

	/**
	 * Removes a given card from the deck, shortens length of the deck by 1 to
	 * reflect this change
	 * 
	 * @param card,
	 *            card to be removed
	 * @param deck,
	 *            deck to remove the card from
	 * @return newDeck, deck with card removed, length one index shorter than given
	 *         deck
	 */
	public static Deck remove(Card card, Deck deck) {
		Deck newDeck = new Deck(true);
		for (int i = 0; i < deck.deck.length; i++) {
			if (deck.deck[i] == card) {
				for (int j = i; j < deck.deck.length - 1; j++) {
					deck.deck[j] = deck.deck[j + 1];
				}
				newDeck = new Deck(deck.deck.length - 1);
				for (int k = 0; k < newDeck.deck.length; k++) {
					newDeck.deck[k] = deck.deck[k];
				}
				// return newDeck;
			}
		}
		return newDeck;
	}

	/**
	 * Gets the size of a given deck
	 * 
	 * @param None
	 * @return length of the deck
	 */
	public int getSize() {
		return this.deck.length;
	}

	/**
	 * Prints all cards in a deck
	 * 
	 * @param none
	 * @return none
	 */
	public void printDeck() {
		for (int i = 0; i < this.deck.length - 1; i++) {
			System.out.println(toString(this.deck[i]));
		}
	}

	public static void main(String[] args) {

	}
}
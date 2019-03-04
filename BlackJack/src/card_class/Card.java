package card_class;

/**
 * 
 * @author connollyp2
 *
 */
public class Card implements Comparable<Card> {

	// Pointer to the next card node, pseudo-deck implementation
	private Card next;

	// Pointer to the previous card node, pseudo-deck implementation
	private Card previous;

	// Suit value for a given card
	private int suit;

	// Numeric value for a given card, also applicable for face cards
	private int number;

	/**
	 * Default Constructor for the card class, defaults to the ace of hearts
	 * 
	 * @param none
	 * @return none
	 **/
	public Card() {
		this.suit = 1;
		this.number = 1;
	}

	/**
	 * Constructor used to create a specific card
	 * 
	 * @param integer
	 *            value for the card number, integer value for the suit
	 * @return None
	 **/
	public Card(int cardNumber, int suite) {
		this.suit = suite;
		this.number = cardNumber;
	}

	/**
	 * Creates a deck of all 52 cards in a standard deck
	 * 
	 * @param None
	 * @return Deck, an array of 52 unique cards
	 **/
	public static Card[] createDeck() {
		Card deck[] = new Card[52];
		int i = 0;
		for (int suit = 1; suit < 5; suit++) {
			for (int cardNumber = 1; cardNumber < 14; cardNumber++) {
				deck[i] = new Card(cardNumber, suit);
				if (i < 51) {
					deck[i].setNext(deck[i + 1]);
				}
				if (i > 0) {
					deck[i].setPrevious(deck[i - 1]);
				}
				i++;
			}
		}
		return deck;
	}

	/**
	 * Creates an empty array of cards of length 52
	 * 
	 * @param None
	 * @return Deck, an empty array of cards of length 52
	 **/
	public static Card[] createEmptyDeck() {
		Card deck[] = new Card[52];
		return deck;
	}

	/**
	 * Creates an empty array of cards with a specified length
	 * 
	 * @param The
	 *            integer length, the desired length of the array
	 * @return Deck, an array of cards of the desired length
	 **/
	public static Card[] createEmptyDeck(int length) {
		Card deck[] = new Card[length];
		return deck;
	}

	public static Card getNext(Card card) {
		return card.next;
	}

	public static Card getPrevious(Card card) {
		return card.previous;
	}

	/**
	 * Returns the suit of the given card
	 * 
	 * @param none
	 * @return The suit value of the card as its integer value
	 **/
	public int getSuit() {
		return this.suit;
	}

	/**
	 * Returns the numeric value of the given card
	 * 
	 * @param Card
	 *            who's numeric value is desired
	 * @return The numeric value of the card as its integer value
	 **/
	public int getNumber() {
		return this.number;
	}

	public Card setNext(Card nextCard) {
		this.next = nextCard;
		return this;
	}

	public Card setPrevious(Card previousCard) {
		this.previous = previousCard;
		return this;
	}

	/**
	 * Determines whether two cards are equal
	 * 
	 * @param Card
	 *            who's value is being compared
	 * @return True if the cards are the same, False if they are different
	 **/
	public boolean equalTo(Card card) {
		if (this.suit == card.suit && this.number == card.number) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Converts card values from their integer values to a readable string format
	 * 
	 * @param The
	 *            card that is being converted
	 * @return The string value for the given card
	 **/
	public static String toString(Card card) {
		if (card.getSuit() == 1) {
			if (card.getNumber() == 1) {
				return "Ace of Hearts";
			} else if (card.getNumber() == 11) {
				return "Jack of Hearts";
			} else if (card.getNumber() == 12) {
				return "Queen of Hearts";
			} else if (card.getNumber() == 13) {
				return "King of Hearts";
			} else if (card.getNumber() > 1 && card.getNumber() < 11) {
				return String.valueOf(card.getNumber()) + " of Hearts";
			} else {
				return "Invalid Card information";
			}
		} else if (card.getSuit() == 2) {
			if (card.getNumber() == 1) {
				return "Ace of Spades";
			} else if (card.getNumber() == 11) {
				return "Jack of Spades";
			} else if (card.getNumber() == 12) {
				return "Queen of Spades";
			} else if (card.getNumber() == 13) {
				return "King of Spades";
			} else if (card.getNumber() > 1 && card.getNumber() < 11) {
				return String.valueOf(card.getNumber()) + " of Spades";
			} else {
				return "Invalid Card information";
			}
		} else if (card.getSuit() == 3) {
			if (card.getNumber() == 1) {
				return "Ace of Diamonds";
			} else if (card.getNumber() == 11) {
				return "Jack of Diamonds";
			} else if (card.getNumber() == 12) {
				return "Queen of Diamonds";
			} else if (card.getNumber() == 13) {
				return "King of Diamonds";
			} else if (card.getNumber() > 1 && card.getNumber() < 11) {
				return String.valueOf(card.number) + " of Diamonds";
			} else {
				return "Invalid Card information";
			}
		} else if (card.getSuit() == 4) {
			if (card.getNumber() == 1) {
				return "Ace of Clubs";
			} else if (card.getNumber() == 11) {
				return "Jack of Clubs";
			} else if (card.getNumber() == 12) {
				return "Queen of Clubs";
			} else if (card.getNumber() == 13) {
				return "King of Clubs";
			} else if (card.getNumber() > 1 && card.getNumber() < 11) {
				return String.valueOf(card.getNumber()) + " of Clubs";
			} else {
				return "Invalid Card information";
			}
		} else {
			return "Invalid card information";
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Card card) {
		int difference = this.getSuit() - card.getSuit();
		if (difference == 0) {
			difference = this.getNumber() - card.getNumber();
		}
		return difference;
	}

	public static void main(String[] args) {

	}

}

package card_class;

public class Hand extends Deck {

	// Hand data
	private Card[] cards;

	/**
	 * Default constructor for a hand
	 */
	public Hand() {
		Card hand[] = new Card[0];
		this.cards = hand;
	}

	/**
	 * Gets the data hand for the given hand
	 * 
	 * @return Hand data for the given hand as an array of cards
	 */
	public Card[] getCards() {
		return this.cards;
	}

	/**
	 * Gets the size of a given hand
	 * 
	 * @param none
	 * @return the length of the given hand
	 */
	@Override
	public int getSize() {
		return this.cards.length;
	}

	/**
	 * Determines whether a given card is contained within a hand
	 * 
	 * @param none
	 * @return Boolean value of whether the given card is contained in the hand
	 */
	@Override
	public boolean contains(Card card) {
		for (int i = 0; i < this.cards.length; i++) {
			if (card.equals(this.cards[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds the given card to a hand
	 * 
	 * @param card
	 * @return hand, hand with a card added
	 */
	public Card[] addCard(Card card) {
		int length = this.getSize();
		Card[] hand = new Card[length + 1];

		for (int i = 0; i < length; i++) {
			hand[i] = this.cards[i];
		}
		this.cards = hand;
		this.cards[length] = card;

		return this.cards;
	}

	/**
	 * Removes a given card from a hand
	 * 
	 * @param card
	 * @return the card that was removed
	 */
	public Card remove(Card card) {
		this.remove(card);
		return card;

	}

	/**
	 * Re-initializes a given hand
	 * 
	 * @param none
	 * @return none
	 */
	public void reset() {
		Card hand[] = new Card[0];
		this.cards = hand;
	}

	/**
	 * Prints a given hand
	 * 
	 * @param hand,
	 *            hand to be printed
	 * @return none
	 */
	public static void printHand(Hand hand) {
		for (int i = 0; i < hand.getSize(); i++) {
			System.out.println(toString(hand.cards[i]));
		}
	}

	/**
	 * Gets the sum of the numeric values of the cards in the hand
	 * 
	 * @param none
	 * @return the sum of the numeric value of the hand
	 */
	public int sum() {
		int sum = 0;

		for (int i = 0; i < this.cards.length; i++) {
			sum = cards[i].getNumber() + sum;
		}
		return sum;
	}

}
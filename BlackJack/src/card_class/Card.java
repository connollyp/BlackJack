package card_class;

public class Card implements Comparable<Card>{
	
	public Card next;
	
	public Card previous;
	
	public int suit;
	
	public int number;
	
	//Default constructor
	public Card() {
		this.suit = 0;
		this.number = 0;
	}

	//Custom constructor
	public Card(int cardNumber, int suite) {
			this.suit = suite;
			this.number = cardNumber;
	}
	
	
	//Creates a deck of 52 cards 1 card of each of the 4 suit types
	public static Card[] createDeck() {
		Card deck[] = new Card[53];
		int i = 0;
		for (int suit = 1; suit <= 4; suit++) {
			for (int cardNumber = 1; cardNumber <= 13; cardNumber++) {
				deck[i] = new Card(cardNumber, suit);
				deck[i].setNext(deck[i], deck[i+1]);
				if (i > 0) {
					deck[i].setPrevious(deck[i], deck[i-1]);
				}
				i++;
			}
		}
		return deck;
	}
	
	public static Card[] createEmptyDeck() {
		Card deck[] = new Card[53];
		return deck;
	}
	
	public static Card[] createEmptyDeck(int length) {
		Card deck[] = new Card[length];
		return deck;
	}
	

	public Card getNext(Card card) {
		return card.next;
	}
	
	public Card getPrevious(Card card) {
		return card.previous;
	}
	
	public int getSuit(Card card) {
		return card.suit;
	}
	
	public int getNumber(Card card) {
		return card.number;
	}
	
	public Card setNext(Card card, Card nextCard) {
		card.next = nextCard;
		return card;
	}
	
	public Card setPrevious(Card card, Card previousCard) {
		card.previous = previousCard;
		return card;
	}
	
	public boolean equalTo(Card card) {
		if (this.suit == card.suit && this.number == card.number) {
			return true;
		}else {
			return false;
		}
	}
		
	public String toString(Card card) {
		if (card.getSuit(card) == 1) {
			if (card.getNumber(card) == 1) {
				return "Ace of hearts";
			}else if (card.getNumber(card) == 11) {
				return "Jack of hearts";
			}else if (card.getNumber(card) == 12) {
				return "Queen of hearts";
			}else if (card.getNumber(card) == 13) {
				return "King of hearts";
			}else if (card.getNumber(card) > 1 && card.getNumber(card) < 11){
				return String.valueOf(card.getNumber(card)) + " of hearts";
			}else {
				return "Invalid Card information";
			}
		}else if (card.getSuit(card) == 2) {
			if (card.getNumber(card) == 1) {
				return "Ace of spades";
			}else if (card.getNumber(card) == 11) {
				return "Jack of spades";
			}else if (card.getNumber(card) == 12) {
				return "Queen of spades";
			}else if (card.getNumber(card) == 13) {
				return "King of spades";
			}else if (card.getNumber(card) > 1 && card.getNumber(card) < 11){
				return String.valueOf(card.getNumber(card)) + " of spades";
			}else {
				return "Invalid Card information";
			}
		}else if (card.getSuit(card) == 3) {
			if (card.getNumber(card) == 1) {
				return "Ace of diamonds";
			} else if(card.getNumber(card) == 11) {
				return "Jack of diamonds";
			}else if (card.getNumber(card) == 12) {
				return "Queen of diamonds";
			}else if (card.getNumber(card) == 13) {
				return "King of diamonds";
			}else if (card.getNumber(card) > 1 && card.getNumber(card) < 11){
				return String.valueOf(card.number) + " of diamonds";
			}else {
				return "Invalid Card information";
			}
		}else if (card.getSuit(card) == 4) {
			if (card.getNumber(card) == 1) {
				return "Ace of clubs";
			}else if(card.getNumber(card) == 11) {
				return "Jack of clubs";
			}else if (card.getNumber(card) == 12) {
				return "Queen of clubs";
			}else if (card.getNumber(card) == 13) {
				return "King of clubs";
			}else if (card.getNumber(card) > 1 && card.getNumber(card) < 11){
				return String.valueOf(card.getNumber(card)) + " of clubs";
			} else {
				return "Invalid Card information";
			}
		}else {
			return "Invalid card information";
		}
		
	}

	@Override
	public int compareTo(Card card) {
		int difference = getSuit(this) - card.getSuit(card);
		if(difference == 0) {
			difference = getNumber(this) - card.getNumber(card);
		}
		return difference;
	}
	
	public static void main(String[] args) {
		Card[] card = createDeck();
		
		for (int i = 0; i < 52; i++) {
			System.out.println(card[i].toString(card[i]));
		}
		
		System.out.println();
		System.out.println(card[13].compareTo(card[25]));
		
	}

}

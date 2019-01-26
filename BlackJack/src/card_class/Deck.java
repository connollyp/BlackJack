package card_class;

import java.util.Random;

public class Deck extends Card{
      //Deck data
      static Random rand = new Random();
      public Card[] deck;
      
      public Deck() {
    	  this.deck = createEmptyDeck();
      }
      
      public Deck(int length) {
    	  this.deck = createEmptyDeck(length);
      }
      
      public Deck(boolean yeet) {
    	  this.deck = createDeck();
      }
      
      public static void shuffle(Deck deck) {
          for (int i = 0; i < deck.deck.length; i++) {
        	  Card card = new Card(rand.nextInt(13) + 1, rand.nextInt(4) + 1);
        	  if (i == 0) {
        		  deck.deck[i] = card;
        		  continue;
        	  }else {
        		  if (contains(card, deck, i) == true) {
            		  continue;
            	  }else if (contains(card, deck, i) == false) {
            		  deck.deck[i] = card;
            		  if (i == 0) {
            			  continue;
            		  }if ((0 < i) && (i < deck.deck.length - 1)){
            			  card.setPrevious(deck.deck[i], deck.deck[i-1]);
            			  card.setNext(deck.deck[i-1], deck.deck[i]);
            		  }if (i == deck.deck.length-1) {
            			  card.setPrevious(deck.deck[i], deck.deck[i-1]);
            		  }
            	  } 
        	  }
          }   
      }
      
      public static boolean contains(Card card, Deck deck, int bounds) {
    	  if (bounds == 0) {
    		  return false;
    	  } else {
        	  for (int i = 0; i <= bounds-1; i++) {
        		  if (card.equalTo(deck.deck[i]) == true) {
        			  return true;  
    	  }
    		  }
    	  }
    	  return false;
      }
      
      public Card draw() {
           int pick = rand.nextInt(this.deck.length) + 0;
           Card c = this.deck[pick];
           remove(c, this);
           return c;
           
      }
      
      public static Deck remove(Card card, Deck deck) {
    	  Deck newDeck = new Deck(true);
    	  for (int i = 0; i < deck.deck.length; i++) {
    		  if (deck.deck[i] == card) {
    			  for (int j = i; j < deck.deck.length - 1; j++) {
    				  deck.deck[j] = deck.deck[j+1];
    			  }
    			  newDeck = new Deck(deck.deck.length - 1);
    			  for (int k = 0; k < newDeck.deck.length; k++) {
    				  newDeck.deck[k] = deck.deck[k];
    			  }
    	    	  return newDeck;
    		  }
    	  }
    	  return newDeck;
      }

      public int getSize(Deck deck) {
           return deck.deck.length;
      }
      
      public void printDeck() {
    	  for (int i = 0; i < this.deck.length-1; i++) {
    		  System.out.println(toString(this.deck[i]));
    	  }
      }
      
  	public static void main(String[] args) {
		//Deck deck = new Deck(true);
		
		//shuffle(deck);
		
		//for (int i = 0; i < deck.deck.length-1; i++) {
			//System.out.println(deck.deck[i].toString(deck.deck[i]));
			
	//	}
		
		Deck deck2 = new Deck(true);
		
		Card card = deck2.deck[0];
		
		deck2 = remove(card, deck2);
		
		System.out.println();
		
		deck2.printDeck();
	}
}
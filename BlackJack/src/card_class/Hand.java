package card_class;

public class Hand extends Deck{
	
	public Card[] hand;
	
      public Hand() {
    	  Card hand[] = new Card[0];
    	  this.hand = hand;
      }
      
      public static int getSize(Hand hand) {
    	  return hand.hand.length;
      }
      
      public boolean contains(Card card) {
    	  for(int i = 0; i < this.hand.length; i++) {
    		  if (card.equals(this.hand[i])) {
    			  return true;
    		  }
    	  }
    	  return false;
      }
      
      public Card[] addCard(Card card) {
           int length = this.hand.length;
           Card[] hand = new Card[length+1];
           
           for(int i = 0; i < hand.length - 1; i++) {
        	   hand[i] = this.hand[i];
           }
           this.hand = hand;
           this.hand[length] = card;
           
           return this.hand;
      }
      
      public Card remove(Card card) {
    		  this.remove(card);
    		  return card;
    	  
      }
      
      public void reset() {
           Card hand[] = new Card[0];
           this.hand = hand;
      }
      
      public void printHand(Hand hand) {
    	  for (int i = 0; i < hand.hand.length-1; i++) {
    		  System.out.println(hand.hand[i].toString());
    	  }
      }
      
      public int sum() {
    	  int sum = 0;
    	  
    	  for(int i = 0; i <= this.hand.length-1; i++) {
    		  sum = hand[i].number + sum;
    	  }
    	  
    	  return sum;
      }
      
}
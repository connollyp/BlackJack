package card_class;

import java.util.Scanner;
/**
 * 
 * @author connollyp2
 *
 */
public class BlackJack extends Player {

	// BlackJack Data
	private Player[] players;

	private Deck deck;

	/**
	 * Constructor for BlackJack class
	 * 
	 * @param none
	 * @return none
	 */
	public BlackJack() {
		this.players = new Player[2];

		this.deck = new Deck();
	}

	/**
	 * Initializes the game of BlackJack, populates players array, creates deck to
	 * be used, deals two cards to each player
	 * 
	 * @param game
	 *            instance of blackjack that is being used
	 * @return none
	 */
	public static void initializeGame(BlackJack game) {
		game.deck = new Deck(false);

		game.players[0] = new Player(true);

		game.players[1] = new Player();

		for (int i = 0; i < game.players.length; i++) {
			Hand hand = game.players[i].getHand();
			for (int k = 0; k < 2; k++) {
				hand.addCard(game.deck.draw());
			}
		}
	}

	/**
	 * Gets the user's answer on whether they would like to add a card to their hand
	 * or not
	 * 
	 * @param Player
	 *            The player who's answer is desired
	 * @return Either HIT or STAY as a string
	 */
	public static String hitOrStay(Player player) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		String answer;

		boolean valid;

		System.out.println();
		System.out.println("Your current hand is: ");
		printHand(player.getHand());
		System.out.println();
		System.out.println("Total: " + sum(player.getHand()));
		System.out.println();
		do {
			System.out.print("Would you like you like to hit or stay?: ");

			answer = input.nextLine().toUpperCase();

			if (answer.equals("HIT") || answer.equals("STAY")) {
				valid = true;
			} else {
				valid = false;
			}
		} while (valid == false);
		return answer;
	}

	/**
	 * Automated decision maker on whether the given player should hit or stay
	 * 
	 * @param player
	 *            the player that is being automated
	 * @return Either HIT or STAY depending on the outcome of the algorithms
	 */
	public static String botHitOrStay(Player player) {
		int botSum = sum(player.getHand());

		if (botSum < 17) {
			return "HIT";
		}
		if (17 <= botSum) {
			return "STAY";
		}
		return "STAY";
	}

	/**
	 * Prints a player's name, hand, and sum of hand
	 * 
	 * @param Player
	 *            The player who's information you wish to print
	 * @return none
	 */
	public static void printPlayer(Player player) {
		System.out.println();
		System.out.println(player.getName() + "'s hand:");
		System.out.println();
		printHand(player.getHand());
		System.out.println();
		System.out.println("Total: " + sum(player.getHand()));
	}

	/**
	 * Gets the sum of the numeric values of all the cards in a given hand
	 * 
	 * @param hand
	 *            hand who's sum is desired
	 * @return the sum of all the numeric values of the cards in the given hand
	 */
	public static int sum(Hand hand) {
		int sum = 0;
		int numAces = 0;

		for (int i = 0; i < hand.getSize(); i++) {
			if (hand.getCards()[i].getNumber() < 10 && 1 < hand.getCards()[i].getNumber()) {
				sum = hand.getCards()[i].getNumber() + sum;
			} else if (10 <= hand.getCards()[i].getNumber()) { // Face cards are given a numeric value of 10 to reflect
																// the rules of Black Jack
				sum = sum + 10;
			} else if(hand.getCards()[i].getNumber() == 1) {
				sum = sum + 11;
				numAces+=1;
			}
		}
		if(21 < sum && 1 < numAces) {
			do {
				sum = sum - 10;
			}while(sum < 21 || 0 < numAces);
		}
		return sum;
	}

	/**
	 * Prints the results of the game, displaying the hands of both players and
	 * their sum, then determines winner
	 * 
	 * @param game
	 *            instance of BlackJack currently being used
	 * @return none
	 */
	public static void getResults(BlackJack game) {
		for (int i = 0; i < game.players.length; i++) {
			printPlayer(game.players[i]);
		}

		int botSum = sum(game.players[1].getHand());

		int playerSum = sum(game.players[0].getHand());

		if (botSum <= 21 && playerSum <= 21 && botSum < playerSum) {
			System.out.println();
			System.out.println("You win!");
		} else if (21 < botSum && playerSum <= 21) {
			System.out.println();
			System.out.println("You Win!");
		} else if (botSum <= 21 && playerSum <= 21 && playerSum < botSum) {
			System.out.println();
			System.out.println("You lose!");
		} else if (botSum <= 21 && 21 < playerSum) {
			System.out.println();
			System.out.println("You lose!");
		} else {
			System.out.println();
			System.out.println("Tie!");
		}
	}

	/**
	 * Implements game logic and calls previous methods to execute a game of
	 * BlackJack
	 * 
	 * @param game
	 *            current instance of BlackJack being played
	 * @return none
	 */
	public static void play(BlackJack game) {
		initializeGame(game);

		shuffle(game.deck);

		String answer;

		do {
			answer = hitOrStay(game.players[0]);
			if (answer.equals("HIT")) {
				game.players[0].getHand().addCard(game.deck.draw());
			}
		} while (answer.equals("HIT") && sum(game.players[0].getHand()) <= 21);

		do {
			answer = botHitOrStay(game.players[1]);
			if (answer.equals("HIT")) {
				game.players[1].getHand().addCard(game.deck.draw());
			}
		} while (answer.equals("HIT") && sum(game.players[1].getHand()) <= 21);

		getResults(game);
	}

	public static void main(String[] args) {
		BlackJack game = new BlackJack();

		play(game);

	}

}

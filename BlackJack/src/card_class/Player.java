package card_class;

import java.util.Scanner;
/**
 * 
 * @author connollyp2
 *
 */
public class Player extends Hand {

	// Player Data
	private int score;

	private Hand hand;

	private String name;

	/**
	 * Constructor for player, initializes score, hand, and name
	 * 
	 * @param Boolean human
	 *            boolean value for whether the given player is an actual user
	 * @return none
	 */
	public Player(boolean human) {

		if (human == true) {
			this.score = 0;

			this.hand = new Hand();

			this.name = setName(this);
		} else {
			this.score = 0;

			this.hand = new Hand();

			this.name = "Bot";
		}
	}

	/**
	 * Default constructor for player class
	 * 
	 * @param none
	 * @return none
	 */
	public Player() {
		this.score = 0;

		this.hand = new Hand();

		this.name = "Bot";
	}

	/**
	 * Increases the score of a player by a given point value
	 * 
	 * @param point
	 * @return none
	 */
	public void increaseScore(int point) {
		this.score = this.score + point;
	}

	/**
	 * Sets the name of the player
	 * 
	 * @param none
	 * @return Name, the name of the player
	 */
	public String setName(Player player) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.printf("What is your name?: ");
		String name = input.nextLine();
		player.name = name;
		return name;

	}

	/**
	 * Gets the name of the given player
	 * 
	 * @param none
	 * @return Name of the player
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the hand of the given player
	 * 
	 * @param none
	 * @return Hand of the target player
	 */
	public Hand getHand() {
		return this.hand;
	}

	/**
	 * Gets the score of the given player
	 * 
	 * @param none
	 * @return score of target player
	 */
	public int getScore() {
		return this.score;
	}

	/**
	 * Prints the name, score, and hand of the given player
	 * 
	 * @param none
	 * @return none
	 */
	public void printPlayer() {
		System.out.println("Player name: " + this.name);
		System.out.println(this.name + "'s score: " + this.score);
		System.out.printf("/n" + this.name + "'s hand: /n");
		printHand(this.hand);
	}

}

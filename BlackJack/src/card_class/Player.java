package card_class;

import java.util.Scanner;

public class Player extends Hand {

	public int score;

	public Hand hand;

	public String name;

	public Player(boolean value) {

		this.score = 0;

		this.hand = new Hand();

		this.name = getName();
	}

	public Player() {
		this.score = 0;

		this.hand = new Hand();

		this.name = "Bot";
	}

	public void increaseScore(int point) {
		this.score = this.score + point;
	}

	public String getName() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.printf("What is your name?: ");
		String name = input.nextLine();
		return name;

	}

	public void getHand() {
		this.hand = new Hand();
	}

	public void printPlayer() {
		System.out.println("Player name: " + this.name);
		System.out.println(this.name + "'s score: " + this.score);
		System.out.printf("/n" + this.name + "'s hand: /n");
		printHand(this.hand);
	}

}

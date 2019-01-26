package card_class;

import java.util.Scanner;

public class BlackJack extends Player {

	public Player[] players;

	public Deck deck;

	public boolean firstGame = true;

	public BlackJack() {
		this.deck = new Deck(true);

		this.players = new Player[2];
	}

	public void initalizePlayers(boolean firstGame, BlackJack game) {

		if (firstGame == true) {
			game.players[0] = new Player(true);
			game.players[1] = new Player();

			game.players[0].hand = new Hand();
			game.players[1].hand = new Hand();

			game.players[0].hand.addCard(game.deck.draw());
			game.players[1].hand.addCard(game.deck.draw());

			game.players[0].hand.addCard(game.deck.draw());
			game.players[1].hand.addCard(game.deck.draw());
		} else {
			game.deck = new Deck(true);

			game.players[0].hand.reset();
			game.players[1].hand.reset();

			game.players[0].hand.addCard(game.deck.draw());
			game.players[1].hand.addCard(game.deck.draw());

			game.players[0].hand.addCard(game.deck.draw());
			game.players[1].hand.addCard(game.deck.draw());
		}
	}

	public String hitOrStay(BlackJack game) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		String answer = "";

		@SuppressWarnings("unused")
		boolean valid;

		do {

			System.out.print("Would you like you like to hit or stay?: ");

			answer = input.nextLine().toUpperCase();

			if (answer.equals("HIT") || answer.equals("STAY") == true) {
				valid = true;
			} else {
				valid = false;
			}
		} while (valid = false);

		return answer.toUpperCase();

	}

	public String botHitOrStay(BlackJack game) {
		int sum = sum(game.players[1].hand.hand);

		String answer;

		if (sum < 17) {
			answer = "HIT";
		} else {
			answer = "STAY";
		}
		return answer;
	}

	public Boolean promptUser(BlackJack game) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		String answer = "";

		boolean value;

		do {
			System.out.printf("Would you like to play again(Y/N)?: ");

			answer = input.nextLine().toUpperCase();

			if (answer.equals("Y") || answer.equals("N")) {
				value = true;
			} else {
				value = false;
			}

		} while (value == false);

		if (answer.equals("Y")) {
			return true;
		} else {
			return false;
		}

	}
	
	public int sum(Card[] hand) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		int sum = 0;
		
		int answer;
		
		boolean correctAnswer;
		
		for (int i = 0; i < hand.length; i++) {
			if(10 <= hand[i].number) {
				sum = sum + 10;
			}//else if (hand.hand[i].number == 1) {
				//do {
					//System.out.print("Would you like the value of Ace to be 1 or 11?: ");
					
					//answer = input.nextInt();
					
					//if(answer == 1 || answer == 11) {
						//correctAnswer = true;
					//}else {
						//correctAnswer = false;
					//}
				//}while(correctAnswer == false);
				
				//sum = sum + answer;
			else {
				sum = sum + hand[i].number;
			}
		}
		return sum;
		
	}

	private void play(BlackJack game) {

		String userAnswer = "";

		String botAnswer = "";

		int playerHand;

		int botHand;

		boolean playAgain;

		initalizePlayers(firstGame, game);

		do {
			playerHand = sum(game.players[0].hand.hand);

			botHand = sum(game.players[1].hand.hand);

			System.out.println("Your hand is: " + playerHand);

			userAnswer = hitOrStay(game);

			if (userAnswer.equals("STAY")) {
				while (botAnswer.equals("STAY") == false && botHand <= 21) {
					botAnswer = botHitOrStay(game);
					game.players[1].hand.addCard(game.deck.draw());
				}
				break;
			} else {
				game.players[0].hand.addCard(game.deck.draw());

				botAnswer = botHitOrStay(game);

				if (botAnswer.equals("HIT")) {
					game.players[1].hand.addCard(game.deck.draw());
				} else {
					continue;
				}
			}
		} while (sum(game.players[0].hand.hand) <= 21 && sum(game.players[1].hand.hand) <= 21);

		int sumOfUserHand = sum(game.players[0].hand.hand);
		
		int sumOfBotHand = sum(game.players[1].hand.hand);
		
		if (sumOfUserHand <= 21 && 21 < sumOfBotHand) {
			System.out.println("Your hand is: " + sumOfUserHand);
			System.out.println("Opponent's hand is: " + sumOfBotHand);
			System.out.println("You win!");
			playAgain = promptUser(game);
			if (playAgain == true) {
				firstGame = false;
				play(game);
			} else {
				System.exit(0);
			}
		}
		if (sumOfBotHand <= 21 && 21 < sumOfUserHand) {
			System.out.println("Your hand is: " + sumOfUserHand);
			System.out.println("Opponent's hand is: " + sumOfBotHand);
			System.out.println("You lose!");
			playAgain = promptUser(game);
			if (playAgain == true) {
				firstGame = false;
				play(game);
			} else {
				System.exit(0);
			}
		}
		if ((sumOfBotHand <= 21 && sumOfUserHand <= 21)
				&& (sumOfUserHand < sumOfBotHand)) {
			System.out.println("Your hand is: " + sumOfUserHand);
			System.out.println("Opponent's hand is: " + sumOfBotHand);
			System.out.println("You lose!");
			playAgain = promptUser(game);
			if (playAgain == true) {
				firstGame = false;
				play(game);
			} else {
				System.exit(0);
			}
		}
		if ((sumOfBotHand <= 21 && sumOfUserHand <= 21)
				&& (sumOfBotHand < sumOfUserHand)) {
			System.out.println("Your hand is: " + sumOfUserHand);
			System.out.println("Opponent's hand is: " + sumOfBotHand);
			System.out.println("You win!");
			playAgain = promptUser(game);
			if (playAgain == true) {
				firstGame = false;
				play(game);
			} else {
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		BlackJack game = new BlackJack();

		game.play(game);

	}

}

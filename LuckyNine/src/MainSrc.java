/*
 * A simple Lucky 9 game (without placing bets) 
 */

import java.util.*;

public class MainSrc {

	private static PlayerHand playerHand = new PlayerHand(); // You
	private static PlayerHand computerHand = new PlayerHand(); // AI
	private static int[] cardsOnHand = new int[3]; // only 3 cards allowed on hand
	private static char draw; 

	public static void main(String[] args) {
		System.out.println("Lucky 9 Game by IasJem\n");
		showPlayerHand(true); // initialize two cards on hand
		System.out.print("Total card count = " + playerHand.getCardCount(cardsOnHand)); 
		drawCard(false); // card on hand is no longer initialized so init = false
		System.out.print("Total card count = " + playerHand.getCardCount(cardsOnHand));
		
		int getPlayerCount = playerHand.getCardCount(cardsOnHand);
		
		showComputerHand(); // show AI hand
		System.out.print("Total card count = " + computerHand.getCardCount(cardsOnHand)); 
		
		System.out.println("\n\n"+ winOrLose(getPlayerCount, computerHand.getCardCount(cardsOnHand)));
	}
	
	private static void drawCard(boolean init) { // Ask player to draw a third card or not
		Scanner getPlayerReply = new Scanner(System.in);
		System.out.print("\nDraw another card (Y/N)?: ");
		draw = getPlayerReply.nextLine().charAt(0);
		
		playerHand.drawThirdCard(cardsOnHand, draw);
		
		getPlayerReply.close();
		
		System.out.println("\n");
		showPlayerHand(init);	
		
	}
	
	private static void showPlayerHand(boolean init) {
		System.out.print("Your current hand:\t");
		
		if (init == true) { 
			playerHand.getInitialCards(cardsOnHand);
		} 

		playerHand.showCardsOnHand(cardsOnHand);
	}
	
	private static void showComputerHand () {
		char reply;
		
		System.out.print("\n\nComputer's hand:\t");
		computerHand.getInitialCards(cardsOnHand);
		
		if ( computerHand.getCardCount(cardsOnHand) <6) {
			reply = 'Y'; // AI will only draw a third card if his card count is lower than 5
		} else {  reply='N'; }
		
		computerHand.drawThirdCard(cardsOnHand, reply);
		computerHand.showCardsOnHand(cardsOnHand);
	}
	
	private static String winOrLose (int playerCount, int computerCount) {
		if (playerCount == computerCount) { 
			return "It's a tie!"; 
		} else if (playerCount > computerCount) { 
				return "You Win!"; 
			} 
		else {
		return "You Lose!";}
	} 

}

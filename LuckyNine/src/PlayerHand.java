import java.util.Random;

public class PlayerHand {
	
	private final int MIN_CARD_COUNT = 1;
	private final int MAX_CARD_COUNT = 10;
	private Random randomCard = new Random();

	public int getCardCount(int[] hand) {
		int cardCount=0;
		for (int i=0; i <=2; i++) {
				cardCount += hand[i]; // add all cards on hand
				if (cardCount > 9) { // if card count is greater than 9
					cardCount -= MAX_CARD_COUNT;
				}
		}	
		return cardCount; // get total card count of each player
	}
	
	public void getInitialCards (int[] hand) {
		for (int i=0; i <2; i++) { // random cards from 1 to 10 only
			hand[i] = randomCard.nextInt(MAX_CARD_COUNT - MIN_CARD_COUNT) + 1;
		}
	}
	
	public void drawThirdCard (int[] hand, char reply) {
		switch(reply) { // if player wants to draw third card
			case 'Y': case 'y':
				hand[2] = randomCard.nextInt(MAX_CARD_COUNT - MIN_CARD_COUNT) + 1;
			break;
			default: hand[2] = 0; break;
		} 
	}
	
	public void showCardsOnHand(int[] hand) {

		for (int i=0; i <=2; i++) {
			if (hand[i] != 0) { // don't show third card if it's 0 
				System.out.print(hand[i] + "\t" );
			}
		}	
	}
	

	
}

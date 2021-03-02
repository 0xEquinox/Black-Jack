import java.util.*;


public class main {

	static Random rand = new Random();
	static Scanner input = new Scanner(System.in);
	static String playerCard1 = "";
	static String playerCard2 = "";
	static int playerCardVal1 = 0;
	static int playerCardVal2 = 0;
	static int playerCardVal = 0;
	static String dealerCard1 = "";
	static String dealerCard2 = "";
	static int dealerCardVal1 = 0;
	static int dealerCardVal2 = 0;
	static int dealerCardVal = 0;
	static boolean running = true;
	
	public static void main(String[] args) {
		
		
		dealerStart();
		dealerCheck();
		System.out.println();
		System.out.println();
		System.out.println();
		playerTurn();
		System.out.println();
		System.out.println();
		if(running == true) {
			dealerTurn();
			dealerCheck();
			if(running == true) {
				win();
			}
		}
		
	}
	
	public static void playerTurn() {
		String[] cards = new String[]{"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		int[] cardValue = new int[] {2,3,4,5,6,7,8,9,10,10,10,10,11};
		int total = 0;
		
		int picker1 = rand.nextInt(13);
		int picker2 = rand.nextInt(13);
		
		String card1 = cards[picker1];
		String card2 = cards[picker2];
		
		total = cardValue[picker1] + cardValue[picker2];
		playerCardVal1 = cardValue[picker1];
		playerCardVal2 = cardValue[picker2];
		playerCardVal = total;
		playerCard1 = card1;
		playerCard2 = card2;
		
		System.out.println("Player Card 1: " + card1);
		System.out.println("Player Card 2: " + card2);
		System.out.println("Player Total: " + total);
		playerCheck();
		System.out.println();
		String choice = " ";
		int turn = 0;
		
		for(;running == true;) {
			
			if(turn >= 1) {
				System.out.println("Would you like to hit or stand?");
				String user = input.nextLine();
				choice = user;
			}else if(card1.equals(card2) && turn < 1) {
				System.out.println("What would you like to do: Hit, Stand, Double Down, or Split?");
				String user = input.nextLine();
				choice = user;
			}else if(turn == 0){
				System.out.println("What would you like to do: Hit, Stand, Double Down: ");
				String user = input.nextLine();
				choice = user;
			}
			if(choice.equals("hit") || choice.equals("Hit")) {
				System.out.println("you hit");
				turn++;
				hit();
				playerCheck();
			}else if(choice.equals("stand") || choice.equals("Stand")) {
				System.out.println("you stood");
				break;
			}else if(choice.equals("double down") || choice.equals("Double Down")) {
				System.out.println("you doubled down");
				hit();
				playerCheck();
				break;
			}else if(choice.equals("split") || choice.equals("Split")) {
				System.out.println("you split");
				split();
				break;
			}else {
				System.out.println("Sorry that wasnt an option please try again");
			}
		}
	}
	
	public static void dealerTurn() {
		System.out.println("Dealer Card 1: " + dealerCard1);
		System.out.println("Dealer Card 2: " + dealerCard2);
		System.out.println("Dealer Total: " + dealerCardVal);
		
		if(dealerCardVal < 17) {
			for(; dealerCardVal < 17;) {
				System.out.println();
				System.out.println("Dealer Hits");
				String[] cards = new String[]{"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
				int[] cardValue = new int[] {2,3,4,5,6,7,8,9,10,10,10,10,11};
				
				
				int picker1 = rand.nextInt(13);
				String card = cards[picker1];
				
				dealerCardVal += cardValue[picker1];
				System.out.println("Dealer's New Card: " + card);
				System.out.println("Total: " + dealerCardVal);
			}
		}else {
			System.out.println("Dealer Stands");
		}
	}
	public static void dealerStart() {
		
		String[] cards = new String[]{"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		int[] cardValue = new int[] {2,3,4,5,6,7,8,9,10,10,10,10,11};
		int total = 0;
		
		int picker1 = rand.nextInt(13);
		int picker2 = rand.nextInt(13);
		
		String card1 = cards[picker1];
		String card2 = cards[picker2];
		total = cardValue[picker1] + cardValue[picker2];
		dealerCard1 = card1;
		dealerCard2 = card2;
		dealerCardVal1 = cardValue[picker1];
		dealerCardVal2 = cardValue[picker2];
		dealerCardVal = dealerCardVal1 + dealerCardVal2;
		
		System.out.println("Dealer Card 1: " + card1);
		System.out.println("Dealer Card 2: " + card2);
		System.out.println("Dealer Total: " + total);
	}
	public static void hit() {
		String[] cards = new String[]{"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		int[] cardValue = new int[] {2,3,4,5,6,7,8,9,10,10,10,10,11};
		
		
		int picker1 = rand.nextInt(13);
		String card = cards[picker1];
		
		playerCardVal += cardValue[picker1];
		System.out.println("Player's New Card: " + card);
		System.out.println("Total: " + playerCardVal);
		
	}public static void split() {
		
		String[] cards = new String[]{"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		int[] cardValue = new int[] {2,3,4,5,6,7,8,9,10,10,10,10,11};
		int total = 0;
		
		int picker1 = rand.nextInt(13);
		int picker2 = rand.nextInt(13);
		
		String card1 = cards[picker1];
		String card2 = cards[picker2];
		
		int total1 = cardValue[picker1] + playerCardVal1; 
		int total2 = cardValue[picker2] + playerCardVal2; 
		
		System.out.println("Hand 1:");
		System.out.println("Card 1: " + playerCard1);
		System.out.println("Card 2: " + card1);
		System.out.println("Total: " + total1);
		System.out.println("Hand 2:");
		System.out.println("Card 1: " + playerCard2);
		System.out.println("Card 2: " + card2);
		System.out.println("Total: " + total2);
		
		System.out.println();
		String choice = "";
		int turn = 0;
		
		for(boolean isLoop = true;isLoop == true;) {
			if(turn == 0) {
				System.out.println("What would you like to do for hand 1? Hit, Stand, Double Down");
				String user = input.nextLine();
				choice = user;
			}else {
				System.out.println("What would you like to do? hit or stand?");
				String user = input.nextLine();
				choice = user;
			}
			
			if(choice.equals("stand") || choice.equals("Stand")) {
				System.out.println("You stood");
				isLoop = false;
			}else if(choice.equals("hit") || choice.equals("Hit")) {
				turn++;
				System.out.println("you hit");
				int picker3 = rand.nextInt(13);
				String card = cards[picker3];
				int cardVal = cardValue[picker3];
				total1 += cardVal;
				int printTurn = turn + 2;
				System.out.println("Card "+ printTurn + ": " + card);
				System.out.println("Total: " + total1); 
				
			}else if(choice.equals("double down") || choice.equals("Double Down")) {
				System.out.println("you doubled down");
				int picker3 = rand.nextInt(13);
				String card = cards[picker3];
				int cardVal = cardValue[picker3];
				total1 += cardVal;
				System.out.println("Card 3: "+ card);
				System.out.println("Total: " + total1); 
				isLoop = false;
			}else {
				System.out.println("Thats not an option please try again.");
			}
		}
		turn = 0;
		for(boolean isLoop2 = true;isLoop2 == true;) {
			if(turn == 0) {
				System.out.println("What would you like to do for hand 2? Hit, Stand, Double Down");
				String user = input.nextLine();
				choice = user;
			}else {
				System.out.println("What would you like to do? hit or stand?");
				String user = input.nextLine();
				choice = user;
			}
			
			if(choice.equals("stand") || choice.equals("Stand")) {
				System.out.println("You stood");
				isLoop2 = false;
			}else if(choice.equals("hit") || choice.equals("Hit")) {
				turn++;
				System.out.println("you hit");
				int picker3 = rand.nextInt(13);
				String card = cards[picker3];
				int cardVal = cardValue[picker3];
				total2 += cardVal;
				int printTurn = turn + 2;
				System.out.println("Card "+ printTurn + ": " + card);
				System.out.println("Total: " + total2); 
				
			}else if(choice.equals("double down") || choice.equals("Double Down")) {
				System.out.println("you doubled down");
				int picker3 = rand.nextInt(13);
				String card = cards[picker3];
				int cardVal = cardValue[picker3];
				total2 += cardVal;
				System.out.println("Card 3: "+ card);
				System.out.println("Total: " + total2); 
				isLoop2 = false;
			}else {
				System.out.println("Thats not an option please try again.");
			}
		}
			
		
	}
	public static void playerCheck() {
		
		if(playerCardVal == 21) {
			System.out.println("BLACK JACK!!!! Player Wins");
			running = false;
		}else if(playerCardVal > 21) {
			System.out.println("Player Busted");
			running = false;
		}
		
	}
	public static void dealerCheck() {
		
		if(dealerCardVal == 21) {
			System.out.println("BLACK JACK!!!! Dealer Wins");
			running = false;
		}else if(dealerCardVal > 21) {
			System.out.println("Dealer Busted");
			running = false;
		}
	}
	public static void win() {
		
		if(dealerCardVal > playerCardVal) {
			System.out.println("Dealer Wins");
		}else if(playerCardVal > dealerCardVal) {
			System.out.println("Player Wins");
		}else {
			System.out.println("It's a tie no one wins");
		}
		
	}
}

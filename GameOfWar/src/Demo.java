import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		Deck teste = new Deck();
		teste.makeCards();
		System.out.println("Shuffling cards.");
		teste.shuffleCards();
		System.out.println("Splitting the deck.");
		teste.splitDeck();
		Player player1= new Player("Ivan");
		Player player2= new Player("Gosho");
		
		Game voina= new Game(teste, player1, player2);
		System.out.println("Giving "+ voina.player1.name+ " a hand");
		System.out.println("Giving "+ voina.player2.name+ " a hand");
		voina.giveEachPlayerAHand(player1.hand, player2.hand);
		
		System.out.println(voina.player1.name+" has "+voina.player1.hand.size()+" cards.");
		System.out.println(voina.player2.name+" has "+voina.player2.hand.size()+" cards.");
		System.out.print("It is time to play war!!! ");
		System.out.println();
		System.out.println();
			do {
				System.out.println("Drawing cards..");
				voina.playWar();
				System.out.println();
			} while (player1.hand.size()>0 || player2.hand.size()>0);
		
		System.out.println(player1.name+" has taken "+ player1.pile.size()+" cards.");
		System.out.println(player2.name+" has taken "+ player2.pile.size()+" cards.");

		if(player1.pile.size()>player2.pile.size()){
			System.out.println(player1.name+" wins!!!");
		}
		if(player2.pile.size()>player1.pile.size()){
			System.out.println(player2.name+" wins!!!");
		}
		if(player1.pile.size()==player2.pile.size()){
			System.out.println("It's a draw.");
		}
		
	}

}

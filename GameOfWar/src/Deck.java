import java.util.ArrayList;

public class Deck  {
	final  String[]numbers= {"2","3","4","5","6","7","8","9","10", "Jack","Queen","King","Ace" };
	final  String[]color = {"spades","clubs", "hearts","diamonds"};
	Card[] cards;
	ArrayList<Card> firstHalf= new ArrayList<Card>();
	ArrayList<Card> secondHalf= new ArrayList<Card>();
	
	void makeCards(){
		cards= new Card[52];
		int index=0;
			for (int j = 0; j < this.color.length; j++) {
				for (int i = 0; i < this.numbers.length; i++) {
					cards[index]= new Card(this.color[j], this.numbers[i],i);
					index++;
				}	
			}
	}
	void shuffleCards(){
		for (int i = 0; i < this.cards.length; i++) {
			int randIndex= (int)(Math.random()*(cards.length));
			Card temp=this.cards[i];
			this.cards[i]=this.cards[randIndex];
			this.cards[randIndex]=temp;
		}
	}
	void splitDeck(){
		for (int i = 0; i < this.cards.length/2; i++) {
				firstHalf.add(this.cards[i]);
		}
		for (int j = this.cards.length/2; j < this.cards.length; j++) {
			secondHalf.add(this.cards[j]);
		}
	}
	void printDeck(){
		for (int i = 0; i < this.cards.length; i++) {
			System.out.println(this.cards[i].color+" of "+ this.cards[i].numbers);
		}
	}
	
//	void printFirstHalf(){
//		for (int i = 0; i < firstHalf.length; i++) {
//			System.out.println(firstHalf[i]);
//		}
//	}
//	void printSecondHalf(){
//		for (int i = 0; i < secondHalf.length; i++) {
//			System.out.println(secondHalf[i]);
//		}
//	}
	
	
	
}

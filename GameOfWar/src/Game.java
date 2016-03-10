import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	Player player1;
	Player player2;
	Deck deck;
	
	public Game(Deck deck, Player player1, Player player2){
		if(deck!=null && player1!=null && player2!=null){
			this.deck=deck;
			this.player1=player1;
			this.player2=player2;
		}
	}
	void giveEachPlayerAHand(ArrayList firstHand, ArrayList secHand){
		for (int i = 0; i < deck.firstHalf.size(); i++) {
			this.player1.hand.add(deck.firstHalf.get(i));
		}
		for (int i = 0; i < deck.secondHalf.size(); i++) {
			this.player2.hand.add(deck.secondHalf.get(i));
		}
	}
	
	void removeCard(int indexStart, int indexEnd){
		for (int i = indexStart; i <=indexEnd; i++) {
			if(player1.hand.get(i)!=null && player2.hand.get(i)!=null){
				player1.hand.remove(i);
				player2.hand.remove(i);
			}
		}
	}
	
	void playWar(){		
		int lastIndex=0;
		int index=0;
		while (player1.hand.size()!=0 || player2.hand.size()!=0) {
			System.out.println(player1.name+" has a "+
					player1.hand.get(0).color+" of "+player1.hand.get(0).numbers);
					
					System.out.println(player2.name+" has a "+
					player2.hand.get(0).color+" of "+player2.hand.get(0).numbers);
							
			
			if(player1.hand.get(0).power > player2.hand.get(0).power){
				System.out.println(player1.name+" takes both cards.");
				player1.pile.add(player1.hand.get(0));
				player1.pile.add(player2.hand.get(0));
				player1.hand.remove(0);
				player2.hand.remove(0);
				return;
			}
			if(player1.hand.get(0).power < player2.hand.get(0).power){
				System.out.println(player2.name+" takes both cards.");
				player2.pile.add(player1.hand.get(0));
				player2.pile.add(player2.hand.get(0));
				player1.hand.remove(0);
				player2.hand.remove(0);
				return;
			}
			if(player1.hand.get(0).power == player2.hand.get(0).power ){
				if(player1.hand.size()>=4 && player2.hand.size()>=4){
				System.out.println("Both cards of of the same rank. Drawing 3 more.");
				System.out.println(player1.name+ " last of the 3 cards is "
				+player1.hand.get(3).color+" of "+player1.hand.get(3).numbers);	
				System.out.println(player2.name+ " last of the 3 cards is "
				+player2.hand.get(3).color+" of "+player2.hand.get(3).numbers);
				
				if(player1.hand.get(3).power > player2.hand.get(3).power){
					System.out.println(player1.name+" takes all the cards.");
						for (int j2 = index; j2 <=index+3; j2++) {
							player1.pile.add(player1.hand.get(j2));
							player1.pile.add(player2.hand.get(j2));			
						}
						removeCard( index,index+3);
						return;
					}
					if(player1.hand.get(3).power < player2.hand.get(3).power){
						System.out.println(player2.name+" takes all the cards.");
						for (int j2 = index; j2 <=index+3; j2++) {
							player2.pile.add(player1.hand.get(j2));
							player2.pile.add(player2.hand.get(j2));
							
						}
						removeCard( index,index+3);
						return;
					}
					
					if(player1.hand.get(3).power== player2.hand.get(3).power){
						System.out.println("Both last cards are of the same rank. Drawing one more.");
						 index=3;	
						 while (player1.hand.get(index).power== player2.hand.get(index).power ||
									player1.hand.size()==0 || player2.hand.size()==0 ) {
							index++;						
						} 
						 
						System.out.println(player1.name+" has "+player1.hand.get(index).color+
								" of "+player1.hand.get(index).numbers);
						System.out.println(player2.name+" has "+player2.hand.get(index).color+
								" of "+player2.hand.get(index).numbers);
						
						if(player1.hand.get(index).power > player2.hand.get(index).power){
							System.out.println(player1.name+" takes all the cards.");
							for (int j = 0; j <= index; j++) {
								player1.pile.add(player1.hand.get(j));
								player1.pile.add(player2.hand.get(j));
							}
							removeCard(0, index);
							return;
						}
						if(player1.hand.get(index).power < player2.hand.get(index).power){
							System.out.println(player2.name+" takes all the cards.");
							for (int j = 0; j <= index; j++) {
								player2.pile.add(player1.hand.get(j));
								player2.pile.add(player2.hand.get(j));
							}
							removeCard(0, index);
							return;
						}
						if(player1.hand.get(index).power == player2.hand.get(index).power){
							System.out.println("Both cards are of the same rank. Both players take half of the cards.");
							for (int i = 0; i < index; i++) {
								player1.pile.add(player2.hand.get(i));
								player2.pile.add(player1.hand.get(i));
							}
							removeCard(0, index);
							return;
						}
					}
				}else{
					for (int i = 0; i < player1.hand.size(); i++) {
						if(i==player1.hand.size()-1){
							lastIndex=i;
						}
						else{
							continue;
						}
					}
					if(player1.hand.get(lastIndex).power>player2.hand.get(lastIndex).power){
						System.out.println(player1.name+" takes all the cards.");
						for (int i = 0; i <=lastIndex; i++) {
							player1.pile.add(player1.hand.get(i));
							player1.pile.add(player2.hand.get(i));
						}
						removeCard(0, lastIndex);
						return;
					}
					if(player1.hand.get(lastIndex).power<player2.hand.get(lastIndex).power){
						System.out.println(player2.name+" takes all the cards.");
						for (int i = 0; i <=lastIndex; i++) {
							player2.pile.add(player1.hand.get(i));
							player2.pile.add(player2.hand.get(i));
						}
						removeCard(0, lastIndex);
						return;
					}
					if(player1.hand.get(lastIndex).power == player2.hand.get(lastIndex).power){
						System.out.println("Both cards are of the same rank. Both players take half of the cards.");
						for (int i = 0; i < index; i++) {
							player1.pile.add(player2.hand.get(i));
							player2.pile.add(player1.hand.get(i));
						}
						removeCard(0, index);
						return;
					}
				}
			}
		}	
	}	
	

}

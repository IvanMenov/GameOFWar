
public class Card {

	 String numbers;
	 String color ;
	 int power;
	 
	public Card(String color, String number, int power ) {
		if(color!=null && number !=null && power>=0 && power<=14){
			this.color=color;
			this.numbers=number;
			this.power=power;
		}
	}
	
}

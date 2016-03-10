import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	 String name;
	ArrayList<Card> hand= new ArrayList<Card>();
	ArrayList<Card> pile= new ArrayList<Card>();
	
	public Player(final String  name) {
		if(name!=null & !name.equals("")){
			this.name= name;
		}
	}	
}

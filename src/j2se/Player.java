package j2se;

import java.util.ArrayList;
public enum Player {
	PLAYER1,PLAYER2,PLAYER3,PLAYER4;
	public boolean exist=true;
	ArrayList<Cards> handcard=new ArrayList<>();
	public void getcard(Cards card){
		handcard.add(card);
	}
	public void showcards(){
		System.out.println(handcard);
		if(exist==false)
			System.out.print("ÒÑ¾­±»ÒÆ³ý");
	}
	public void remove(){
		this.exist=false;
	}
}
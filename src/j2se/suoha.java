package j2se;

import java.util.Scanner;
public class suoha {
	private Cards card;                          //��������
	private boolean end;
	public suoha(){
	}
	public suoha(Cards card){
		this.card=card;
	}
	public void setend(){
		this.end=true;
	}
	public boolean getend(){
		return this.end;
	}
	public void start(){
		this.card.initgame();
		Scanner sc = new Scanner(System.in);
		for(;;){
			System.out.println("����1�鿨������2�鿴���ƣ�����3�鿴�ƿ⣬����4�Ƴ���ң�����5��������");
			int p = sc.nextInt();
			switch(p){
			case 1:
				this.card.choosecard(Player.PLAYER1,this);
				this.card.choosecard(Player.PLAYER2,this);
				this.card.choosecard(Player.PLAYER3,this);
				this.card.choosecard(Player.PLAYER4,this);
				break;
			case 2:
				Player.PLAYER1.showcards();
				Player.PLAYER2.showcards();
				Player.PLAYER3.showcards();
				Player.PLAYER4.showcards();
				break;
			case 3:
				this.card.watchcards();
				break;
			case 4:
				System.out.println("�Ƴ��ĸ�Player������������");
				int q = sc.nextInt();
				switch(q){
				case 1:
					Player.PLAYER1.remove();
					break;
				case 2:
					Player.PLAYER2.remove();
					break;
				case 3:
					Player.PLAYER3.remove();
					break;
				case 4:
					Player.PLAYER4.remove();
					break;
				}
				break;
			case 5:
				Cards.node(Player.PLAYER1);
				Cards.node(Player.PLAYER2);
				Cards.node(Player.PLAYER3);
				Cards.node(Player.PLAYER4);
				break;
			}
			if(end)
				break;
		}
		System.out.println("��Ϸ����");
		Player.PLAYER1.showcards();
		Player.PLAYER2.showcards();
		Player.PLAYER3.showcards();
		Player.PLAYER4.showcards();
	}
	public static void main(String[] args) {
		suoha game=new suoha(new Cards());
		game.start();
	}
}

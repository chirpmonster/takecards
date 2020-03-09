package j2se;

import java.util.Scanner;
public class suoha {
	private Cards card;                          //用于连接
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
			System.out.println("输入1抽卡，输入2查看手牌，输入3查看牌库，输入4移除玩家，输入5整理手牌");
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
				System.out.println("移除哪个Player，请输入数字");
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
		System.out.println("游戏结束");
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

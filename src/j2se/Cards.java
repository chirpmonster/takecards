package j2se;

import java.util.ArrayList;
import java.util.List;
public class Cards {
	private String colour;
	private String number;
	ArrayList<Cards> cardpool=new ArrayList<>();
	private Cards leftnode;
	private Cards rightnode;
	private Cards middle;
	public Cards(){
	}
	public Cards(String colour,String number){
		this.colour=colour;
		this.number=number;
	}
	public String getcolour(){
		return this.colour;
	}
	public String getnumber(){
		return this.number;
	}
	public String toString(){                                    //2��9���Ż��������������
		return this.colour+this.number;
	}
	public void initgame(){	                                    //��ʼ����Ϸ
		String[] colour={"����","�ݻ�","����","����"};
		String[] number={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		for(int i=0;i<=3;i++){
			for(int j=0;j<=12;j++){
				Cards newone=new Cards(colour[i],number[j]);
				cardpool.add(newone);
			}
		}
		
	}
	public void choosecard(Player player,suoha game){   //�鿨
		if(player.exist==false)
			return;
		if(game.getend())
			return;
		int i;
		i=(int)(Math.random() * cardpool.size());
		player.getcard(cardpool.get(i));
		cardpool.remove(i);
		if(cardpool.size()==0){
			game.setend();
		}
	}
	public void watchcards(){                                        //���ƿ�
		System.out.print("�ƿ��ﻹ��");
		System.out.println(cardpool);	
	}
	public static void node(Player player){                    //����������(2��8���Ż�)
		Cards root=new Cards();
		for(Cards h:player.handcard){
			root.donode(h);
		}
		player.handcard.clear();
		player.handcard.addAll(root.takenode());
	}
	private void donode(Cards h){                             //����������
		if(middle==null)
			middle=h;
		else{
			if(compare(h,middle)){
				if(rightnode==null){
					this.rightnode=new Cards();
					rightnode.donode(h);
				}
				else
					rightnode.donode(h);
			}
			if(compare(h,middle)==false){
				if(leftnode==null){
					this.leftnode=new Cards();
					leftnode.donode(h);
				}
				else
					leftnode.donode(h);
			}
		}
	}
	public ArrayList<Cards> takenode(){                      //���������
		ArrayList<Cards> nodecard=new ArrayList<>();
		if(leftnode!=null){
			nodecard.addAll(leftnode.takenode());
		}
		nodecard.add(middle);
		if(rightnode!=null){
			nodecard.addAll(rightnode.takenode());
		}
		return nodecard;
	}
	private boolean compare(Cards middle,Cards h){     //�ȴ�С
		int colour1=0,colour2=0,number1=0,number2=0;
		switch(middle.colour){
		case "����":
			colour1=1;
			break;
		case "�ݻ�":
			colour1=2;
			break;
		case "����":
			colour1=3;
			break;
		case "����":
			colour1=4;
			break;
		}
		switch(h.colour){
		case "����":
			colour2=1;
			break;
		case "�ݻ�":
			colour2=2;
			break;
		case "����":
			colour2=3;
			break;
		case "����":
			colour2=4;
			break;
		}
		switch(middle.number){
		case "A":
			number1=1;
			break;
		case "2":
			number1=2;
			break;
		case "3":
			number1=3;
			break;
		case "4":
			number1=4;
			break;
		case "5":
			number1=5;
			break;
		case "6":
			number1=6;
			break;
		case "7":
			number1=7;
			break;
		case "8":
			number1=8;
			break;
		case "9":
			number1=9;
			break;
		case "10":
			number1=10;
			break;
		case "J":
			number1=11;
			break;
		case "Q":
			number1=12;
			break;
		case "K":
			number1=13;
			break;
		}
		switch(h.number){
		case "A":
			number2=1;
			break;
		case "2":
			number2=2;
			break;
		case "3":
			number2=3;
			break;
		case "4":
			number2=4;
			break;
		case "5":
			number2=5;
			break;
		case "6":
			number2=6;
			break;
		case "7":
			number2=7;
			break;
		case "8":
			number2=8;
			break;
		case "9":
			number2=9;
			break;
		case "10":
			number2=10;
			break;
		case "J":
			number2=11;
			break;
		case "Q":
			number2=12;
			break;
		case "K":
			number2=13;
			break;
		}
		if(colour1>colour2)
			return true;
		else if(colour1<colour2)
			return false;
		else{
			if(number1>number2)
				return true;
			else
				return false;
		}
	}
}

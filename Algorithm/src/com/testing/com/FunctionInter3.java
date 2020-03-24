package com.testing.com;

interface MessageAble{
	Message getMessage(String msg);
}
class Message{
	private String msge;
	Message(String msg){
		this.msge = msg;
		System.out.println(msge);
	}
	
}
public class FunctionInter3 {

	public static void main(String[] args) {
		MessageAble msg = Message::new;
		msg.getMessage("Sakthi");
		System.out.println(msg);
			
	}

}

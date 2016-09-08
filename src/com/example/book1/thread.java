package com.example.book1;

public class thread extends Thread{
	public static String b;
	public static void run(User user) {
	 b=new YQConServer().sendLoginInfo(user);  
	}
	
	public static String ret()
	{
		return b;
		
	}

}

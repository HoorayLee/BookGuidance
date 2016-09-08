package com.example.book1;

import java.io.Serializable;

public class User implements Serializable    {
	 String acount;
	 static String account;
	 String password;
	 int operation;
	 int credit;
	/*String nick;
	String sex;
	int age;*/
	public void setAccount(String a)
	{
		this.acount=a;
	}
	
	public void setPassword(String a)
	{
		this.password=a;
	}
	public void setOperation(int operation){
		this.operation=3;
		
	}
	public int getOperation(){
		return operation;
		
	}
	public String getAccount() {
		// TODO Auto-generated method stub
		return acount;
	}
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	/*public String getNick() {
	return nick;
}
public void setNick(String nick) {
	this.nick = nick;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
*/public int getcredit() {
	return credit;
}
public void setcredit(int credit) {
	this.credit = credit;
}
}

package com.example.book1;

import java.io.Serializable;
import java.util.ArrayList;

public class YQMessage implements Serializable{
	String type;
	public  String content;
	public String content2;
	public static int number;
	public String studentId;
	public String[][] record;
	public ArrayList<String> recordA;

	public String[][] getRecord() {
		return record;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent2() {
		return content2;
	}
	public void setContent2(String content2) {
		this.content2 = content2;
	}
	public static int getNumber() {
		return number;
	}
	public static void setNumber(int number) {
		YQMessage.number = number;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public ArrayList<String> getRecordA() {
		return recordA;
	}
	public void setRecordA(ArrayList<String> recordA) {
		this.recordA = recordA;
	}
	public void setRecord(String[][] record) {
		this.record = record;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}

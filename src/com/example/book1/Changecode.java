package com.example.book1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Changecode extends Activity {
	public static String code1;
	public static String code2;
	boolean b=false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_changecode);
		final Button Btna = (Button)findViewById(R.id.button1);
		code1="123";
		code2="123";
		Btna.setOnClickListener(new ImageButton.OnClickListener(){//search for books 
            public void onClick(View v) {    
            	 code1=((EditText) findViewById(R.id.editText1)).getText().toString();
            	 code2=((EditText) findViewById(R.id.editText2)).getText().toString();
            	 b = judge(code1,code2);
            	 if(b==true)
     			{
            		 Btna.setText("成功修改!");
     			}
     			
     			else
     			{
     				Btna.setText("失败!");
     			}
            	 //b=YQConServer.changecode(code1,code2);
            	// b=true;
            }

			private boolean judge(String code1, String code2) {
				boolean b = false;// TODO Auto-generated method stub
				if(!code1.equals("123"))
     			{
            		 Btna.setText("密码错误!");
     			}
     			else if(code1.equals(code2))
     			{
     				Btna.setText("请不要使用相同的密码!");
     			}
     			else
     			{
     				YQConServer.feedback1(User.account+"将自己的密码修改为"+code2+"已存入数据库");
     				YQConServer.changecode(code1, code2);
     				b=true;
     			}
				return b;
			}
            });
		
		
//		if(b==false)
//		{
//			Toast.makeText(this, "Incorrect Password!", 100);
//		}
//		else
//		{
//			Toast.makeText(this, "Succeed!", 100);
//		}
		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.changecode, menu);
		return true;
	}

}

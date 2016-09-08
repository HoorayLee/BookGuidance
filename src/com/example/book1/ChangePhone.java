package com.example.book1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ChangePhone extends Activity {
	public static String code1;
	public static String code2;
	boolean b=false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_change_phone);
		
			
			final Button Btna = (Button)findViewById(R.id.button1);
			Btna.setOnClickListener(new ImageButton.OnClickListener(){//search for books 
	            public void onClick(View v) {    
	            	 code1=((EditText) findViewById(R.id.editText1)).getText().toString();
	            	 code2=((EditText) findViewById(R.id.editText2)).getText().toString();
	            	 if(!code1.equals(code2))
	            	 {
	            		 Btna.setText("两次号码不相同!");
	            	 }
	            	 else
	            	 {
	            	 b=YQConServer.feedback1(User.account+"将电话号码改成了："+code1+"；已存入数据库");
	            	// b=YQConServer.changecode(code1,code2);
	            	 Btna.setText("修改成功!");
	            	 act1.number=code1;
	            	 }
	            }
	            });
//			if(b==false)
//			{
//				Toast.makeText(this, "Fail in connecting!", 100);
//			}
//			else
//			{
//				Toast.makeText(this, "Succeed!", 100);
//			}
			 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.change_phone, menu);
		return true;
	}

}

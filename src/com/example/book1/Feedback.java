package com.example.book1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Feedback extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feedback);
		Button Btna = (Button)findViewById(R.id.button1);
		
		 Btna.setOnClickListener(new Button.OnClickListener(){//创建监听    
	            public void onClick(View v) { 
	            	boolean a;
	            	String content=((EditText) findViewById(R.id.editText1)).getText().toString();
	            	a=YQConServer.feedback(content);
	            	if(a==true)
	            	{
	            		TextView myTextView;
	            		myTextView = (TextView)findViewById(R.id.textView1);
	            		 myTextView.setText("我们已收到您的反馈！");
	            	}
	            	else
	            	{
	            		TextView myTextView;
	            		myTextView = (TextView)findViewById(R.id.textView1);
	            		 myTextView.setText("服务器通讯异常！");
	            	}
	            }
	            });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.feedback, menu);
		return true;
	}

}

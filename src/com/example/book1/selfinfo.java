package com.example.book1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class selfinfo extends Activity{

	public selfinfo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selfinfo);
		ImageButton Btn1 = (ImageButton)findViewById(R.id.imageButton1);
		Button Btn2 = (Button)findViewById(R.id.button1);
		Button Btn3 = (Button)findViewById(R.id.button2);
		TextView t1 = (TextView)findViewById(R.id.textView3);
		t1.setText("�绰���룺"+act1.number);
		TextView t2 = (TextView)findViewById(R.id.textView1);
		int a=100;
		a=a+lendhis.good;
		t2.setText("��������ֵ��"+a);
		Btn1.setOnClickListener(new ImageButton.OnClickListener(){//�޸�ͷ��   
            public void onClick(View v) {    
            	//setTitle("none");
            }
            });
		Btn2.setOnClickListener(new Button.OnClickListener(){//��������    
            public void onClick(View v) {    
            	Intent intent1 = new Intent();
                intent1.setClass(selfinfo.this, Changecode.class);
       		    startActivity(intent1);
            }
            });
		Btn3.setOnClickListener(new Button.OnClickListener(){//��������    
            public void onClick(View v) {    
            	Intent intent1 = new Intent();
                intent1.setClass(selfinfo.this, ChangePhone.class);
       		    startActivity(intent1);
            }
            });
	}

}

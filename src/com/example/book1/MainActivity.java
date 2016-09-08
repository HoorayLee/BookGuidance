package com.example.book1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button Btn1 = (Button)findViewById(R.id.button1);//��ȡ��ť��Դ   
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
		.detectDiskReads()
		.detectDiskWrites()
		.detectNetwork()   // or .detectAll() for all detectable problems
		.penaltyLog()
		.build());
		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
		.detectLeakedSqlLiteObjects()
		.detectLeakedClosableObjects()
		.penaltyLog()
		.penaltyDeath()
		.build());
        Btn1.setOnClickListener(new Button.OnClickListener(){//��������    
            

			@Override
			public void onClick(View arg0) {
				String account=((EditText) findViewById(R.id.editText1)).getText().toString();  
                String password=((EditText) findViewById(R.id.editText2)).getText().toString();  
                login(account, password);  
				User.account=account;
			}
            });
		
		
	}
	
	public void login(String account, String password)
	{
		User user=new User();  
		
        user.setAccount(account);  
        user.setPassword(password);  
        user.setOperation(3);  
        
        String b;
       
        //int a=1;
        thread.run(user);
        b=thread.ret();
        //��½�ɹ�  
        if(b.equals("yeah")){  
            Intent intent = new Intent();
			intent.setClass(MainActivity.this, act1.class);
			 startActivity(intent);	// TODO Auto-generated method stub
			  
        }else {  
        	setTitle(b);
            Toast.makeText(this, "wrong password/acount!", Toast.LENGTH_SHORT).show();  
        }  
    }  
		
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
}

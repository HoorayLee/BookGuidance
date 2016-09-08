package com.example.book1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SlidingDrawer;
import android.widget.Toast;

public class act1 extends Activity{
	public static String book;
	public static int i=0;
	public static String number="29983940";
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act1);
		setTitle("Welcome!");
		
		
		ImageButton Btn1 = (ImageButton)findViewById(R.id.imageButton1);
		ImageButton Btn = (ImageButton)findViewById(R.id.imageButton2);
		
		
		Button Btna = (Button)findViewById(R.id.handle1);
		Button Btnb = (Button)findViewById(R.id.handle2);
		Button Btnc = (Button)findViewById(R.id.handle3);
		Button Btnd = (Button)findViewById(R.id.handle4);
		Button Btne = (Button)findViewById(R.id.handle5);
		
		
		 Btn1.setOnClickListener(new ImageButton.OnClickListener(){//个人信息 
	            public void onClick(View v) {    
	            	Intent intent = new Intent();
	                intent.setClass(act1.this, selfinfo.class);
	       		    startActivity(intent);
	            }
	            });
		 Btn.setOnClickListener(new ImageButton.OnClickListener(){//search for books 
	            public void onClick(View v) {    
	            	book=((EditText) findViewById(R.id.editText1)).getText().toString();
	            	//Log.v("TAG", book);
	     
	            	Intent intent1 = new Intent();
	                intent1.setClass(act1.this, Searchbook.class);
	       		    startActivity(intent1);
	            }
	            });
		 Btna.setOnClickListener(new Button.OnClickListener(){//借阅记录    
	            public void onClick(View v) {    
	            	Intent intent1 = new Intent();
	                intent1.setClass(act1.this, lendhis.class);
	       		    startActivity(intent1);
	            }
	            });
		 Btnb.setOnClickListener(new Button.OnClickListener(){//预约记录    
	            public void onClick(View v) {    
	            	
	            	Intent intent1 = new Intent();
	                intent1.setClass(act1.this, ReserveHis.class);
	       		    startActivity(intent1);
	            }
	            });
		 Btnc.setOnClickListener(new Button.OnClickListener(){//搜索记录    
	            public void onClick(View v) {    
	            	Intent intent1 = new Intent();
	                intent1.setClass(act1.this, SearchRec.class);
	       		    startActivity(intent1);
	            }
	            });
		 Btnd.setOnClickListener(new Button.OnClickListener(){//意见反馈    
	            public void onClick(View v) {    
	            	Intent intent = new Intent();
	                intent.setClass(act1.this, Feedback.class);
	       		    startActivity(intent);	
	            }
	            });
		 Btne.setOnClickListener(new Button.OnClickListener(){//设置    
	            public void onClick(View v) {    
	            	Intent intent = new Intent();
	                intent.setClass(act1.this, setting.class);
	       		    startActivity(intent);	
	            }
	            });
		 
		 
	}
	
	public void getsever(String url)
	{
	
	}
		
}
	


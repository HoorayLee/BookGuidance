package com.example.book1;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class setting extends Activity{

	public setting() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting);
		setTitle("设置");
		Button Btn1 = (Button)findViewById(R.id.button1);
		Button Btn3 = (Button)findViewById(R.id.button3);
		Button Btn4 = (Button)findViewById(R.id.button4);
		Button Btn5 = (Button)findViewById(R.id.button5);
		
		 Btn1.setOnClickListener(new Button.OnClickListener(){//清空记录   
	            public void onClick(View v) {    
	            	Searchbook.i=0;
	            	Searchbook.i1=0;
	            	YQConServer.feedback1(User.account+"清除了本地浏览记录");
	            }
	            });
		
		 Btn3.setOnClickListener(new Button.OnClickListener(){//消息中心  
	            public void onClick(View v) {    
	            	String ns = Context.NOTIFICATION_SERVICE;

	            	NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);//定义通知栏展现的内容信息

	            	int icon = R.drawable.back2;

	            	CharSequence tickerText = "该还书了！";

	            	long when = System.currentTimeMillis();

	            	Notification notification = new Notification(icon, tickerText, when);

	            	//定义下拉通知栏时要展现的内容信息

	            	Context context = getApplicationContext();

	            	CharSequence contentTitle = "该还书了！";

	            	CharSequence contentText = "你有书即将到期了！";

	            	Intent notificationIntent = new Intent();
	            	notificationIntent.setClass(setting.this, setting.class);
	       		    startActivity(notificationIntent);
	       		    PendingIntent contentIntent = PendingIntent.getActivity(setting.this,0,new Intent(setting.this,setting.class),0);
	            	
	            	notification.setLatestEventInfo(context, contentTitle, contentText,contentIntent); 

	            	//用mNotificationManager的notify方法通知用户生成标题栏消息通知

	            	mNotificationManager.notify(1, notification);	
	            }
	            });
		 Btn4.setOnClickListener(new Button.OnClickListener(){//消息推送方式    
	            public void onClick(View v) {    
	            	Intent intent = new Intent();
	                intent.setClass(setting.this, Way.class);
	       		    startActivity(intent);	

	            }
	            });
		 Btn5.setOnClickListener(new Button.OnClickListener(){//推出   
	            public void onClick(View v) {    
	            	boolean a = false;
	            	a=YQConServer.exit();
	            	if(a==true)
	            	{
	            		android.os.Process.killProcess(android.os.Process.myPid());
	            	}
	            }
	            });
	}

}

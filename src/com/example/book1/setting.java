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
		setTitle("����");
		Button Btn1 = (Button)findViewById(R.id.button1);
		Button Btn3 = (Button)findViewById(R.id.button3);
		Button Btn4 = (Button)findViewById(R.id.button4);
		Button Btn5 = (Button)findViewById(R.id.button5);
		
		 Btn1.setOnClickListener(new Button.OnClickListener(){//��ռ�¼   
	            public void onClick(View v) {    
	            	Searchbook.i=0;
	            	Searchbook.i1=0;
	            	YQConServer.feedback1(User.account+"����˱��������¼");
	            }
	            });
		
		 Btn3.setOnClickListener(new Button.OnClickListener(){//��Ϣ����  
	            public void onClick(View v) {    
	            	String ns = Context.NOTIFICATION_SERVICE;

	            	NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);//����֪ͨ��չ�ֵ�������Ϣ

	            	int icon = R.drawable.back2;

	            	CharSequence tickerText = "�û����ˣ�";

	            	long when = System.currentTimeMillis();

	            	Notification notification = new Notification(icon, tickerText, when);

	            	//��������֪ͨ��ʱҪչ�ֵ�������Ϣ

	            	Context context = getApplicationContext();

	            	CharSequence contentTitle = "�û����ˣ�";

	            	CharSequence contentText = "�����鼴�������ˣ�";

	            	Intent notificationIntent = new Intent();
	            	notificationIntent.setClass(setting.this, setting.class);
	       		    startActivity(notificationIntent);
	       		    PendingIntent contentIntent = PendingIntent.getActivity(setting.this,0,new Intent(setting.this,setting.class),0);
	            	
	            	notification.setLatestEventInfo(context, contentTitle, contentText,contentIntent); 

	            	//��mNotificationManager��notify����֪ͨ�û����ɱ�������Ϣ֪ͨ

	            	mNotificationManager.notify(1, notification);	
	            }
	            });
		 Btn4.setOnClickListener(new Button.OnClickListener(){//��Ϣ���ͷ�ʽ    
	            public void onClick(View v) {    
	            	Intent intent = new Intent();
	                intent.setClass(setting.this, Way.class);
	       		    startActivity(intent);	

	            }
	            });
		 Btn5.setOnClickListener(new Button.OnClickListener(){//�Ƴ�   
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

package com.example.book1;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ReserveHis extends Activity {
	//String[][] record=new String[50][50];
	public static String[] lend= new String[10];
	private static LinearLayout llLayout;
	 Button Btn[]=new Button[10];
	 public static int num=0;
	int n,i;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reserve_his);
		
		i=Searchbook.i;
		i--;
		n=i;
		for(;i>-1;i--)
		{
			create(i);
		}
		
//		record=YQConServer.reserveRec(User.account);
//		if(record[0][0]=="error!")
//		{
//			Toast.makeText(this, "��ԤԼ��¼��", 100);
//		}
//		else if(record!=null)
//		{
//			for(n=0;n<50;n++)
//			{
//				if(record[n][0]!=null)
//				{
//					for(i=0;i<50;i++)
//					{
//						if(record[n][i]==null)
//						{
//							break;
//						}
//						else
//							create(n,i);
//					}
//				}
//				else
//					break;
//			}
//		}

		if(n>-1)
		{
			 Btn[n].setOnClickListener(new Button.OnClickListener(){
					public void onClick(View v) { 
						boolean b=true;
						//b=YQConServer.confirm(Searchbook.bo[n]);
			        		if(b==true)
			        		{
			        			Btn[n].setText("�ɹ�ȷ�ϣ��鱾�ѽ��");
			        			lend[num]=Searchbook.bo[n];
			        			num++;
			        			Searchbook.i--;
			        			YQConServer.feedback1(Searchbook.bo[n]+"�ѱ��û�ȷ�Ͻ��");
			        			
			        			
			        		}
			        		else
			        		{
			        			Btn[n].setText("�����Ʋ�ͼ��ݽ���");
			        		}
			        	
			        	}
			 });
		}
//			 String ns = Context.NOTIFICATION_SERVICE;
//
//         	NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);//����֪ͨ��չ�ֵ�������Ϣ
//
//         	int icon = R.drawable.back2;
//
//         	CharSequence tickerText = "�û����ˣ�";
//
//         	long when = System.currentTimeMillis();
//
//         	Notification notification = new Notification(icon, tickerText, when);
//
//         	//��������֪ͨ��ʱҪչ�ֵ�������Ϣ
//
//         	Context context = getApplicationContext();
//
//         	CharSequence contentTitle = "�û����ˣ�";
//
//         	CharSequence contentText = "�����鼴�������ˣ�";
//
//         	Intent notificationIntent = new Intent();
//         	notificationIntent.setClass(ReserveHis.this, ReserveHis.class);
//    		    startActivity(notificationIntent);
//    		    PendingIntent contentIntent = PendingIntent.getActivity(ReserveHis.this,0,new Intent(ReserveHis.this,ReserveHis.class),0);
//         	
//         	notification.setLatestEventInfo(context, contentTitle, contentText,contentIntent); 
//
//         	//��mNotificationManager��notify����֪ͨ�û����ɱ�������Ϣ֪ͨ
//
//         	mNotificationManager.notify(1, notification);
		}
		
	

//	public void create(int n,int i)
//	{
//		llLayout = (LinearLayout) findViewById(R.id.scrollView2);
//        Btn[i] = new Button(ReserveHis.this);
//        Btn[i].setText("ȷ����ɽ��飺"+record[n][i]);
//       // mInts.add(count);
//        Btn[i].setWidth(500);
//         llLayout.addView(Btn[i]);
//       
//	}
	public void create(int i)
	{
		llLayout = (LinearLayout) findViewById(R.id.scrollView2);
        Btn[i] = new Button(ReserveHis.this);
        Btn[i].setText("ȷ����ɽ��飺"+Searchbook.bo[i]);
       // mInts.add(count);
        Btn[i].setWidth(800);
         llLayout.addView(Btn[i]);
       
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reserve_his, menu);
		return true;
	}

}

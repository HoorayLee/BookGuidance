package com.example.book1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
/*
 * 此借阅记录不能够显示所有曾经借的书，只能显示已借未还的书
 * 以后还需要改进
 */
public class lendhis extends Activity{
	private static LinearLayout llLayout;
	 Button Btn[]=new Button[10];
	int n,i;
	public static int good=0;
	
	String[][] record=new String[50][50];
	
	protected void onCreate(Bundle savedInstanceState) {
		//record=YQConServer.lendhis(User.account);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lendhis);
		i=ReserveHis.num;
		i--;
		n=i;
		for(;i>-1;i--)
		{
			create(i);
		}
//		if(record[0][0]=="error!")
//		{
//			Toast.makeText(this, "无借阅记录！", 100);
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
							//b=YQConServer.;(Searchbook.bo[n]);
				        		if(b==true)
				        		{
				        			Btn[n].setText("成功确认！信用度增加了！");
				        			ReserveHis.num--;
				        			YQConServer.feedback1(ReserveHis.lend[n]+"已确认被归还，信用度上升");
				        			
				        			good++;
				        		}
				        		else
				        		{
				        			Btn[n].setText("请先移步图书馆还书");
				        		}
				        	}

						

				 });	
	}
			
		
	}

//	public void create(int n,int i)
//	{
//		llLayout = (LinearLayout) findViewById(R.id.scrollView2);
//        Btn[i] = new Button(lendhis.this);
//        Btn[i].setText("确认已还书："+record[n][i]);
//       // mInts.add(count);
//        Btn[i].setWidth(500);
//         llLayout.addView(Btn[i]);
//	}
	public void create(int i)
	{
		llLayout = (LinearLayout) findViewById(R.id.scrollView2);
        Btn[i] = new Button(lendhis.this);
        Btn[i].setText("确认已还书："+ReserveHis.lend[i]);
       // mInts.add(count);
        Btn[i].setWidth(720);
         llLayout.addView(Btn[i]);
	}
}


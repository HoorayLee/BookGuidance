package com.example.book1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
/*
 * �˽��ļ�¼���ܹ���ʾ������������飬ֻ����ʾ�ѽ�δ������
 * �Ժ���Ҫ�Ľ�
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
//			Toast.makeText(this, "�޽��ļ�¼��", 100);
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
				        			Btn[n].setText("�ɹ�ȷ�ϣ����ö������ˣ�");
				        			ReserveHis.num--;
				        			YQConServer.feedback1(ReserveHis.lend[n]+"��ȷ�ϱ��黹�����ö�����");
				        			
				        			good++;
				        		}
				        		else
				        		{
				        			Btn[n].setText("�����Ʋ�ͼ��ݻ���");
				        		}
				        	}

						

				 });	
	}
			
		
	}

//	public void create(int n,int i)
//	{
//		llLayout = (LinearLayout) findViewById(R.id.scrollView2);
//        Btn[i] = new Button(lendhis.this);
//        Btn[i].setText("ȷ���ѻ��飺"+record[n][i]);
//       // mInts.add(count);
//        Btn[i].setWidth(500);
//         llLayout.addView(Btn[i]);
//	}
	public void create(int i)
	{
		llLayout = (LinearLayout) findViewById(R.id.scrollView2);
        Btn[i] = new Button(lendhis.this);
        Btn[i].setText("ȷ���ѻ��飺"+ReserveHis.lend[i]);
       // mInts.add(count);
        Btn[i].setWidth(720);
         llLayout.addView(Btn[i]);
	}
}


package com.example.book1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Searchbook extends Activity {

	public static String[] bo= new String[10];
	public static String[] rec = new String[10];
	public static int i=0;
	public static int i1=0;
	int i2=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_searchbook);
		 final String book=act1.book;
		
		rec[i1]=book;
		i1++;
		search(book);
		final Button Btn1=(Button)findViewById(R.id.button1);
		if (!Btn1.getText().equals("查无此书！"))
		{
		 Btn1.setOnClickListener(new Button.OnClickListener(){
		public void onClick(View v) {  
			
			String book1=act1.book;
			
        	//boolean a = YQConServer.book(book1);
			 //if(a==true)
			int n=i-1;
        	if(i2<1)
        	{
        		Btn1.setText("预约成功！");
        		YQConServer.feedback1(book+"已被"+User.account+"预约; 优先级为1");
        		bo[i]=book;
        		i++;
        		i2++;
        	
        	}
        	else{
        		Btn1.setText("请不要重复预约！");
        	
        	}
        }

        });
		}

	}
	public void search(String book) {
		boolean b = false;
		int cc=0;
		TextView myTextView;
		Button a = (Button)findViewById(R.id.button1);
    	if (book!=null)
    	{
    		//b=YQConServer.check(book);
    		if(book.equals("百年孤独"))
    			{
    			b=true;
    			cc=1;
    			}
    		
    		else if(book.equals("红楼梦"))
    		{
    			b=true;
    			cc=2;
    		}
    		else if(book.equals("西游记"))
    		{
    			b=true;
    			cc=3;
    		}
    		else if(book.equals("谈修养"))
    		{
    			b=true;
    			cc=4;
    		}
    		else if(book.equals("基督山伯爵"))
    		{
    			b=true;
    			cc=5;
    		}
    		else if(book.equals("边城"))
    		{
    			b=true;
    			cc=6;
    		}
    		
    	}
    	if(b==true&&cc==1)
    	{
    		myTextView = (TextView)findViewById(R.id.textView1); 
            
            myTextView.setText("书名："+book+"    作者：加西亚（法）"); 
    	}
    	else if(b==true&&cc==2)
    	{
    		myTextView = (TextView)findViewById(R.id.textView1); 
            
            myTextView.setText("书名："+book+"    作者：曹雪芹（中）"); 
    	}
    	else if(b==true&&cc==3)
    	{
    		myTextView = (TextView)findViewById(R.id.textView1); 
            
            myTextView.setText("书名："+book+"    作者：吴承恩（中）"); 
    	}
    	else if(b==true&&cc==4)
    	{
    		myTextView = (TextView)findViewById(R.id.textView1); 
            
            myTextView.setText("书名："+book+"    作者：朱光潜（中）"); 
    	}
    	else if(b==true&&cc==5)
    	{
    		myTextView = (TextView)findViewById(R.id.textView1); 
            
            myTextView.setText("书名："+book+"    作者：大仲马（法）"); 
    	}
    	else if(b==true&&cc==6)
    	{
    		myTextView = (TextView)findViewById(R.id.textView1); 
            
            myTextView.setText("书名："+book+"    作者：沈从文（中）"); 
    	}
    	else if(b==false)
    	{
    		myTextView = (TextView)findViewById(R.id.textView1); 
        	book="查无此书！";
        	myTextView.setText(book);  
        	a.setText(book);
    	}// TODO Auto-generated method stub
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.searchbook, menu);
		return true;
	}

}

package com.example.book1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SearchRec extends Activity {
	private static LinearLayout llLayout;
	 TextView t1[]=new TextView[10];
	int n,i;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_rec);
		i=Searchbook.i1;
		i--;
		for(;i>-1;i--)
		{
			create(i);
		}
	}
	public void create(int i)
	{
		llLayout = (LinearLayout) findViewById(R.id.scrollView2);
        t1[i] = new Button(SearchRec.this);
        t1[i].setText(" È√˚£∫"+Searchbook.rec[i]);
       // mInts.add(count);
        t1[i].setWidth(720);
         llLayout.addView(t1[i]);
       
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_rec, menu);
		return true;
	}

}

package com.example.book1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class Way extends Activity {

	private static int a1,a2,a3=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_way);
		CheckBox a=(CheckBox)findViewById(R.id.checkBox1); 
		CheckBox b=(CheckBox)findViewById(R.id.checkBox2); 
		CheckBox c=(CheckBox)findViewById(R.id.checkBox3);
		Button bu = ((Button)findViewById(R.id.button1));
		if(a1==1)
		{
			a.isChecked();
		}
		if(a2==1)
		{
			b.isChecked();
		}
		if(a3==1)
		{
			c.isChecked();
		}
		a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
            @Override 
            public void onCheckedChanged(CompoundButton buttonView, 
                    boolean isChecked) { 
                // TODO Auto-generated method stub 
                if(isChecked){ 
                    a1=1; 
                }else{ 
                    a1=0; 
                } 
            } 
        }); 
		b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
            @Override 
            public void onCheckedChanged(CompoundButton buttonView, 
                    boolean isChecked) { 
                // TODO Auto-generated method stub 
                if(isChecked){ 
                    a2=1; 
                }else{ 
                    a2=0; 
                } 
            } 
        }); 
		c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
            @Override 
            public void onCheckedChanged(CompoundButton buttonView, 
                    boolean isChecked) { 
                // TODO Auto-generated method stub 
                if(isChecked){ 
                    a3=1; 
                }else{ 
                    a3=0; 
                } 
            } 
        }); 
		 bu.setOnClickListener(new Button.OnClickListener(){//消息中心  
	            public void onClick(View v) {    
	            	setTitle("保存成功！");	
	            }
	            });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.way, menu);
		return true;
	}

}

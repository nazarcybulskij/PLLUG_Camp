package com.example.pllug_client_;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button SetButton;
	private Button GetButtonList;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SetButton=(Button)findViewById(R.id.button1);
		
		SetButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				if (new IsConnection().isInternet(MainActivity.this)){
					Intent intent=new Intent(MainActivity.this,SetEntityActivity.class);
					startActivity(intent);
				
				}else{
					Toast.makeText(MainActivity.this, "Sorry:) Don't internet connection",Toast.LENGTH_LONG).show();
					
				}
					
				
			}
		});
		
		GetButtonList=(Button)findViewById(R.id.button2);
		
		GetButtonList.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if (new IsConnection().isInternet(MainActivity.this)){
					Intent intent=new Intent(MainActivity.this,GetListActivity.class);
					startActivity(intent);
				}else{
					Toast.makeText(MainActivity.this, "Sorry:) Don't internet connection",Toast.LENGTH_LONG).show();
				}
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

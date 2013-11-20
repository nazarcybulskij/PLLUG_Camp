package com.example.pllug_client_;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SetEntityActivity extends Activity {
	private Button SendButton;
	private EditText lastname;
	private EditText firstname;
	private sendGet senduser;

	
	public final String Logi="info";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setactivity);
		SendButton=(Button)findViewById(R.id.button1);
		lastname=(EditText)findViewById(R.id.editText2);
		firstname=(EditText)findViewById(R.id.editText1);
		
		SendButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if (v.getId()==R.id.button1){
					final String  firstnamestr=String.valueOf((firstname.getText())).trim();
					final String  lastnamestr=String.valueOf((lastname.getText())).trim();
					
					if (firstnamestr.equals("")){
						return;
					}
					if (lastnamestr.equals("")){
						return;
					}
					if (new IsConnection().isInternet(SetEntityActivity.this)){
				
						senduser=new sendGet(firstnamestr,lastnamestr);
						new Thread(new Runnable() {
						
							@Override
							public void run() {
							
								senduser.send();
						
								
							}
						}).start();
					}else{
						Toast.makeText(SetEntityActivity.this, "Sorry:) not internet connection ",Toast.LENGTH_SHORT).show();
					}
						
					
					firstname.setText("");
					lastname.setText("");
					
				}
				
			}
		});
		
		
		
	}
	
	
	

}

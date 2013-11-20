package com.example.pllug_client_;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class GetListActivity extends Activity {
	
	private static final String TAG="INFO";
	HttpList http=new HttpList();
	private ListView listDB;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.getlist);
		
			listDB=(ListView)findViewById(R.id.list);
			MyTask start=new MyTask();
			start.execute();
			String jsonst=" "; 
			try {
				jsonst=start.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONArray ja = null;
			try {
			   ja=new JSONArray(jsonst);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Log.i(TAG,String.valueOf(ja.length()));
			
			JSONObject jsondata;
			ArrayList<String>listview=new ArrayList<String>();
			for (int i=0;i<ja.length();i++){
			  try {
				jsondata= (JSONObject)ja.get(i);
				Log.i(TAG,jsondata.toString());
				String[]temp=jsondata.toString().split("\"");
				listview.add(temp[3]+" "+temp[7]);
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
				
			}
			
		  
			
			
			ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, R.layout.my_list_items,listview);
		    listDB.setAdapter(adapter);
		   
		
			
		
		
		
		
	}
	
	
	
	public class MyTask extends AsyncTask<Void,Void,String>{

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}

		@Override
		
		protected String doInBackground(Void... params) {
			// TODO Auto-generated method stub
		 		 	   
			return HttpList.downloadList("http://asd.nazarzh.cloudbees.net/asd");
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
		}
		
		
		
	}
	
	
	
	

}

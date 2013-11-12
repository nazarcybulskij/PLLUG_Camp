package com.example.pllug_client_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;


import android.util.Log;

public class HttpList {
	
	
	
	
	
	
	
	
	private static final String Tag="asd";
	public static   String downloadList (String uri) {
		String  out=" ";
		StringBuilder temp=null;
		DefaultHttpClient cient=new DefaultHttpClient();
		try {
			HttpResponse response=cient.execute(new HttpPost(uri));				
			HttpEntity entity=response.getEntity();
			InputStream content = entity.getContent();			
			BufferedReader reader = new BufferedReader(new InputStreamReader(content));
			temp=new StringBuilder();
		    String line;
		    Log.i(Tag,"asd");
			while((line = reader.readLine()) != null) {
				temp.append(line);
				Log.i(Tag,line);
	        }
 
			 
			//out=EntityUtils.toString(entity);
					
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp.toString();
		
		
		
	}
	

}

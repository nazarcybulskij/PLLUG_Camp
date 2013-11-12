package com.example.pllug_client_;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class sendGet {
	private String  firstnamestr;
	private String  lastnamestr;
	
	

	public sendGet(String firstnamestr, String lastnamestr) {
		super();
		this.firstnamestr = firstnamestr;
		this.lastnamestr = lastnamestr;
	}
	
	
	
	public void send(){
		
		
			StringBuilder uri=new StringBuilder("http://asd.nazarzh.cloudbees.net/asd");
			
			uri.append("?lastname="+lastnamestr);
			uri.append("&firstname="+firstnamestr);
			
			
			
			try {
				DefaultHttpClient cient=new DefaultHttpClient();
				HttpResponse response=cient.execute(new HttpGet(uri.toString()));
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
	}
	

}

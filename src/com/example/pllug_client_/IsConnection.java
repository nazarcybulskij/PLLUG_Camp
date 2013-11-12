package com.example.pllug_client_;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class IsConnection {
	
	public boolean isInternet(Context context) {
		
		
		ConnectivityManager cm=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
		
		if (cm==null){
			return false;
			
		}
		NetworkInfo ni=cm.getActiveNetworkInfo();
		if (ni!=null && ni.isAvailable() && ni.isConnected())
			return true;
		else
			return false;
					
		
		
	}
	
	

}

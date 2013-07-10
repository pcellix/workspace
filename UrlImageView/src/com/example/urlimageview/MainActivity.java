package com.example.urlimageview;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends Activity {

    public static final String WIFI = "Wi-Fi";
    public static final String ANY = "Any";
   
    // Whether there is a Wi-Fi connection.
    private static boolean wifiConnected = false; 
    // Whether there is a mobile connection.
    private static boolean mobileConnected = false;
    // Whether the display should be refreshed.
    public static boolean refreshDisplay = true;
    
    // The user's current network preference setting.
    public static String sPref = null;
    
    // The BroadcastReceiver that tracks network connectivity changes.
    private NetworkReceiver receiver = new NetworkReceiver();
	Bitmap bitmap;
	ImageView iv;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	     IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
	        receiver = new NetworkReceiver();
	        this.registerReceiver(receiver, filter);
		

	     }
	@Override 
    public void onDestroy() {
        super.onDestroy();
        // Unregisters BroadcastReceiver when app is destroyed.
        if (receiver != null) {
            this.unregisterReceiver(receiver);
        }
    }
	 @Override
	    public void onStart () {
	        super.onStart();  
	        
	        // Gets the user's network preference settings
	        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
	        
	        // Retrieves a string value for the preferences. The second parameter
	        // is the default value to use if a preference value is not found.
	        sPref = sharedPrefs.getString("listPref", "Wi-Fi");

	        updateConnectedFlags(); 
	       
	        if(refreshDisplay){
	            loadPage();    
	        }
	        
	        
	    }
	 
	   public void loadPage(){
			new Thread(new Runnable() {

				@Override
				public void run() {
					try {
			
						URL url = new URL(
								"http://www.muzykalnie.pl/pictures/Wokalistki/Cheryl_Cole/cheryl_cole_3.jpg");
						HttpURLConnection connection = (HttpURLConnection) url
								.openConnection();
						connection.setDoInput(true);
						connection.connect();
						InputStream input = connection.getInputStream();
						bitmap = BitmapFactory.decodeStream(input);
						handler1.sendEmptyMessage(0);
						Log.d("bass", "bitmap decoded");
						Log.d("bass", "empty message send");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}).start();
	   }
	    
	   public void updateConnectedFlags() {
	        ConnectivityManager connMgr = (ConnectivityManager) 
	                getSystemService(Context.CONNECTIVITY_SERVICE);
	        
	        NetworkInfo activeInfo = connMgr.getActiveNetworkInfo();
	        if (activeInfo != null && activeInfo.isConnected()) {
	            wifiConnected = activeInfo.getType() == ConnectivityManager.TYPE_WIFI;
	            mobileConnected = activeInfo.getType() == ConnectivityManager.TYPE_MOBILE;
	        } else {
	            wifiConnected = false;
	            mobileConnected = false;
	        }  
	    }


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.action_settings:
	    	Intent intent = new Intent(this, SettingsActivity.class);
	    	startActivity(intent);
	    }
	    return super.onMenuItemSelected(featureId, item);
	}

	private Handler handler1 = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			iv = (ImageView) findViewById(R.id.iv);
			iv.setImageBitmap(bitmap);
			Log.d("bass", "saass");
		}

	};
	public class NetworkReceiver extends BroadcastReceiver {   
	      
		@Override
		public void onReceive(Context context, Intent intent) {
		    ConnectivityManager conn =  (ConnectivityManager)
		        context.getSystemService(Context.CONNECTIVITY_SERVICE);
		    NetworkInfo networkInfo = conn.getActiveNetworkInfo();
		       
		    // Checks the user prefs and the network connection. Based on the result, decides whether
		    // to refresh the display or keep the current display.
		    // If the userpref is Wi-Fi only, checks to see if the device has a Wi-Fi connection.
		    if (WIFI.equals(sPref) && networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
		        // If device has its Wi-Fi connection, sets refreshDisplay
		        // to true. This causes the display to be refreshed when the user
		        // returns to the app.
		        refreshDisplay = true;


		    // If the setting is ANY network and there is a network connection
		    // (which by process of elimination would be mobile), sets refreshDisplay to true.
		    } else if (ANY.equals(sPref) && networkInfo != null) {
		        refreshDisplay = true;
		                 
		    // Otherwise, the app can't download content--either because there is no network
		    // connection (mobile or Wi-Fi), or because the pref setting is WIFI, and there 
		    // is no Wi-Fi connection.
		    // Sets refreshDisplay to false.
		    } else {
		        refreshDisplay = false;
		    }
		}
	}}

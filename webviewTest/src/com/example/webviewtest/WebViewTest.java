package com.example.webviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class WebViewTest extends Activity {
	
	WebView webView;
	EditText addressBar;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view_test);
		webView = (WebView) findViewById(R.id.webView);
		EditText addressBar = (EditText) findViewById(R.id.addressBar);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setWebViewClient(new WebViewClient());
		webView.loadUrl("http://www.google.pl/");
		webView.setOnTouchListener(new OnTouchListener() {            
		        @Override
		        public boolean onTouch(View v, MotionEvent event) {
		        	Log.d("lol","lol");
		        	return true;
		        }
		});
	}
	public void changeWebPage(View view){
	//	String webPageToVisit = addressBar.getText().toString();
		webView.loadUrl("http://www.netia.pl");
		
	} 
	
	public void Click(View v){
		v = webView;
		Log.d("lol","lol");
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		getMenuInflater().inflate(R.menu.web_view_test, menu);
		return true;
	}

}

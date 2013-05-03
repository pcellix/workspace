package com.example.textviewtest;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TextViewTest extends Activity {
	TextExtension text1;
	TextView text;
	ClipData.Item clip1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final ClipboardManager clipBoard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
		class ClipboardListener implements ClipboardManager.OnPrimaryClipChangedListener
		{
		   public void onPrimaryClipChanged()
		   {
			   String tekst = clipBoard.getText().toString();
		      downloadJson json=new downloadJson();
			  json.execute("http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey=pukhd8djvdz2w29e88x67372&q="+clipBoard.getText().toString()+"&page_limit=5");
				Log.d("ziom",clipBoard.getText().toString());
			 
			   
		      // do something useful here with the clipboard
		      // use getText() methodz
		   }
		}
		clipBoard.addPrimaryClipChangedListener( new ClipboardListener() );
		setContentView(R.layout.activity_text_view_test);
		text1 = new TextExtension(this);
		text1.setTextIsSelectable(true);
		text1.setText(R.string.hello_world);
		RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
		relativeLayout.addView(text1);
	
	}
	//	text = (TextView) findViewById(R.id.textView);
	/*	text.setOnLongClickListener(new OnLongClickListener() {
			  @Override
			    public boolean onLongClick(View v) {
				Log.d("kwas","kwas");
			    return true;
			    }
			
		}); */
/*		text.setOnTouchListener(new OnTouchListener() {            
	        @Override
	        public boolean onTouch(View v, MotionEvent event) {
	        	int start = text.getSelectionStart();
	        	StringBuilder sb = new StringBuilder();
	        	sb.append("");
	        	sb.append(start);
	        	String strI = sb.toString();
	        	Log.d("lol",strI);
	        	return true;
	        } 
	});  */
		
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.text_view_test, menu);
		return true;
	}


}

package com.example.jsonexample;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parsexmlexample.R;

public class MainActivity extends Activity {
	TextView text;
	EditText mEdit;
	ImageView img;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text = (TextView) findViewById(R.id.info);
		mEdit = (EditText) findViewById(R.id.editText1);
		img = (ImageView) findViewById(R.id.imageView1);
		URL url;
		try {
			URL url1 = new URL("http://image10.bizrate-images.com/resize?sq=60&uid=2216744464");
			Bitmap bmp = BitmapFactory.decodeStream(url1.openConnection().getInputStream());
			img.setImageBitmap(bmp);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		} 

	}
	public void searchForMovie(View view){
		String movieToSearch=mEdit.getText().toString();
		downloadJson json=new downloadJson(text,mEdit);
		json.execute("http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey=pukhd8djvdz2w29e88x67372&q="+movieToSearch+"&page_limit=5");

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


}

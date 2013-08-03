package com.example.actionbartest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.SearchView;

public class ActionBarTest extends Activity {
	SearchView searchBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_action_bar_test);
		searchBar = (SearchView) findViewById(R.id.searchView1);
		searchBar.setSubmitButtonEnabled(true);
		class searchListener implements View.OnClickListener{
			
			public void onClick(View w){
				Log.d("kwas","taaaaa");
				
			}
			
		}
		
		searchBar.setOnSearchClickListener(new searchListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.action_bar_test, menu);
		return true;
	}

}

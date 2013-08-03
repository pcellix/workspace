package com.example.system;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(android.R.layout.simple_list_item_1);
		String[] array = new String[2];
		array[0] = "10";
		array[1] = "21";
		ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, array);
		ListView listView = (ListView) findViewById(R.id.ja);
		listView.setAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

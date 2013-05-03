package com.example.textviewtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class downloadJson extends AsyncTask<String, Void, String> {
	private TextView view;
	private EditText etext1;
	private String title;
/*	public downloadJson	(TextView textView, EditText editText){
		this.etext1 = editText;
		this.view = textView;
	} */
	
	TextView txt;
	@Override
	
	protected String doInBackground(String... params) {

		String result = "";
		try {

			String queryString = params[0];
			HttpGet get = new HttpGet(queryString);

			HttpClient client = new DefaultHttpClient();
			HttpResponse response = client.execute(get);
			// result = response.getStatusLine().toString();

			// result = response.getEntity().getContent();
			String line = "";
			StringBuilder total = new StringBuilder();
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));

			// Read response until the end
			while ((line = rd.readLine()) != null) {
				total.append(line);
			}

			result = total.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public void onPostExecute(String result){
	  try {
		  Log.d("kwas",result);
		JSONObject jObject = new JSONObject(result);
		JSONArray jArray = jObject.getJSONArray("movies");
		for (int i=0; i < jArray.length(); i++)
		{
		    JSONObject oneObject = jArray.getJSONObject(i);
		    // Pulling items from the array
		  title = oneObject.getString("title");
		    //view.setText(title);
		}
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  //JSONArray jArray = jObject.getJSONArray("movies");
  }
	public void fillTitle(String title){
		
		
	}
	
	 
}
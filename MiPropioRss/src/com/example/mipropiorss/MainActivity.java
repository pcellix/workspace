package com.example.mipropiorss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.jar.Attributes;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	
	String xmlContent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				URL url;
				try {
					url = new URL("http://ep00.epimg.net/rss/elpais/portada.xml");
					BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
				    StringBuilder strBuild = new StringBuilder();
				    String str;
				    while ((str = in.readLine()) != null) 
				    {
				        strBuild.append(str);
				    }
				    in.close();
				    xmlContent  = strBuild.toString();
				
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				SAXParserFactory factory = SAXParserFactory.newInstance();
				SAXParser saxParser;
				try {
					saxParser = factory.newSAXParser();
					saxParser.parse(xmlContent, handler);
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}).start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	DefaultHandler handler = new DefaultHandler() {
		 
		boolean bfname = false;

	 
		public void startElement(String uri, String localName,String qName, 
	                Attributes attributes) throws SAXException {
	 
			System.out.println("Start Element :" + qName);
	 
			if (qName.equalsIgnoreCase("TITLE")) {
				bfname = true;
			}
	 
		}
	 
		public void endElement(String uri, String localName,
			String qName) throws SAXException {
	 
			System.out.println("End Element :" + qName);
	 
		}
	 
		public void characters(char ch[], int start, int length) throws SAXException {
	 
			if (bfname) {
				String name =  new String(ch, start, length);
				Log.d("bass", name);
				bfname = false;
			}
	 

	 
		}
	 
	     };

}

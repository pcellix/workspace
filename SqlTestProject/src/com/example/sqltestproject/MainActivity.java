package com.example.sqltestproject;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	private static final String TEXT_TYPE = " TEXT";
	private static final String COMMA_SEP = ",";
	private static final String SQL_CREATE_ENTRIES =
	    "CREATE TABLE " + "TABLE_NAME" + " (" +
	    "ID" + " INTEGER PRIMARY KEY," +
	    "COLUMN_NAME_ENTRY_ID" + TEXT_TYPE + COMMA_SEP +
	    "COLUMN_NAME_TITLE" + TEXT_TYPE + COMMA_SEP +
	    " )";

	private static final String SQL_DELETE_ENTRIES =
	    "DROP TABLE IF EXISTS " + "TABLE_NAME";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		DatabaseHandler datas = new DatabaseHandler(this);
		datas.addContact("jams", "bond");
		datas.addContact("jams", "asco");
		datas.getContact(1);
		
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public class DatabaseHandler extends SQLiteOpenHelper {
		 
	    // All Static variables
	    // Database Version
	    private static final int DATABASE_VERSION = 1;
	 
	    // Database Name
	    private static final String DATABASE_NAME = "contactsManager";
	 
	    // Contacts table name
	    private static final String TABLE_CONTACTS = "contacts";
	 
	    // Contacts Table Columns names
	    private static final String KEY_ID = "id";
	    private static final String KEY_NAME = "name";
	    private static final String KEY_PH_NO = "phone_number";
	 
	    public DatabaseHandler(Context context) {
	        super(context, DATABASE_NAME, null, DATABASE_VERSION);
	    }
	 
	    // Creating Tables
	    @Override
	    public void onCreate(SQLiteDatabase db) {
	        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
	                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
	                + KEY_PH_NO + " TEXT" + ")";
	        db.execSQL(CREATE_CONTACTS_TABLE);
	    }
	 
	    // Upgrading database
	    @Override
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	        // Drop older table if existed
	        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
	 
	        // Create tables again
	        onCreate(db);
	    }
	    
	    void addContact(String name, String phoneNumber) {
	        SQLiteDatabase db = this.getWritableDatabase();
	 
	        ContentValues values = new ContentValues();
	        values.put(KEY_NAME, name); // Contact Name
	        values.put(KEY_PH_NO, phoneNumber); // Contact Phone
	 
	        // Inserting Row
	        db.insert(TABLE_CONTACTS, null, values);
	        db.close(); // Closing database connection
	    }
	 String getContact(int id) {
	        SQLiteDatabase db = this.getReadableDatabase();
	 
	        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
	                KEY_NAME, KEY_PH_NO }, KEY_ID + "=?",
	                new String[] { String.valueOf(id) }, null, null, null, null);
	        if (cursor != null)
	            cursor.moveToFirst();
	 
	        String contact = (cursor.getString(0) + cursor.getString(1) + cursor.getString(2));
	        Log.d("bass",contact);
	        return contact;
	    }
	}
}
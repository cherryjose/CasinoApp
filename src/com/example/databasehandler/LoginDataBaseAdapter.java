package com.example.databasehandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;



public class LoginDataBaseAdapter 
{
	static final String DATABASE_NAME = "UserScore.db";
	static final int DATABASE_VERSION = 1;
	public static final int NAME_COLUMN = 1;
	// TODO: Create public field for each column in your table.
	// SQL Statement to create a new database.
	static final String DATABASE_CREATE = "create table "+"User"+"( " +"ID"+" integer primary key autoincrement,"+ "USERNAME text unique ,PASSWORD text, Overall_Score integer, UserPicture text); ";
	// Variable to hold the database instance
	public  SQLiteDatabase db;
	// Context of the application using the database.
	private final Context context;
	// Database open/upgrade helper
	private DataBaseHelper dbHelper;
	public static int overall_score;
	public  LoginDataBaseAdapter(Context _context) 
	{
		context = _context;
		dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	public  LoginDataBaseAdapter open() throws SQLException 
	{
		db = dbHelper.getWritableDatabase();
		return this;
	}
	public void close() 
	{
		db.close();
	}
	public  SQLiteDatabase getDatabaseInstance()
	{
		return db;
	}
	public void insertEntry(String userName,String password, int overall_score, String Image_Path)
	{
		this.overall_score = overall_score;
       ContentValues newValues = new ContentValues();
		// Assign values for each row.
		newValues.put("USERNAME", userName);
		newValues.put("PASSWORD",password);
		newValues.put("OVERALL_SCORE", this.overall_score);
		newValues.put("UserPicture", Image_Path);
		
		// Insert the row into your table
		db.insert("User", null, newValues);
		///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
	}
	public int deleteEntry(String UserName)
	{
		//String id=String.valueOf(ID);
	    String where="USERNAME=?";
	    int numberOFEntriesDeleted= db.delete("User", where, new String[]{UserName}) ;
       // Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
        return numberOFEntriesDeleted;
	}	
	public String getSingleEntry(String userName)
	{
		Cursor cursor=db.query("User", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
        	cursor.close();
        	return "NOT EXIST";
        }
	    cursor.moveToFirst();
		String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
		cursor.close();
		return password;				
	}
	
	public String getPath(String userName)
	{
		Cursor cursor=db.query("User", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
        	cursor.close();
        	return "NOT EXIST";
        }
	    cursor.moveToFirst();
		String path= cursor.getString(cursor.getColumnIndex("UserPicture"));
		cursor.close();
		return path;				
	}
	public void  updateEntry(String userName,int overall_score)
	{
		// Define the updated row content.
				ContentValues updatedValues = new ContentValues();
				// Assign values for each row.
				updatedValues.put("USERNAME", userName);
				updatedValues.put("Overall_Score",overall_score);

				
		        String where="USERNAME = ?";
			    db.update("User",updatedValues, where, new String[]{userName});			   
	}
	public String getoverallscore(String userName) {
		// TODO Auto-generated method stub
		Cursor cursor=db.query("User", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
        	cursor.close();
        	return "NOT EXIST";
        }
	    cursor.moveToFirst();
	    String overall_score= cursor.getString(cursor.getColumnIndex("PASSWORD"));
	    int overall= cursor.getInt(cursor.getColumnIndex("Overall_Score"));
		String over=Integer.toString(overall);
		cursor.close();
		return over;
	}		
}


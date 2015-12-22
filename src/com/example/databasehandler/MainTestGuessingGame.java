package com.example.databasehandler;

import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MainTestGuessingGame {
	 
	MyActivity ma = new MyActivity();
	
	Context c = App.getContext();
	
	public void guess(String result, String fscore) {

		AlertDialog.Builder builder = new AlertDialog.Builder(c);
	  	builder.setMessage(result + fscore);
	    //Toast.makeText(c, "Would you want to play Guessing Game?", Toast.LENGTH_LONG).show();
	    builder.setNegativeButton("NO",new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int which) {
		((Activity) c).finish();
			}
	    });
	    
	    builder.setPositiveButton("YES",
	    new DialogInterface.OnClickListener() {
	    public void onClick(DialogInterface dialog,int which) 
	    {
	    	Random r = new Random();
	    	((MyActivity) c).score = 100;
	    	((MyActivity) c).chance = 10;
	    	((MyActivity) c).rand = r.nextInt(100 - 0) + 1;
	    	((MyActivity) c).i = 0;
	    	((MyActivity) c).onCreate(new Bundle());  
	    	
	    	
	    }
	    });
	    builder.show();
	    
	}
}



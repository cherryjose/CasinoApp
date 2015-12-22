package com.example.databasehandler;

import android.app.Application;
import android.content.Context;
import android.speech.tts.TextToSpeech.OnInitListener;


public class App extends Application implements OnInitListener {

    private static Context mContext;
	

    public static Context getContext() {
        return mContext;
    }

	   public static void setContext(Context context) {
	        mContext = context;
	    }

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		
	}

 

	
}

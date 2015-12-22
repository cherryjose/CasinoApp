package com.example.databasehandler;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

public class ViewResult extends Activity{
	String username=null;
	Context c = App.getContext();
	LoginDataBaseAdapter loginDataBaseAdapter;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_result);
		username = getIntent().getExtras().getString("UserInfo");
		loginDataBaseAdapter=new LoginDataBaseAdapter(this);
		loginDataBaseAdapter=loginDataBaseAdapter.open();
		String overallscore=loginDataBaseAdapter.getoverallscore(username);
		//Toast.makeText(ViewResult.this, overallscore, Toast.LENGTH_LONG).show();
		TextView t=(TextView)findViewById(R.id.textView2);
		t.setText(overallscore);
	}

}
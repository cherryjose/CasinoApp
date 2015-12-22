package com.example.databasehandler;

import com.example.databasehandler.R;

import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class AllGames extends Activity {
String username=null;
ImageView imageView;
Context c = App.getContext();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_all_games);
		username = getIntent().getExtras().getString("UserInfo");
		
		ImageView btnPlay = (ImageView)findViewById(R.id.imageView5);
        imageView = (ImageView) findViewById(R.id.imageView6);
		
		String fetchingPath = ((MainActivity) c).pathName;
		//Toast.makeText(AllGames.this, fetchingPath, Toast.LENGTH_LONG).show();
		
		imageView.setImageDrawable(Drawable.createFromPath(fetchingPath));
		//String path=LoginDataBaseAdapter.getPath(userName);
		
		//ImageView imageView = (ImageView) findViewById(R.id.image_view);
		//imageView.setImageDrawable(Drawable.createFromPath(path));
		
		btnPlay.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(AllGames.this, PlayMusic.class);
			    startActivity(intent);
			}
		});
		
		ImageView tictactoe = (ImageView)findViewById(R.id.imageView3);
		tictactoe.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(AllGames.this, NormalActivity.class);
				intent.putExtra("UserInfo", username);
			    startActivity(intent);
			}
		});
		ImageView guessing = (ImageView)findViewById(R.id.imageView4);
		guessing.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(AllGames.this, MyActivity.class);
				intent.putExtra("UserInfo", username);
			    startActivity(intent);
			}
		});
		ImageView score = (ImageView)findViewById(R.id.imageView2);
		score.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(AllGames.this, ViewResult.class);
				intent.putExtra("UserInfo", username);
			    startActivity(intent);
			}
		});
		
		}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.all_games, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

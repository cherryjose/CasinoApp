package com.example.databasehandler;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController.MediaPlayerControl;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class PlayMusic extends Activity implements MediaPlayerControl {
   private Button b1,b2,b3,b4;
   private ImageView iv;
   private MediaPlayer mediaPlayer;
   private double startTime = 0;
   private double finalTime = 0;
   private Handler myHandler = new Handler();;
   private int forwardTime = 5000;
   private int backwardTime = 5000;
   private SeekBar seekbar;
   private TextView tx1,tx2,tx3;
   
   private ListView mainList;
   private final String[] listContent = { "Bollywood Song", "Hollywood Song", "English Song"};
   private final int[] resID = { R.raw.song, R.raw.kk, R.raw.hh };
   
   public static int oneTimeOnly = 0;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_play_music);
      
   // Initializing variables
 		mediaPlayer = new MediaPlayer();
 		mainList = (ListView) findViewById(R.id.listView1);
 		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listContent);
 		mainList.setAdapter(adapter);
      
 		mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() 
 		{
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) 
			{		
				playSong(position);
			}
 		 });
      b1 = (Button) findViewById(R.id.button);
      b2 = (Button) findViewById(R.id.button2);
      b3=(Button)findViewById(R.id.button3);
      b4=(Button)findViewById(R.id.button4);
      iv=(ImageView)findViewById(R.id.imageView);
      
      tx1=(TextView)findViewById(R.id.textView2);
      tx2=(TextView)findViewById(R.id.textView3);
      tx3=(TextView)findViewById(R.id.textView4);
      	
      seekbar=(SeekBar)findViewById(R.id.seekBar);
      seekbar.setClickable(false);
      b2.setEnabled(false);
      
      b3.setOnClickListener(new View.OnClickListener() {
	         @Override
	         public void onClick(View v) {
	            Toast.makeText(getApplicationContext(), "Playing sound",Toast.LENGTH_SHORT).show();
	            mediaPlayer.setLooping(true);
	            mediaPlayer.start();
	            
	            finalTime = mediaPlayer.getDuration();
	            startTime = mediaPlayer.getCurrentPosition();
	            
	            if (oneTimeOnly == 0) {
	               seekbar.setMax((int) finalTime);
	               oneTimeOnly = 1;
	            }
	            tx2.setText(String.format("%d ms",
	            TimeUnit.MILLISECONDS.toMicros((long) finalTime),
	            TimeUnit.MILLISECONDS.toMicros((long) finalTime) -
	            TimeUnit.MILLISECONDS.toMicros(TimeUnit.MILLISECONDS.toMicros((long) finalTime)))
	            );
	            
	            tx1.setText(String.format("%d ms",
	            TimeUnit.MILLISECONDS.toMicros((long) startTime),
	            TimeUnit.MILLISECONDS.toMicros((long) startTime) -
	            TimeUnit.MILLISECONDS.toMicros(TimeUnit.MILLISECONDS.toMicros((long) startTime)))
	            );
	            
	            seekbar.setProgress((int)startTime);
	            myHandler.postDelayed(UpdateSongTime,100);
	            b2.setEnabled(true);
	            b3.setEnabled(false);
	         }
	      });
      b2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "Pausing sound",Toast.LENGTH_SHORT).show();
            mediaPlayer.pause();
            b2.setEnabled(false);
            b3.setEnabled(true);
         }
      });
      
      b1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            int temp = (int)startTime;
            
            if((temp+forwardTime)<=finalTime){
               startTime = startTime + forwardTime;
               mediaPlayer.seekTo((int) startTime);
               Toast.makeText(getApplicationContext(),"You have jumped forward 5 microseconds.",Toast.LENGTH_SHORT).show();
            }
            else{
               Toast.makeText(getApplicationContext(),"Cannot jump forward 5 microseconds",Toast.LENGTH_SHORT).show();
            }
         }
      });
      
      b4.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            int temp = (int)startTime;
            
            if((temp-backwardTime)>0){
               startTime = startTime - backwardTime;
               mediaPlayer.seekTo((int) startTime);
               Toast.makeText(getApplicationContext(),"You have jumped backward 5 microseconds.",Toast.LENGTH_SHORT).show();
            }
            else{
               Toast.makeText(getApplicationContext(),"Cannot jump backward 5 microseconds.",Toast.LENGTH_SHORT).show();
            }
         }
      });
   }
   
   public void playSong(int songIndex) {
		// Play song
		mediaPlayer.reset();// stops any current playing song
		mediaPlayer = MediaPlayer.create(getApplicationContext(), resID[songIndex]);// create's new media player
		 mediaPlayer.start(); // starting mediaplayer
		
	            Toast.makeText(getApplicationContext(), "Playing sound",Toast.LENGTH_SHORT).show();
	            mediaPlayer.start();
	          
	            finalTime = mediaPlayer.getDuration();
	            startTime = mediaPlayer.getCurrentPosition();
	            
	            if (oneTimeOnly == 0) {
	               seekbar.setMax((int) finalTime);
	               oneTimeOnly = 1;
	            }
	            tx2.setText(String.format("%d ms",
	            TimeUnit.MILLISECONDS.toMicros((long) finalTime),
	            TimeUnit.MILLISECONDS.toMicros((long) finalTime) -
	            TimeUnit.MILLISECONDS.toMicros(TimeUnit.MILLISECONDS.toMicros((long) finalTime)))
	            );
	            
	            tx1.setText(String.format("%d ms",
	            TimeUnit.MILLISECONDS.toMicros((long) startTime),
	            TimeUnit.MILLISECONDS.toMicros((long) startTime) -
	            TimeUnit.MILLISECONDS.toMicros(TimeUnit.MILLISECONDS.toMicros((long) startTime)))
	            );
	            
	            seekbar.setProgress((int)startTime);
	            myHandler.postDelayed(UpdateSongTime,100);
	            b2.setEnabled(true);
	            b3.setEnabled(false);
	         }

   private Runnable UpdateSongTime = new Runnable() {
      public void run() {
         startTime = mediaPlayer.getCurrentPosition();
         tx1.setText(String.format("%d ms",
         
         TimeUnit.MILLISECONDS.toMicros((long) startTime),
         TimeUnit.MILLISECONDS.toMicros((long) startTime) -
         TimeUnit.MILLISECONDS.toMicros(TimeUnit.MICROSECONDS.toMinutes((long) startTime)))
         );
         seekbar.setProgress((int)startTime);
         myHandler.postDelayed(this, 100);
      }
   };
   
  /* @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.menu_main, menu);
      return true;
   }*/
   
   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      // Handle action bar item clicks here. The action bar will
      // automatically handle clicks on the Home/Up button, so long
      // as you specify a parent activity in AndroidManifest.xml.
      
      int id = item.getItemId();
      
      //noinspection SimplifiableIfStatement
      
      if (id == R.id.action_settings) {
         return true;
      }
      return super.onOptionsItemSelected(item);
   }
   
@Override
public void start() {
	// TODO Auto-generated method stub
	
}

@Override
public void pause() {
	// TODO Auto-generated method stub
	
}

@Override
public int getDuration() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int getCurrentPosition() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public void seekTo(int pos) {
	// TODO Auto-generated method stub
	
}

@Override
public boolean isPlaying() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public int getBufferPercentage() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public boolean canPause() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean canSeekBackward() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean canSeekForward() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public int getAudioSessionId() {
	// TODO Auto-generated method stub
	return 0;
}
}
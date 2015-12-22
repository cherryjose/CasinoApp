package com.example.databasehandler;

import android.content.Context;

import android.media.AudioManager;
import android.media.ToneGenerator;
import android.widget.EditText;
import android.widget.Toast;

public class GuessingGame 
{

	int valinta2;
	Context c = App.getContext();
	int answer = ((MyActivity) c).rand;
	int overall_score=0;
	LoginDataBaseAdapter loginDataBaseAdapter;
	MyActivity ma = new MyActivity();
	String user=ma.username;
	public void execute(int value, String userID)
	{
		 //EditText mEdit = a;
		 //EditText mEdit3 = cc;
		 	
			if (((MyActivity) c).chance != 1) 
			{
				if (value == ((MyActivity) c).rand) 
				{
					//((MyActivity) c).stopp(null);
					
					((MyActivity) c).score = ((MyActivity) c).score;
					((MyActivity) c).chance = ((MyActivity) c).chance;
					
					//mEdit3.setText(String.valueOf(((MyActivity) c).score));
					//mEdit4.setText(String.valueOf(((MyActivity) c).chance));

					ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
					toneG.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 200);
					loginDataBaseAdapter=new LoginDataBaseAdapter(this.c);
					loginDataBaseAdapter=loginDataBaseAdapter.open();
					String tests=userID; 
					String overall=loginDataBaseAdapter.getoverallscore(userID);
					int result=Integer.parseInt(overall)+1;
					loginDataBaseAdapter.updateEntry(tests, result);
					
					MainTestGuessingGame mt = new MainTestGuessingGame();
					mt.guess("Congratulations! You won! Press yes to play again or no to quit. Your score is - ",String.valueOf(((MyActivity) c).score ));
				} 
				else
				{
					((MyActivity) c).score = ((MyActivity) c).score - 10;
					((MyActivity) c).chance = ((MyActivity) c).chance - 1;
								
					/*if (value < ((MyActivity) c).rand)
					{
						Toast.makeText(c,"The number you entered is less than the number chosen by the program",Toast.LENGTH_LONG).show();			
					}
					else 
					{
						Toast.makeText(c,"The number you entered is greater than the number chosen by the program",Toast.LENGTH_LONG).show();
					} */ 
					//mEdit3.setText(String.valueOf(((MyActivity) c).score));
					//mEdit4.setText(String.valueOf(((MyActivity) c).chance));
				}
			}
			else 
			{
				//mEdit3.setText(String.valueOf(((MyActivity) c).score-10));
				//mEdit4.setText(String.valueOf(((MyActivity) c).chance-1));
				//((MyActivity) c).stopp(null);
				MainTestGuessingGame mt = new MainTestGuessingGame();
				mt.guess("You lost! Number chosen by the game was " +answer+" Press Yes to play again or No to quit","");	
			}		 
	}
}

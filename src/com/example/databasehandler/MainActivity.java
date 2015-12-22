package com.example.databasehandler;

import com.example.databasehandler.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	Button btnSignIn,btnSignUp;
	LoginDataBaseAdapter loginDataBaseAdapter;
	public String pathName;
	//Context c = App.getContext();
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.setContext(this);
        
         // create a instance of SQLite Database
	     loginDataBaseAdapter=new LoginDataBaseAdapter(this);
	     loginDataBaseAdapter=loginDataBaseAdapter.open();
	     
	     // Get The Refference Of Buttons
	     btnSignIn=(Button)findViewById(R.id.buttonSignIN);
	     btnSignUp=(Button)findViewById(R.id.buttonSignUP);
			
	    // Set OnClick Listener on SignUp button 
	    btnSignUp.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			
			/// Create Intent for SignUpActivity  and Start The Activity
			Intent intentSignUP=new Intent(getApplicationContext(),RegisterationActivity.class);
			startActivity(intentSignUP);
			}
		});
 //   }
 // Methods to handleClick Event of Sign In Button
    // 	public void signIn(View V)
 	   //{
// 			setContentView(R.layout.activity_main);
 	
 		    // get the Refferences of views
 		    final  EditText editTextUserName=(EditText)findViewById(R.id.editTextUserNameToLogin);
 		    final  EditText editTextPassword=(EditText)findViewById(R.id.editTextPasswordToLogin);
 		    
 			Button btnSignIn=(Button)findViewById(R.id.buttonSignIN);
 				
 			// Set On ClickListener
 			btnSignIn.setOnClickListener(new View.OnClickListener() {
 				
 				public void onClick(View v) {
 					// get The User name and Password
 					String userName=editTextUserName.getText().toString();
 					String password=editTextPassword.getText().toString();
 					
 					// fetch the Password form database for respective user name
 					String storedPassword=loginDataBaseAdapter.getSingleEntry(userName);
 					String path=loginDataBaseAdapter.getPath(userName);			 
					pathName = path;	
 					
 					// check if the Stored password matches with  Password entered by user
 					if(password.equals(storedPassword))
 					{
 						//Toast.makeText(MainActivity.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
 						Intent intent = new Intent(getApplicationContext(),AllGames.class);
 						intent.putExtra("UserInfo", userName);
 						startActivity(intent);
 					}
 					else
 					{
 						Toast.makeText(MainActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
 						Intent intent=new Intent(getApplicationContext(),MainActivity.class);
 						startActivity(intent);
 					}
 				}
 			});
 	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    @Override
	protected void onDestroy() {
		super.onDestroy();
	    // Close The Database
		loginDataBaseAdapter.close();
	}
}

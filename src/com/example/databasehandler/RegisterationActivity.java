package com.example.databasehandler;

import java.io.File;

import com.example.databasehandler.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class RegisterationActivity  extends Activity
{
	EditText editTextUserName,editTextPassword,editTextConfirmPassword;
	Button btnCreateAccount;
	LoginDataBaseAdapter loginDataBaseAdapter;
	
	Button button;
	ImageView imageView;
	static final int CAM_REQUEST=1;
	Long time = System.currentTimeMillis();
	Long finalTime = time;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		
		button=(Button) findViewById(R.id.button);
        imageView=(ImageView) findViewById(R.id.image_view);
        button.setOnClickListener(new View.OnClickListener() 
        {
        	@Override
			public void onClick(View v) 
			{
				Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				File file = getFile();
				camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
				startActivityForResult(camera_intent, CAM_REQUEST);
			}
		});
		
		// get Instance  of Database Adapter
		loginDataBaseAdapter=new LoginDataBaseAdapter(this);
		loginDataBaseAdapter=loginDataBaseAdapter.open();
		
		// Get Refferences of Views
		editTextUserName=(EditText)findViewById(R.id.editTextUserName);
		editTextPassword=(EditText)findViewById(R.id.editTextPassword);
		editTextConfirmPassword=(EditText)findViewById(R.id.editTextConfirmPassword);
		
		btnCreateAccount=(Button)findViewById(R.id.buttonCreateAccount);
		btnCreateAccount.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			String userName=editTextUserName.getText().toString();
			String password=editTextPassword.getText().toString();
			int overall_score = 0;
			String path = "/sdcard/camera_app/"+finalTime +".png";
			String confirmPassword=editTextConfirmPassword.getText().toString();
			
			// check if any of the fields are vaccant
			if(userName.equals("")||password.equals("")||confirmPassword.equals(""))
			{
					Toast.makeText(getApplicationContext(), "Please enter credentials to register.", Toast.LENGTH_LONG).show();
					return;
			}
			// check if both password matches
			if(!password.equals(confirmPassword))
			{
				Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
				return;
			}
			else
			{
			    // Save the Data in Database
			    loginDataBaseAdapter.insertEntry(userName, password, overall_score, path);
			    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_SHORT).show();
			    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
				startActivity(intent);
			}
		}
	});
}
	private File getFile()
    {
    	File folder = new File("/sdcard/camera_app");
    	
    	if(!folder.exists())
    	{
    		folder.mkdir();
    	}
    	//File image_file = new File(folder,"cam_image.jpg");
    	File image_file = new File(folder,time + ".png");
    	return image_file;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) 
    {
    	//String path = "/sdcard/camera_app/cam_image.jpg";
    	String path = "/sdcard/camera_app/"+finalTime +".png";
    	
    	imageView.setImageDrawable(Drawable.createFromPath(path));
    }
    	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		loginDataBaseAdapter.close();
	}
}

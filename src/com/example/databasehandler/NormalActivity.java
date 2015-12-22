package com.example.databasehandler;

import android.os.Bundle;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class NormalActivity extends Activity {
	 Button btn00,btn01,btn02,btn10,btn11,btn12,btn20,btn21,btn22;
	 LoginDataBaseAdapter loginDataBaseAdapter;
	 String username=null;
     AlertDialog.Builder alert,error;

     TextView playerLbl,header;

@Override

public void onCreate(Bundle savedInstanceState) {

   super.onCreate(savedInstanceState);

   setContentView(R.layout.activity_normal);
	username = getIntent().getExtras().getString("UserInfo");
   setClickEvent();

     }

public void setClickEvent()

{

     btn00=(Button)findViewById(R.id.btn00);

     btn01=(Button)findViewById(R.id.btn01);

     btn02=(Button)findViewById(R.id.btn02);

     btn10=(Button)findViewById(R.id.btn10);

     btn11=(Button)findViewById(R.id.btn11);

  btn12=(Button)findViewById(R.id.btn12);

     btn20=(Button)findViewById(R.id.btn20);

     btn21=(Button)findViewById(R.id.btn21);

     btn22=(Button)findViewById(R.id.btn22);

     btn00.setOnClickListener(new Clicker());

     btn01.setOnClickListener(new Clicker());

     btn02.setOnClickListener(new Clicker());

     btn10.setOnClickListener(new Clicker());

     btn11.setOnClickListener(new Clicker());

     btn12.setOnClickListener(new Clicker());

     btn20.setOnClickListener(new Clicker());       

     btn21.setOnClickListener(new Clicker());

     btn22.setOnClickListener(new Clicker());

  }

public void resetButton()

 {

            btn00.setText("");

            btn01.setText("");

            btn02.setText("");

            btn10.setText("");

            btn11.setText("");

            btn12.setText("");

            btn20.setText("");

            btn21.setText("");

            btn22.setText("");

            playerLbl.setText("Player1");

           /* header=(TextView)findViewById(R.id.header);

            header.setText("Tic Tac Toe : New Game");*/

}

public void createDialog()

{

     alert=new AlertDialog.Builder(this);

     alert.setTitle("Winner");

     alert.setPositiveButton("OK",new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

                   // TODO Auto-generated method stub

                          resetButton();

                   }

            });

     error=new AlertDialog.Builder(this);

     error.setTitle("Error");

     error.setMessage("This cell is occupied");

     error.setPositiveButton("OK",new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {                             // TODO Auto-generated method stub

                   }

            });

}

public boolean determineWinner()

{

     createDialog();

     if(btn00.getText().toString().equals("X")&&

btn01.getText().toString().equals("X") && btn02.getText().toString().equals("X"))

     {
    	 	result();
            alert.setMessage("Winner is : Player1");

            alert.show();

            return true;

     }

if(btn00.getText().toString().equals("X") && btn10.getText().toString().equals("X") && btn20.getText().toString().equals("X"))

     {
	result();
            alert.setMessage("Winner is : Player1");

            alert.show();

            return true;

     }

if(btn10.getText().toString().equals("X") && btn11.getText().toString().equals("X") && btn12.getText().toString().equals("X"))

     {
	result();
            alert.setMessage("Winner is : Player1");

            alert.show();

            return true;

     }

if(btn20.getText().toString().equals("X") && btn21.getText().toString().equals("X") && btn22.getText().toString().equals("X"))

     {
	result();
            alert.setMessage("Winner is : Player1");

            alert.show();

            return true;

     }

if(btn01.getText().toString().equals("X") && btn11.getText().toString().equals("X") && btn21.getText().toString().equals("X"))

     {
	result();
            alert.setMessage("Winner is : Player1");

            alert.show();

            return true;

     }

if(btn02.getText().toString().equals("X") && btn12.getText().toString().equals("X") && btn22.getText().toString().equals("X"))

     {
	result();
            alert.setMessage("Winner is : Player1");

            alert.show();

            return true;

     }

if(btn00.getText().toString().equals("X") && btn11.getText().toString().equals("X") && btn22.getText().toString().equals("X"))

     {
	result();
            alert.setMessage("Winner is : Player1");

            alert.show();

            return true;

     }

if(btn02.getText().toString().equals("X") && btn11.getText().toString().equals("X") && btn20.getText().toString().equals("X"))

     {
	result();
            alert.setMessage("Winner is : Player1");

            alert.show();

            return true;

     }

if(btn00.getText().toString().equals("0") && btn01.getText().toString().equals("0") && btn02.getText().toString().equals("0"))

     {

            alert.setMessage("Winner is : Player2");

            alert.show();

            return true;

     }

if(btn10.getText().toString().equals("0") && btn11.getText().toString().equals("0") && btn12.getText().toString().equals("0"))

     {

            alert.setMessage("Winner is : Player2");

            alert.show();

            return true;

     }

if(btn20.getText().toString().equals("0") && btn21.getText().toString().equals("0") && btn22.getText().toString().equals("0"))

     {
            alert.setMessage("Winner is : Player2");

            alert.show();

         return true;

  }

if(btn00.getText().toString().equals("0") && btn10.getText().toString().equals("0") && btn20.getText().toString().equals("0"))

  {

         alert.setMessage("Winner is : Player2");

         alert.show();

         return true;

  }

if(btn01.getText().toString().equals("0") && btn11.getText().toString().equals("0") && btn21.getText().toString().equals("0"))

  {

         alert.setMessage("Winner is : Player2");

         alert.show();

         return true;

  }

if(btn02.getText().toString().equals("0") && btn12.getText().toString().equals("0") && btn22.getText().toString().equals("0"))

  {

         alert.setMessage("Winner is : Player2");

         alert.show();

         return true;

  }

if(btn00.getText().toString().equals("0") && btn11.getText().toString().equals("0") && btn22.getText().toString().equals("0"))

  {

         alert.setMessage("Winner is : Player2");

         alert.show();

         return true;

  }

if(btn02.getText().toString().equals("0") && btn11.getText().toString().equals("0") && btn20.getText().toString().equals("0"))

  {

         alert.setMessage("Winner is : Player2");

         alert.show();

         return true;

  }

  return false;

}
public void result()
{
	loginDataBaseAdapter=new LoginDataBaseAdapter(this);
	loginDataBaseAdapter=loginDataBaseAdapter.open();
	String tests=username; 
	String overall=loginDataBaseAdapter.getoverallscore(username);
	int result=Integer.parseInt(overall)+1;
	loginDataBaseAdapter.updateEntry(tests, result);
	}

public void checkAgain()

{

  boolean flag;

  if(!btn00.getText().toString().equals("") && !btn01.getText().toString().equals("") && !btn02.getText().toString().equals("") && !btn10.getText().toString().equals("") && !btn11.getText().toString().equals("") && !btn12.getText().toString().equals("") && !btn20.getText().toString().equals("") && !btn21.getText().toString().equals("") && !btn22.getText().toString().equals(""))

  {

         flag=determineWinner();

         if(!flag)

         {

                alert.setMessage("No One Won,GAME OVER !!!!! ");

                alert.show();

         }   


  }

}

public class Clicker implements android.view.View.OnClickListener

{

  boolean flag;

  public void onClick(View v)

  {

         playerLbl=(TextView)findViewById(R.id.playerLbl);

         String lbl=playerLbl.getText().toString();

         Button btn=(Button)v;

         if(btn.getText().toString().equals(""))

         {

                if(lbl.equals("Player1"))

                {

                      btn.setText("X");

                      playerLbl.setText("Player2");

                }

                else

                {

                      btn.setText("0");

                      playerLbl.setText("Player1");

                }

         }

         else

         {

                error.show();

         }

         flag=determineWinner();

         if(!flag)

         {

                checkAgain();

         }            

  }

}

}
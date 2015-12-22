package com.example.databasehandler;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;


public class MyActivity extends Activity 
{
	String username;
	int score = 100;
	int chance = 10;
	Random r = new Random();
	int rand = r.nextInt(100 - 0) + 1;
	Context c = App.getContext();
	int i=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);
		
		username = getIntent().getExtras().getString("UserInfo");
		App.setContext(this);
	}

	public void onClick(View V)
	{
		Button b = (Button)V;
		String buttontext = b.getText().toString();
		int value=Integer.valueOf(buttontext);
		
		if(value < rand)
		{
			b.setBackgroundColor(Color.YELLOW);
			Bitmap bg=Bitmap.createBitmap(480,800,Bitmap.Config.ARGB_8888);
			Canvas can =new Canvas(bg);
			Paint paint = new Paint();
			paint.setColor(Color.BLACK);
			Paint paint2 = new Paint();
			paint2.setColor(Color.YELLOW);
			Paint paint1 = new Paint();
			paint1.setColor(Color.BLUE);
			paint1.setStyle(Paint.Style.STROKE);
			paint1.setStrokeWidth(2);
			if(i==0)
			{
				i=i+1;
				can.drawCircle(105, 57, 30, paint);
			}
			else if(i==1)
			{
				i=i+1;
				//Head Code
				can.drawCircle(105, 57, 30, paint);
				//Code for two eyes
				RectF eye1 = new RectF(85, 45,95, 50);
				can.drawOval(eye1, paint2);		
				RectF eye2 = new RectF(115, 45,125, 50);
				can.drawOval(eye2, paint2);
			}
			else if(i==2)
			{
				i=i+1;
				//Head Code
				can.drawCircle(105, 57, 30, paint);
				//Code for two eyes
				RectF eye1 = new RectF(85, 45,95, 50);
				can.drawOval(eye1, paint2);		
				RectF eye2 = new RectF(115, 45,125, 50);
				can.drawOval(eye2, paint2);
				//Code for Mouth
				RectF mouth = new RectF(95, 65,115, 75);
				can.drawOval(mouth, paint2);
			}
			else if(i==3)
			{
				i=i+1;
				//Head Code
				can.drawCircle(105, 57, 30, paint);
				//Code for two eyes
				RectF eye1 = new RectF(85, 45,95, 50);
				can.drawOval(eye1, paint2);		
				RectF eye2 = new RectF(115, 45,125, 50);
				can.drawOval(eye2, paint2);
				//Code for Mouth
				RectF mouth = new RectF(95, 65,115, 75);
				can.drawOval(mouth, paint2);
				//Code for ears
				RectF ear1 = new RectF(70, 45,75, 65);
				can.drawOval(ear1, paint1);
				RectF ear2 = new RectF(135, 45,140, 65);
				can.drawOval(ear2, paint1);
			}
			else if(i==4)
			{
				i=i+1;
				//Head Code
				can.drawCircle(105, 57, 30, paint);
				//Code for two eyes
				RectF eye1 = new RectF(85, 45,95, 50);
				can.drawOval(eye1, paint2);		
				RectF eye2 = new RectF(115, 45,125, 50);
				can.drawOval(eye2, paint2);
				//Code for Mouth
				RectF mouth = new RectF(95, 65,115, 75);
				can.drawOval(mouth, paint2);
				//Code for ears
				RectF ear1 = new RectF(70, 45,75, 65);
				can.drawOval(ear1, paint1);
				RectF ear2 = new RectF(135, 45,140, 65);
				can.drawOval(ear2, paint1);
				//Code for Neck
				can.drawRect(100, 80, 110, 100, paint);
			}
			else if(i==5)
			{
				i=i+1;
				//Head Code
				can.drawCircle(105, 57, 30, paint);
				//Code for two eyes
				RectF eye1 = new RectF(85, 45,95, 50);
				can.drawOval(eye1, paint2);		
				RectF eye2 = new RectF(115, 45,125, 50);
				can.drawOval(eye2, paint2);
				//Code for Mouth
				RectF mouth = new RectF(95, 65,115, 75);
				can.drawOval(mouth, paint2);
				//Code for ears
				RectF ear1 = new RectF(70, 45,75, 65);
				can.drawOval(ear1, paint1);
				RectF ear2 = new RectF(135, 45,140, 65);
				can.drawOval(ear2, paint1);
				//Code for Neck
				can.drawRect(100, 80, 110, 100, paint);
				//Code for Chest
				can.drawRect(90,100,120,200, paint);
			}
			else if(i==6)
			{
				i=i+1;
				//Head Code
				can.drawCircle(105, 57, 30, paint);
				//Code for two eyes
				RectF eye1 = new RectF(85, 45,95, 50);
				can.drawOval(eye1, paint2);		
				RectF eye2 = new RectF(115, 45,125, 50);
				can.drawOval(eye2, paint2);
				//Code for Mouth
				RectF mouth = new RectF(95, 65,115, 75);
				can.drawOval(mouth, paint2);
				//Code for ears
				RectF ear1 = new RectF(70, 45,75, 65);
				can.drawOval(ear1, paint1);
				RectF ear2 = new RectF(135, 45,140, 65);
				can.drawOval(ear2, paint1);
				//Code for Neck
				can.drawRect(100, 80, 110, 100, paint);
				//Code for Chest
				can.drawRect(90,100,120,200, paint);
				//Code for arms
				Path p = new Path();
			    p.moveTo(90, 100);
			    p.lineTo(50, 135);
			    p.lineTo(55, 135);
			    p.lineTo(90, 105);
			    can.drawPath(p, paint);
			    
			    Path p1 = new Path();
			    p1.moveTo(120, 100);
			    p1.lineTo(160, 135);
			    p1.lineTo(155, 135);
			    p1.lineTo(120, 105);
			    can.drawPath(p1, paint);
			}
			else if(i==7)
			{
				i=i+1;
				//Head Code
				can.drawCircle(105, 57, 30, paint);
				//Code for two eyes
				RectF eye1 = new RectF(85, 45,95, 50);
				can.drawOval(eye1, paint2);		
				RectF eye2 = new RectF(115, 45,125, 50);
				can.drawOval(eye2, paint2);
				//Code for Mouth
				RectF mouth = new RectF(95, 65,115, 75);
				can.drawOval(mouth, paint2);
				//Code for ears
				RectF ear1 = new RectF(70, 45,75, 65);
				can.drawOval(ear1, paint1);
				RectF ear2 = new RectF(135, 45,140, 65);
				can.drawOval(ear2, paint1);
				//Code for Neck
				can.drawRect(100, 80, 110, 100, paint);
				//Code for Chest
				can.drawRect(90,100,120,200, paint);
				//Code for arms
				Path p = new Path();
			    p.moveTo(90, 100);
			    p.lineTo(50, 135);
			    p.lineTo(55, 135);
			    p.lineTo(90, 105);
			    can.drawPath(p, paint);
			    
			    Path p1 = new Path();
			    p1.moveTo(120, 100);
			    p1.lineTo(160, 135);
			    p1.lineTo(155, 135);
			    p1.lineTo(120, 105);
			    can.drawPath(p1, paint);
				//Code for legs
				Path p2 = new Path();
			    p2.moveTo(90, 195);
			    p2.lineTo(50, 225);
			    p2.lineTo(55, 225);
			    p2.lineTo(90, 200);
			    can.drawPath(p2, paint);
			    
			    Path p3 = new Path();
			    p3.moveTo(120, 195);
			    p3.lineTo(160, 225);
			    p3.lineTo(155, 225);
			    p3.lineTo(120, 200);
			    can.drawPath(p3, paint);
			}
			else if(i==8)
			{
				i=i+1;
				//Head Code
				can.drawCircle(105, 57, 30, paint);
				//Code for two eyes
				RectF eye1 = new RectF(85, 45,95, 50);
				can.drawOval(eye1, paint2);		
				RectF eye2 = new RectF(115, 45,125, 50);
				can.drawOval(eye2, paint2);
				//Code for Mouth
				RectF mouth = new RectF(95, 65,115, 75);
				can.drawOval(mouth, paint2);
				//Code for ears
				RectF ear1 = new RectF(70, 45,75, 65);
				can.drawOval(ear1, paint1);
				RectF ear2 = new RectF(135, 45,140, 65);
				can.drawOval(ear2, paint1);
				//Code for Neck
				can.drawRect(100, 80, 110, 100, paint);
				//Code for Chest
				can.drawRect(90,100,120,200, paint);
				//Code for arms
				Path p = new Path();
			    p.moveTo(90, 100);
			    p.lineTo(50, 135);
			    p.lineTo(55, 135);
			    p.lineTo(90, 105);
			    can.drawPath(p, paint);
			    
			    Path p1 = new Path();
			    p1.moveTo(120, 100);
			    p1.lineTo(160, 135);
			    p1.lineTo(155, 135);
			    p1.lineTo(120, 105);
			    can.drawPath(p1, paint);
				//Code for legs
				Path p2 = new Path();
			    p2.moveTo(90, 195);
			    p2.lineTo(50, 225);
			    p2.lineTo(55, 225);
			    p2.lineTo(90, 200);
			    can.drawPath(p2, paint);
			    
			    Path p3 = new Path();
			    p3.moveTo(120, 195);
			    p3.lineTo(160, 225);
			    p3.lineTo(155, 225);
			    p3.lineTo(120, 200);
			    can.drawPath(p3, paint);
			    //Code for the Box
			    can.drawRect(30, 225, 180, 290, paint);
			    //Two Lines for rope
				can.drawLine(30, 10, 65, 89, paint1);
				can.drawLine(180, 10, 145, 89, paint1);
				
				//Code of Curve Rope
				RectF rectF = new RectF(65, 70, 145, 100);
				can.drawArc (rectF, 0, 180, false, paint1);
			}
			else
			{
				//Head Code
				can.drawCircle(105, 57, 30, paint);
				//Code for two eyes
				RectF eye1 = new RectF(85, 45,95, 50);
				can.drawOval(eye1, paint2);		
				RectF eye2 = new RectF(115, 45,125, 50);
				can.drawOval(eye2, paint2);
				//Code for Mouth
				RectF mouth = new RectF(95, 65,115, 75);
				can.drawOval(mouth, paint2);
				//Code for ears
				RectF ear1 = new RectF(70, 45,75, 65);
				can.drawOval(ear1, paint1);
				RectF ear2 = new RectF(135, 45,140, 65);
				can.drawOval(ear2, paint1);
				//Code for Neck
				can.drawRect(100, 80, 110, 100, paint);
				//Code for Chest
				can.drawRect(90,100,120,200, paint);
				//Code for arms
				Path p = new Path();
			    p.moveTo(90, 100);
			    p.lineTo(80, 100);
			    p.lineTo(80, 145);
			    p.lineTo(85, 145);
			    p.lineTo(85, 105);
			    p.lineTo(90, 105);
			    can.drawPath(p, paint);
			    
			    Path p1 = new Path();
			    p1.moveTo(120, 100);
			    p1.lineTo(130, 100);
			    p1.lineTo(130, 145);
			    p1.lineTo(125, 145);
			    p1.lineTo(125, 105);
			    p1.lineTo(120, 105);
			    can.drawPath(p1, paint);
				//Code for legs
				Path p2 = new Path();
			    p2.moveTo(90, 195);
			    p2.lineTo(80, 195);
			    p2.lineTo(80, 240);
			    p2.lineTo(85, 240);
			    p2.lineTo(85, 200);
			    p2.lineTo(90, 200);
			    can.drawPath(p2, paint);
			    
			    Path p3 = new Path();
			    p3.moveTo(120, 195);
			    p3.lineTo(130, 195);
			    p3.lineTo(130, 240);
			    p3.lineTo(125, 240);
			    p3.lineTo(125, 200);
			    p3.lineTo(120, 200);
			    can.drawPath(p3, paint);
			   
			    //Two Lines for rope
				can.drawLine(30, 10, 65, 89, paint1);
				can.drawLine(180, 10, 145, 89, paint1);
				
				//Code of Curve Rope
				RectF rectF = new RectF(65, 70, 145, 100);
				can.drawArc (rectF, 0, 180, false, paint1);
			}
			RelativeLayout l = (RelativeLayout) findViewById(R.id.activity_my);
			//LinearLayout l=(LinearLayout) findViewById(R.id.activity_main);
			l.setBackground(new BitmapDrawable(bg));
		}
		else if(value > rand)
		{
			b.setBackgroundColor(Color.RED);
			Bitmap bg=Bitmap.createBitmap(480,800,Bitmap.Config.ARGB_8888);
			Canvas can =new Canvas(bg);
			Paint paint = new Paint();
			paint.setColor(Color.BLACK);
			Paint paint1 = new Paint();
			paint1.setColor(Color.BLUE);
			paint1.setStyle(Paint.Style.STROKE);
			paint1.setStrokeWidth(2);
			Paint paint2 = new Paint();
			paint2.setColor(Color.YELLOW);
			if(i==0)
			{
				i=i+1;
				can.drawCircle(105, 57, 30, paint);
			}
			else if(i==1)
			{
				i=i+1;
				//Head Code
				can.drawCircle(105, 57, 30, paint);
				//Code for two eyes
				RectF eye1 = new RectF(85, 45,95, 50);
				can.drawOval(eye1, paint2);		
				RectF eye2 = new RectF(115, 45,125, 50);
				can.drawOval(eye2, paint2);
			}
			else if(i==2)
			{
				i=i+1;
				//Head Code
				can.drawCircle(105, 57, 30, paint);
				//Code for two eyes
				RectF eye1 = new RectF(85, 45,95, 50);
				can.drawOval(eye1, paint2);		
				RectF eye2 = new RectF(115, 45,125, 50);
				can.drawOval(eye2, paint2);
				//Code for Mouth
				RectF mouth = new RectF(95, 65,115, 75);
				can.drawOval(mouth, paint2);
			}
			else if(i==3)
			{
				i=i+1;
				//Head Code
				can.drawCircle(105, 57, 30, paint);
				//Code for two eyes
				RectF eye1 = new RectF(85, 45,95, 50);
				can.drawOval(eye1, paint2);		
				RectF eye2 = new RectF(115, 45,125, 50);
				can.drawOval(eye2, paint2);
				//Code for Mouth
				RectF mouth = new RectF(95, 65,115, 75);
				can.drawOval(mouth, paint2);
				//Code for ears
				RectF ear1 = new RectF(70, 45,75, 65);
				can.drawOval(ear1, paint1);
				RectF ear2 = new RectF(135, 45,140, 65);
				can.drawOval(ear2, paint1);
			}
			else if(i==4)
			{
				i=i+1;
				//Head Code
				can.drawCircle(105, 57, 30, paint);
				//Code for two eyes
				RectF eye1 = new RectF(85, 45,95, 50);
				can.drawOval(eye1, paint2);		
				RectF eye2 = new RectF(115, 45,125, 50);
				can.drawOval(eye2, paint2);
				//Code for Mouth
				RectF mouth = new RectF(95, 65,115, 75);
				can.drawOval(mouth, paint2);
				//Code for ears
				RectF ear1 = new RectF(70, 45,75, 65);
				can.drawOval(ear1, paint1);
				RectF ear2 = new RectF(135, 45,140, 65);
				can.drawOval(ear2, paint1);
				//Code for Neck
				can.drawRect(100, 80, 110, 100, paint);
			}
			else if(i==5)
			{
				i=i+1;
				//Head Code
				can.drawCircle(105, 57, 30, paint);
				//Code for two eyes
				RectF eye1 = new RectF(85, 45,95, 50);
				can.drawOval(eye1, paint2);		
				RectF eye2 = new RectF(115, 45,125, 50);
				can.drawOval(eye2, paint2);
				//Code for Mouth
				RectF mouth = new RectF(95, 65,115, 75);
				can.drawOval(mouth, paint2);
				//Code for ears
				RectF ear1 = new RectF(70, 45,75, 65);
				can.drawOval(ear1, paint1);
				RectF ear2 = new RectF(135, 45,140, 65);
				can.drawOval(ear2, paint1);
				//Code for Neck
				can.drawRect(100, 80, 110, 100, paint);
				//Code for Chest
				can.drawRect(90,100,120,200, paint);
			}
			else if(i==6)
			{
				i=i+1;
				//Head Code
				can.drawCircle(105, 57, 30, paint);
				//Code for two eyes
				RectF eye1 = new RectF(85, 45,95, 50);
				can.drawOval(eye1, paint2);		
				RectF eye2 = new RectF(115, 45,125, 50);
				can.drawOval(eye2, paint2);
				//Code for Mouth
				RectF mouth = new RectF(95, 65,115, 75);
				can.drawOval(mouth, paint2);
				//Code for ears
				RectF ear1 = new RectF(70, 45,75, 65);
				can.drawOval(ear1, paint1);
				RectF ear2 = new RectF(135, 45,140, 65);
				can.drawOval(ear2, paint1);
				//Code for Neck
				can.drawRect(100, 80, 110, 100, paint);
				//Code for Chest
				can.drawRect(90,100,120,200, paint);
				//Code for arms
				Path p = new Path();
			    p.moveTo(90, 100);
			    p.lineTo(50, 135);
			    p.lineTo(55, 135);
			    p.lineTo(90, 105);
			    can.drawPath(p, paint);
			    
			    Path p1 = new Path();
			    p1.moveTo(120, 100);
			    p1.lineTo(160, 135);
			    p1.lineTo(155, 135);
			    p1.lineTo(120, 105);
			    can.drawPath(p1, paint);
			}
			else if(i==7)
			{
				i=i+1;
				//Head Code
				can.drawCircle(105, 57, 30, paint);
				//Code for two eyes
				RectF eye1 = new RectF(85, 45,95, 50);
				can.drawOval(eye1, paint2);		
				RectF eye2 = new RectF(115, 45,125, 50);
				can.drawOval(eye2, paint2);
				//Code for Mouth
				RectF mouth = new RectF(95, 65,115, 75);
				can.drawOval(mouth, paint2);
				//Code for ears
				RectF ear1 = new RectF(70, 45,75, 65);
				can.drawOval(ear1, paint1);
				RectF ear2 = new RectF(135, 45,140, 65);
				can.drawOval(ear2, paint1);
				//Code for Neck
				can.drawRect(100, 80, 110, 100, paint);
				//Code for Chest
				can.drawRect(90,100,120,200, paint);
				//Code for arms
				Path p = new Path();
			    p.moveTo(90, 100);
			    p.lineTo(50, 135);
			    p.lineTo(55, 135);
			    p.lineTo(90, 105);
			    can.drawPath(p, paint);
			    
			    Path p1 = new Path();
			    p1.moveTo(120, 100);
			    p1.lineTo(160, 135);
			    p1.lineTo(155, 135);
			    p1.lineTo(120, 105);
			    can.drawPath(p1, paint);
				//Code for legs
				Path p2 = new Path();
			    p2.moveTo(90, 195);
			    p2.lineTo(50, 225);
			    p2.lineTo(55, 225);
			    p2.lineTo(90, 200);
			    can.drawPath(p2, paint);
			    
			    Path p3 = new Path();
			    p3.moveTo(120, 195);
			    p3.lineTo(160, 225);
			    p3.lineTo(155, 225);
			    p3.lineTo(120, 200);
			    can.drawPath(p3, paint);
			}
			else if(i==8)
			{
				i=i+1;
				//Head Code
				can.drawCircle(105, 57, 30, paint);
				//Code for two eyes
				RectF eye1 = new RectF(85, 45,95, 50);
				can.drawOval(eye1, paint2);		
				RectF eye2 = new RectF(115, 45,125, 50);
				can.drawOval(eye2, paint2);
				//Code for Mouth
				RectF mouth = new RectF(95, 65,115, 75);
				can.drawOval(mouth, paint2);
				//Code for ears
				RectF ear1 = new RectF(70, 45,75, 65);
				can.drawOval(ear1, paint1);
				RectF ear2 = new RectF(135, 45,140, 65);
				can.drawOval(ear2, paint1);
				//Code for Neck
				can.drawRect(100, 80, 110, 100, paint);
				//Code for Chest
				can.drawRect(90,100,120,200, paint);
				//Code for arms
				Path p = new Path();
			    p.moveTo(90, 100);
			    p.lineTo(50, 135);
			    p.lineTo(55, 135);
			    p.lineTo(90, 105);
			    can.drawPath(p, paint);
			    
			    Path p1 = new Path();
			    p1.moveTo(120, 100);
			    p1.lineTo(160, 135);
			    p1.lineTo(155, 135);
			    p1.lineTo(120, 105);
			    can.drawPath(p1, paint);
				//Code for legs
				Path p2 = new Path();
			    p2.moveTo(90, 195);
			    p2.lineTo(50, 225);
			    p2.lineTo(55, 225);
			    p2.lineTo(90, 200);
			    can.drawPath(p2, paint);
			    
			    Path p3 = new Path();
			    p3.moveTo(120, 195);
			    p3.lineTo(160, 225);
			    p3.lineTo(155, 225);
			    p3.lineTo(120, 200);
			    can.drawPath(p3, paint);
			    //Code for the Box
			    can.drawRect(30, 225, 180, 290, paint);
			    //Two Lines for rope
				can.drawLine(30, 10, 65, 89, paint1);
				can.drawLine(180, 10, 145, 89, paint1);
				
				//Code of Curve Rope
				RectF rectF = new RectF(65, 70, 145, 100);
				can.drawArc (rectF, 0, 180, false, paint1);
			}
			else
			{
				//Head Code
				can.drawCircle(105, 57, 30, paint);
				//Code for two eyes
				RectF eye1 = new RectF(85, 45,95, 50);
				can.drawOval(eye1, paint2);		
				RectF eye2 = new RectF(115, 45,125, 50);
				can.drawOval(eye2, paint2);
				//Code for Mouth
				RectF mouth = new RectF(95, 65,115, 75);
				can.drawOval(mouth, paint2);
				//Code for ears
				RectF ear1 = new RectF(70, 45,75, 65);
				can.drawOval(ear1, paint1);
				RectF ear2 = new RectF(135, 45,140, 65);
				can.drawOval(ear2, paint1);
				//Code for Neck
				can.drawRect(100, 80, 110, 100, paint);
				//Code for Chest
				can.drawRect(90,100,120,200, paint);
				//Code for arms
				Path p = new Path();
			    p.moveTo(90, 100);
			    p.lineTo(80, 100);
			    p.lineTo(80, 145);
			    p.lineTo(85, 145);
			    p.lineTo(85, 105);
			    p.lineTo(90, 105);
			    can.drawPath(p, paint);
			    
			    Path p1 = new Path();
			    p1.moveTo(120, 100);
			    p1.lineTo(130, 100);
			    p1.lineTo(130, 145);
			    p1.lineTo(125, 145);
			    p1.lineTo(125, 105);
			    p1.lineTo(120, 105);
			    can.drawPath(p1, paint);
				//Code for legs
				Path p2 = new Path();
			    p2.moveTo(90, 195);
			    p2.lineTo(80, 195);
			    p2.lineTo(80, 240);
			    p2.lineTo(85, 240);
			    p2.lineTo(85, 200);
			    p2.lineTo(90, 200);
			    can.drawPath(p2, paint);
			    
			    Path p3 = new Path();
			    p3.moveTo(120, 195);
			    p3.lineTo(130, 195);
			    p3.lineTo(130, 240);
			    p3.lineTo(125, 240);
			    p3.lineTo(125, 200);
			    p3.lineTo(120, 200);
			    can.drawPath(p3, paint);
			   
			    //Two Lines for rope
				can.drawLine(30, 10, 65, 89, paint1);
				can.drawLine(180, 10, 145, 89, paint1);
				
				//Code of Curve Rope
				RectF rectF = new RectF(65, 70, 145, 100);
				can.drawArc (rectF, 0, 180, false, paint1);
			}
			RelativeLayout l = (RelativeLayout) findViewById(R.id.activity_my);
			//LinearLayout l=(LinearLayout) findViewById(R.id.activity_main);
			l.setBackground(new BitmapDrawable(bg));
		}
		else 
		{
			b.setBackgroundColor(Color.GREEN);
			Bitmap bg=Bitmap.createBitmap(480,800,Bitmap.Config.ARGB_8888);
			Canvas can =new Canvas(bg);
			Paint paint = new Paint();
			paint.setColor(Color.BLACK);
			Paint paint2 = new Paint();
			paint2.setColor(Color.YELLOW);
			Paint paint1 = new Paint();
			paint1.setColor(Color.BLUE);
			paint1.setStyle(Paint.Style.STROKE);
			paint1.setStrokeWidth(2);
			//Head Code
			can.drawCircle(105, 57, 30, paint);
			//Code for two eyes
			RectF eye1 = new RectF(85, 45,95, 50);
			can.drawOval(eye1, paint2);		
			RectF eye2 = new RectF(115, 45,125, 50);
			can.drawOval(eye2, paint2);
			//Code for Mouth
			RectF mouth = new RectF(95, 65,115, 75);
			can.drawOval(mouth, paint2);
			//Code for ears
			RectF ear1 = new RectF(70, 45,75, 65);
			can.drawOval(ear1, paint1);
			RectF ear2 = new RectF(135, 45,140, 65);
			can.drawOval(ear2, paint1);
			//Code for Neck
			can.drawRect(100, 80, 110, 100, paint);
			//Code for Chest
			can.drawRect(90,100,120,200, paint);
			//Code for arms
			Path p = new Path();
		    p.moveTo(90, 100);
		    p.lineTo(50, 135);
		    p.lineTo(55, 135);
		    p.lineTo(90, 105);
		    can.drawPath(p, paint);
		    
		    Path p1 = new Path();
		    p1.moveTo(120, 100);
		    p1.lineTo(160, 135);
		    p1.lineTo(155, 135);
		    p1.lineTo(120, 105);
		    can.drawPath(p1, paint);
			//Code for legs
			Path p2 = new Path();
		    p2.moveTo(90, 195);
		    p2.lineTo(50, 225);
		    p2.lineTo(55, 225);
		    p2.lineTo(90, 200);
		    can.drawPath(p2, paint);
		    
		    Path p3 = new Path();
		    p3.moveTo(120, 195);
		    p3.lineTo(160, 225);
		    p3.lineTo(155, 225);
		    p3.lineTo(120, 200);
		    can.drawPath(p3, paint);
			/*AlertDialog.Builder builder = new AlertDialog.Builder(d);
		  	builder.setMessage("Hello");
		    //Toast.makeText(c, "Would you want to play Guessing Game?", Toast.LENGTH_LONG).show();
		    builder.setNegativeButton("NO",new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(d,"Good Bye", Toast.LENGTH_LONG).show();
			((Activity) d).finish();
				}
		    });*/
		    RelativeLayout l = (RelativeLayout) findViewById(R.id.activity_my);
			//LinearLayout l=(LinearLayout) findViewById(R.id.activity_main);
			l.setBackground(new BitmapDrawable(bg));
		}
		//Toast.makeText(this,"enter a text here",Toast.LENGTH_SHORT).show();
		GuessingGame gg = new GuessingGame();
		gg.execute(value,username);
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
}

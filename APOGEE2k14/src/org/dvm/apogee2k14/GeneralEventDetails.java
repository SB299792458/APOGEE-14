package org.dvm.apogee2k14;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;


import java.util.List;

import org.dvm.apogee2k14.R;
import org.xmlpull.v1.XmlPullParserException;



import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class GeneralEventDetails extends ListActivity implements OnClickListener
{
 public OnLongClickListener longClickListner;
 LinearLayout panel1,panel2,panel3,panel7;
 TextView text1,text2,text3,text7;
 View openLayout;
 ConnectivityManager cm;
 String url;
 
// private static String link = "http://bits-oasis.org/2013test/backend/backend/?name=";
//	private EventData evData;
	
 private Information eventInfo, moreInfo;
 private String eventName;
 ImageView ib,ib2;
 
 ImageView ic_op1,ic_op2,ic_op3,ic_op7;
 
 @Override
 public void onCreate(Bundle savedInstanceState)
 {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.accordian);
  
  cm =(ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
  
  
  eventName = getIntent().getExtras().getString("fromwhereinfo");
	TextView eventNameTextView = (TextView) findViewById(R.id.EventNameBox);
	eventNameTextView.setText(eventName);
	

	
	try
	{
		Log.v("CZ","i was here ...");
		SplashScreen.db.createDatabase();
	}
	catch(IOException ii)
	{
		
	}
	SplashScreen.db.openDatabase();
	

	
	
	eventInfo=(SplashScreen.db).getEventsTableData(eventName);
	moreInfo=(SplashScreen.db).getEventTabsByName(eventName);
//	Log.v("CZ","i was here ..." + res.length);
	
	(SplashScreen.db).closeDataBase();
	  
	  
	ic_op1=(ImageView)findViewById(R.id.iv1);
	ic_op2=(ImageView)findViewById(R.id.iv2);
	ic_op3=(ImageView)findViewById(R.id.iv3);
//	ic_op4=(ImageView)findViewById(R.id.iv4);
//	ic_op5=(ImageView)findViewById(R.id.iv5);
	ic_op7=(ImageView)findViewById(R.id.iv7);
	
	ic_op1.setImageResource(R.drawable.arrow_dw);
	ic_op2.setImageResource(R.drawable.arrow_dw);
	ic_op3.setImageResource(R.drawable.arrow_dw);
//	ic_op4.setImageResource(R.drawable.arrow_dw);
//	ic_op5.setImageResource(R.drawable.arrow_dw);
	ic_op7.setImageResource(R.drawable.arrow_dw);
	
	addListenerOnButton();
	
	CheckBox fav = (CheckBox) findViewById(R.id.checkBox1);
	//fav.setChecked(true);
	
	SharedPreferences favPrefs = getSharedPreferences("OASISPREFS", 0);
	fav.setChecked(favPrefs.getBoolean(eventName, false));
	
	fav.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() 
	{
		
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) 
		{
			SharedPreferences setFavPrefs = getSharedPreferences("OASISPREFS", 0);
			SharedPreferences.Editor editor = setFavPrefs.edit();
			
			if(isChecked)
			{
				editor.putBoolean(eventName, true);
			}
			else
			{
				editor.remove(eventName);
			}
			editor.commit();
		}
	});
	
	String eventlink = "";
	int i;
	char c;
	for(i=0;i<eventName.length();i++)
	{
		c = eventName.charAt(i);
		if(c != ' ')
			eventlink = eventlink + c;
	}
	
	new putValuesInBox(eventInfo);
  
  
  panel1 = (LinearLayout) findViewById(R.id.panel1);
  panel2 = (LinearLayout) findViewById(R.id.panel2);
  panel3 = (LinearLayout) findViewById(R.id.panel3);
 // panel4 = (LinearLayout) findViewById(R.id.panel4);
//  panel5 = (LinearLayout) findViewById(R.id.panel5);
  panel7 = (LinearLayout) findViewById(R.id.panel7);
  
  //panel1.setVisibility(View.VISIBLE);
  
  //panel1.setVisibility(View.VISIBLE);
  
  //Log.v("CZ","height at first ..." + panel1.getMeasuredHeight());
  
  text1 = (TextView) findViewById(R.id.text1);
  text2 = (TextView) findViewById(R.id.text2);
  text3 = (TextView) findViewById(R.id.text3);
 // text4 = (TextView) findViewById(R.id.text4);
//  text5 = (TextView) findViewById(R.id.text5);
  text7 = (TextView) findViewById(R.id.text7);

  text1.setOnClickListener(this);
  text2.setOnClickListener(this);
  text3.setOnClickListener(this);
 // text4.setOnClickListener(this);
//  text5.setOnClickListener(this);
  text7.setOnClickListener(this);  
  
  ic_op1.setOnClickListener(this);
  ic_op2.setOnClickListener(this);
  ic_op3.setOnClickListener(this);
//  ic_op4.setOnClickListener(this);
//  ic_op5.setOnClickListener(this);
  ic_op7.setOnClickListener(this);
  
  
 String eventLink=eventName.replaceAll(" ", "%20");
  
  
  url="http://bits-apogee.org/2014/getcontent/?even="+eventLink;
  new DownloadJSON().execute("http://bits-apogee.org/2014/getcontent/?even="+eventLink);
	
 }
 
 private class DownloadJSON extends AsyncTask<String, Void, String> 
 {

 @Override
 protected String doInBackground(String... arg0) 
 {
 try
 {
		
	 	NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
		boolean isConnected = activeNetwork != null &&
		                      activeNetwork.isConnectedOrConnecting();
		NetworkInfo mWifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
			
		if (isConnected || mWifi.isConnected()){
			//(SplashScreen.db).openDatabase();
			 aJSONparser x=new aJSONparser();
			    x.parseIT();
			
			//(SplashScreen.db).closeDataBase();

	  }
	 // ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	 

	  
	    return "";
	  
	  
	 //return loadXMLfromServer(arg0[0]);
 }
 catch(Exception e)
 {
 return "Error in Connection";
 }

 //return null;
 }



 }
 
 public void addListenerOnButton() {
	 
		ib = (ImageView) findViewById(R.id.drawerimage);
		ib2=(ImageView) findViewById(R.id.imageButton1);
		ib.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

			  Intent in2 = new Intent(GeneralEventDetails.this, NavigationDrawer.class);
			    startActivity(in2);

			}

		});
ib2.setOnClickListener(new OnClickListener() {

	@Override
	public void onClick(View arg0) {

	  Intent in2 = new Intent(GeneralEventDetails.this, MainScreen.class);
	    startActivity(in2);

	}

});

	}
private class putValuesInBox implements OnClickListener
	{

	 putValuesInBox(Information eventInfo)
		{
			if(eventInfo != null)
			{
				WebView webby = (WebView) findViewById(R.id.OverviewBox);
				webby.loadData(eventInfo.overview, "text/html", null);
				
				TextView eventDate = (TextView)findViewById(R.id.DateBox);
				eventDate.setText("Date: " + eventInfo.date + " ");
				
				TextView eventVenue = (TextView)findViewById(R.id.LocationBox);
				eventVenue.setText("Venue: " + eventInfo.venue + " ");
				
				TextView eventTime = (TextView)findViewById(R.id.TimeBox);
				eventTime.setText("Start Time: " + eventInfo.stime + "\n" + "End Time: " + eventInfo.etime + "\n");
				
				WebView eventMore = (WebView)findViewById(R.id.MoreBox);
				eventMore.loadData(moreInfo.more, "text/html", null);
				//eventMore.setMovementMethod(new ScrollingMovementMethod());
				
				ImageView reminderBtn = (ImageView)findViewById(R.id.setReminderBtn);
				reminderBtn.setOnClickListener(this);
			}
		}
		
		
		public void onClick(View v)
		{
			
			Calendar beginTime = Calendar.getInstance();
			beginTime.set(2014, 3, eventInfo.day, eventInfo.hour , eventInfo.minute);
			
			Intent reminderIntent = new Intent(Intent.ACTION_EDIT);
			//reminderIntent.putExtra("", value)
			reminderIntent.setType("vnd.android.cursor.item/event");
			reminderIntent.putExtra("title", eventName);
			if(eventInfo.day > 0)
				reminderIntent.putExtra("beginTime", beginTime.getTimeInMillis());
			reminderIntent.putExtra("eventLocation", eventInfo.venue);
			startActivity(reminderIntent);
		}

		}
 
 @Override
 public void onClick(View v)
 {
  hideOthers(v);
 }
 private void hideThemAll()
 {
  if(openLayout == null) return;
  if(openLayout == panel1)
   panel1.startAnimation(new ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel1, true));
  if(openLayout == panel2)
   panel2.startAnimation(new ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel2, true));
  if(openLayout == panel3)
   panel3.startAnimation(new ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel3, true));
 /* if(openLayout == panel4)
   panel4.startAnimation(new ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel4, true));
  if(openLayout == panel5)
   panel5.startAnimation(new ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel5, true));*/
  if(openLayout == panel7)
	   panel7.startAnimation(new ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel7, true));

 }
 private void hideOthers(View layoutView)
 {
  {
	  int v;
	   if(layoutView.getId() == R.id.text1 ||layoutView.getId() == R.id.iv1)
	   {
	    v = panel1.getVisibility();
	    if(v != View.VISIBLE)
	    {
	     panel1.setVisibility(View.VISIBLE);
	    
	     //Log.v("CZ","height..." + panel1.getHeight());
	    }
	    
	    //panel1.setVisibility(View.GONE);
	    //Log.v("CZ","again height..." + panel1.getHeight());
	    hideThemAll();
	    ic_op1.setImageResource(R.drawable.arrow_dw);
	    if(v != View.VISIBLE)
	    {
	     panel1.startAnimation(new ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel1, true));
	     ic_op1.setImageResource(R.drawable.arrow_up);
	    }
	   }
	   else if(layoutView.getId() == R.id.text2  ||layoutView.getId() == R.id.iv2)
	   {
	    v = panel2.getVisibility();
	    hideThemAll();
	    ic_op2.setImageResource(R.drawable.arrow_dw);
	    if(v != View.VISIBLE)
	    {
	     panel2.startAnimation(new ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel2, true));
	     ic_op2.setImageResource(R.drawable.arrow_up);
	    }
	   }
	   else if(layoutView.getId() == R.id.text3  ||layoutView.getId() == R.id.iv3)
	   {
	    v = panel3.getVisibility();
	    hideThemAll();
	    ic_op3.setImageResource(R.drawable.arrow_dw);
	    if(v != View.VISIBLE)
	    {
	     panel3.startAnimation(new ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel3, true));
	     ic_op3.setImageResource(R.drawable.arrow_up);
	    }
	   }
	 /*  else if(layoutView.getId() == R.id.text4  ||layoutView.getId() == R.id.iv4)
	   {
	    v = panel4.getVisibility();
	    hideThemAll();
	    ic_op4.setImageResource(R.drawable.arrow_dw);
	    if(v != View.VISIBLE)
	    {
	     panel4.startAnimation(new ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel4, true));
	     ic_op4.setImageResource(R.drawable.arrow_up);
	    }
	   }
	   else if(layoutView.getId() == R.id.text5  ||layoutView.getId() == R.id.iv5)
	   {
	    v = panel5.getVisibility();
	    hideThemAll();
	    ic_op5.setImageResource(R.drawable.arrow_dw);
	    if(v != View.VISIBLE)
	    {
	     panel5.startAnimation(new ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel5, true));
	     ic_op5.setImageResource(R.drawable.arrow_up);
	    }
   }*/
	   else if(layoutView.getId() == R.id.text7  ||layoutView.getId() == R.id.iv7)
	   {
	    v = panel7.getVisibility();
	    hideThemAll();
	    ic_op7.setImageResource(R.drawable.arrow_dw);
	    if(v != View.VISIBLE)
	    {
	     panel7.startAnimation(new ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel7, true));
	     ic_op7.setImageResource(R.drawable.arrow_up);
	    }
   }
  }
 }
 
 public class ScaleAnimToHide extends ScaleAnimation
 { 
	 private View mView;

         private LayoutParams mLayoutParams;

         private int mMarginBottomFromY, mMarginBottomToY;

         private boolean mVanishAfter = false;

         public ScaleAnimToHide(float fromX, float toX, float fromY, float toY, int duration, View view,boolean vanishAfter)
         {
             super(fromX, toX, fromY, toY);
             setDuration(duration);
             openLayout = null;
             mView = view;
             mVanishAfter = vanishAfter;
             mLayoutParams = (LayoutParams) view.getLayoutParams();
             int height = mView.getHeight();
             mMarginBottomFromY = (int) (height * fromY) + mLayoutParams.bottomMargin - height;
             mMarginBottomToY = (int) (0 - ((height * toY) + mLayoutParams.bottomMargin)) - height;
            
          //   Log.v("CZ","height..." + height + " , mMarginBottomFromY...." + mMarginBottomFromY  + " , mMarginBottomToY.." +mMarginBottomToY);
         }

         @Override
         protected void applyTransformation(float interpolatedTime, Transformation t)
         {
             super.applyTransformation(interpolatedTime, t);
             if (interpolatedTime < 1.0f)
             {
                 int newMarginBottom = mMarginBottomFromY + (int) ((mMarginBottomToY - mMarginBottomFromY) * interpolatedTime);
                 mLayoutParams.setMargins(mLayoutParams.leftMargin, mLayoutParams.topMargin,mLayoutParams.rightMargin, newMarginBottom);
                 mView.getParent().requestLayout();
                 //Log.v("CZ","newMarginBottom..." + newMarginBottom + " , mLayoutParams.topMargin..." + mLayoutParams.topMargin);
             }
             else if (mVanishAfter)
             {
                 mView.setVisibility(View.GONE);
             }
         }
 }
 public class ScaleAnimToShow extends ScaleAnimation
 {

         private View mView;

         private LayoutParams mLayoutParams;

         private int mMarginBottomFromY, mMarginBottomToY;

         private boolean mVanishAfter = false;

         public ScaleAnimToShow(float toX, float fromX, float toY, float fromY, int duration, View view,boolean vanishAfter)
         {
             super(fromX, toX, fromY, toY);
             
             
             
             
             openLayout = view;
             setDuration(duration);
             mView = view;
             mVanishAfter = vanishAfter;
             mLayoutParams = (LayoutParams) view.getLayoutParams();
             mView.setVisibility(View.VISIBLE);
             int height = mView.getHeight();
             //mMarginBottomFromY = (int) (height * fromY) + mLayoutParams.bottomMargin + height;
             //mMarginBottomToY = (int) (0 - ((height * toY) + mLayoutParams.bottomMargin)) + height;
            
             mMarginBottomFromY = 0;
             mMarginBottomToY = height;
            
            // Log.v("CZ",".................height..." + height + " , mMarginBottomFromY...." + mMarginBottomFromY  + " , mMarginBottomToY.." +mMarginBottomToY);
         }

         @Override
         protected void applyTransformation(float interpolatedTime, Transformation t)
         {
             super.applyTransformation(interpolatedTime, t);
             if (interpolatedTime < 1.0f)
             {
                 int newMarginBottom = (int) ((mMarginBottomToY - mMarginBottomFromY) * interpolatedTime) - mMarginBottomToY;
                 mLayoutParams.setMargins(mLayoutParams.leftMargin, mLayoutParams.topMargin,mLayoutParams.rightMargin, newMarginBottom);
                 mView.getParent().requestLayout();
                 //Log.v("CZ","newMarginBottom..." + newMarginBottom + " , mLayoutParams.topMargin..." + mLayoutParams.topMargin);
             }
         }

 }




}

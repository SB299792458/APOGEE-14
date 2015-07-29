package org.dvm.apogee2k14;
import org.dvm.apogee2k14.R;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;



public class ScheduleActivity extends Activity {
	//	private EventData evData;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.loadweb);
			//url for sponsors goes here-->
			WebView webview=(WebView)findViewById(R.id.web); 
			webview.loadUrl("https://docs.google.com/spreadsheet/lv?key=0ApZN5FkF-bGFdFpubHBVYjV2R2ZSYWQzMS1rRWo5LXc&toomany=true");
		
		
		}
}



























/*package com.example.apogee2k14;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import com.example.apogee2k14.R;
//import com.example.apogee2k14.GeneralEventDetails.DownloadJSON;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ScheduleActivity extends ListActivity
{
	private String day;
	private String dayStr;
	ArrayAdapter<String> adapter;
	ImageView ivHome,ivDrawer;
	ConnectivityManager cm;
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
	//	setContentView(R.layout.activity_general_event_details);
		
		DBAccess db= SplashScreen.db;
		try
		{
		db.createDatabase();
		}
		catch(IOException ii)
		{
			
		}
		db.openDatabase();
					
		// day = 24/10 OR 25/10 OR 26/10 OR 27/10 OR 28/10 
		dayStr = getIntent().getExtras().getString("dayValue");
		Log.d("exception","value of day" + dayStr);
		day= dayStr.replaceAll("2013","2014");
			
    	
		//cm =(ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
		Log.d("exception","value of day" + day);
		
		final String eventNames[] = db.getEventNamesByDate(day);
		
		if(eventNames!=null)
		{
		
		
			this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.label,eventNames));
		    // refer the ArrayAdapter Document in developer.android.com
		    ListView lv = getListView();
		
		
		//lv.setCacheColorHint(0);
		
		lv.setOnItemClickListener(new OnItemClickListener() {
		
			@Override
			public void onItemClick(AdapterView<?> adapter, View view,
					int position, long id) {
				
				Intent in2 = new Intent(ScheduleActivity.this, GeneralEventDetails.class);
				in2.putExtra("fromwhereinfo", eventNames[position]);
				startActivity(in2);
			}
		});
		
		}
	//	ivDrawer = (ImageView) findViewById(R.id.drawerheader);
	//	ivDrawer.setOnClickListener(this);

		  
			 String all1[]=SplashScreen.db.getEventNamesByCategory("Workshops");
			 Log.d("exception", ""+all1.length);
			 for(int i=0;i<all1.length;i++)
			 {
			// String eventLink=all1[i].replaceAll(" ", "%20");
			 String eventLink=all1[i];
			 String url = "http://bits-apogee.org/2014/getcontent/?even="+eventLink;
			 new DownloadJSONSchedule().execute(url);
			 }	
				
	}
	
	private class DownloadJSONSchedule extends AsyncTask<String, Void, String> 
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
}

		@Override
		protected void onPostExecute(String result)
		{
			setContentView(R.layout.schedule_tableview);
			ivHome=(ImageView) findViewById(R.id.imageButton2);
			ivDrawer.setOnClickListener(new OnClickListener(){
						@Override
						public void onClick(View arg0) {

						  Intent in = new Intent(ScheduleActivity.this, ScheduleDrawer.class);
						   startActivity(in);
						}
					});
					
			ivHome.setOnClickListener(new OnClickListener() {
								@Override
								public void onClick(View arg0) {
								  Intent in2 = new Intent(ScheduleActivity.this, MainScreen.class);
								    startActivity(in2);
								}
							});
			
					

			if(eventDatas == null || eventDatas.size() == 0)
				return;
			
			tl = (TableLayout)findViewById(R.id.tablelayout);
			
			tr = new TableRow[eventDatas.size()];
			reminders = new Button[eventDatas.size()];
			eventNames = new TextView[eventDatas.size()];
			startTimes = new TextView[eventDatas.size()];
			endTimes = new TextView[eventDatas.size()];
			venues = new TextView[eventDatas.size()];
			
			int i;
			Information temp;
			for(i=0;i<eventDatas.size();i++)
			{
				temp = eventDatas.get(i);
				tr[i] = new TableRow(getApplicationContext());
				//tr[i].setWeightSum(7);
				
				reminders[i] = new Button(getApplicationContext());
				reminders[i].setLayoutParams(new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.FILL_PARENT));
				reminders[i].setBackgroundColor(Color.WHITE);
				reminders[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.reminder));
				
				eventNames[i] = new TextView(getApplicationContext());
				eventNames[i].setLayoutParams(new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.FILL_PARENT));
				eventNames[i].setText(temp.getName() + " ");
				eventNames[i].setTextColor(Color.parseColor("#021F3D"));
				eventNames[i].setTypeface(null,Typeface.BOLD);
				eventNames[i].setOnClickListener(this);
				//eventNames[i].setLayoutParams(new LayoutParams(width, height));
				
				startTimes[i] = new TextView(getApplicationContext());
				startTimes[i].setLayoutParams(new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.FILL_PARENT));
				startTimes[i].setText(temp.getSTime() + "  ");
				startTimes[i].setTextColor(Color.parseColor("#021F3D"));
				startTimes[i].setTypeface(null,Typeface.BOLD);
				startTimes[i].setOnClickListener(this);
				
				endTimes[i] = new TextView(getApplicationContext());
				endTimes[i].setLayoutParams(new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.FILL_PARENT));
				endTimes[i].setText(temp.getETime() + "  ");
				endTimes[i].setTypeface(null,Typeface.BOLD);
				endTimes[i].setTextColor(Color.parseColor("#021F3D"));
				endTimes[i].setOnClickListener(this);
				
				//Log.d("nihav", endTimes[i].getText().toString());
				
				venues[i] = new TextView(getApplicationContext());
				venues[i].setLayoutParams(new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.FILL_PARENT));
				venues[i].setTypeface(null,Typeface.BOLD);
				venues[i].setText(temp.getVenue());
				venues[i].setTextColor(Color.parseColor("#021F3D"));
				
				//Log.d("nihav", temp.getEventName() + " " + temp.getEventEndTime());
				
				//tr[i].addView(reminders[i]);
				tr[i].addView(eventNames[i]);
				tr[i].addView(startTimes[i]);
				tr[i].addView(endTimes[i]);
				tr[i].addView(venues[i]);
				
				tl.addView(tr[i]);
			}
		}

	 
		@Override
		public void onClick(View v) 
		{
			int i=-1;
			int index=-1;
			for(i=0;i<eventNames.length;i++)
			{
				if(eventNames[i].equals(v))
				{
					index = i;
					break;
				}
			}
			if(index != -1)
			{
				//TimeDATA temp = eventDatas.get(index);
				//Log.d("nihav", "" + temp.getEventName());
				if(!(temp.getEventPop().equals("null")))
				{
					Intent intent = new Intent(ScheduleActivity.this, GeneralEventDetails.class);
					intent.putExtra("fromwhereinfo", eventDatas.get(index).getName());
					startActivity(intent);
				}
			}
			else
			{
				for(i=0;i<startTimes.length;i++)
				{
					if(startTimes[i].equals(v))
					{
						index = i;
						break;
					}
				}
				if(index == -1)
				{
					for(i=0;i<endTimes.length;i++)
					{
						if(endTimes[i].equals(v))
						{
							index = i;
							break;
						}
					}		
				}
				if(index != -1)
				{
					Information rem = eventDatas.get(index);
					Calendar beginTime = Calendar.getInstance();
					beginTime.set(2014, 03, Integer.parseInt(dayStr.substring(0, dayStr.indexOf('-'))), rem.getHour(), rem.getMinute());
					
					Intent reminderIntent = new Intent(Intent.ACTION_EDIT);
					//reminderIntent.putExtra("", value)
					reminderIntent.setType("vnd.android.cursor.item/event");
					reminderIntent.putExtra("title", rem.getName());
					//if(rem.getDay() > 0)
						reminderIntent.putExtra("beginTime", beginTime.getTimeInMillis());
					reminderIntent.putExtra("eventLocation", rem.getVenue());
					startActivity(reminderIntent);
				}
			}
		}
		
		private String loadXMLfromServer(String urlString) throws XmlPullParserException, IOException
		{
			InputStream stream = null;
			
			ScheduleXMLParser oasisXMLParser = new ScheduleXMLParser();
			//List<String> conts= null;
			//EventData eventData = null;
			String cont = null;
			//Log.d("nihav", "load from server");
			//StringBuilder htmlString = new StringBuilder();
			
			try
			{
				//stream = downloadURL(urlString);
				
				//Log.d("nihav", "load from server");
				
				//eventDatas = oasisXMLParser.parse(stream);
			
				//Log.d("nihav", "i am back");
			}
			finally
			{
				if(stream != null)
				{
					stream.close();
				}
			}
			int i;
				String str = evData.getEventContent();
				while((i=str.indexOf("<pre>")) >= 0)
				{
					str = str.substring(0, i) + str.substring(i+5);
				}
				while((i=str.indexOf("</pre>")) >= 0)
				{
					str = str.substring(0, i) + str.substring(i+6);
				}
				evData.setEventCont(str);
				htmlString.append(str);
			
			return "";
		}

		private InputStream downloadURL(String urlString) throws IOException
		{
			URL url = new URL(urlString);
			//Log.d("nihav", "download from server");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(10000);
			conn.setConnectTimeout(15000);
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			conn.connect();
			//Log.d("nihav", "download from server");
			return conn.getInputStream();
		}

		
	}

	@Override
	public void onClick(View v) {
		
		// TODO Auto-generated method stub
		
		Intent in = new Intent(ScheduleActivity.this, ScheduleDrawer.class);
		   startActivity(in);
	}
*/
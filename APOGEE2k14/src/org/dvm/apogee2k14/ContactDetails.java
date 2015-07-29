package org.dvm.apogee2k14;

import java.io.IOException;

import org.dvm.apogee2k14.R;


import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebView.FindListener;
import android.widget.TextView;
//ConnectivityManager cm=null;

public class ContactDetails extends Activity{
	
	Information eventInfo;
	String eventName;

	
	public void onCreate(Bundle savedInstanceState)
	 {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.simple_contacts);
	  
	 // cm =(ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
	 // eventName = getIntent().getExtras().getString("fromwhereinfo");
	//	TextView eventNameTextView = (TextView) findViewById(R.id.EventNameBox);
	//	eventNameTextView.setText(eventName);
	  
	 /* eventName = getIntent().getExtras().getString("fromwhereinfo");
		TextView eventNameTextView = (TextView) findViewById(R.id.EventNameBox);
		eventNameTextView.setText(eventName);
		*/

		
		try
		{
			Log.v("CZ","i was here ...");
			SplashScreen.db.createDatabase();
		}
		catch(IOException ii)
		{
			
		}
		SplashScreen.db.openDatabase();
		WebView eventMore = (WebView)findViewById(R.id.textViewContact);
		
		eventInfo=(SplashScreen.db).getEventsTableData("Contacts");
		Log.d("exception",eventInfo.overview);
		
		
		eventMore.loadData(eventInfo.overview, "text/html", null);
		
		//TextView tv=(TextView)findViewById(R.id.textViewContact);
		
		
		

		
	//	moreInfo=(SplashScreen.db).getEventTabsByName(eventName);
	//		Log.v("CZ","i was here ..." + res.length);
		
		(SplashScreen.db).closeDataBase();


}
}

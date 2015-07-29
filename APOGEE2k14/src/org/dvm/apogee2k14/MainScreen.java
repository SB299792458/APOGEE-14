package org.dvm.apogee2k14;

import org.dvm.apogee2k14.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

public class MainScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	  SplashScreen.db=new DBAccess(MainScreen.this);

	    GridView gridview = (GridView) findViewById(R.id.gridview);
	    gridview.setAdapter(new ImageAdapter(this));

	    gridview.setOnItemClickListener(new OnItemClickListener() {
        	@Override
        	public void onItemClick(AdapterView<?> parent, View view,
        			int position, long id) {
        		String[] items = getResources().getStringArray(R.array.mainmenuitems);
        		if(items[position].equals("Event of the Day")) {
        			Intent in = new Intent(MainScreen.this, GeneralListView.class);
        			in.putExtra("fromwhereinfo", items[position]);
        			startActivity(in);
        		}
        		else if(items[position].equals("Quiz")) {
        			Intent in = new Intent(MainScreen.this, QuizActivity.class);
        			in.putExtra("fromwhereinfo", items[position]);
        			startActivity(in);
        		}
        		
        		else if(items[position].equals("Schedule")){
        			
        			Intent in = new Intent(MainScreen.this, ScheduleActivity.class);
        			startActivity(in);
        		}
        		else if(items[position].equals("Sponsors"))
        		{
        			Intent in = new Intent(MainScreen.this, SponsorsActivity.class);
        			//in.putExtra("fromwhereinfo", items[position]);
        			startActivity(in);        			
        		}
        		else if(items[position].equals("Think Again"))
        		{
        			Intent in = new Intent(MainScreen.this, ThinkAgain.class);
        			//in.putExtra("fromwhereinfo", items[position]);
        			startActivity(in);        			
        		}
        		else if(items[position].equals("Social"))
        		{
        			Intent in = new Intent(MainScreen.this, Social_fb.class);
        			//in.putExtra("fromwhereinfo", items[position]);
        			startActivity(in);        			
        		}
        		
        		else if(items[position].equals("Events"))
        		{
        			Intent in = new Intent(MainScreen.this, EventScreen.class);
        			//in.putExtra("fromwhereinfo", items[position]);
        			startActivity(in);        			
        		}
        		else if(items[position].equals("Contact Us"))
        		{
        			Intent in = new Intent(MainScreen.this, ContactDetails.class);
        			//in.putExtra("fromwhereinfo", "Contacts");
        			startActivity(in);        			
        		}
        		else if(items[position].equals("Campus Ambassadors"))
        		{
        			Intent in = new Intent(MainScreen.this, CampusAmbassadors.class);
        			//in.putExtra("fromwhereinfo", "Contacts");
        			startActivity(in);        			
        		}
        		else {
	        		Intent in = new Intent(MainScreen.this, GeneralListView.class);
	        		in.putExtra("fromwhereinfo", items[position]);
	        		startActivity(in);
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

}

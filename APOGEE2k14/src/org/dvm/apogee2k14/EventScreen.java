package org.dvm.apogee2k14;

import org.dvm.apogee2k14.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

public class EventScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);

	    GridView gridview2 = (GridView) findViewById(R.id.gridview);
	    gridview2.setAdapter(new EventImageAdapter(this));

	    gridview2.setOnItemClickListener(new OnItemClickListener() {
        	@Override
        	public void onItemClick(AdapterView<?> parent, View view,
        			int position, long id) {
        		String[] items2 = getResources().getStringArray(R.array.eventcategories);

	        		Intent in = new Intent(EventScreen.this, GeneralListView.class);
	        		in.putExtra("fromwhereinfo", items2[position]);
	        		startActivity(in);
        		
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


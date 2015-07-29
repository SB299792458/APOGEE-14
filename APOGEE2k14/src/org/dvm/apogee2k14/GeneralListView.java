package org.dvm.apogee2k14;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dvm.apogee2k14.R;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.text.Editable;
import android.text.TextWatcher;

@SuppressWarnings("unused")
public class GeneralListView extends Activity
{
	ArrayList<HashMap<String, String>> productList;
	EditText inputField;
	ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		final View l = inflater.inflate(R.layout.activity_general_list_screen, null);
		ListView lv = (ListView) l.findViewById(R.id.genListView);
		
		
		lv.setCacheColorHint(0);
		
		//obj to access offline database
		DBAccess db= SplashScreen.db;
		
		try
		{
			db.createDatabase();
		}
		catch(IOException ii)
		{
			
		}
		
		// handling "Elements" click
		if(getIntent().getExtras().getString("fromwhereinfo").equals("Automation")) 
		{
			
		ImageView iv=(ImageView) l.findViewById(R.id.cat_icon_head);
		iv.setImageResource(R.drawable.automationh);
		
		
		db.openDatabase();
		final String ev[] = db.getEventNamesByCategory(getIntent().getExtras().getString("fromwhereinfo"));
			//Log.d("check", ev.length+"");
			adapter = new ArrayAdapter<String>(this,R.layout.list_black_text,R.id.list_content, ev);
			
			lv.setAdapter(adapter);
			lv.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> adapter, View view,
						int position, long id) {
					
					Intent in = new Intent(GeneralListView.this, GeneralEventDetails.class);
					in.putExtra("fromwhereinfo", ev[position]);
					startActivity(in);
				}
			});
		}
		
		if(getIntent().getExtras().getString("fromwhereinfo").equals("Favourites"))
		{
			final SharedPreferences favPrefs = getSharedPreferences("OASISPREFS", 0);
			ImageView iv=(ImageView) l.findViewById(R.id.cat_icon_head);
			iv.setImageResource(R.drawable.head_fav);
			
			//favPrefs.get
			final List<String> lst = new ArrayList<String>();
			try
			{
				Map<String, ?> keys = favPrefs.getAll();
				for(Map.Entry<String, ?> entry : keys.entrySet())
				{
					lst.add(entry.getKey());
				}
			}
			catch(NullPointerException nu)
			{
				
			}
			
			adapter = new ArrayAdapter<String>(this,R.layout.list_black_text,R.id.list_content, lst);
			lv.setAdapter(adapter);
			lv.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> adapter, View view,
						int position, long id) {
					Intent in = new Intent(GeneralListView.this, GeneralEventDetails.class);
					in.putExtra("fromwhereinfo", lst.get(position));
					startActivity(in);
				}
			});
		}
		
		// handling "Events" click
		if(getIntent().getExtras().getString("fromwhereinfo").equals("Build And Design")) 
		{
			ImageView iv=(ImageView) l.findViewById(R.id.cat_icon_head);
			iv.setImageResource(R.drawable.buildndesignh);
			db.openDatabase();
		final String ev[] = db.getEventNamesByCategory(getIntent().getExtras().getString("fromwhereinfo"));
			//Log.d("check", ev.length+"");
			adapter = new ArrayAdapter<String>(this,R.layout.list_black_text,R.id.list_content, ev);
			
			lv.setAdapter(adapter);
			lv.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> adapter, View view,
						int position, long id) {
					
					Intent in = new Intent(GeneralListView.this, GeneralEventDetails.class);
					in.putExtra("fromwhereinfo", ev[position]);
					startActivity(in);
				}
			});
		}		
		if(getIntent().getExtras().getString("fromwhereinfo").equals("Code & Simulate")) 
		{
			ImageView iv=(ImageView) l.findViewById(R.id.cat_icon_head);
			iv.setImageResource(R.drawable.codeh);
			db.openDatabase();
		final String ev[] = db.getEventNamesByCategory(getIntent().getExtras().getString("fromwhereinfo"));
			//Log.d("check", ev.length+"");
			adapter = new ArrayAdapter<String>(this,R.layout.list_black_text,R.id.list_content, ev);
			
			lv.setAdapter(adapter);
			lv.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> adapter, View view,
						int position, long id) {
					
					Intent in = new Intent(GeneralListView.this, GeneralEventDetails.class);
					in.putExtra("fromwhereinfo", ev[position]);
					startActivity(in);
				}
			});
		}
		// handling develop and discover events clicks
		if(getIntent().getExtras().getString("fromwhereinfo").equals("Develop & Discover")) 
		{
		db.openDatabase();
		ImageView iv=(ImageView) l.findViewById(R.id.cat_icon_head);
		iv.setImageResource(R.drawable.developh);
		final String ev[] = db.getEventNamesByCategory(getIntent().getExtras().getString("fromwhereinfo"));
			//Log.d("check", ev.length+"");
			adapter = new ArrayAdapter<String>(this,R.layout.list_black_text,R.id.list_content, ev);
			
			lv.setAdapter(adapter);
			lv.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> adapter, View view,
						int position, long id) {
					
					Intent in = new Intent(GeneralListView.this, GeneralEventDetails.class);
					in.putExtra("fromwhereinfo", ev[position]);
					startActivity(in);
				}
			});
		}
		// handling economania events clicks
		if(getIntent().getExtras().getString("fromwhereinfo").equals("Economania")) 
		{
		db.openDatabase();
		ImageView iv=(ImageView) l.findViewById(R.id.cat_icon_head);
		iv.setImageResource(R.drawable.economaniah);
		final String ev[] = db.getEventNamesByCategory(getIntent().getExtras().getString("fromwhereinfo"));
			//Log.d("check", ev.length+"");
			adapter = new ArrayAdapter<String>(this,R.layout.list_black_text,R.id.list_content, ev);
			
			lv.setAdapter(adapter);
			lv.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> adapter, View view,
						int position, long id) {
					
					Intent in = new Intent(GeneralListView.this, GeneralEventDetails.class);
					in.putExtra("fromwhereinfo", ev[position]);
					startActivity(in);
				}
			});
		}
		// handling water events clicks
		if(getIntent().getExtras().getString("fromwhereinfo").equals("ASME")) 
		{
		db.openDatabase();
		ImageView iv=(ImageView) l.findViewById(R.id.cat_icon_head);
		iv.setImageResource(R.drawable.asmeh);
		final String ev[] = db.getEventNamesByCategory(getIntent().getExtras().getString("fromwhereinfo"));
			//Log.d("check", ev.length+"");
			adapter = new ArrayAdapter<String>(this,R.layout.list_black_text,R.id.list_content, ev);
			
			lv.setAdapter(adapter);
			lv.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> adapter, View view,
						int position, long id) {
					
					Intent in = new Intent(GeneralListView.this, GeneralEventDetails.class);
					in.putExtra("fromwhereinfo", ev[position]);
					startActivity(in);
				}
			});
		}
		// handling earth events clicks
		if(getIntent().getExtras().getString("fromwhereinfo").equals("Miscellaneous")) 
		{
		db.openDatabase();
		ImageView iv=(ImageView) l.findViewById(R.id.cat_icon_head);
		iv.setImageResource(R.drawable.miscellaneoush);
		final String ev[] = db.getEventNamesByCategory(getIntent().getExtras().getString("fromwhereinfo"));
			//Log.d("check", ev.length+"");
			adapter = new ArrayAdapter<String>(this,R.layout.list_black_text,R.id.list_content, ev);
			
			lv.setAdapter(adapter);
			lv.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> adapter, View view,
						int position, long id) {
					
					Intent in = new Intent(GeneralListView.this, GeneralEventDetails.class);
					in.putExtra("fromwhereinfo", ev[position]);
					startActivity(in);
				}
			});
		}		// handling ether events clicks
		
		
		if(getIntent().getExtras().getString("fromwhereinfo").equals("Online Events")) 
		{
		db.openDatabase();
		ImageView iv=(ImageView) l.findViewById(R.id.cat_icon_head);
		iv.setImageResource(R.drawable.onlineh);
		final String ev[] = db.getEventNamesByCategory(getIntent().getExtras().getString("fromwhereinfo"));
			//Log.d("check", ev.length+"");
			adapter = new ArrayAdapter<String>(this,R.layout.list_black_text,R.id.list_content, ev);
			
			lv.setAdapter(adapter);
			lv.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> adapter, View view,
						int position, long id) {
					
					Intent in = new Intent(GeneralListView.this, GeneralEventDetails.class);
					in.putExtra("fromwhereinfo", ev[position]);
					startActivity(in);
				}
			});
		}
		// handling art events clicks
		if(getIntent().getExtras().getString("fromwhereinfo").equals("Papers & Projects"))
		{
		db.openDatabase();
		ImageView iv=(ImageView) l.findViewById(R.id.cat_icon_head);
		iv.setImageResource(R.drawable.papersh);
		final String ev[] = db.getEventNamesByCategory(getIntent().getExtras().getString("fromwhereinfo"));
			//Log.d("check", ev.length+"");
			adapter = new ArrayAdapter<String>(this,R.layout.list_black_text,R.id.list_content, ev);
			
			lv.setAdapter(adapter);
			lv.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> adapter, View view,
						int position, long id) {
					
					Intent in = new Intent(GeneralListView.this, GeneralEventDetails.class);
					in.putExtra("fromwhereinfo", ev[position]);
					startActivity(in);
				}
			});
		}// handling dance events clicks
		if(getIntent().getExtras().getString("fromwhereinfo").equals("Quizzes")) {
			ImageView iv=(ImageView) l.findViewById(R.id.cat_icon_head);
			iv.setImageResource(R.drawable.quizzesh);
				db.openDatabase();
				final String ev[] = db.getEventNamesByCategory(getIntent().getExtras().getString("fromwhereinfo"));
					//Log.d("check", ev.length+"");
					adapter = new ArrayAdapter<String>(this,R.layout.list_black_text,R.id.list_content, ev);
					
					lv.setAdapter(adapter);
					lv.setOnItemClickListener(new OnItemClickListener() {
						@Override
						public void onItemClick(AdapterView<?> adapter, View view,
								int position, long id) {
							
							Intent in = new Intent(GeneralListView.this, GeneralEventDetails.class);
							in.putExtra("fromwhereinfo", ev[position]);
							startActivity(in);
						}
					});
				}
		// handling drama events clicks
		if(getIntent().getExtras().getString("fromwhereinfo").equals("Workshops")) {
			
				db.openDatabase();
				ImageView iv=(ImageView) l.findViewById(R.id.cat_icon_head);
				iv.setImageResource(R.drawable.workshopsh);
				final String ev[] = db.getEventNamesByCategory(getIntent().getExtras().getString("fromwhereinfo"));
					//Log.d("check", ev.length+"");
					adapter = new ArrayAdapter<String>(this,R.layout.list_black_text,R.id.list_content, ev);
					
					lv.setAdapter(adapter);
					lv.setOnItemClickListener(new OnItemClickListener() {
						@Override
						public void onItemClick(AdapterView<?> adapter, View view,
								int position, long id) {
							
							Intent in = new Intent(GeneralListView.this, GeneralEventDetails.class);
							in.putExtra("fromwhereinfo", ev[position]);
							startActivity(in);
						}
					});
				}
		if(getIntent().getExtras().getString("fromwhereinfo").equals("AIC")) 		{
			db.openDatabase();
			ImageView iv=(ImageView) l.findViewById(R.id.cat_icon_head);
			iv.setImageResource(R.drawable.aich);
			final String ev[] = db.getEventNamesByCategory(getIntent().getExtras().getString("fromwhereinfo"));
				//Log.d("check", ev.length+"");
				adapter = new ArrayAdapter<String>(this,R.layout.list_black_text,R.id.list_content, ev);
				
				lv.setAdapter(adapter);
				lv.setOnItemClickListener(new OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> adapter, View view,
							int position, long id) {
						
						Intent in = new Intent(GeneralListView.this, GeneralEventDetails.class);
						in.putExtra("fromwhereinfo", ev[position]);
						startActivity(in);
					}
				});
			}
		
		if(getIntent().getExtras().getString("fromwhereinfo").equals("Kernel Events"))
		{
			ImageView iv=(ImageView) l.findViewById(R.id.cat_icon_head);
			iv.setImageResource(R.drawable.kernelh);
			
			final String ev[]={"iStrike","SMS","Full Throttle Grand Prix","International Coding League","Dhiti","Robots at War"};
			adapter = new ArrayAdapter<String>(this,R.layout.list_black_text,R.id.list_content, ev);
			lv.setAdapter(adapter);
			lv.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> adapter, View view,
						int position, long id) {
					
					Intent in = new Intent(GeneralListView.this, GeneralEventDetails.class);
					in.putExtra("fromwhereinfo", ev[position]);
					startActivity(in);
				}
			});
		}
		if(getIntent().getExtras().getString("fromwhereinfo").equals("Event of the Day"))
		{
			ImageView iv=(ImageView) l.findViewById(R.id.cat_icon_head);
			iv.setImageResource(R.drawable.eotdh);
			
			final String ev[]={"28th Hackathon","29th iStrike","30th SMS","31st Checkmate"};
			final String ev2[]={"Hackathon","iStrike","SMS","Checkmate"};
			adapter = new ArrayAdapter<String>(this,R.layout.list_black_text,R.id.list_content, ev);
			lv.setAdapter(adapter);
			lv.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> adapter, View view,
						int position, long id) {
					
					Intent in = new Intent(GeneralListView.this, GeneralEventDetails.class);
					in.putExtra("fromwhereinfo", ev2[position]);
					startActivity(in);
				}
			});
		}
		

		
		
		setContentView(l);
	}
}



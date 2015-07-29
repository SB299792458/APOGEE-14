package org.dvm.apogee2k14;
import java.util.ArrayList;
import java.util.HashMap;

import org.dvm.apogee2k14.R;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

public class Social_fb extends Activity implements OnClickListener {

	Button fb,youtube,twitter,apogee;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_social_fb);
		
		fb=(Button) findViewById(R.id.button4);
		youtube=(Button) findViewById(R.id.button1);
		twitter=(Button) findViewById(R.id.button3);
		apogee=(Button) findViewById(R.id.button2);
		
		fb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Uri u = Uri.parse("http://www.facebook.com/apogee");
				Intent in = new Intent(Intent.ACTION_VIEW,u);
				startActivity(in); 
			}
		});
		
	youtube.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Uri u = Uri.parse("https://www.youtube.com/watch?v=OO7y603jXRw");
			Intent in = new Intent(Intent.ACTION_VIEW,u);
			startActivity(in); 
		}
	});
		twitter.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Uri u = Uri.parse("http://twitter.com/BITSApogee");
			Intent in = new Intent(Intent.ACTION_VIEW,u);
			startActivity(in); 
		}
	});
		apogee.setOnClickListener(new OnClickListener() {
			
		@Override
		public void onClick(View v) {
			Uri u = Uri.parse("http://bits-apogee.org/");
			Intent in = new Intent(Intent.ACTION_VIEW,u);
			startActivity(in); 
		}
	});	

	
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	
}

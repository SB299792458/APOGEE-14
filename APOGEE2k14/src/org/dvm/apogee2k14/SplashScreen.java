package org.dvm.apogee2k14;

import org.dvm.apogee2k14.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends Activity 
{
	public static DBAccess db ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splashscreen);
		
		final Intent gotoMain = new Intent(SplashScreen.this, MainScreen.class);
	//	final Intent checkDB = new Intent(SplashScreen.this, ApogeeJSONParser.class);
	//	final Intent parser = new Intent(SplashScreen.this, ApogeeJSONParser.class);
	//	parser.putExtra("whicheventinfo", "checkmate");
		Thread splash = new Thread(){
			public void run(){
				try{
					sleep(3000);
				}
				catch(InterruptedException ii){
					//ii.printStackTrace();
				}
				finally{
			startActivity(gotoMain);
		//	startActivity(parser);
				}
			}
		};
		splash.start();
	}
	
	@Override
	protected void onPause()
	{
		super.onPause();
		finish();
	}
}

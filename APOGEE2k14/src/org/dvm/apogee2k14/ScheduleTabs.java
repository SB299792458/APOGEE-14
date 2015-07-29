package org.dvm.apogee2k14;

import org.dvm.apogee2k14.R;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class ScheduleTabs extends TabActivity 
{
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_tabs);
        
        TabHost tabHost = getTabHost();
        
        TabSpec tabs[] = new TabSpec[5];
        Intent ints[] = new Intent[5];
        int i;
        for(i=0;i<5;i++)
        {
        	tabs[i]= tabHost.newTabSpec("" + (i + 24) + "/10");
        	tabs[i].setIndicator("" + (i + 24) + "/10");
        	ints[i] = new Intent(ScheduleTabs.this, ScheduleActivity.class);
        	ints[i].putExtra("dayValue", "" + (i + 24) + "/10");
        	tabs[i].setContent(ints[i]);
        	tabHost.addTab(tabs[i]);
        }
	}
	/*
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
	  // ignore orientation/keyboard change
	  super.onConfigurationChanged(newConfig);
	}*/
}


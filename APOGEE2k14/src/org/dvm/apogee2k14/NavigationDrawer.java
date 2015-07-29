
package org.dvm.apogee2k14;
import java.util.Locale;

import org.dvm.apogee2k14.R;



import android.app.ListActivity;
//import android.app.Activity;
//import android.app.Fragment;
//import android.app.FragmentManager;
import android.app.SearchManager;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
//import android.support.v4.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
//import android.widget.TextView;
import android.widget.Toast;

public class NavigationDrawer extends ListActivity {
 //   private ItemsAdapter adapter;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
       // storing string resources into Array
        String[] adobe_products = getResources().getStringArray(R.array.eventcategories);
         
        // Binding resources Array to ListAdapter
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.label, adobe_products));
         
        ListView lv = getListView();
 
        // listening to single list item on click
        lv.setOnItemClickListener(new OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View view,
              int position, long id) {
               
              // selected item 
              String product = ((TextView) view).getText().toString();                           
            Intent in = new Intent(NavigationDrawer.this, GeneralListView.class);
      		in.putExtra("fromwhereinfo", product);
      		startActivity(in);
             
          }
        });
    }
}


/*package com.example.apogee2k14;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.example.apogee2k14.R;


import android.app.ListActivity;
//import android.app.Activity;
//import android.app.Fragment;
//import android.app.FragmentManager;
import android.app.SearchManager;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
//import android.support.v4.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
//import android.widget.TextView;
import android.widget.Toast;

public class NavigationDrawer extends ListActivity {
 //   private ItemsAdapter adapter;
	private Integer[] mThumbIds3 = {
            R.drawable.automation , R.drawable.builddesign,
            R.drawable.codesimulate, R.drawable.developdiscover,
            R.drawable.economania, R.drawable.asme, R.drawable.aic,
            R.drawable.miscellaneous, R.drawable.onlineevents,
            R.drawable.papersprojects, R.drawable.quiz,
            R.drawable.workshops
               };
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_planet);
        // storing string resources into Array
        String[] categories = getResources().getStringArray(R.array.eventcategories);
        ListView listView;
        getListView().setCacheColorHint(0);
        List<NavRow> rowItems;

        // Binding resources Array to ListAdapter
      //  this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.label, adobe_products));
      //  this.setListAdapter(new ArrayAdapter<Integer>(this, R.layout.list_item, R.id.categoryImage, mThumbIds3));
        rowItems = new ArrayList<NavRow>();
        for (int i = 0; i < categories.length; i++) {
        NavRow item = new NavRow(mThumbIds3[i], categories[i]);
        rowItems.add(item);
        }
       
       listView = (ListView) findViewById(R.id.list2);
       CustomListViewAdapter adapter = new CustomListViewAdapter(this, R.layout.img_row_layout, rowItems);
       listView.setAdapter(adapter);
 
       
      // ListView lv = getListView();

       // listening to single list item on click
      listView.setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView<?> parent, View view,
             int position, long id) {
              
             // selected item 
             String product = ((TextView) view).getText().toString();                           
           Intent in = new Intent(NavigationDrawer.this, GeneralListView.class);
     		in.putExtra("fromwhereinfo", product);
     		startActivity(in);
            
         }
       });
       
       
       //   listView.setOnItemClickListener(this);
       }
        @Override
       public void onItemClick(AdapterView<?> parent, View view, int position,
        long id) {
            // selected item 
            String product = ((TextView) view).getText().toString();                           
          Intent in = new Intent(NavigationDrawer.this, GeneralListView.class);
    		in.putExtra("fromwhereinfo", product);
    		startActivity(in);
            }

 
    }
*/
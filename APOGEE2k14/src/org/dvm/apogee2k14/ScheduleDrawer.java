package org.dvm.apogee2k14;

import org.dvm.apogee2k14.R;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ScheduleDrawer extends ListActivity{
//  private ItemsAdapter adapter;

	@Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       
      // storing string resources into Array
       final String[] adobe_products = getResources().getStringArray(R.array.days);
       // Binding resources Array to ListAdapter
       this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.label, adobe_products));
        
       ListView lv = getListView();

       // listening to single list item on click
       lv.setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView<?> parent, View view,
             int position, long id) {
              
             // selected item 
          //   String product = ((TextView) view).getText().toString();                           
           Log.d("exception", "sfsfsfsfsffgs"+ adobe_products[position]);
             
             Intent in = new Intent(ScheduleDrawer.this, ScheduleActivity.class);
     		in.putExtra("dayValue",  adobe_products[position]);
     		startActivity(in);
            
         }
       });

	}
}

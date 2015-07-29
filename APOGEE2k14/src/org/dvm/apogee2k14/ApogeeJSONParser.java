package org.dvm.apogee2k14;

import java.util.ArrayList;
import java.util.HashMap;

import org.dvm.apogee2k14.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class ApogeeJSONParser extends Activity {
	 
	    private ProgressDialog pDialog;
	    // String str=getIntent().getExtras().getString("whicheventinfo");
	    // URL to get contacts JSON
	    private  String url = "http://bits-apogee.org/2014/getcontent/?even=checkmate";
	 
	    // JSON Node names
		//private static final String TAG_USER = "user";
		private static final String TAG_ID = "id";
		private static final String TAG_NAME = "name";
		//private static final String TAG_EMAIL = "email";
		
		
		private static final String TAG_CATEGORY = "category";
		private static final String TAG_OVERVIEW = "overview";
		private static final String TAG_ETIME = "endingtime";
		private static final String TAG_VENUE = "venue";
		private static final String TAG_STIME = "startingtime";
		private static final String TAG_DATE = "date";
		private static final String TAG_TABNAMES = "tabNames";
		private static final String TAG_TABCONT = "tabContent";
		String tab_names[]={};
		String tab_content[]={};
		//private static final String TAG_ID="id";
		public TextView tv;
	    // contacts JSONArray
	    JSONArray cont = null;
	 
	    // Hashmap for ListView
	    ArrayList<HashMap<String, String>> contactList;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv= (TextView)findViewById(R.id.textView1);
		new GetContacts().execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	private class GetContacts extends AsyncTask<Void, Void, Void> {
		 
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(ApogeeJSONParser.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
 
        }
 
        @Override
        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();
 
            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);
 
            //Log.d("Response: ", "> " + jsonStr);
            //tv.setText(jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    
                    // Getting JSON Array node
                    //cont = jsonObj.getJSONArray(TAG_CONTACTS);
                    
        /*            
                    
                    Log.d("Category: ", "> " + jsonObj.getString(TAG_CATEGORY));
                    Log.d("Name: ", "> " + jsonObj.getString(TAG_NAME));*/
                    JSONArray tabNames = jsonObj.getJSONArray(TAG_TABNAMES);
                    JSONArray tabContent= jsonObj.getJSONArray(TAG_TABCONT);
                    Log.d("tabnames", "> " + tabNames.getString(0));
                    
                    //returned event id
                    int rid=jsonObj.getInt(TAG_ID);
                    String rname=jsonObj.getString(TAG_NAME);
                    
                    Information inf=new Information();
                    int k=tabNames.length();
                    for (int l=0;l<k;l++){
                    	tab_names[l]=tabNames.getString(l);
                    	tab_content[l]=tabContent.getString(l);
                    	
                    	
                    	
                    }
                    inf.setTabName(tab_names);
                    inf.setTabContent(tab_content);
                    inf.setId(Integer.parseInt(jsonObj.getString(TAG_ID)));
                    inf.setName(jsonObj.getString(TAG_NAME));   
                    inf.setCategory(jsonObj.getString(TAG_CATEGORY));
                    inf.setDate(jsonObj.getString(TAG_DATE));
                    inf.setVenue(jsonObj.getString(TAG_VENUE));
                    inf.setSTime(jsonObj.getString(TAG_STIME));
                    inf.setETime(jsonObj.getString(TAG_ETIME));
                    inf.setOverview(jsonObj.getString(TAG_OVERVIEW));
                                 
                    
                    DB db= new DB( ApogeeJSONParser.this );
                    db.create(inf);
                    
                    
                    
       
					
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }
 
            return null;
        }
 
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
  
        }
 

	}
	
}


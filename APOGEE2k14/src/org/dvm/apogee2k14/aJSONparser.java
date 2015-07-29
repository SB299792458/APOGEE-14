package org.dvm.apogee2k14;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import android.widget.TextView;

public class aJSONparser{
	
	
	 private  String url = "http://bits-apogee.org/2014/getcontent/?even=checkmate";

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
		String tab_names[]=null;
		String tab_content[]=null;
		//private static final String TAG_ID="id";
		public TextView tv;
	    // contacts JSONArray
	    JSONArray cont = null;
	 
	    // Hashmap for ListView
	    ArrayList<HashMap<String, String>> contactList;
	
      public void parseIT() {
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
                  tab_names=new String[k];
                  tab_content=new String[k];
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
                 // Log.v("cz","i am here db init "+ inf.getVenue());
                  (SplashScreen.db).updateInformation(inf);
                  Log.d("exception", "edwefsefsfasfa");
                 // (SplashScreen.db).updateOTHERS(inf);
                
                //  Log.v("cz","i am here db init "+ inf.getVenue());
                  
                //  db.closeDataBase();
                  
					
              } catch (JSONException e) {
                  e.printStackTrace();
              }
          } else {
              Log.e("ServiceHandler", "Couldn't get any data from the url");
          }
      }
}
      
      

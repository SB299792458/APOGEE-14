package org.dvm.apogee2k14;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAccess extends SQLiteOpenHelper
{

      private SQLiteDatabase dbS;
      private SQLiteDatabase dbR;
      //private SQLiteDatabase db2;
      //private SQLiteDatabase db3;
      
      private final Context myContext;
      private static final String DATABASE_NAME = "apogee2014.db";
      public final static String DATABASE_PATH ="/data/data/org.dvm.apogee2k14/databases/";
      public static final int DATABASE_VERSION = 1;
      
  	public static final String ID = "id";
  	public static final String NAME = "name";
  	public static final String CATEGORY = "category";
  	public static final String OVERVIEW = "overview";
  	public static final String CONTACTS = "contacts";
  	public static final String MAX_PARTICIPANTS = "max_participants";
  	public static final String DATE = "date";
  	public static final String STIME = "stime";
  	public static final String ETIME = "etime";
  	public static final String VENUE = "venue";
  	public static final String H_ID = "heading_id";
  	public static final String CONTENT = "content";
  	public static final String E_ID = "event_id";
      private static final String EVENTS_TABLE = "events_table";
      private static final String EVENTS_TABS = "events_tabs";
      private static final String EVENTS_HEADING = "events_heading";
      private static final String EVENTS_CAT_ID = "events_cat_id";
      
      //Constructor
      public DBAccess(Context context)
      {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.myContext = context;
      }
      

      //Create a empty database on the system
      public void createDatabase() throws IOException
      {

    	  	Log.d("check", "in create db");
            boolean dbExist = checkDataBase();

            if(dbExist)
            {
                  Log.v("DB Exists", "db exists");
            }
           
            boolean dbExist1 = checkDataBase();
            if(!dbExist1)
            {
                  this.getReadableDatabase();
                  try
                  {
                        this.close();    
                        copyDataBase();
                  }
                  catch (IOException e)
                  {
                        throw new Error("Error copying database");
                  }
            }

      }

      //Check database already exist or not
      private boolean checkDataBase()
      {
            boolean checkDB = false;
            try
            {
                  String myPath = DATABASE_PATH + DATABASE_NAME;
                  File dbfile = new File(myPath);
                  checkDB = dbfile.exists();
            }
            catch(SQLiteException e)
            {
            }
            return checkDB;
      }

      //Copies your database from your local assets-folder to the just created empty database in the system folder
      private void copyDataBase() throws IOException
      {

            String outFileName = DATABASE_PATH + DATABASE_NAME;

            OutputStream myOutput = new FileOutputStream(outFileName);
            InputStream myInput = myContext.getAssets().open(DATABASE_NAME);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0)
            {
                  myOutput.write(buffer, 0, length);
            }
            myInput.close();
            myOutput.flush();
            myOutput.close();
      }

      //delete database
      public void db_delete()
      {
            File file = new File(DATABASE_PATH + DATABASE_NAME);
            if(file.exists())
            {
                  file.delete();
                  System.out.println("delete database file.");
            }
      }

      //Open database
      public void openDatabase() throws SQLException
      {
            String myPath = DATABASE_PATH + DATABASE_NAME;
            dbS = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
      }

      public synchronized void closeDataBase()throws SQLException
      {
            if(dbS != null)
                  dbS.close();
            super.close();
      }

      public void onCreate(SQLiteDatabase db)
      {
      }

      public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
      {    
            /*if (newVersion > oldVersion)
            {
                  Log.v("Database Upgrade", "Database version higher than old.");
                  db_delete();
            }*/
      }
     

public String[] getEventNamesByDate(String date)
{
	dbR =this.getReadableDatabase();
	String events[]=null;
	Cursor cu1=null;
	
	String dateInp= date ; 
	
	Log.d("exception", "ada "+dateInp);
	try{
	cu1=dbR.rawQuery("SELECT name FROM events_table WHERE date=?" , new String[] {dateInp + "" } );
	cu1.moveToFirst();
	int j=cu1.getCount(), l=0;
	Log.d("exception", "ada"+j);
	if(j>0)
	{
	events=new String[j];
	do{
		events[l]=cu1.getString(cu1.getColumnIndex("name"));
		l++;
	}while(cu1.moveToNext());
	}	
	else{
	events=null;
	}
	}catch(Exception ee){
		Log.d("exception", ee.getMessage()); 
	}finally
	{
	cu1.close();
	}
	return events;
	
}

 //add your public methods for insert, get, delete and update data in database.	
	public String[] getEventNamesByCategory(String name)
    {    	dbS =this.getReadableDatabase();
        	Cursor cursor4=null,cursor5 =null;
        	int j=0,k=0,l=0;
        	String ename[] = null;
        	try {
        		cursor4 =dbS.rawQuery("SELECT id FROM events_cat_id WHERE name=?", new String[] {name + ""});
    			cursor4.moveToFirst();
    			k = cursor4.getInt(cursor4.getColumnIndex("id"));
    			cursor5 =dbS.rawQuery("SELECT name FROM events_table WHERE category=?", new String[] {k + ""});
    			j=cursor5.getCount();
    			ename = new String[j];
    			 while (cursor5.moveToNext()) {
    				 ename[l] = cursor5.getString(cursor5.getColumnIndex("name")); 
    				 Log.d("events", ename[l]);
    			l++;
    			 }
        	}
    			 catch(Exception ee)
    			 {
    				Log.d("exception", ee.getMessage()); 
    			 }finally {
    	             cursor4.close();
    	             cursor5.close();
    	            }return ename;
    
}
	  public int updateInformation(Information Einformation) {
	        Log.d("exception", "query");
	        // this.getWritableDatabase();
	        ContentValues values = new ContentValues();
	        values.put(ID, Einformation.getId());
	        values.put(NAME, Einformation.getName());
	        values.put(DATE, Einformation.getDate());
	        values.put(CATEGORY, Einformation.getCategory());
	        values.put(VENUE, Einformation.getVenue());
	        values.put(STIME, Einformation.getSTime());
	        values.put(ETIME, Einformation.getETime());
	        values.put(OVERVIEW, Einformation.getOverview());
	        // updating row
	        String q="\"";
	        String w=" \\\" ";
	        String over= Einformation.getOverview().replaceAll(q,w);
	        String query = " UPDATE events_table SET id='" + Einformation.getId() + "' , name='" + Einformation.getName() + "' , date='" + Einformation.getDate() + "' , overview='" + over + "' , venue='" + Einformation.getVenue() + "' , stime='" + Einformation.getSTime() + "' , etime='" + Einformation.getETime() + "' WHERE id='" + Einformation.getId()+"' ";
	        Log.d("exception", over);
	        this.getWritableDatabase().execSQL(query); 
	   //   int result =db3.update(EVENTS_TABLE, values, ID + " = ?",new String[] { String.valueOf(Einformation.getId()) });
	        
	        
	        int limit=Einformation.gettab_content().length;
			  int temp[]=new int[limit];
			  Log.d("exception","qqqqqqqqqqqqq");  
			  Cursor c2=null;
			  
			  for(int i=0;i<temp.length;i++)
			  {
			  Log.d("exception","qqqqqqqqqqqqq" + Einformation.gettab_content()[i]);   
			  c2=dbS.rawQuery("SELECT * FROM events_heading WHERE name=?", new String[]{ Einformation.gettab_content()[i]});
			  c2.moveToFirst();
			  temp[i]=c2.getInt(c2.getColumnIndex("id"));
			  Log.d("exception", temp[i]+"");
			  
			  c2.close();
			  
			  }

			  Cursor c1=dbS.rawQuery("SELECT * FROM events_tabs WHERE event_id=?",  new String[] {Einformation.getId() + ""});
			  c1.moveToFirst();
			  
			  
			  // int j=c1.getCount();
			  int l=0;
				 do {
					 	String q2="\"";
				        String w2=" \\\" ";
				        String content= (Einformation.gettab_name())[l].replaceAll(q2,w2);
				        String query2 = " UPDATE events_tabs SET content='" + content + "' WHERE heading_id='" + temp[l] +"' and event_id='"+Einformation.getId()+"' ";
				        Log.d("exception", query2);
						
				        this.getWritableDatabase().execSQL(query2); 
				        l++;
				 
				 }while (c1.moveToNext());
			  
			  c1.close();

	        
	        
	        
	    //  db3.close();
	        return 1;
	      }
	
	  
	  public int updateOTHERS(Information Einformation)
	  {
		  
		  		  return 1;
	  }
//getting data regarding events from 
	public Information getEventsTableData(String name)
    {    	dbS =this.getReadableDatabase();
        	Cursor cursor4=null;
        	  	
        	Information eventInfo=null;
        		
        		String query = new String( "SELECT * FROM "+"events_table"
        			    +" WHERE name ='"+name+"'" );
        		   cursor4 = dbS.rawQuery( query, null );

        		  if(cursor4.moveToFirst())
        		  {

          			eventInfo = new Information();
          			
          			
          		    eventInfo.setId(Integer.parseInt(cursor4.getString(cursor4.getColumnIndex("id"))));
          		    eventInfo.setName(cursor4.getString(cursor4.getColumnIndex("name")));
          		    eventInfo.setCategory(cursor4.getString(cursor4.getColumnIndex("category")));
          		    eventInfo.setOverview(cursor4.getString(cursor4.getColumnIndex("overview")));
          		    eventInfo.setDate(cursor4.getString(cursor4.getColumnIndex("date")));
          		    eventInfo.setSTime(cursor4.getString(cursor4.getColumnIndex("stime")));
          		    eventInfo.setETime(cursor4.getString(cursor4.getColumnIndex("etime")));
          		    eventInfo.setVenue(cursor4.getString(cursor4.getColumnIndex("venue")));
          			
          		    Log.v("CZ","i was here ..." + eventInfo.getDate());
          		
        		  }
        		  cursor4.close();
        		
        		
        	    dbS.close();
        	return eventInfo;
    
}	

	//getting data regarding different tab headings and their values
	
	public Information getEventTabsByName(String name)
    {    	dbS =this.getReadableDatabase();
        	Cursor cursor4=null,cursor5 =null, cursor6=null;
        	int j=0,k=0,l=0;
        	Information moreInfo=new Information();
        	String ename[] = null;
        	String hname[]=null;
        	int hnameT=0;
        Log.v("present","I was here 2");
        	try {
        		cursor4 =dbS.rawQuery("SELECT id FROM events_table WHERE name=?", new String[] {name + ""});
    			cursor4.moveToFirst();
    			k = cursor4.getInt(cursor4.getColumnIndex("id"));
    			cursor5 =dbS.rawQuery("SELECT * FROM events_tabs WHERE event_id=?", new String[] {k + ""});
    			cursor5.moveToFirst();
    			j=cursor5.getCount();
    			ename = new String[j];
    			hname= new String[j];
    			Log.d("exception", "bfore while");
    			 do{
    				 hnameT=cursor5.getInt(cursor5.getColumnIndex("heading_id"));
    				 ename[l] = cursor5.getString(cursor5.getColumnIndex("content")); 
    			
    				 cursor6 =dbS.rawQuery("SELECT * FROM events_heading WHERE id=?", new String[] {hnameT + ""});
    				 cursor6.moveToFirst();
    	    		 hname[l]=cursor6.getString(cursor6.getColumnIndex("name"));
    	    		 Log.d("exception", "helooooo");
    				 Log.d("events", hname[l]+ "\n"+ename[l]);
    				   cursor6.close();
       				
    				 l++;
    			 }while(cursor5.moveToNext());
    			 
    			 moreInfo.setmore(hname, ename);
        	}
    			 catch(Exception ee)
    			 {
    				Log.d("exception", ee.getMessage()); 
    			 }finally {
    				 
    	             cursor4.close();
    	             cursor5.close();
    	              
    			 }
        	
        	dbS.close();
        	return moreInfo;
    
}


}

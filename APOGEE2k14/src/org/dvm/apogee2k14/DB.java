package org.dvm.apogee2k14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DB extends SQLiteOpenHelper {

	public static final String DATABASE_NAME = "apogee2014.db";
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

    public DB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("check", "here1");
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
    	Log.d("check", "here2");
    	 final String CREATE_EVENTS_TABLE = "CREATE TABLE "
    			+ EVENTS_TABLE
    			+ "("
    			+ ID
    			+ " INTEGER NOT NULL, "
    			+ NAME
    			+ " TEXT NOT NULL, "
    			+ CATEGORY
    			+ " TEXT, "
    			+ OVERVIEW
    			+ " TEXT, "
    			+ DATE
    			+ " TEXT, "
    			+ STIME
    			+ " TEXT, "
                + ETIME
    			+ " TEXT, "
    			+ VENUE
    			+ " TEXT "
    			+ ")";
     // db.execSQL(CREATE_EVENTS_TABLE);
      
      final String CREATE_EVENTS_HEADING = "CREATE TABLE "
    		+ EVENTS_HEADING
  			+ "("
  			+ ID
  			+ " INTEGER NOT NULL, "
  			+ NAME
  			+ " TEXT NOT NULL "
  			+ ")";
      final String CREATE_EVENTS_TABS = "CREATE TABLE "
      		+ EVENTS_TABS
    			+ "("
    			+ ID
    			+ " INTEGER NOT NULL, "
    			+ H_ID
    			+ " TEXT NOT NULL, "
    			+ CONTENT
    			+ " TEXT NOT NULL, "
    			+ E_ID
    			+ " TEXT NOT NULL "
    			+ ")";
      final String CREATE_EVENTS_CAT = "CREATE TABLE "
      		+ EVENTS_CAT_ID
    			+ "("
    			+ ID
    			+ " INTEGER NOT NULL, "
    			+ NAME
    			+ " TEXT NOT NULL "
    			+ ")";
    db.execSQL(CREATE_EVENTS_TABLE);
    db.execSQL(CREATE_EVENTS_HEADING);
    db.execSQL(CREATE_EVENTS_TABS);
    db.execSQL(CREATE_EVENTS_CAT);
    Log.d("check", "here");
    
/*    db.execSQL(" INSERT INTO 'events_cat_id'  SELECT 3 AS 'id',  'Home' AS 'name' UNION SELECT 4 ,  'Build And Design' UNION SELECT 5 ,  'Papers & Projects' UNION SELECT 6 ,  'Online Events' UNION SELECT 7 ,  'Workshops' UNION SELECT 8 ,  'Miscellaneous' UNION SELECT 9 ,  'Guest Lectures' UNION SELECT 10 ,  'Economania' UNION SELECT 11 ,  'Develop & Discover' UNION SELECT 12 ,  'Code & Simulate' UNION SELECT 13 ,  'Automation' UNION SELECT 14 ,  'Quizzes' UNION SELECT 15 ,  'ASME SPDC' UNION SELECT 16 ,  'ASME' UNION SELECT 17 ,  'AIC' UNION SELECT 18 ,  'Civil' UNION SELECT 19 ,  'Mechanical/Manufacturing' UNION SELECT 20 ,  'EEE/ENI' UNION SELECT 21 ,  'CS/IS' UNION SELECT 22 ,  'Economics/Finance' UNION SELECT 23 ,  'Chemical' ;");
    db.execSQL(" INSERT INTO 'events_heading'  SELECT 3 AS 'id',  'How To Reach Pilani' AS 'name' UNION SELECT 4 ,  'FAQs' UNION SELECT 5 ,  'Accomodation' UNION SELECT 6 ,  'Workshop Payment' UNION SELECT 7 ,  'Schedule' UNION SELECT 8 ,  'Certificates' UNION SELECT 9 ,  'Prize Money' UNION SELECT 10 ,  'Problem Statement' UNION SELECT 11 ,  'Results' UNION SELECT 12 ,  'Syllabus' UNION SELECT 13 ,  'Eligibility' UNION SELECT 14 ,  'Rules' UNION SELECT 15 ,  'Judging Criteria' UNION SELECT 16 ,  'Resources' UNION SELECT 17 ,  'On Campus Registration' UNION SELECT 18 ,  'Sample Questions' UNION SELECT 19 ,  'Materials' UNION SELECT 21 ,  'Guidelines' UNION SELECT 22 ,  'Event Structure' UNION SELECT 23 ,  'Registration Details' UNION SELECT 24 ,  'Categories' UNION SELECT 25 ,  'Event Sponsor' UNION SELECT 26 ,  'links' ;");
   
	String res="";
	int c=0;
	String line="";
	String[] queries=new String[100];
	try
	{
	BufferedReader bf=new BufferedReader(new FileReader("C:/Users/shikhar/Desktop/stage2.txt"));
	line=bf.readLine();		
	while((line=bf.readLine())!=null)
{
		res="INSERT INTO 'events_tabs' ('id', 'heading_id', 'content', 'event_id') VALUES " +"( "+ line +" );";			
		queries[c]=res;
		c++;		
}
for(int i=0;i<queries.length;i++)
	db.execSQL(queries[i]);
bf.close( );
	}
	catch(Exception ee)
	{
		Log.d("exception", ee.getMessage());
	}*/
   }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
         db.execSQL("DROP TABLE IF EXISTS " + EVENTS_TABLE);
         db.execSQL("DROP TABLE IF EXISTS " + EVENTS_HEADING);
         db.execSQL("DROP TABLE IF EXISTS " + EVENTS_TABS);
         db.execSQL("DROP TABLE IF EXISTS " + EVENTS_CAT_ID);

            // Create tables again
            onCreate(db);
    }
    public boolean create(Information information) {

        boolean createSuccessful = false;

        ContentValues values = new ContentValues();
        values.put(ID, information.getId());
        values.put(NAME, information.getName());
        values.put(DATE, information.getDate());
        values.put(CATEGORY, information.getCategory());
        values.put(VENUE, information.getVenue());
        values.put(STIME, information.getSTime());
        values.put(ETIME, information.getETime());
        values.put(OVERVIEW, information.getOverview());
        SQLiteDatabase db = this.getWritableDatabase();

     //   createSuccessful = db.insert(EVENTS_TABLE, null, values) > 0;
        db.close();

      //  return createSuccessful;
    return true;
    }

  public int updateInformation(Information Einformation) {
        SQLiteDatabase db = this.getWritableDatabase();
 
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
        return db.update(EVENTS_TABLE, values, ID + " = ?",
                new String[] { String.valueOf(Einformation.getId()) });
    }
    
    
 /*   public String[] getEventNamesByCategory(String name)
    {    	SQLiteDatabase db =this.getReadableDatabase();
        	Cursor cursor4=null,cursor5 =null;
        	int j=0,k=0,l=0;
        	String ename[]={};
        	try {
        		cursor4 =db.rawQuery("SELECT id FROM events_cat_id WHERE name=?", new String[] {name + ""});
    			cursor4.moveToFirst();
    			k = cursor4.getInt(cursor4.getColumnIndex("id"));
    			cursor5 =db.rawQuery("SELECT name FROM events_table WHERE category_id=?", new String[] {k + ""});
    			j=cursor5.getCount();
    			 while (cursor5.moveToNext()) {
    				 ename[l] = cursor5.getString(cursor5.getColumnIndex("name")); 
    			l++;
    			 }}finally {
    	             cursor4.close();
    	             cursor5.close();
    	            }return ename;
    
}*/
}
package org.dvm.apogee2k14;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Information  {
	
	
	public static final String DATABASE_NAME = "apogee2014.db";
	public static final int DATABASE_VERSION = 1;
	String name="",date="TBA",category="",venue="TBA",stime="TBA",etime="TBA",overview="TBA",tab_name[]=null,tab_content[]=null;
	String more="";
	int id,day,hour,minute;
    

    public String getmore() {
        return more;
    }
    public void setmore(String heading[], String info[] ) {
        for(int i=0; i<heading.length; i++)
        {
        	more=more +"<h3>"+ heading[i]+ "</h3>" +"\n"+ info[i] +"\n\n";
        }
        more=more.replace("\\r\\n", "<br/>");
    }

public int getId() {
        return id;
    }
    
public void setId(int id) {
        this.id = id;
    }



public String[] gettab_name() {
    return tab_name;
}

public void setTabName(String tab_name[]) {
    
	this.tab_name = tab_name;
}
public String[] gettab_content() {
	
    return tab_content;
    
}

public void setTabContent(String tab_content[]) {
    this.tab_name = tab_content;
}


    
    public String getName() {
        return name;
    }
public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        
        if(date.indexOf("TBA") <= 0)
    	{
        	int val=date.indexOf('-');
        	
        	if(val>0)
        	day = Integer.parseInt(date.substring(0,val));
    		
    	}
    	else
    	{
    		date = "TBA";
    		day=0;
    	}
        this.date = date;
        
    }
	public String getDate() {
        return date;
    }
	
	public int getDay(){
		return day;
	}
	
	public int getHour(){
		return hour;
	}
	
	public int getMinute(){
		return minute;
	}

    public void setCategory(String category) {
        this.category = category;
    }
public String getCategory() {
        return category;
    }
public void setVenue(String venue) {
        this.venue = venue;
    }
public String getVenue() {
        return venue;
    }
public void setSTime(String stime) {
	if(stime.indexOf("TBA") <= 0)
	{
		
		int i = stime.indexOf(":");
		if(i>0)
		{
		hour = Integer.parseInt(stime.substring(0, i));
		minute = Integer.parseInt(stime.substring(i+1, stime.length()));
		}
			
			}
	else
	{

		stime = "TBA";

		}
	
	this.stime = stime;
    }
public String getSTime() {
        
	return stime;
    }
public void setETime(String etime) {
	if(stime.indexOf("TBA") <= 0)
	{
		etime="TBA";
	}
	this.etime = etime;
    }
public String getETime() {
        return etime;
    }
public void setOverview(String overview) {
	overview=overview.replace("\\r\\n", "<br/>");    
	this.overview = overview;
    }
public String getOverview() {    
	return overview;
    }

}









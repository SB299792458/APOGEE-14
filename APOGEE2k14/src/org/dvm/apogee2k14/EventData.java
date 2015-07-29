package org.dvm.apogee2k14;

public class EventData 
{
	private String eventName;
	private String eventDate;
	private String eventTime;
	private String eventEndTime;
	private String eventVenue;
	private String eventCont;
	private String eventPop;
	
	private int day;
	private int hour;
	private int minute;
	
	EventData(String evName, String evDate, String evTime, String evEndTime, String evVenue, String evCont, String evPop)
	{
		setEventCont(evCont);
		setEventDate(evDate);
		setEventName(evName);
		setEventTime(evTime);
		setEventEndTime(evEndTime);
		setEventVenue(evVenue);
		setEventPop(evPop);
		
		
		day = -1;
		hour = -1;
		minute = -1;
	}
	
	public String getEventName(){
		return eventName;
	}
	
	public String getEventDate(){
		return eventDate;
	}
	
	public String getEventTime(){
		return eventTime;
	}
	
	public String getEventEndTime(){
		return eventEndTime;
	}
	
	public String getEventVenue(){
		return eventVenue;
	}
	
	public String getEventContent(){
		return eventCont;
	}
	
	public String getEventPop(){
		return eventPop;
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
	public void setEventName(String evName){
		eventName = evName;
	}
	
	public void setEventDate(String evDate){
		if(evDate.indexOf("TBA") >= 0)
		{
			evDate = "TBA";
		}
		else
		{
			day = Integer.parseInt(evDate.substring(0, evDate.indexOf('/')));
		}
		eventDate = evDate;
	}
	
	public void setEventTime(String evTime){
		if(evTime.indexOf("TBA") >= 0)
		{
			evTime = "TBA";
		}
		else
		{
			int i = evTime.indexOf(":");
			hour = Integer.parseInt(evTime.substring(0, i));
			minute = Integer.parseInt(evTime.substring(i+1, evTime.length()));
		}
		eventTime = evTime;
	}
	
	public void setEventEndTime(String evEndTime){
		eventEndTime = evEndTime;
	}
	
	public void setEventVenue(String evVenue){
		if(evVenue.indexOf("TBA") >= 0)
		{
			evVenue = "TBA";
		}
		eventVenue = evVenue;
	}
	
	public void setEventCont(String evCont){
		eventCont = evCont;
	}
	
	public void setEventPop(String evPop){
		eventPop = evPop;
	}

}


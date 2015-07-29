package org.dvm.apogee2k14;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Log;
import android.util.Xml;

public class ScheduleXMLParser 
{
	private String ns = null;
	
	public List<EventData> parse(InputStream in) throws XmlPullParserException, IOException
	{
		try
		{
			//Log.d("nihav", "in parse");
			XmlPullParser parser = Xml.newPullParser();
			parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
			parser.setInput(in, null);
			parser.nextTag();
			return readFeed(parser);
		}
		finally
		{
			in.close();
		}
	}

	private List<EventData> readFeed(XmlPullParser parser) throws XmlPullParserException, IOException
	{
		//Log.d("nihav", "in read feed");
		List<EventData> content = new ArrayList<EventData>();
		parser.require(XmlPullParser.START_TAG, ns, "data");
	    while (parser.next() != XmlPullParser.END_TAG) 
	    {
	        if (parser.getEventType() != XmlPullParser.START_TAG) {
	            continue;
	        }
	        String name = parser.getName();
	        // Starts by looking for the entry tag
	        if (name.equals("event")) {
	            content.add(readEvent(parser));
	        } else {
	            skip(parser);
	        }
	    }  
		
		return content;
	}
	
	private EventData readEvent(XmlPullParser parser)throws XmlPullParserException, IOException
	{
		String evName="TBA", evDate="TBA", evTime="TBA", evEndTime="TBA", evVenue="TBA", evCont="TBA", evPop="TBA";
		parser.require(XmlPullParser.START_TAG, ns, "event");
		while(parser.next() != XmlPullParser.END_TAG)
		{
			if(parser.getEventType() != XmlPullParser.START_TAG)
			{
				continue;
			}
			
			String name = parser.getName();
			if(name.equals("cont"))
			{
				evCont = evCont + readContent(parser);
			}
			else if(name.equals("date"))
			{
				evDate = readDate(parser);
			}
			else if(name.equals("starttime"))
			{
				evTime = readStartTime(parser);
			}
			else if(name.equals("endtime"))
			{
				evEndTime = readEndTime(parser);
			}
			else if(name.equals("venue"))
			{
				evVenue = readVenue(parser);
			}
			else if(name.equals("name"))
			{
				evName= readName(parser);
			}
			else if(name.equals("papa"))
			{
				evPop = readPop(parser);
			}
			else
			{
				skip(parser);
			}
			
		}
		return new EventData(evName, evDate, evTime, evEndTime, evVenue, evCont, evPop);

	}

	private void skip(XmlPullParser parser) throws XmlPullParserException, IOException
	{
		if(parser.getEventType() != XmlPullParser.START_TAG)
		{
			throw new IllegalStateException();
		}
		int depth = 1;
		while(depth != 0)
		{
			switch (parser.next())
			{
			case XmlPullParser.END_TAG: depth--;
										break;
			case XmlPullParser.START_TAG: depth++;
											break;
			}
		}
	}

	private String readContent(XmlPullParser parser) throws XmlPullParserException, IOException
	{
		parser.require(XmlPullParser.START_TAG, ns, "cont");
		String cont = readText(parser);
		parser.require(XmlPullParser.END_TAG, ns, "cont");
		return cont;
	}
	
	private String readDate(XmlPullParser parser) throws XmlPullParserException, IOException
	{
		parser.require(XmlPullParser.START_TAG, ns, "date");
		String date = readText(parser);
		parser.require(XmlPullParser.END_TAG, ns, "date");
		return date;
	}
	
	private String readStartTime(XmlPullParser parser) throws XmlPullParserException, IOException
	{
		parser.require(XmlPullParser.START_TAG, ns, "starttime");
		String time = readText(parser);
		parser.require(XmlPullParser.END_TAG, ns, "starttime");
		return time;
	}

	private String readEndTime(XmlPullParser parser) throws XmlPullParserException, IOException
	{
		parser.require(XmlPullParser.START_TAG, ns, "endtime");
		String time = readText(parser);
		parser.require(XmlPullParser.END_TAG, ns, "endtime");
		return time;
	}
	
	private String readVenue(XmlPullParser parser) throws XmlPullParserException, IOException
	{
		parser.require(XmlPullParser.START_TAG, ns, "venue");
		String venue = readText(parser);
		parser.require(XmlPullParser.END_TAG, ns, "venue");
		return venue;
	}
	
	private String readName(XmlPullParser parser) throws XmlPullParserException, IOException
	{
		parser.require(XmlPullParser.START_TAG, ns, "name");
		String name = readText(parser);
		parser.require(XmlPullParser.END_TAG, ns, "name");
		return name;
	}

	private String readPop(XmlPullParser parser) throws XmlPullParserException, IOException
	{
		parser.require(XmlPullParser.START_TAG, ns, "papa");
		String pop = readText(parser);
		parser.require(XmlPullParser.END_TAG, ns, "papa");
		return pop;
	}

	private String readText(XmlPullParser parser) throws XmlPullParserException, IOException
	{
		String result = "";
		if(parser.next() == XmlPullParser.TEXT)
		{
			result = parser.getText();
			parser.nextTag();
		}
		return result;
	}


}

package org.dvm.apogee2k14;

import java.io.IOException;
import java.io.InputStream;

import org.dvm.apogee2k14.EventData;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;


public class ApogeeXMLParser {
	private String ns = null;
	
	public EventData parse(InputStream in) throws XmlPullParserException, IOException
	{
		try
		{
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

	private EventData readFeed(XmlPullParser parser) throws XmlPullParserException, IOException
	{
		//List<String> content = new ArrayList<String>();
		String evName="", evDate="", evTime="", evEndTime="", evVenue="", evCont="", evPop="";
		parser.require(XmlPullParser.START_TAG, ns, "data");
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
			else if(name.equals("time"))
			{
				evTime = readTime(parser);
			}
			else if(name.equals("venue"))
			{
				evVenue = readVenue(parser);
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
	
	private String readTime(XmlPullParser parser) throws XmlPullParserException, IOException
	{
		parser.require(XmlPullParser.START_TAG, ns, "time");
		String time = readText(parser);
		parser.require(XmlPullParser.END_TAG, ns, "time");
		return time;
	}
	
	private String readVenue(XmlPullParser parser) throws XmlPullParserException, IOException
	{
		parser.require(XmlPullParser.START_TAG, ns, "venue");
		String venue = readText(parser);
		parser.require(XmlPullParser.END_TAG, ns, "venue");
		return venue;
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

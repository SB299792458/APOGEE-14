package org.dvm.apogee2k14;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

import org.dvm.apogee2k14.R;
import org.xmlpull.v1.XmlPullParserException;



import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class EOTDActivity extends Activity 
{
	private EventData evData;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loading);
		//the url for event of the day goes down here-->
		new DownloadXML().execute("http://bits-oasis.org/2013test/backend/backend/?name=");
	}
	private class DownloadXML extends AsyncTask<String, Void, String>
	{

		@Override
		protected String doInBackground(String... arg0) 
		{
			try
			{
				return loadXMLfromServer(arg0[0]);
			}
			catch(IOException e)
			{
				return "Error in Connection";
			}
			catch(XmlPullParserException xe)
			{
				return "Error in XML";
			}
			//return null;
		}

		@Override
		protected void onPostExecute(String result)
		{
			setContentView(R.layout.updates_activity);
			
			WebView webby = (WebView) findViewById(R.id.webViewUpdates);
			webby.loadData(evData.getEventContent(), "text/html", null);
		}
		

		private String loadXMLfromServer(String urlString) throws XmlPullParserException, IOException
		{
			InputStream stream = null;
			
			ApogeeXMLParser apogeeXMLParser = new ApogeeXMLParser();
			//List<String> conts= null;
			//EventData eventData = null;
			String cont = null;
			
			StringBuilder htmlString = new StringBuilder();
			
			try
			{
				stream = downloadURL(urlString);
				evData = apogeeXMLParser.parse(stream);
			}
			finally
			{
				if(stream != null)
				{
					stream.close();
				}
			}
			int i;
				String str = evData.getEventContent();
				while((i=str.indexOf("<pre>")) >= 0)
				{
					str = str.substring(0, i) + str.substring(i+5);
				}
				while((i=str.indexOf("</pre>")) >= 0)
				{
					str = str.substring(0, i) + str.substring(i+6);
				}
				evData.setEventCont(str);
				htmlString.append(str);
			
			return htmlString.toString();
		}

		private InputStream downloadURL(String urlString) throws IOException
		{
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(10000);
			conn.setConnectTimeout(15000);
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			conn.connect();
			return conn.getInputStream();
		}

	}
}

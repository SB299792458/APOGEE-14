package org.dvm.apogee2k14;
import org.dvm.apogee2k14.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebView;



public class SponsorsActivity extends Activity {
	private static final String PIC_WIDTH = "1000";

		//	private EventData evData;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.loadweb);
			//url for sponsors goes here-->
			WebView webview=(WebView)findViewById(R.id.web); 
			
			String str="<div style=\"text-align:center;\"> <br/> <br/> <div style=\"width:750px; background-color:#efefef; padding:10px 0px; font-size:26px;color:black;\">Title Sponsor</div> <br/> <center> <a href=\"www.highsierra.in/\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/hs.png\" style=\"border:none; padding:10px 30px;\"/> </a> </center> <div style=\"clear:both\"></div> </div> <div style=\"text-align:center;\"> <br/> <br/> <div style=\"width:750px; background-color:#efefef; padding:10px 0px; font-size:26px;color:black;\">Associate Title Sponsor</div> <br/> <center> <a href=\"www.centurypaperindia.com/\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/Century-Paper_Associate-Title-Sponsor.png\" style=\"border:none; padding:10px 30px;\"/> </a> </center> <div style=\"clear:both\"></div> </div> <div style=\"text-align:center;\"> <br/> <br/> <div style=\"width:750px; background-color:#efefef; padding:10px 0px; font-size:26px;color:black;\">Gold Sponsor</div> <br/> <center> <a href=\"www.ideacellular.com/?\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/idea_png.png\" style=\"border:none; padding:10px 30px;\"/> </a> <a href=\"http://eldecogroup.org\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/eldeco_paint_png.png\" style=\"border:none; padding:10px 30px;\"/> </a> <a href=\"www.tcs.com/\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/TCS_Gold-Sponsor.png\" style=\"border:none; padding:10px 30px;\"/> </a> </center> <div style=\"clear:both\"></div> </div> <div style=\"text-align:center;\"> <br/> <br/> <div style=\"width:750px; background-color:#efefef; padding:10px 0px; font-size:26px;color:black;\">Silver Sponsor</div> <br/> <center> <a href=\"http://vishvaprotech.com\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/Vishva_Protech_logo.png\" style=\"border:none; padding:10px 30px;\"/> </a> <a href=\"http://helixtech.co\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/helix_ed.png\" style=\"border:none; padding:10px 30px;\"/> </a> <a href=\"http://informossys.com\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/informo_ed.png\" style=\"border:none; padding:10px 30px;\"/> </a> <a href=\"www.ambujacement.com/\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/ac-png.png\" style=\"border:none; padding:10px 30px;\"/> </a> <a href=\" www.microsoft.com/india\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/ms_png_1_1.png\" style=\"border:none; padding:10px 30px;\"/> </a> <a href=\"www.bmc.com/en-IN/\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/BMC_Silver-Sponsor.png\" style=\"border:none; padding:10px 30px;\"/> </a> <a href=\"www.licindia.in/\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/LIC_Silver-Sponsor_1.png\" style=\"border:none; padding:10px 30px;\"/> </a> </center> <div style=\"clear:both\"></div> </div> <div style=\"text-align:center;\"> <br/> <br/> <div style=\"width:750px; background-color:#efefef; padding:10px 0px; font-size:26px;color:black;\">Knowledge Partner</div> <br/> <center> <a href=\"http://academy.dlink.com\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/D-LinkAcademy-logo-teal.png\" style=\"border:none; padding:10px 30px;\"/> </a> </center> <div style=\"clear:both\"></div> </div> <div style=\"text-align:center;\"> <br/> <br/> <div style=\"width:750px; background-color:#efefef; padding:10px 0px; font-size:26px;color:black;\">Gaming Partner</div> <br/> <center> <a href=\"www.gigabyte.in\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/gb_png.png\" style=\"border:none; padding:10px 30px;\"/> </a> </center> <div style=\"clear:both\"></div> </div> <div style=\"text-align:center;\"> <br/> <br/> <div style=\"width:750px; background-color:#efefef; padding:10px 0px; font-size:26px;color:black;\">Educational Partner</div> <br/> <center> <a href=\"http://nesoindia.org\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/Logo.png\" style=\"border:none; padding:10px 30px;\"/> </a> <a href=\"www.ualberta.ca/\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/UA-EAC-COLOUR_1.png\" style=\"border:none; padding:10px 30px;\"/> </a> </center> <div style=\"clear:both\"></div> </div> <div style=\"text-align:center;\"> <br/> <br/> <div style=\"width:750px; background-color:#efefef; padding:10px 0px; font-size:26px;color:black;\">Online Shopping Partner</div> <br/> <center> <a href=\"www.10kya.com\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/10kya_new.png\" style=\"border:none; padding:10px 30px;\"/> </a> </center> <div style=\"clear:both\"></div> </div> <div style=\"text-align:center;\"> <br/> <br/> <div style=\"width:750px; background-color:#efefef; padding:10px 0px; font-size:26px;color:black;\">Prize Partner</div> <br/> <center> <a href=\"www.oxicash.in\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/Oxigen_Wallet_png.png\" style=\"border:none; padding:10px 30px;\"/> </a> <a href=\"http:// www.greenrockstore.com\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/green_rock-option_2_-.png\" style=\"border:none; padding:10px 30px;\"/> </a> <a href=\"www.lazyninja.in/\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/LazyNinja-Logo.png\" style=\"border:none; padding:10px 30px;\"/> </a> </center> <div style=\"clear:both\"></div> </div> <div style=\"text-align:center;\"> <br/> <br/> <div style=\"width:750px; background-color:#efefef; padding:10px 0px; font-size:26px;color:black;\">Gift partner</div> <br/> <center> <a href=\"http://wegreet.in\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/WeGreet_logo.png\" style=\"border:none; padding:10px 30px;\"/> </a> </center> <div style=\"clear:both\"></div> </div> <div style=\"text-align:center;\"> <br/> <br/> <div style=\"width:750px; background-color:#efefef; padding:10px 0px; font-size:26px;color:black;\">Merchandise Partner</div> <br/> <center> <a href=\"http://postergully.com\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/Untitled-1.png\" style=\"border:none; padding:10px 30px;\"/> </a> </center> <div style=\"clear:both\"></div> </div> <div style=\"text-align:center;\"> <br/> <br/> <div style=\"width:750px; background-color:#efefef; padding:10px 0px; font-size:26px;color:black;\">Event Partner</div> <br/> <center> <a href=\"http://http://bisquare.com/\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/BISQUARE.png\" style=\"border:none; padding:10px 30px;\"/> </a> <a href=\"http://thdc.gov.in/?\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/ENGH_1.png\" style=\"border:none; padding:10px 30px;\"/> </a> <a href=\"www.ericsson.com/in?\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/ERICSSON.png\" style=\"border:none; padding:10px 30px;\"/> </a> <a href=\"http://exotel.in/?\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/EXOTEL.png\" style=\"border:none; padding:10px 30px;\"/> </a> <a href=\"www.hedgequants.com/?\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/HEDGE_QUANTS.png\" style=\"border:none; padding:10px 30px;\"/> </a> <a href=\"www.jindalsconsortium.in/?\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/JINDALS.png\" style=\"border:none; padding:10px 30px;\"/> </a> <a href=\"www.larsentoubro.com/lntcorporate/common/ui_templates/homepage_news.aspx?res=P_PWR\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/L_and_T_POWER.png\" style=\"border:none; padding:10px 30px;\"/> </a> <a href=\"www.larsentoubro.com/?\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/larsen-toubro-engineering-construction.gif\" style=\"border:none; padding:10px 30px;\"/> </a> <a href=\"http://bits-apogee.org\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/SKYLINE.png\" style=\"border:none; padding:10px 30px;\"/> </a> <a href=\"www.dsij.in/?\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/dsijlogo_1.gif\" style=\"border:none; padding:10px 30px;\"/> </a> </center> <div style=\"clear:both\"></div> </div> <div style=\"text-align:center;\"> <br/> <br/> <div style=\"width:750px; background-color:#efefef; padding:10px 0px; font-size:26px;color:black;\">Programming Partner</div> <br/> <center> <a href=\"http://www.codechef.com/\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/Codechef.png\" style=\"border:none; padding:10px 30px;\"/> </a> </center> <div style=\"clear:both\"></div> </div> <div style=\"text-align:center;\"> <br/> <br/> <div style=\"width:750px; background-color:#efefef; padding:10px 0px; font-size:26px;color:black;\">Media Partner</div> <br/> <center> <a href=\"www.aptidude.com\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/png_logo_aptiDude_black.png\" style=\"border:none; padding:10px 30px;\"/> </a> <a href=\"http://the-week.com\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/THE-WEEK---NEW-LOGO.png\" style=\"border:none; padding:10px 30px;\"/> </a> </center> <div style=\"clear:both\"></div> </div> <div style=\"text-align:center;\"> <br/> <br/> <div style=\"width:750px; background-color:#efefef; padding:10px 0px; font-size:26px;color:black;\">Workshop Partner</div> <br/> <center> <a href=\"http://phyzok.com/home/\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/phyzok_plate.png\" style=\"border:none; padding:10px 30px;\"/> </a> <a href=\"www.texelgroup.com/\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/Texel_Workshop-Partner.png\" style=\"border:none; padding:10px 30px;\"/> </a> <a href=\"http://authentictechs.com/\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/Authenitic-Techs_Workshop-Partner.png\" style=\"border:none; padding:10px 30px;\"/> </a> <a href=\"www.infizeal.com/\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/Infi-Zeal_Workshop-Partner.png\" style=\"border:none; padding:10px 30px;\"/> </a> <a href=\"http://techdefence.com/\" target=\"_blank\"> <img src=\"http://bits-apogee.org/2014/site_media/images/sponsors/TechDefence_Workshop_Partner.png\" style=\"border:none; padding:10px 30px;\"/> </a> </center> <div style=\"clear:both\"></div> </div>";
			webview.loadData(str,"text/html", null);
			webview.setPadding(0, 0, 0, 0);
			webview.setInitialScale(getScale());
		
		}
		
		private int getScale(){
		    Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay(); 
		    int width = display.getWidth(); 
		    Double val = new Double(width)/new Double(PIC_WIDTH);
		    val = val * 100d;
		    return val.intValue();
		}
}

/*package com.example.apogee2k14;

	import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

	import org.xmlpull.v1.XmlPullParserException;

import com.example.apogee2k14.R;

	import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

	public class SponsorsActivity extends Activity {
		private EventData evData;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_loading);
			//url for sponsors goes here-->
			new DownloadXML().execute("http://bits-oasis.org/2013test/backend/backend/?name=AndroidSponsors");
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
				setContentView(R.layout.sponsor_activity);
				
				WebView webby = (WebView) findViewById(R.id.webViewSponz);
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
				//Log.d("nihav", "here");
				try
				{
					stream = downloadURL(urlString);
					evData = apogeeXMLParser.parse(stream);
					//Log.d("nihav", "here");
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
				//Log.d("nihav", "hello");
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


*/
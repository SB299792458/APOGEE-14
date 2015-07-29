package org.dvm.apogee2k14;

import java.io.IOException;

import org.dvm.apogee2k14.R;


import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebView.FindListener;
import android.widget.TextView;

public class ThinkAgain extends Activity{
	
	Information eventInfo;
	String eventName;

	
	public void onCreate(Bundle savedInstanceState)
	 {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.simple_contacts);
	  String s="<p><span style=\\\\\"text-decoration: underline;\\\\\"><strong>THINK AGAIN:</strong></span><br /><br /><span style=\\\\\"text-decoration: underline;\\\\\">Walter Lewin:</span><br /><br />He dangles on the spring just to prove his point about damping, explains velocity in class by firing a rifle, rides a fire extinguisher propelled tricycle in the classroom to show how a rocket lifts off and all this while answering your trivial questions with his uncanny sense of humour. This APOGEE, be prepared for the best Physics lecture of your life, for Think Again brings to you Dr. Walter Lewin &ndash; the eccentric MIT Astrophysicist who will be in town to deliver a lecture on the birth and death of stars. &gt;So refrain from booking those tickets that take you back home, because you don&rsquo;t want to be missing this one!<br /><br /><span style=\\\\\"text-decoration: underline;\\\\\">John Beck Hofmann:</span> <br /><br />NASA. Jet Propulsion Lab. Mars Orbiter Mission. Seems all Hollywood sci-fi thriller like? Well that is exactly what you are going to get a dose of! This APOGEE, Think Again brings to you Director of Photography for NASA&rsquo;s Jet Propulsion Lab, Emmy-award winning cinematographer John-Beck Hofmann. A multi-talented personality, John has many interesting experiences to share including those working on the Mars Orbiter Mission. So, brace yourselves for the intergalactic journey through space and time this APOGEE.<br /><br /><span style=\\\\\"text-decoration: underline;\\\\\">Mansoor Khan:</span><br /><br />Having studied at several prestigious engineering colleges like IIT Bombay, Cornell and the MIT this man dropped out, only to pursue his passion in direction and film making, and incidentally ended up launching the career of his cousin, Aamir Khan. He has an enviable filmography which includes the cult classic Jo Jeeta Wohi Sikandar, Qayamat Se Qayamat Tak and the Shah Rukh Khan starrer Josh. When all was going hunky dory in the show business, he retreated to Coonoor and created Acres Wild, an organic farm and farm stay. Recently he authored a book, The Third Curve, questioning our concept of constant and perpetual growth. Having always done what his heart has desired, he is a role model for our generation who wish to follow their dreams. And this APOGEE, he will be in Pilani telling you how exactly to go about it.Think Again Conclave presents their third speaker, Mansoor Khan &ndash; Director, Filmmaker, and Author.<br /><br /><span style=\\\\\"text-decoration: underline;\\\\\">Johanna Blakely:</span><br /><br />Charming calm and confident while on stage, she explains some of her seemingly mind-boggling thoughts about entertainment and human life with the ease of learning ABC, all while constantly exuding a lovely smile.So, this APOGEE, get ready to shed all your preconceived notions and debunk myths regarding YOUR life and the effect of SOCIAL MEDIA on it. Think Again presents to you Johanna Blakely, Managing Director and Director of Research at the Norman Lear Center, University of Southern California, to enlighten one and all on the impact of social media on our lives.<br /><br /><span style=\\\\\"text-decoration: underline;\\\\\">Padma Shri Anil Gupta:</span><br /><br />His interests include ensuring recognition, respect and reward for grassroots inventors and innovators at a local, national and global level. For more than twelve years, in order to learn from grassroots teachers, he has been walking around 6000 km across India as part of Shodh Yatra. The founder of Honey Bee Network, Dr. Anil Kumar Gupta is a professor in the Centre for Management in Agriculture at IIM-A, and conferred the Padma Shri in Management Education in 2004. He is also the Co-ordinator of SRISTI and holds the Executive Vice Chair of the National Innovation Foundation. This APOGEE, interact with the man who redefines innovation, and shows how crucial the knowledge possessed by the unsung inventors and indigenous entrepreneurs is, whose ingenuity, hidden by poverty, could change many people's lives.<br /><br /><span style=\\\\\"text-decoration: underline;\\\\\"><strong>PRE-APOGEE EXTRAVAGANZA:</strong></span><br /><br /><span style=\\\\\"text-decoration: underline;\\\\\">Vinod Dham:</span><br /><br />Vinod Dham is an inventor, entrepreneur and venture capitalist, and popularly known as the Father of the Pentium chip, for his contribution to the development of Pentium Processors from Intel. He is a mentor, adviser and sits on the boards of many companies including promising start-ups funded through his India based fund &ndash; Indo-US Venture Partners, where he is the founding Managing Director.&nbsp;This is no ordinary lecture, but an interactive session. Send in all questions you would like to ask Mr. Dham to guestlectures@bits-apogee.org</p>";
		
		WebView eventMore = (WebView)findViewById(R.id.textViewContact);
		
		
		eventMore.loadData(s, "text/html", null);
		

}
}

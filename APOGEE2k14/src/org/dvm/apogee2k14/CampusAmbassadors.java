package org.dvm.apogee2k14;

import java.io.IOException;

import org.dvm.apogee2k14.R;


import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebView.FindListener;
import android.widget.TextView;

public class CampusAmbassadors extends Activity{
	
	private static final String PIC_WIDTH = "500";
	Information eventInfo;
	String eventName;

	
	public void onCreate(Bundle savedInstanceState)
	 {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.simple_contacts);
	  
		
		WebView eventMore = (WebView)findViewById(R.id.textViewContact);
		
		String a="<p><strong>Register&nbsp;<a href=/\"docs.google.com/forms/d/1T13jxzM4WDN9kCOaRry6llFjGiWXRkFFVLnzzcojac0/viewform/\"> here</a></strong></p><p><strong>WHO IS A CAMPUS AMBASSADOR?</strong></p><p>Campus Ambassador is a person responsible for publicizing and promoting APOGEE in their college. The Ambassador will be representative of APOGEE, BITS Pilani in his/her college. It is a unique opportunity for students to enhance their skills in the fields of publicity, marketing, networking , and maintaining public relations at a national level by acting as the Campus Ambassador for their college. A representative from the college will be chosen to promote and publicize.</p><p><strong>THE FRAMEWORK OF RESPONSIBILITIES THAT THE AMBASSADORS TO TAKE ON</strong></p><p>Work on Campus as a representative of APOGEE'14.<br /> Create Brand Awareness for APOGEE'14 in and around your Campus.<br /> a) Putting up posters of our events on student notice boards.<br /> b) Forwarding the mails to their student mailing list.<br /> c) Publicizing our events on their social media channels by sharing the link of our event.<br /> Coordinate with your and other colleges to create awareness on APOGEE'14 website and the events</p><p><strong>ADVANTAGES OF BEING A CAMPUS AMBASSADOR INCLUDE</strong></p><p>a) Opportunity to collaborate with, and be a part of a network of thousands of students from across the country.<br /> b) Gain exposure in national level event promotion, organization and brand management.<br /> c) Each Campus Ambassador will receive a certificate accrediting their efforts in the above mentioned activities.<br /> d) Exemption of registration fees for campus ambassador* .</p><p>Astik Tyagi<br />+91 9772089918<br />reccnacc[at]bits-apogee.org</p><p><span>Shubit Minocha<br /><span>+91-9468-64-7500<br /><span>pcr[at]bits-apogee[dot]org</span></span></span></p>";
		String b="<p>Selected Campus Ambassadors -&nbsp;</p>\r\n" + 
				"<table dir=\\\"ltr\\\" border=\\\"1\\\" cellspacing=\\\"0\\\" cellpadding=\\\"0\\\"><colgroup><col width=\\\"120\\\" /><col width=\\\"363\\\" /><col width=\\\"120\\\" /></colgroup>\r\n" + 
				"<tbody>\r\n" + 
				"<tr>\r\n" + 
				"<td>Name</td>\r\n" + 
				"<td>COLLEGE</td>\r\n" + 
				"<td>CITY</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>PRANJAL SINGH</td>\r\n" + 
				"<td>Amity School of Communication</td>\r\n" + 
				"<td>Lucknow</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Dheeraj Rajpal</td>\r\n" + 
				"<td>Dayalbagh Educational Institute</td>\r\n" + 
				"<td>Agra</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Soumitra Sarkar</td>\r\n" + 
				"<td>Manipla Institute Of technology</td>\r\n" + 
				"<td>Ajmer</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Aibel Mathew</td>\r\n" + 
				"<td>College of Engg. &amp; Technology,Akola</td>\r\n" + 
				"<td>Akola</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Ashutosh SHringi</td>\r\n" + 
				"<td>Institute of ENgineering and Technolgy</td>\r\n" + 
				"<td>Alwar</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Ritwik Jain</td>\r\n" + 
				"<td>PDM College Of Technology and Management</td>\r\n" + 
				"<td>Bahadurgarh</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Garvit Rathi</td>\r\n" + 
				"<td>Lakshmi Narain College Of Technology And Science(LNCTS)</td>\r\n" + 
				"<td>Bhopal</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Karan Bulchandani</td>\r\n" + 
				"<td>MANIT</td>\r\n" + 
				"<td>Bhopal</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>MAHESH LODHI</td>\r\n" + 
				"<td>Peoples College of Research &amp; Technology Bhanpur Bhopal</td>\r\n" + 
				"<td>BHOPAL</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>PARTHSARTHI BHARGAVA</td>\r\n" + 
				"<td>University Institute Of Technology,RGPV</td>\r\n" + 
				"<td>Bhopal</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Rohit kumar bhagat</td>\r\n" + 
				"<td>institute of technical education and research</td>\r\n" + 
				"<td>bhubaneswar</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>KUMAR SHRAIYASH</td>\r\n" + 
				"<td>KIIT UNIVERSITY</td>\r\n" + 
				"<td>BHUBANESWAR</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Tejas Lodaya</td>\r\n" + 
				"<td>GOVERNMENT ENGINEERING COLLEGE BHUJ</td>\r\n" + 
				"<td>Bhuj</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Roshan Mani</td>\r\n" + 
				"<td>Government College of Engineering &amp; Technology , Bikaner</td>\r\n" + 
				"<td>Bikaner</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Apoorv Jindal</td>\r\n" + 
				"<td>PEC University of Technology</td>\r\n" + 
				"<td>Chandigarh</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>sruthi</td>\r\n" + 
				"<td>P.S.G.COLLEGE OF TECHNOLOGY</td>\r\n" + 
				"<td>COIMBATORE</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>CIBI RAJ PON</td>\r\n" + 
				"<td>Sri Ramakrishna Engineering College</td>\r\n" + 
				"<td>Coimbatore</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Geethaanchali M</td>\r\n" + 
				"<td>Bannari amman institute of technology</td>\r\n" + 
				"<td>erode</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>R Deepak Kumar</td>\r\n" + 
				"<td>Kongu Engineering College</td>\r\n" + 
				"<td>Erode</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Priyadarshini Shukla</td>\r\n" + 
				"<td>Krishna Institute Of Engineering &amp; Technology ,Ghaziabad</td>\r\n" + 
				"<td>Ghaziabad</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>vishal singh</td>\r\n" + 
				"<td>JAYPEE UNIVERSITY OF ENGINEERING AND TECHNOLOGY , GUNA</td>\r\n" + 
				"<td>GUNA</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Suresh Yadav</td>\r\n" + 
				"<td>Gurgaon College of Engineering</td>\r\n" + 
				"<td>Gurgaon</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>AKSHAY JOSHI</td>\r\n" + 
				"<td>Institute of technology and management (ITM)</td>\r\n" + 
				"<td>Gwalior, M.P.</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>abhishek</td>\r\n" + 
				"<td>maharishi markandeshwar engineering college maharishi markandeshwar university</td>\r\n" + 
				"<td>haryana</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>HARSHIT AHLUWALIA</td>\r\n" + 
				"<td>SSGPURC</td>\r\n" + 
				"<td>HOSHIARPUR</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Shivam Mittal</td>\r\n" + 
				"<td>Bits Pilani hyderabad Campud</td>\r\n" + 
				"<td>hyderabad</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>bhagat</td>\r\n" + 
				"<td>vardhaman college of engineering</td>\r\n" + 
				"<td>hyderabad</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>himanshu joshi</td>\r\n" + 
				"<td>shri vaishnav institude of technology and science</td>\r\n" + 
				"<td>indore</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>YASHONIL GANGWAL</td>\r\n" + 
				"<td>ACROPOLIS INSTITUTE OF TECHNOLOGY AND RESEARCH,INDORE(MADHYA PRADESH)</td>\r\n" + 
				"<td>INDORE</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Shashank Kaurav</td>\r\n" + 
				"<td>Gyan Ganga College of Technology</td>\r\n" + 
				"<td>Jabalpur (Madhya pradesh)</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Manoj chaudhary</td>\r\n" + 
				"<td>Amity university rajasthan</td>\r\n" + 
				"<td>jaipur</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Nipul Jhalani</td>\r\n" + 
				"<td>Global Technical Campus</td>\r\n" + 
				"<td>Jaipur</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>NITISH SHUKLA</td>\r\n" + 
				"<td>MNIT</td>\r\n" + 
				"<td>JAIPUR</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>ADITI VYAS</td>\r\n" + 
				"<td>POORNIMA COLLEGE OF ENGINEERING</td>\r\n" + 
				"<td>JAIPUR</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Anubhav Tyagi</td>\r\n" + 
				"<td>JECRC University</td>\r\n" + 
				"<td>Jaipur</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Manjeet Raj Pandey</td>\r\n" + 
				"<td>Suresh Gyan Vihar University</td>\r\n" + 
				"<td>Jaipur, RJ</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Brajesh Mohan</td>\r\n" + 
				"<td>LOVELY PROFESSIONAL UNIVERSITY</td>\r\n" + 
				"<td>JALLANDHAR</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Siddharth Srivastav</td>\r\n" + 
				"<td>Harcourt Butler Technological Institute</td>\r\n" + 
				"<td>Kanpur</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Gowtham</td>\r\n" + 
				"<td>Sai Spurthi Institute of Technology</td>\r\n" + 
				"<td>Khammam</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Pulkit Popli</td>\r\n" + 
				"<td>University Institute of Engineering and Technology, Kurukshetra University</td>\r\n" + 
				"<td>Kurukshetra</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Vidushi Singh</td>\r\n" + 
				"<td>Lady Shri Ram College For Women</td>\r\n" + 
				"<td>New Delhi</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Apoorv Shankar</td>\r\n" + 
				"<td>Maharaja Agrasen Institute of Technology</td>\r\n" + 
				"<td>New Delhi</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Nagavenkatesh G</td>\r\n" + 
				"<td>RGUKT IIIT NUZVID</td>\r\n" + 
				"<td>NUZVID</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Sidharth sharma</td>\r\n" + 
				"<td>National Institute of Construction Management &amp; Research</td>\r\n" + 
				"<td>Pune</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Anirudha Mulgund</td>\r\n" + 
				"<td>Rajendra Mane College of Engineering and technology</td>\r\n" + 
				"<td>Ratnagiri</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>SITAM SUVAM JENS</td>\r\n" + 
				"<td>NATIONAL INSTITUTE OF TECHNOLOGY,ROURKELA</td>\r\n" + 
				"<td>ROURKELA</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Rajath</td>\r\n" + 
				"<td>Hyderabad Institute of technology and management</td>\r\n" + 
				"<td>secunderabad</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>NIKHIL TRIPATHI</td>\r\n" + 
				"<td>NIT,MEGHALAYA</td>\r\n" + 
				"<td>SHILLONG</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>ARITRO MUKHERJEE</td>\r\n" + 
				"<td>SILIGURI INSTITUTE OF TECHNOLOGY,TECHNO INDIA</td>\r\n" + 
				"<td>SILIGURI,DARJEELING</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Shrestha Bansal</td>\r\n" + 
				"<td>Jaypee University Of Information Technology</td>\r\n" + 
				"<td>Solan</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Nikunj Katkoria</td>\r\n" + 
				"<td>Sardar Vallabhbhai National Institute of technology</td>\r\n" + 
				"<td>Surat</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Ambuj Shah</td>\r\n" + 
				"<td>ujjain engineering college</td>\r\n" + 
				"<td>Ujjain</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Ramtej Bolisetty</td>\r\n" + 
				"<td>Babaria Institute of Technology</td>\r\n" + 
				"<td>Vadodara</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>chanakya karra</td>\r\n" + 
				"<td>P.V.P Siddhartha institute of technology</td>\r\n" + 
				"<td>vijayawada</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>sandeep sahu</td>\r\n" + 
				"<td>andhra university college of engineering</td>\r\n" + 
				"<td>visakhapatnam</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>p bhanu chaitany</td>\r\n" + 
				"<td>gitam university</td>\r\n" + 
				"<td>visakhapatnam</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>shivasai somarathi</td>\r\n" + 
				"<td>jayamukhi Institute of technological sciences</td>\r\n" + 
				"<td>Warangal</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Kondeti Harish Kumar</td>\r\n" + 
				"<td>Kakatiya institute of technology and sciences,warangal</td>\r\n" + 
				"<td>warangal</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>A.Nishitha Manogna</td>\r\n" + 
				"<td>KITS Warangal</td>\r\n" + 
				"<td>Warangal</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Akil Kothari</td>\r\n" + 
				"<td>Manipal Institute Of Technology</td>\r\n" + 
				"<td>Manipal</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Abhishek kalsi</td>\r\n" + 
				"<td>IIT Ropar</td>\r\n" + 
				"<td>Rupnagar</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>lokesh</td>\r\n" + 
				"<td>national institute of technology, goa</td>\r\n" + 
				"<td>ponda</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>VIGNESH T</td>\r\n" + 
				"<td>VELAMMAL ENGINEERING COLLEGE</td>\r\n" + 
				"<td>CHENNAI</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Kartik Anand</td>\r\n" + 
				"<td>Ambala College of Engineering and Applied Research</td>\r\n" + 
				"<td>Ambala Cantt</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Kushal Rane</td>\r\n" + 
				"<td>Shri Guru Gobind Singhji Institute of Engineering &amp; Technology,Nanded</td>\r\n" + 
				"<td>Nanded</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Amrita Kulshreshtha</td>\r\n" + 
				"<td>Career Point University</td>\r\n" + 
				"<td>Kota</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>RAVI VERMA</td>\r\n" + 
				"<td>U.I.E.T. C.S.J.M.U. KANPUR</td>\r\n" + 
				"<td>KANPUR</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Ashesh Agarwal</td>\r\n" + 
				"<td>Maharishi Markandeshwar Engineering College</td>\r\n" + 
				"<td>Ambala, Mullana</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>AMRIT BAGGA</td>\r\n" + 
				"<td>NIIT UNIVERSITY</td>\r\n" + 
				"<td>Neemrana</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>HARSHIT BHANDARI</td>\r\n" + 
				"<td>Jodhpur Institute Of Engineering and Technology</td>\r\n" + 
				"<td>Jodhpur</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>&nbsp;</td>\r\n" + 
				"<td>&nbsp;</td>\r\n" + 
				"<td>&nbsp;</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Deep Doshi</td>\r\n" + 
				"<td>UVPCE</td>\r\n" + 
				"<td>Ahmedabad</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>DIVYANSHU PRAKASH</td>\r\n" + 
				"<td>MEWAR UNIVERSITY</td>\r\n" + 
				"<td>CHITTORGARH (RAJASTHAN)</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Neil Dave</td>\r\n" + 
				"<td>Pandit Deendayal Petroleum University</td>\r\n" + 
				"<td>Gandhinagar</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>akshat khamesra</td>\r\n" + 
				"<td>College of Technology and Engineering, Udaipur</td>\r\n" + 
				"<td>UDAIPUR</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Anjesh Agrawal</td>\r\n" + 
				"<td>Sir Padampat Singhania University</td>\r\n" + 
				"<td>Udaipur</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Satyanarayana Shiva Mantravadi</td>\r\n" + 
				"<td>K. L. University</td>\r\n" + 
				"<td>Vijayawada</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Apoorv khurana</td>\r\n" + 
				"<td>meerut institute of technology</td>\r\n" + 
				"<td>meerut</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Shubhanshu Shekhar Shukla</td>\r\n" + 
				"<td>BIT,MESRA,RANCHI (DEOGHAR CAMPUS)</td>\r\n" + 
				"<td>DEOGHAR</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>John T Mathew</td>\r\n" + 
				"<td>ABV- Indian Institute of IT &amp; Management, Gwalior</td>\r\n" + 
				"<td>Gwalior</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>PRANAV VYAS</td>\r\n" + 
				"<td>Arya college of engg.&amp; I. T. ,Jaipur</td>\r\n" + 
				"<td>Jaipur</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Karan Somjhani</td>\r\n" + 
				"<td>Oriental Institute of Science and Technology</td>\r\n" + 
				"<td>Bhopal</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Nujalla Venkata Krishna Sairam</td>\r\n" + 
				"<td>RVR &amp; JC College Of Engineering</td>\r\n" + 
				"<td>Guntur</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>SANJEEV RANJAN</td>\r\n" + 
				"<td>Ch. Brahm prakah government engineering college</td>\r\n" + 
				"<td>new delhi</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Naman Khator</td>\r\n" + 
				"<td>Manipal University Jaipur</td>\r\n" + 
				"<td>Jaipur</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>YOGESH SHARMA</td>\r\n" + 
				"<td>SRM University NCR Campus</td>\r\n" + 
				"<td>ghaziabad</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>gaurav kumar mishra</td>\r\n" + 
				"<td>JAIPUR NATIONAL UNIVERSITY</td>\r\n" + 
				"<td>jaipur</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Akhilesh Tiwari</td>\r\n" + 
				"<td>Faculty of Engineering&amp; technology, M.J.P.ROHILKHAND UNIVERSITY,BAREILLY, 243006, UTTAR PRADESH, INDIA</td>\r\n" + 
				"<td>BAREILLY</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>&nbsp;</td>\r\n" + 
				"<td>&nbsp;</td>\r\n" + 
				"<td>&nbsp;</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Praveen kumar Vidyarthi</td>\r\n" + 
				"<td>BBDNITM</td>\r\n" + 
				"<td>lucknow</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Aakarshan Sharma</td>\r\n" + 
				"<td>GIT</td>\r\n" + 
				"<td>Jaipur</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Sujith chandra</td>\r\n" + 
				"<td>Balaji institute of technology and sciences</td>\r\n" + 
				"<td>Warangal</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Kesana RamKiran</td>\r\n" + 
				"<td>jntuh college of engineering</td>\r\n" + 
				"<td>hyderabad</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>J V V SOWMYA</td>\r\n" + 
				"<td>ANITS</td>\r\n" + 
				"<td>visakhapatnam</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Preethi Reddy.V</td>\r\n" + 
				"<td>G.Pulla Reddy Engineering College</td>\r\n" + 
				"<td>Kurnool</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>mohit shrivastava</td>\r\n" + 
				"<td>Sagar institute of science and technology</td>\r\n" + 
				"<td>bhopal</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Ch Neeharika</td>\r\n" + 
				"<td>NRI institute of Technology</td>\r\n" + 
				"<td>Vijayawada</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Hari Shankar R L</td>\r\n" + 
				"<td>I.I.A.E.I.T</td>\r\n" + 
				"<td>pUNE</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Chirag Joshi</td>\r\n" + 
				"<td>GCT</td>\r\n" + 
				"<td>Jaipur</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>&nbsp;</td>\r\n" + 
				"<td>&nbsp;</td>\r\n" + 
				"<td>&nbsp;</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>GAUTAM SHARMA</td>\r\n" + 
				"<td>ITM UNIVERSITY,GWALIOR,MP.</td>\r\n" + 
				"<td>GWALIOR</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>SHREYA LALIT</td>\r\n" + 
				"<td>LINGAYA'S UNIVERSITY</td>\r\n" + 
				"<td>FARIDABAD</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>vishnu kant pandey</td>\r\n" + 
				"<td>srm university,chennai</td>\r\n" + 
				"<td>153,101 cross street 15 sector k.k nagar chennai-78 near nagatamma temple</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>PRAJWAL TIKALE</td>\r\n" + 
				"<td>SINHGAD COLLEGE OF ENGINEERING PUNE</td>\r\n" + 
				"<td>PUNE</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>karuna hazrati</td>\r\n" + 
				"<td>Dronacharya college</td>\r\n" + 
				"<td>Delhi</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Rakesh Kumar</td>\r\n" + 
				"<td>Balaji institute of technology and science</td>\r\n" + 
				"<td>Warangal</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>DURGA PRASAD PENUGONDA</td>\r\n" + 
				"<td>SRI VASAVI ENGINEERING COLLEGE</td>\r\n" + 
				"<td>TADEPALLIGUDEM</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>N.KRISHNA CHAITANYA</td>\r\n" + 
				"<td>SHIV NADAR UNIVERSITY</td>\r\n" + 
				"<td>DADRI</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Tejaswee Panwar</td>\r\n" + 
				"<td>National Institute of Technology,Uttarakhand</td>\r\n" + 
				"<td>Srinagar Garhwal</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Manjul Arya</td>\r\n" + 
				"<td>Samrat Ashok Technological Institute, Vidisha (M.P.)</td>\r\n" + 
				"<td>Vidisha</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>Sanchit Mittal</td>\r\n" + 
				"<td>Shiv Nadar University</td>\r\n" + 
				"<td>Noida</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>ravi teja</td>\r\n" + 
				"<td>vignan university</td>\r\n" + 
				"<td>guntur</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>NISHANT KUMAR</td>\r\n" + 
				"<td>JECRC UDML COLLEGE OF ENGINEERING, JAIPUR</td>\r\n" + 
				"<td>Jaipur</td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody>\r\n" + 
				"</table>";
				String c= a+"\n"+b;
		eventMore.loadData(c, "text/html", null);
		eventMore.setPadding(0, 0, 0, 0);
		eventMore.setInitialScale(getScale());
		

}
	
	private int getScale(){
	    Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay(); 
	    int width = display.getWidth(); 
	    Double val = new Double(width)/new Double(PIC_WIDTH);
	    val = val * 100d;
	    return val.intValue();
	}
}

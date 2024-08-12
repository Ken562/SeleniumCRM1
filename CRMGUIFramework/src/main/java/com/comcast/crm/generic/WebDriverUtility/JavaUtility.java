package com.comcast.crm.generic.WebDriverUtility;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		Random random = new Random();
		int randomNum = random.nextInt(1000);
		return randomNum;
	}
	public String getSystemDateYYYYDDMM() {
		
		Date dateobj = new Date();
		
		//To capture only date
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String actdate = sim.format(dateobj);
		
		return actdate;
	}
	
	public String getrequiredDateYYYYDDMM(int days) {
		Date dateobj = new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String actdate = sim.format(dateobj);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
	    String dataRequires = sim.format(cal.getTime());
	    return dataRequires;
	    
	    //another method
	    
//	    SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
//	    Calendar cal = sim.getCalendar();
//	    cal.setTime(new Date());//here we are optimizing the code
//	    cal.add(Calendar.DAY_OF_MONTH,days);
//	    String dataRequires = sim.format(cal.getTime());
//	    return dataRequires;
	}
	public String getLocalDateandTime() {
		return LocalDateTime.now().toString().replace(":", "-");
	}
	
}

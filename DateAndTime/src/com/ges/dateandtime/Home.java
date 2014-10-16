package com.ges.dateandtime;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.app.Activity;

public class Home extends Activity {

	TextView dateAndTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        dateAndTime=(TextView)findViewById(R.id.dateTime);
        
        final Handler h = new Handler();
        h.post(new Runnable() {
            @Override
            public void run() {
              
            	 long millis =(long)currentTime();
                 
                 
                 dateAndTime.setText(getDate(millis, "dd/MM/yyyy hh:mm:ss.SSS"));
                 
                 h.postDelayed(this, 1000);
            }
        });
        
    }
    
    /**
     * Return date in specified format.
     * @param milliSeconds Date in milliseconds
     * @param dateFormat Date format 
     * @return String representing date in specified format
     */
    public static String getDate(long milliSeconds, String dateFormat)
    {
        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        // Create a calendar object that will convert the date and time value in milliseconds to date. 
         Calendar calendar = Calendar.getInstance();
         calendar.setTimeInMillis(milliSeconds);
         return formatter.format(calendar.getTime());
    }
    
    static {
        try {
        	System.loadLibrary("DateAndTime");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
    private native double currentTime();
    
    
}

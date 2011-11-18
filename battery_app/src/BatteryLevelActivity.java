package com.hammink.BatteryLevel;

import android.app.Activity;
import android.os.BatteryManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

/**
 * A run-once binary for finding the battery level, voltage, temperature, technology, status, health, and plugged state of an Android-based phone.
 * This is the main source file.   Create a new Eclipse Android Project, main package named "com.hammink.BatteryLevel"
 * create "/res/drawable-hdpi/my_border.xml" and paste the contents of this my_border.xml.  Do the same for "res/layout/main.xml"
 * @author John Hammink
 * November 2, 2011
 *
 */
public class BatteryLevelActivity extends Activity {
    /** Called when the activity is first created. */
    private TextView batterLevel;
	private TextView batteryVoltage;
	private TextView batteryTemperature;
	private TextView batteryTechnology;
	private TextView batteryStatus;
	private TextView batteryHealth;
	private TextView batteryPlugged;

    @Override
    /**
     * Called when the current activity is first created.
     */
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        batterLevel = (TextView)(super.findViewById(R.id.batteryLevel));
        batteryVoltage = (TextView)(super.findViewById(R.id.batteryVoltage));
        batteryTemperature = (TextView)(super.findViewById(R.id.batteryTemperature));
        batteryTechnology = (TextView)(super.findViewById(R.id.batteryTechnology));
        batteryStatus = (TextView)(super.findViewById(R.id.batteryStatus));
        batteryHealth = (TextView)(super.findViewById(R.id.batteryHealth));
        batteryPlugged = (TextView)(super.findViewById(R.id.batteryPlugged));
        batteryLevel();
    }

    /**
     * Computes the battery level, voltage, temperature, technology by registering a receiver to the intent triggered 
     * by a battery status/level change.
     */
    private void batteryLevel() {
        BroadcastReceiver batteryLevelReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                context.unregisterReceiver(this);
                String tech = intent.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY);
                int temp = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1);
                float volt = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1);
                int rawlevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
                int level = -1;
                if (rawlevel >= 0 && scale > 0) {
                    level = (rawlevel * 100) / scale;
                }
               int status = intent.getIntExtra("status", BatteryManager.BATTERY_STATUS_UNKNOWN);
	       	   String Status;
	       	   if (status == BatteryManager.BATTERY_STATUS_CHARGING){
	       	    Status = "Charging";
	       	   } else if (status == BatteryManager.BATTERY_STATUS_DISCHARGING){
	       	    Status = "Discharging";
	       	   } else if (status == BatteryManager.BATTERY_STATUS_NOT_CHARGING){
	       	    Status = "Not charging";
	       	   } else if (status == BatteryManager.BATTERY_STATUS_FULL){
	       	    Status = "Full";
	       	   } else {
	       	    Status = "Unknown";
	       	   }
	    	   int health = intent.getIntExtra("health", BatteryManager.BATTERY_HEALTH_UNKNOWN);
	    	   String Health;
	    	   if (health == BatteryManager.BATTERY_HEALTH_GOOD){
	    	    Health = "Good";
	    	   } else if (health == BatteryManager.BATTERY_HEALTH_OVERHEAT){
	    	    Health = "Overheated/Overheating";
	    	   } else if (health == BatteryManager.BATTERY_HEALTH_DEAD){
	    	    Health = "Dead";
	    	   } else if (health == BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE){
	    	    Health = "Over Voltage";
	    	   } else if (health == BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE){
	    	    Health = "Unspecified Failure";
	    	   } else {
	    	    Health = "Unknown";
	    	   }
	    	   
	       	   
	    	   int plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
	       	   String Plugged;
	       	   if (plugged == BatteryManager.BATTERY_PLUGGED_AC) {
	       		   Plugged = "Plugged into AC";
	       	   } else if (plugged == BatteryManager.BATTERY_PLUGGED_USB) {
	       		   Plugged = "Plugged into USB";
	       	   } else {
	       		   Plugged = "Not plugged in.";
	       	   }
	    	   
                batterLevel.setText("Battery Level Remaining: " + level + "%");
                batteryVoltage.setText("Voltage: " + volt/1000 + "V");
                batteryTemperature.setText("Temperature: " + temp/10 + "C");
                batteryTechnology.setText("Technology: " + tech); 
                batteryStatus.setText("Status: " + Status);
                batteryHealth.setText("Health: " + Health);
                batteryPlugged.setText(Plugged);
            }
            
        };
        IntentFilter batteryLevelFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryLevelReceiver, batteryLevelFilter);
    }
    
}
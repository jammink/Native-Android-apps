package com.hammink.AndroidOSInfoActivity;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;

/**
 * A run-once (Android 2.1 or greater) binary for finding the OS Version, Phone Model, OS Info (including Linux Version), CPU info and Hardware info 
 * of an Android-based phone.  More features to be added.
 * To build from source:
 * Create a new Eclipse Android Project, main package named "com.hammink.AndroidOSInfoActivity"
 * Copy the main source .java file Do the same for "res/layout/main.xml"
 * 
 * Working binaries of this app can be found at:
 * http://people.mozilla.com/~jhammink/android_native_info_app/bin/
 * @author John Hammink
 * November 16, 2011
 *
 */

public class AndroidOSInfoActivityActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView OSVersion = (TextView)  findViewById(R.id.OSVersion);
        TextView PhoneModel = (TextView) findViewById(R.id.PhoneModel);
        TextView OSinfo = (TextView) findViewById(R.id.OSinfo);
        TextView CPUinfo = (TextView)  findViewById(R.id.CPUinfo);
        OSinfo.setText(ReadOSinfo());
        CPUinfo.setText(ReadCPUinfo());
        OSVersion.setText(ReadOSVersion());
        PhoneModel.setText(ReadPhoneModel());
    }
 
private String ReadOSVersion() {
	String AndroidVersion = android.os.Build.VERSION.RELEASE;
	return AndroidVersion;
}

private String ReadPhoneModel() {
	String PhoneModel = android.os.Build.MODEL;
	return PhoneModel;
}

private String ReadCPUinfo()
{
	ProcessBuilder cmd;
	String result = "";
	
		try{
			String[] args = {"system/bin/cat","/proc/cpuinfo"};
			cmd = new ProcessBuilder(args);
		
			Process process = cmd.start();
			InputStream in = process.getInputStream();
			byte[] re = new byte[1024];
			while(in.read(re) !=-1){
				System.out.println(new String(re));
				result = result + new String(re);
			}
			in.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	return result;
}
    
private String ReadOSinfo()
{
	ProcessBuilder cmd;
	String result="";

	try{
		String[] args = {"system/bin/cat", "/proc/version"};
		cmd = new ProcessBuilder(args);
	
		Process process = cmd.start();
		InputStream in = process.getInputStream();
		byte[] re = new byte[1024];
		while(in.read(re) != -1){
			System.out.println(new String(re));
			result = result + new String(re);
		}
		in.close();
	}catch(IOException ex) {
		ex.printStackTrace();
	}
	return result;
	}
}

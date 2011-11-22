package com.hammink.PhoneAndroidOSInfoActivity;

import java.io.IOException;
import java.io.InputStream;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * A run-once (Android 2.1 to 2.3.3) binary for finding the OS Version, Phone Model, OS Info (including Linux Version), CPU info and Hardware info 
 * of an Android-based phone.  More features to be added.
 * To build from source:
 * Create a new Eclipse Android Project, main package named   "com.hammink.PhoneAndroidOSInfoActivity"
 * Copy the main source .java file Do the same for "res/layout/main.xml"
 * 
 * Working binaries of this app can be found at:
 * http://people.mozilla.com/~jhammink/android_native_info_app/bin/
 * @author John Hammink
 * November 16, 2011
 *
 */

public class PhoneAndroidOSInfoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ScrollView scrllvwNo1 = (ScrollView) findViewById(R.id.scrllvwNo1);
        TextView OSVersion = (TextView)  findViewById(R.id.OSVersion);
        TextView OSinfo = (TextView) findViewById(R.id.OSinfo);
        TextView CPUinfo = (TextView)  findViewById(R.id.CPUinfo);
		TextView Board = (TextView) findViewById(R.id.Board);
		TextView Brand = (TextView) findViewById(R.id.Brand);
		TextView Cpu_abi = (TextView) findViewById(R.id.Cpu_abi);
		TextView Device = (TextView) findViewById(R.id.Device);
		TextView Display = (TextView)findViewById(R.id.Display);
		TextView Fingerprint = (TextView) findViewById(R.id.Fingerprint);
		TextView Host = (TextView) findViewById(R.id.Host);
		TextView IDd = (TextView) findViewById(R.id.IDd);
		TextView Manufacturer = (TextView) findViewById(R.id.Manufacturer);
		TextView Model = (TextView) findViewById(R.id.Model);
		TextView Product = (TextView) findViewById(R.id.Product);
		TextView Tags = (TextView) findViewById(R.id.Tags);
		TextView Type = (TextView) findViewById(R.id.Type);
		TextView User = (TextView) findViewById(R.id.User);

		scrllvwNo1.isEnabled();
        OSVersion.setText("Android OS: " + ReadOSVersion());
		Model.setText("Model: " + ReadModel());
		Board.setText("Board: " + ReadBoard());
		Brand.setText("Brand: " + ReadBrand());
		Cpu_abi.setText("CPU_ABI: " + ReadCpu_abi());
		Device.setText("Device: " + ReadDevice());
		Display.setText("Display: " + ReadDisplay());
		Fingerprint.setText("Fingerprint: " + ReadFingerprint());
		Host.setText("Host: " + ReadHost());
		IDd.setText("ID: " + ReadIDd());
		Manufacturer.setText("Manufacturer: " + ReadManufacturer());
		Product.setText("Product: " + ReadProduct());
		Tags.setText("Tags: " + ReadTags());
		Type.setText("Type: " + ReadType());
		User.setText("User: " + ReadUser());
		CPUinfo.setText("CPU Info: " + ReadCPUinfo());
		OSinfo.setText("OS Info: " + ReadOSinfo());
    }
 
private String ReadOSVersion() {
	String AndroidVersion = android.os.Build.VERSION.RELEASE;
	return AndroidVersion;
}

private String ReadBoard() {
	String Board = android.os.Build.BOARD;
	return Board;
}

private String ReadBrand() {
	String Brand = android.os.Build.BRAND;
	return Brand;
}

private String ReadCpu_abi() {
	String Cpu_abi = android.os.Build.CPU_ABI;
	return Cpu_abi;
}

private String ReadDevice() {
	String Device = android.os.Build.DEVICE;
	return Device;
}

private String ReadDisplay() {
	String Display = android.os.Build.DISPLAY;
	return Display;
}

private String ReadFingerprint() {
	String Fingerprint = android.os.Build.FINGERPRINT;
	return Fingerprint;
}

private String ReadHost() {
	String Host = android.os.Build.HOST;
	return Host;
}

private String ReadIDd() {
	String IDd = android.os.Build.ID;
	return IDd;
}

private String ReadManufacturer() {
	String Manufacturer = android.os.Build.MANUFACTURER;
	return Manufacturer;
}

private String ReadModel() {
	String Model = android.os.Build.MODEL;
	return Model;
}

private String ReadProduct() {
	String Product = android.os.Build.PRODUCT;
	return Product;
}

private String ReadTags() {
	String Tags = android.os.Build.TAGS;
	return Tags;
}

private String ReadType() {
	String Type = android.os.Build.TYPE;
	return Type;
}

private String ReadUser() {
	String User = android.os.Build.USER;
	return User;
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
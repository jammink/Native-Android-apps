package com.hammink.AndroidOSInfoActivity;

import java.io.IOException;
import java.io.InputStream;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * A run-once (Android 2.1 or greater) binary for finding the OS Version, Phone Model, OS Info (including Linux Version), CPU info and Hardware info 
 * of an Android-based phone.  More features to be added.
 * To build from source:
 * Create a new Eclipse Android Project, main package named   "com.hammink.AndroidOSInfoActivity"
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
		TextView Board = (TextView) findViewById(R.id.Board);
		TextView Bootloader = (TextView) findViewById(R.id.Bootloader);
		TextView Brand = (TextView) findViewById(R.id.Brand);
		TextView Cpu_abi = (TextView) findViewById(R.id.Cpu_abi);
		TextView Cpu_abi2 = (TextView) findViewById(R.id.Cpu_abi2);
		TextView Device = (TextView) findViewById(R.id.Device);
		TextView Display = (TextView)findViewById(R.id.Display);
		TextView Fingerprint = (TextView) findViewById(R.id.Fingerprint);
		TextView Hardware = (TextView) findViewById(R.id.Hardware);
		TextView Host = (TextView) findViewById(R.id.Host);
		TextView IDd = (TextView) findViewById(R.id.IDd);
		TextView Manufacturer = (TextView) findViewById(R.id.Manufacturer);
		TextView Model = (TextView) findViewById(R.id.Model);
		TextView Product = (TextView) findViewById(R.id.Product);
		TextView Serial = (TextView) findViewById(R.id.Serial);
		TextView Tags = (TextView) findViewById(R.id.Tags);
		TextView Time = (TextView) findViewById(R.id.Time);
		TextView Type = (TextView) findViewById(R.id.Type);
		TextView User = (TextView) findViewById(R.id.User);

        OSinfo.setText(ReadOSinfo());
        CPUinfo.setText(ReadCPUinfo());
        OSVersion.setText(ReadOSVersion());
        PhoneModel.setText(ReadPhoneModel());
		Board.setText(ReadBoard());
		Bootloader.setText(ReadBootloader());
		Brand.setText(ReadBrand());
		Cpu_abi.setText(ReadCpu_abi());
		Cpu_abi2.setText(ReadCpu_abi2());
		Device.setText(ReadDevice());
		Display.setText(ReadDisplay());
		Fingerprint.setText(ReadFingerprint());
		Hardware.setText(ReadHardware());
		Host.setText(ReadHost());
		IDd.setText(ReadIDd());
		Manufacturer.setText(ReadManufacturer());
		Model.setText(ReadModel());
		Product.setText(ReadProduct());
		Serial.setText(ReadSerial());
		Tags.setText(ReadTags());
		Time.setText(ReadTime());
		Type.setText(ReadType());
		User.setText(ReadUser());
    }
 
private String ReadOSVersion() {
	String AndroidVersion = android.os.Build.VERSION.RELEASE;
	return AndroidVersion;
}

private String ReadPhoneModel() {
	String PhoneModel = android.os.Build.MODEL;
	return PhoneModel;
}

private String ReadBoard() {
	String Board = android.os.Build.BOARD;
	return Board;
}

private String ReadBootloader() {
	String Bootloader = android.os.Build.BOOTLOADER;
	return Bootloader;
}

private String ReadBrand() {
	String Brand = android.os.Build.BRAND;
	return Brand;
}

private String ReadCpu_abi() {
	String Cpu_abi = android.os.Build.CPU_ABI;
	return Cpu_abi;
}

private String ReadCpu_abi2() {
	String Cpu_abi2 = android.os.Build.CPU_ABI2;
	return Cpu_abi2;
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

private String ReadHardware() {
	String Hardware = android.os.Build.HARDWARE;
	return Hardware;
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

private String ReadSerial() {
	String Serial = android.os.Build.SERIAL;
	return Serial;
}

private String ReadTags() {
	String Tags = android.os.Build.TAGS;
	return Tags;
}

private String ReadTime() {
	String Time = android.os.Build.TIME;
	return Time;
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

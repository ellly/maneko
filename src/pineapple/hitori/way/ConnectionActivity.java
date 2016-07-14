package pineapple.hitori.way;

import pineapple.hitori.way.GrobalData;
import pineapple.hitori.way.Util;
import pineapple.hitori.way.DialogBuilder;
import pineapple.hitori.way.BluetoothUtil;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.DialogInterface;
import android.content.Intent;

public class ConnectionActivity extends Activity {
	
	private static final Handler handler = new Handler();
	
	private Button bluetoothSettingButton;
	private Button serverButton;
	private Button guestButton;
	
	private BluetoothUtil bu;
	private BluetoothDevice targetDevice = null;
	private BluetoothConnection bc;
	private BluetoothAdapter ba;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maneko);
		bluetoothSettingButton = (Button) findViewById(R.id.BluetoothButton);
		serverButton = (Button) findViewById(R.id.ServerButton);
		guestButton = (Button) findViewById(R.id.GuestButton);
		
		bluetoothSettingButton.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View v) {
				bc.write(1);
			}
		});
		serverButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				bc.write(2);
			}
		});
		
		guestButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				bc.write(3);
			}
		});
		
	}	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

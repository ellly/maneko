package pineapple.hitori.way;

import pineapple.hitori.way.BluetoothConnection;
import pineapple.hitori.way.GrobalData;
import android.app.KeyguardManager;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.widget.ImageView;
import android.util.Log;
import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.BitmapFactory;
import android.widget.EditText;

public class ConnectionService extends Service{
	private BluetoothConnection bluetoothConnection;
	protected static final Handler handler = new Handler();
	
	private boolean endFlag = false;
	
	private final Runnable bluetoothReceiveRunnable = new Runnable() {
		@Override
		public void run() {
			MoveActivity(ConnectionActivity.class);
			/*
			try{
				bluetoothReceive();
			}
			catch(Exception e){}
				endCheck();
			*/
		}
	};
	
	private synchronized void endCheck(){
		
		if(!endFlag){
			endFlag = true;
			
			stopSelf();

		}
	}
	
	private void MoveActivity(Class<?> cls){
		final Intent intent = new Intent(this,cls);
		handler.post(new Runnable(){
			@Override
			public void run(){
				startActivity(intent);
			}
		});
	}
	
	private void bluetoothReceive(){
		BluetoothConnection bluetoothConnection = ConnectionService.this.bluetoothConnection;
		int i;
		while((i = bluetoothConnection.read()) != -1){
		}
	}
	
	protected void stop(){
		endFlag = true;
		bluetoothConnection.close();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		this.bluetoothConnection = GrobalData.bluetoothConnection;
		new Thread(bluetoothReceiveRunnable).start();
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}

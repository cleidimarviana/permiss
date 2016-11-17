package net.seamusd.permiss;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

/** 	Automatically granted permissions
		
		There is some permission that will be automatically 
		granted at install time and will not be able to revoke. 
		We call it Normal Permission (PROTECTION_NORMAL). Here is the full list of them:
		
		android.permission.ACCESS_LOCATION_EXTRA_COMMANDS
		android.permission.ACCESS_NETWORK_STATE
		android.permission.ACCESS_NOTIFICATION_POLICY
		android.permission.ACCESS_WIFI_STATE
		android.permission.ACCESS_WIMAX_STATE
		android.permission.BLUETOOTH
		android.permission.BLUETOOTH_ADMIN
		android.permission.BROADCAST_STICKY
		android.permission.CHANGE_NETWORK_STATE
		android.permission.CHANGE_WIFI_MULTICAST_STATE
		android.permission.CHANGE_WIFI_STATE
		android.permission.CHANGE_WIMAX_STATE
		android.permission.DISABLE_KEYGUARD
		android.permission.EXPAND_STATUS_BAR
		android.permission.FLASHLIGHT
		android.permission.GET_ACCOUNTS
		android.permission.GET_PACKAGE_SIZE
		android.permission.INTERNET
		android.permission.KILL_BACKGROUND_PROCESSES
		android.permission.MODIFY_AUDIO_SETTINGS
		android.permission.NFC
		android.permission.READ_SYNC_SETTINGS
		android.permission.READ_SYNC_STATS
		android.permission.RECEIVE_BOOT_COMPLETED
		android.permission.REORDER_TASKS
		android.permission.REQUEST_INSTALL_PACKAGES
		android.permission.SET_TIME_ZONE
		android.permission.SET_WALLPAPER
		android.permission.SET_WALLPAPER_HINTS
		android.permission.SUBSCRIBED_FEEDS_READ
		android.permission.TRANSMIT_IR
		android.permission.USE_FINGERPRINT
		android.permission.VIBRATE
		android.permission.WAKE_LOCK
		android.permission.WRITE_SYNC_SETTINGS
		com.android.alarm.permission.SET_ALARM
		com.android.launcher.permission.INSTALL_SHORTCUT
		com.android.launcher.permission.UNINSTALL_SHORTCUT

*/

import android.support.v4.app.ActivityCompat;
import android.util.Log;

public class PermissManager {

	private static final String TAG = PermissManager.class.getSimpleName();

	// permission group MICROPHONE
	public static final int RECOARD_AUDIO = 209;

	// permission group STORAGE
	public static final int READ_EXTERNAL_STORAGE = 223;
	public static final int WRITE_EXTERNAL_STORAGE = 224;

	// permission group LOCATION
	public static final int ACCESS_FINE_LOCATION = 207;
	public static final int ACCESS_COARSE_LOCATION = 208;

	// permission group CALENDAR
	public static final int READ_CALENDAR = 201;
	public static final int WRITE_CALENDAR = 202;

	// permission group CAMERA
	public static final int WRITE_CAMERA = 203;

	// permission group CONTACTS
	public static final int READ_CONTACTS = 204;
	public static final int WRITE_CONTACTS = 205;
	public static final int GET_ACCOUNTS = 206;

	// permission group PHONE
	public static final int READ_PHONE_STATE = 210;
	public static final int CALL_PHONE = 211;
	public static final int READ_CALL_LOG = 212;
	public static final int WRITE_CALL_LOG = 213;
	public static final int ADD_VOICE_MAIL = 214;
	public static final int USE_SIP = 215;

	// permission group SENSORS
	public static final int BODY_SENSORS = 216;

	// permission group SMS
	public static final int SEND_SMS = 217;
	public static final int RECEIVE_SMS = 218;
	public static final int READ_SMS = 219;
	public static final int RECEIVE_WAP_PUSH = 220;
	public static final int RECEIVE_MMS = 221;
	public static final int READ_CELL_BROADCASTS = 222;

	private Activity activity;

	public PermissManager(Activity activity) {
		this.activity = activity;
	}

	/**
	 * This method request permission for record audio
	 * 
	 * @return
	 */
	public boolean requestPermissForRecord() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ActivityCompat.checkSelfPermission(activity,
				Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {

			ActivityCompat.requestPermissions(activity, new String[] { Manifest.permission.RECORD_AUDIO },
					RECOARD_AUDIO);

			Log.i(TAG, "PERMISSION FOR RECORD");

			return false;
		} else
			return true;

	}

	/**
	 * This method request permission for write files in external storage:
	 * photos, media and files on your device
	 * 
	 * @return
	 */
	public boolean requestPermissExtStorage() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ActivityCompat.checkSelfPermission(activity,
				Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

			ActivityCompat.requestPermissions(activity, new String[] { Manifest.permission.WRITE_EXTERNAL_STORAGE },
					WRITE_EXTERNAL_STORAGE);

			Log.i(TAG, "PERMISSION EXTERNAL STORAGE");

			return false;
		} else
			return true;

	}

	/**
	 * This method request permission for get location
	 * 
	 * @return
	 */
	public boolean requestPermissLocation() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
				&& ActivityCompat.checkSelfPermission(activity,
						Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
				&& ActivityCompat.checkSelfPermission(activity,
						Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

			ActivityCompat.requestPermissions(activity, new String[] { Manifest.permission.ACCESS_FINE_LOCATION },
					ACCESS_FINE_LOCATION);

			Log.i(TAG, "PERMISSION ACCESS LOCATION");

			return false;
		} else
			return true;
	}

	/**
	 * This method request permission for write calendar
	 * 
	 * @return
	 */
	public boolean requestPermissCalendar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ActivityCompat.checkSelfPermission(activity,
				Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {

			ActivityCompat.requestPermissions(activity, new String[] { Manifest.permission.WRITE_CALENDAR },
					WRITE_CALENDAR);

			Log.i(TAG, "PERMISSION CALENDAR");

			return false;
		} else
			return true;
	}

	/**
	 * This method request permission for camera: take picture and record video
	 * 
	 * @return
	 */
	public boolean requestPermissCamera() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ActivityCompat.checkSelfPermission(activity,
				Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

			ActivityCompat.requestPermissions(activity, new String[] { Manifest.permission.CAMERA }, WRITE_CAMERA);

			Log.i(TAG, "PERMISSION CAMERA");

			return false;
		} else
			return true;
	}

	/**
	 * This method request permission for read contacts: take picture and record
	 * video
	 * 
	 * @return
	 */
	public boolean requestPermissContacts() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ActivityCompat.checkSelfPermission(activity,
				Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {

			ActivityCompat.requestPermissions(activity, new String[] { Manifest.permission.READ_CONTACTS },
					READ_CONTACTS);

			Log.i(TAG, "PERMISSION CONTACS");

			return false;
		} else
			return true;
	}

	/**
	 * This method request permission for phone video
	 * 
	 * @return
	 */
	public boolean requestPermissPhone() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ActivityCompat.checkSelfPermission(activity,
				Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {

			ActivityCompat.requestPermissions(activity, new String[] { Manifest.permission.READ_PHONE_STATE },
					READ_PHONE_STATE);

			Log.i(TAG, "PERMISSION PHONE");

			return false;
		} else
			return true;
	}

	/**
	 * This method request permission for sensors video
	 * 
	 * @return
	 */
	public boolean requestPermissSensors() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ActivityCompat.checkSelfPermission(activity,
				Manifest.permission.BODY_SENSORS) != PackageManager.PERMISSION_GRANTED) {

			ActivityCompat.requestPermissions(activity, new String[] { Manifest.permission.BODY_SENSORS },
					BODY_SENSORS);

			Log.i(TAG, "PERMISSION SENSORS");

			return false;
		} else
			return true;
	}

	/**
	 * This method request permission for send sms video
	 * 
	 * @return
	 */
	public boolean requestPermissSMS() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ActivityCompat.checkSelfPermission(activity,
				Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {

			ActivityCompat.requestPermissions(activity, new String[] { Manifest.permission.SEND_SMS }, SEND_SMS);

			Log.i(TAG, "PERMISSION SMS");

			return false;
		} else
			return true;
	}

}

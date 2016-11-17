package net.seamusd.doneis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import net.seamusd.permiss.PermissManager;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = MainActivity.class.getSimpleName();
	private ListView listView;

	private PermissManager permiss;

	private static final String LOCATION = "Location";
	private static final String MICROPHONE = "Microphone";
	private static final String WRITE_EXTERNAL_STORATE = "External Storage";
	private static final String CALENDAR = "Calendar";
	private static final String CAMERA = "Camera";
	private static final String CONTACTS = "Contacts";

	private static final String PHONE = "Phone";
	private static final String SENSORS = "Sensors";
	private static final String SMS = "SMS";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		permiss = new PermissManager(this);

		// Get ListView object from xml
		listView = (ListView) findViewById(R.id.list);

		// Defined Array values to show in ListView
		String[] values = new String[] { LOCATION, MICROPHONE, WRITE_EXTERNAL_STORATE, CAMERA, CONTACTS, PHONE,
				CALENDAR, SENSORS, SMS };

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
				android.R.id.text1, values);

		// Assign adapter to ListView
		listView.setAdapter(adapter);

		// ListView Item Click Listener
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

				String itemValue = (String) listView.getItemAtPosition(position);

				if (itemValue.equals(MICROPHONE)) {
					if (permiss.requestPermissForRecord()) {
						// TODO Something here
					}

				} else if (itemValue.equals(LOCATION)) {
					if (permiss.requestPermissLocation()) {
						// TODO Something here
					}
				} else if (itemValue.equals(WRITE_EXTERNAL_STORATE)) {
					if (permiss.requestPermissExtStorage()) {
						// TODO Something here
					}
				} else if (itemValue.equals(CAMERA)) {
					if (permiss.requestPermissCamera()) {
						// TODO Something here
					}
				} else if (itemValue.equals(CONTACTS)) {
					if (permiss.requestPermissContacts()) {
						// TODO Something here
					}
				} else if (itemValue.equals(PHONE)) {
					if (permiss.requestPermissPhone()) {
						// TODO Something here
					}
				} else if (itemValue.equals(CALENDAR)) {
					if (permiss.requestPermissCalendar()) {
						// TODO Something here
					}
				} else if (itemValue.equals(SENSORS)) {
					if (permiss.requestPermissSensors()) {
						// TODO Something here
					}
				} else if (itemValue.equals(SMS)) {
					if (permiss.requestPermissSMS()) {
						// TODO Something here
					}
				}

			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

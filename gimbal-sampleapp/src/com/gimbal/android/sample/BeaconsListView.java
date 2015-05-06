package com.gimbal.android.sample;

//import com.gimbal.android.sample.R;
import com.gimbal.android.sample.AppActivity.GimbalEventReceiver;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

public class BeaconsListView extends Activity {

	private GimbalEventReceiver gimbalEventReceiver;
	private GimbalEventListAdapter adapter2;

	ListView listview1;

	// private ProgressBar spinner;

	// @SuppressLint("CutPasteId")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_beacons_list_view);

		startService(new Intent(this, AppService.class));// from AppActivity
		// spinner = (ProgressBar) findViewById(R.id.progressBar1);
		// spinner.setVisibility(View.GONE);
		// Get ListView object from xml
		// listview1 = (ListView) findViewById(R.id.list1);

		// Defined Array values to show in ListView
		/*
		 * String[] values = new String[] { "Gym", "Barnes and Noble Bookstore",
		 * "Starbucks", "Library", "Dr. Scharff's Office",};
		 */

		/*
		 * ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
		 * android.R.layout.simple_list_item_1, values);
		 */

		// Assign adapter to ListView
		// listview1.setAdapter(adapter1);

		// from AppActivity
		if (GimbalDAO.showOptIn(getApplicationContext())) {
			startActivity(new Intent(this, OptInActivity.class));
		}

		adapter2 = new GimbalEventListAdapter(this);

		// ListView listView = (ListView) findViewById(R.id.list1); // listview
		// is
		// mentioned
		// in
		// activity_main.xml
		// layout
		// file

		// listView.setAdapter(adapter2);
	}

	@Override
	protected void onResume() {
		super.onResume();
		adapter2.setEvents(GimbalDAO.getEvents(getApplicationContext()));
	}

	@Override
	protected void onStart() {
		super.onStart();
		gimbalEventReceiver = new GimbalEventReceiver();
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(GimbalDAO.GIMBAL_NEW_EVENT_ACTION);
		registerReceiver(gimbalEventReceiver, intentFilter);
	}

	@Override
	protected void onStop() {
		super.onStop();
		unregisterReceiver(gimbalEventReceiver);
	}

	// --------------------
	// EVENT RECEIVER
	// --------------------

	class GimbalEventReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			adapter2.setEvents(GimbalDAO.getEvents(getApplicationContext()));
		}
	}

	/*
	 * public void load(View view) { spinner.setVisibility(View.VISIBLE); }
	 */

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.beacons_list_view, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
		case R.id.action_settings:
			// go to settings 
			return true;
		case R.id.scoreboard:
			// go to leaderboard
			Intent intent = new Intent(getApplicationContext(),
					Leaderboard.class);
			startActivity(intent);
			return true;
		/*case R.id.mybadges:
			// go to my badges
			return true;*/
		default:
			return super.onOptionsItemSelected(item);
		}
		/*int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);*/
	}
}

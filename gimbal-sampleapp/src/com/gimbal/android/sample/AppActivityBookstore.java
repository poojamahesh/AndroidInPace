package com.gimbal.android.sample;

import com.gimbal.android.sample.R;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class AppActivityBookstore extends Activity {

	private GimbalEventReceiver gimbalEventReceiver;
	private GimbalEventListAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_app_activity_bookstore);
		// Change layout according to requirements
		startService(new Intent(this, AppService.class));
		// Change Intent according to requirements

		if (GimbalDAO.showOptIn(getApplicationContext())) {
			startActivity(new Intent(this, OptInActivity.class));
		}

		adapter = new GimbalEventListAdapter(this);

		ListView listView = (ListView) findViewById(R.id.listview);
		listView.setAdapter(adapter);
		
		// Dynamic Button creation
				Button nxtbtn = new Button(this);
				nxtbtn.setText("Next Location");
				listView.addFooterView(nxtbtn);
				 

				// Listening to button
				nxtbtn.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {
						Intent intent = new Intent(AppActivityBookstore.this,
								LocationCafeteria.class);
						startActivity(intent);
					}
				});
	}

	@Override
	protected void onResume() {
		super.onResume();
		adapter.setEvents(GimbalDAO.getEvents(getApplicationContext()));
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
			adapter.setEvents(GimbalDAO.getEvents(getApplicationContext()));
		}
	}

	// --------------------
	// SETTINGS MENU
	// --------------------

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.app_activity_bookstore, menu);
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

	// This method is mentioned in list_item.xml. Aim is to go from one place to
	// another.
	/*public void buttonClick(View view) {
		// System.out.println("you have clicked yogesh");
		Intent intent = new Intent(AppActivityBookstore.this,
				LocationCafeteria.class);
		startActivity(intent);
	}*/
}

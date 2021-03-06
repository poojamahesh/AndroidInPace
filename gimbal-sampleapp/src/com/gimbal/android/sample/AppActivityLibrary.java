/**
 * Copyright (C) 2014 Gimbal, Inc. All rights reserved.
 *
 * This software is the confidential and proprietary information of Gimbal, Inc.
 *
 * The following sample code illustrates various aspects of the Gimbal SDK.
 *
 * The sample code herein is provided for your convenience, and has not been
 * tested or designed to work on any particular system configuration. It is
 * provided AS IS and your use of this sample code, whether as provided or
 * with any modification, is at your own risk. Neither Gimbal, Inc.
 * nor any affiliate takes any liability nor responsibility with respect
 * to the sample code, and disclaims all warranties, express and
 * implied, including without limitation warranties on merchantability,
 * fitness for a specified purpose, and against infringement.
 */
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

public class AppActivityLibrary extends Activity {
	private GimbalEventReceiver gimbalEventReceiver;
	private GimbalEventListAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_app_activity_location2);
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
				Intent intent = new Intent(AppActivityLibrary.this, LocationBookstore.class);
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
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			startActivity(new Intent(this, SettingsActivity.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	// This method is mentioned in list_item.xml. Aim is to go from one place to
	// another.
	/*
	 * public void buttonClick(View view) { //
	 * System.out.println("you have clicked yogesh"); Intent intent = new
	 * Intent(AppActivityLibrary.this, LocationBookstore.class);
	 * startActivity(intent); }
	 */
}

package com.gimbal.android.sample;

import com.gimbal.android.sample.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class LocationGym extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location_gym);
		 Button b = (Button)findViewById(R.id.gymfoundFirst);

	        b.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                Intent intent = new Intent(getApplicationContext(), AppActivityGym.class);
	                startActivity(intent);
	            }
	        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.location_gym, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		/*switch (item.getItemId()) {
		case R.id.action_settings:
			// go to settings 
			return true;
		case R.id.myleaderboard:
			// go to leaderboard
			Intent intent = new Intent(getApplicationContext(),
					Leaderboard.class);
			startActivity(intent);
			return true;
		case R.id.mybadges:
			// go to my badges
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}*/
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

package com.gimbal.android.sample;

import com.gimbal.android.sample.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LocationLibrary extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location_library);
		 
		Button b1 = (Button)findViewById(R.id.location2foundFirst);
		// Buttons needs to be changed according to requirement 
		//Button b1 = (Button)findViewById(R.id.nextlocation);

	        b1.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                Intent intent = new Intent(getApplicationContext(), AppActivityLibrary.class);
	                // AppActivity class needs to be changed ; may be a duplicate of AppActivity 
	                startActivity(intent);
	            }
	        });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.location2, menu);
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

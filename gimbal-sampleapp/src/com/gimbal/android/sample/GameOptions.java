package com.gimbal.android.sample;

import com.gimbal.android.sample.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class GameOptions extends Activity {

	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_options);

		// From GameOptions of imported class
		tv = (TextView) findViewById(R.id.go);

		tv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//Intent intent = new Intent(GameOptions.this, First.class);
				//Intent intent = new Intent(GameOptions.this, AppActivity.class);
				Intent intent = new Intent(GameOptions.this, BeaconsListView.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game_options, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.

		/*
		 * switch (item.getItemId()) { case R.id.action_settings: // go to
		 * settings return true; case R.id.leaderboardgamestart: // go to
		 * leaderboard Intent intent = new Intent(getApplicationContext(),
		 * Leaderboard.class); startActivity(intent);
		 * //intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT); return
		 * true;
		 * 
		 * case R.id.mybadges: // go to my badges return true; default: return
		 * super.onOptionsItemSelected(item); }
		 */

		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);

	}
}

package com.gimbal.android.sample;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class Leaderboard extends Activity {

	/*private static Leaderboard instance = null;
	
	
	private Leaderboard(){}
	
	public static Leaderboard getInstance()
	{
	if (instance == null)
		instance = new Leaderboard();
	
	return instance;
	}*/

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_leaderboard);
	    TextView scoreboard = (TextView) findViewById(R.id.scoreboard);
	    Score score = Score.getInstance();
	    System.out.println("The name is :" + score.getName() + "and the score is "+score.getScore());
	    //scoreboard.setBackgroundColor(CONTEXT_RESTRICTED);
		//scoreboard.setText("Hi "+score.getName()+", Your score is "+String.valueOf(score.getScore())); // final score 
	    scoreboard.setText("Hi "+score.getName()+", Your score is "+String.valueOf(score.getScore()));
		
		// Use Parse.com along with other part for e.g. 'instance'
		// -----Parse code
		/*Parse.enableLocalDatastore.get(this);

		Parse.initialize(this, "NEgy5OqvwjZwvrbIQJ05Iq9AqbxQmBSrjjIIUnua",
				"AgnzIyxpGjwCEaJopc6KQXaSWCywYgQ0qrBWkaJC");

		final ParseObject gameScore = new ParseObject("TestData");

		gameScore.put("score", 1);
		gameScore.put("playerName", "Adarsh");
		gameScore.put("cheatMode", false);
		gameScore.saveInBackground();

		// Retrieving Objects
		ParseQuery<ParseObject> query = ParseQuery.getQuery("TestData");

		// Retrieve the most recent ones
		query.orderByDescending("createdAt");

		// Only retrieve the last ten
		query.setLimit(10);

		 int score = gameScore.getInt("0"); // previously used
		final String playerName = gameScore.getString("playerName"); // previously used
		boolean cheatMode = gameScore.getBoolean("cheatMode"); // previously used

		scoreboard.setText(playerName + "         " + score);
*/
		//gameScore.increment("score"); // previously used 
		//gameScore.increment("rnIOGhqSQb",2);
		//gameScore.saveInBackground();
		
// previously used 
		/*Button b = (Button) findViewById(R.id.back);
		b.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						AppActivity.class);
				startActivity(intent);
			}
		});*/
		
	}

	
	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.leaderboard, menu);
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
	}*/

}

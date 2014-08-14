package com.example.dbexample;

import com.example.db.R;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button regButton = (Button)findViewById(R.id.buttonMainRegister);
        Button listButton = (Button)findViewById(R.id.ButtonMainList);
        regButton.setOnClickListener(this);
        listButton.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		Intent intent;
		switch(v.getId()) {
		case R.id.buttonMainRegister :
			intent = new Intent();
			intent.setClass(getApplicationContext(), Registration.class);
			startActivity(intent);
			break;
		case R.id.ButtonMainList :
			intent = new Intent();
			intent.setClass(getApplicationContext(), ListUsers.class);
			startActivity(intent);
			break;
		}
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

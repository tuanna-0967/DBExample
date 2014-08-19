package com.example.dbexample;

import com.example.db.DatabaseHandler;
import com.example.db.R;
import com.example.db.User;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DetailsUsers  extends Activity implements OnClickListener{
	private static String position = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.details_users);
		Intent intent = getIntent();
		position = intent.getStringExtra("position");
		Log.d("value of position from intent", position);
		DatabaseHandler db = new DatabaseHandler(this);
		User user = db.getUser(position);
		TextView textViewDetailName = (TextView) findViewById(R.id.textViewDetailsName);
		textViewDetailName.setText(user.getName());
		
		TextView textViewDetailAddress = (TextView) findViewById(R.id.textViewDetailsAddress);
		textViewDetailAddress.setText(user.getAddress());
		
		TextView textViewDetailsPhone = (TextView) findViewById(R.id.textViewDetailsPhone);
		textViewDetailsPhone.setText(user.getPhone());
		
		Button backButton = (Button)findViewById(R.id.buttonDetailsBack);
		backButton.setOnClickListener(this);
		
		Button editButton = (Button)findViewById(R.id.buttonEditDetails);
		editButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.buttonDetailsBack) {
			Intent intent = new Intent(getApplicationContext(), ListUsers.class);
			startActivity(intent);
		}
		else if(v.getId() == R.id.buttonEditDetails) {
			Intent intent = new Intent(getApplicationContext(), EditUsers.class);
			intent.putExtra("position", position);
			startActivity(intent);
		}
	}
}

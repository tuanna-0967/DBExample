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
import android.widget.EditText;
import android.widget.Toast;

public class EditUsers extends Activity implements OnClickListener{
	private static String position = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_user);
		Intent intent = getIntent();
		position = intent.getStringExtra("position");

		DatabaseHandler db = new DatabaseHandler(this);
		Log.d("position", position);
		//get user for the position clicked for edit
		User user = db.getUser(position);
		
		Log.d("User Name", user.getName());
		Log.d("Address", user.getAddress());
		Log.d("Users phone", user.getPhone());
		
		//set the values in editText boxes
		EditText name = ((EditText)findViewById(R.id.editTextEditName));
		name.setText(user.getName());
		EditText address = ((EditText)findViewById(R.id.editTextEditAddress));
		address.setText(user.getAddress());
		EditText phone = ((EditText)findViewById(R.id.editTextEditPhone));
		phone.setText(user.getPhone());
		
		Button backButton = (Button)findViewById(R.id.buttonEditBack);
		backButton.setOnClickListener(this);
		
		Button updateButton = (Button)findViewById(R.id.buttonEdit);
		updateButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.buttonEditBack) {
			Intent intent = new Intent(getApplicationContext(), ListUsers.class);
			startActivity(intent);
		}
		else if(v.getId() == R.id.buttonEdit) {
			User user = new User(
							((EditText)findViewById(R.id.editTextEditName)).getText().toString(),
							((EditText)findViewById(R.id.editTextEditAddress)).getText().toString(),
							((EditText)findViewById(R.id.editTextEditPhone)).getText().toString()
						);
			DatabaseHandler db = new DatabaseHandler(this);
			int updateCount = db.editUser(user, position);
			if(updateCount == 1) {
				Toast toast = Toast.makeText(getApplicationContext(),
						"User successfully updated",
						Toast.LENGTH_SHORT);
				toast.show();
			}
			else{
				Toast toast = Toast.makeText(getApplicationContext(),
						"User update failed, Try Again",
						Toast.LENGTH_SHORT);
				toast.show();
			}
		}
	}

}

package com.example.dbexample;

import com.example.db.DatabaseHandler;
import com.example.db.R;
import com.example.db.User;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends Activity implements OnClickListener{
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        Button regButton = (Button)findViewById(R.id.buttonRegister);
        regButton.setOnClickListener(this);
        Button backButton = (Button)findViewById(R.id.buttonRegisterBack);
        backButton.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		Intent intent;
		switch(v.getId()) {
		case R.id.buttonRegister :
			register();
			break;
		case R.id.buttonRegisterBack :
			intent = new Intent();
			intent.setClass(getApplicationContext(), MainActivity.class);
			startActivity(intent);
			break;
		}	
	}

	private void register() {
		String user = ((EditText)findViewById(R.id.editTextRegName)).getText().toString();
			String address = ((EditText)findViewById(R.id.editTextRegAddress)).getText().toString();
			String phone = ((EditText)findViewById(R.id.editTextRegPhone)).getText().toString();
			DatabaseHandler db = new DatabaseHandler(this);
			int id = db.addUser(new User(user,address,phone));
			db.close();
			if(id>0) {
				Toast toast = Toast.makeText(getApplicationContext(),
						"User registered at id " + id,
						Toast.LENGTH_SHORT);
				toast.show();
			}
			else {
				Toast toast = Toast.makeText(getApplicationContext(),
						"User registration failed",
						Toast.LENGTH_SHORT);
				toast.show();
			}
			((EditText)findViewById(R.id.editTextRegName)).setText("");
			((EditText)findViewById(R.id.editTextRegAddress)).setText("");
			((EditText)findViewById(R.id.editTextRegPhone)).setText("");
	}
}

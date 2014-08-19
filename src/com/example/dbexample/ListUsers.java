package com.example.dbexample;


import com.example.dbexample.DetailsUsers;
import com.example.db.DatabaseHandler;
import com.example.db.R;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListUsers extends ListActivity{
	
	public void onCreate(Bundle icicle) {
		 super.onCreate(icicle);
		 	DatabaseHandler db = new DatabaseHandler(this);
			String[] users = db.getAllUsers();
			if(users!=null) {
				for(String us:users) {
					Log.d("String Array Value", us);
				}
				db.close();
			}
		    // Use your own layout
		    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_users, R.id.textViewList, users);
		    setListAdapter(adapter);
		}
		
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Log.d("On click of a item", Integer.toString(position));
		Intent intent = new Intent();
		intent.setClass(getApplicationContext(), DetailsUsers.class);
		intent.putExtra("position", Integer.toString(position + 1));  //position starts from 0, but in db row starts from 1
		startActivity(intent);
	}
}

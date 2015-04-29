package com.afuture.listview;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.afuture.R;

public class ListViewActivity extends Activity {
	Button listview, simplecursorAdapter, simpleAdapter, myAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);
		listview = (Button) findViewById(R.id.listview);
		simplecursorAdapter = (Button) findViewById(R.id.simplecursorAdapter);
		simpleAdapter = (Button) findViewById(R.id.simpleAdapter);
		myAdapter = (Button) findViewById(R.id.myAdapter);
		listview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ListViewActivity.this,
						MyListActivity.class);
				startActivity(intent);
			}
		});
		simplecursorAdapter.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ListViewActivity.this,
						SimpleCursorAdapterListView.class);
				startActivity(intent);
			}
		});
		
		simpleAdapter.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ListViewActivity.this,
						SimpleAdapterActivity.class);
				startActivity(intent);
			}
		});
		
		myAdapter.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ListViewActivity.this,
						MyAdapter.class);
				startActivity(intent);
			}
		});
	}

	void xxx() {
		Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

		while (cursor.moveToNext()) {
			String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
			String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

			Log.d("TAG", "Name is : " + name);
			int isHas = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
			if (isHas > 0) {
				Cursor c = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = " + id, null, null);
				while (c.moveToNext()) {
					String number = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
					Log.d("TAG ", "Number is : " + number);
				}
				c.close();
			}
		}
		cursor.close();

	}
}

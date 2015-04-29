package com.afuture.listview;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.afuture.R;

public class MyListActivity extends Activity {
	ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_list);
		lv = (ListView) findViewById(R.id.listview);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getData());
		lv.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}

	private List<String> getData() {
		List<String> data = new ArrayList<String>();
		for (int i = 0; i < new Random().nextInt(50); ++i) {
			long x = new Random().nextLong();
			data.add(i + "." + x);
		}
		
		return data;
	}
}

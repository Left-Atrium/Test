package com.afuture.listview;

import com.afuture.R;
import com.afuture.listview.adapter.CustomedAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MyAdapter extends Activity {
	ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_adapter);
		lv = (ListView) findViewById(R.id.listview);
		CustomedAdapter ca = new CustomedAdapter(this);
		lv.setAdapter(ca);
		ca.notifyDataSetChanged();
		
	}
}

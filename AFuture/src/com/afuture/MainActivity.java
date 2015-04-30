package com.afuture;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.afuture.listview.ListViewActivity;

public class MainActivity extends Activity {
	Button listview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listview = (Button)findViewById(R.id.listview);
		listview.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent listViewIntent = new Intent(MainActivity.this,ListViewActivity.class);
				startActivity(listViewIntent);
			}
		});
		
	}

}
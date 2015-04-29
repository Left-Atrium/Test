package com.afuture.ontouchevent;

import java.util.ArrayList;
import java.util.List;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.afuture.R;

public class OnTouchEventActivity extends Activity {
	CostumedListView lv = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ontouchevent);
		lv = (CostumedListView) findViewById(R.id.lv);
	}
	@Override
	protected void onResume() {
		super.onResume();
		ArrayAdapter<String> aa = new ArrayAdapter<String>(this, 
														android.R.layout.simple_list_item_1, 
														getData());
		lv.setAdapter(aa);
		
		 
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			Log.i("parentoutput", "DownX = " + x);
			Log.i("parentoutput", "DownY = " + y);
			break;
		case MotionEvent.ACTION_MOVE:
			Log.i("parentoutput", "MoveX = " + x);
			Log.i("parentoutput", "MoveY = " + y);
			break;
		default:
			break;
		}
		return false;
	}
	private List<String> getData(){
		List<String> l = new ArrayList<String>();
		for(int i = 0;i < 10 ; ++i){
			
			l.add("project Hello World" + i*10);
		}
		return l ;
	}
}

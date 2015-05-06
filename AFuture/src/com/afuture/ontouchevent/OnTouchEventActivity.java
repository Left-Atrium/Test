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
import android.widget.Scroller;

import com.afuture.R;

public class OnTouchEventActivity extends Activity {
	Scroller myscroller;
	CostumedListView lv = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ontouchevent);
		lv = (CostumedListView) findViewById(R.id.lv);
		myscroller = new Scroller(this);
	}
	@Override
	protected void onResume() {
		super.onResume();
		ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
												R.layout.item_view, R.id.list_item, 
												getData());
		lv.setAdapter(aa);
		
		 
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			break;
		case MotionEvent.ACTION_MOVE:
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

package com.afuture.ontouchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;

public class CostumedListView extends ListView {

	public CostumedListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	public CostumedListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	public CostumedListView(Context context) {
		super(context);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		return super.onTouchEvent(ev);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public boolean onTouchEvent(MotionEvent event) {
//		float x = event.getX();
//		float y = event.getY();
//		int currentItem = pointToPosition((int)x, (int)y);
//		Log.i("positionoutput",currentItem + "");
//		
//		
//		
//		switch (event.getAction()) {
//		case MotionEvent.ACTION_DOWN:
//			Log.i("output", "DownX = " + x);
//			Log.i("output", "DownY = " + y);
//			break;
//		case MotionEvent.ACTION_MOVE:
//			Log.i("output", "MoveX = " + x);
//			Log.i("output", "MoveY = " + y);
//			break;
//		default:
//			break;
//		}
//		return true;
//	}
	
}

package com.ipjmc.scroller;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.Scroller;

public class CustomView extends LinearLayout {

	private static final String TAG = "CustomView";

	private Scroller mScroller;
	private GestureDetector mGestureDetector;
	public CustomView(Context context) {
		this(context, null);
	}
	
	public CustomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setClickable(true);
		setLongClickable(true);
		mScroller = new Scroller(context);
		Animation scaleAnimation = new ScaleAnimation(1, 0, 1, 0, 2, 0.5f ,2,0.5f);
		scaleAnimation.setDuration(5000);
		
		
		Animation alphaAnimation = new AlphaAnimation(0.1f, 1f);
		alphaAnimation.setDuration(2000);
		AnimationSet aset = new AnimationSet(true);
		aset.addAnimation(alphaAnimation);
		aset.addAnimation(scaleAnimation);
		
		this.setAnimation(aset);
//		this.setAnimation(scaleAnimation);
//		this.setAnimation(alphaAnimation);
//		mGestureDetector = new GestureDetector(context, new CustomGestureListener());
		 
	}
	@Override
	public void setOnClickListener(OnClickListener l) {
		// TODO Auto-generated method stub
		super.setOnClickListener(l);
	}
	//调用此方法滚动到目标位置
	public void smoothScrollTo(int fx, int fy) {
		int dx = fx - mScroller.getFinalX();
		int dy = fy - mScroller.getFinalY();
		smoothScrollBy(dx, dy);
	}

	//调用此方法设置滚动的相对偏移
	public void smoothScrollBy(int dx, int dy) {

		//设置mScroller的滚动偏移量
		mScroller.startScroll(mScroller.getFinalX(), mScroller.getFinalY(), dx, dy);
		invalidate();//这里必须调用invalidate()才能保证computeScroll()会被调用，否则不一定会刷新界面，看不到滚动效果
	}
	
	@Override
	public void computeScroll() {
	
		//先判断mScroller滚动是否完成
		if (mScroller.computeScrollOffset()) {
		
			//这里调用View的scrollTo()完成实际的滚动
			scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
			
			//必须调用该方法，否则不一定能看到滚动效果
			postInvalidate();
		}
		super.computeScroll();
	}
	float starty,startx;
	int logy = 0;
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			starty = event.getY();
			startx = event.getX();
			break;
		case MotionEvent.ACTION_MOVE:
			mScroller.startScroll(getScrollX(),getScrollY(), (int)(startx - event.getX()),(int)(starty - event.getY()),0);
			starty = event.getY();
			startx = event.getX();
			postInvalidate();
			break;
		case MotionEvent.ACTION_UP :
			mScroller.startScroll(0,0,0,0,0);
			postInvalidate();
			break;
		default:
			return mGestureDetector.onTouchEvent(event);
		}
		return super.onTouchEvent(event);
	}
	
	class CustomGestureListener implements GestureDetector.OnGestureListener {

		@Override
		public boolean onDown(MotionEvent e) {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public void onShowPress(MotionEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean onSingleTapUp(MotionEvent e) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY) {
			
			int dis = (int)((distanceY-0.5)/2);
			Log.i(TAG, dis + ".");
			smoothScrollBy(0, dis);
			return false;
		}

		@Override
		public void onLongPress(MotionEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
}
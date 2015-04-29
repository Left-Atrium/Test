package com.afuture.listview.data;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewBean {
	Button bt;
	TextView title;
	TextView info;
	ImageView iv;
	public Button getBt() {
		return bt;
	}
	public void setBt(Button bt) {
		this.bt = bt;
	}
	public TextView getTitle() {
		return title;
	}
	public void setTitle(TextView title) {
		this.title = title;
	}
	public TextView getInfo() {
		return info;
	}
	public void setInfo(TextView info) {
		this.info = info;
	}
	public ImageView getIv() {
		return iv;
	}
	public void setIv(ImageView iv) {
		this.iv = iv;
	}
	
}

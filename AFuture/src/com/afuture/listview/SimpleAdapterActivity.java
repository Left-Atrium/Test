package com.afuture.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.afuture.R;

public class SimpleAdapterActivity extends Activity {
	ListView lv ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_adapter);
		lv = (ListView) findViewById(R.id.listview);
		SimpleAdapter ad = new SimpleAdapter(this, 
				getData(), 
				R.layout.simpleadapter, 
				new String[]{"image","title","info"}, 
				new int[]{R.id.image,R.id.title,R.id.info});
		
		lv.setAdapter(ad);
		
		ad.notifyDataSetChanged();
		
	}
	private List<Map<String, Object>> getData(){
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		Map<String, Object> vl;
		
		vl = new HashMap<String, Object>();
		vl.put("image", R.drawable.ic_launcher);
		vl.put("title", "Example");
		vl.put("info", "Infomation");
		data.add(vl);
		
		vl = new HashMap<String, Object>();
		vl.put("image", R.drawable.ic_launcher);
		vl.put("title", "Doom");
		vl.put("info", "PreVail");
		data.add(vl);
		
		vl = new HashMap<String, Object>();
		vl.put("image", R.drawable.ic_launcher);
		vl.put("title", "GOD");
		vl.put("info", "Sacred");
		data.add(vl);
		
		return data;
	}
}

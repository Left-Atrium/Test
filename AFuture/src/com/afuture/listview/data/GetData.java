package com.afuture.listview.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.afuture.R;

public class GetData {
	public static List<Map<String,Object>> getData(){
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> map;

		map = new HashMap<String,Object>();

		map.put("image", R.drawable.ic_launcher);
		map.put("title", "Hello Android");
		map.put("info","I'm a good boy");
		list.add(map);
		
		map = new HashMap<String,Object>();
		map.put("image", R.drawable.ic_launcher);
		map.put("title", "Hello Java");
		map.put("info","You're a Good Girl");
		list.add(map);
		
		map = new HashMap<String,Object>();
		map.put("image", R.drawable.ic_launcher);
		map.put("title", "Hello Android");
		map.put("info","Have a nice Day");
		list.add(map);
		return list;
	}
}

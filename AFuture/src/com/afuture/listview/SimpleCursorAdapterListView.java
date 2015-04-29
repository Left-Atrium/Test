package com.afuture.listview;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.provider.Contacts.PeopleColumns;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.afuture.R;

public class SimpleCursorAdapterListView extends Activity {
	ListView lv ;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simplecursoradapterlistview);
		lv = (ListView) findViewById(R.id.listview);
		Cursor cursor = getContentResolver().query(People.CONTENT_URI, null, null, null, null);
		//我们将获得的Cursor对象交由Activity管理，这样Cursor的生命周期和Activity便能够自动同步，省去自己手动管理Cursor。
		startManagingCursor(cursor);
		/**
		 * SimpleCursorAdapter 构造函数前面3个参数和ArrayAdapter是一样的，
		 * 最后两个参数：一个包含数据库的列的String型数组，
		 * 一个包含布局文件中对应组件id的int型数组。
		 * 其作用是自动的将String型数组所表示的每一列数据映射到布局文件对应id的组件上。
		 * 上面的代码，将NAME列的数据一次映射到布局文件的id为text1的组件上。
		 */
		ListAdapter adapter = new android.support.v4.widget.SimpleCursorAdapter
						(this, 
						android.R.layout.simple_list_item_1, 
						cursor, 
						new String[]{PeopleColumns.NAME},
						new int[]{android.R.id.text1});
		lv.setAdapter(adapter);
		
		
		
	}
}

package com.afuture.listview.listview;

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
		//���ǽ���õ�Cursor������Activity��������Cursor���������ں�Activity���ܹ��Զ�ͬ����ʡȥ�Լ��ֶ�����Cursor��
		startManagingCursor(cursor);
		/**
		 * SimpleCursorAdapter ���캯��ǰ��3��������ArrayAdapter��һ���ģ�
		 * �������������һ���������ݿ���е�String�����飬
		 * һ�����������ļ��ж�Ӧ���id��int�����顣
		 * ���������Զ��Ľ�String����������ʾ��ÿһ������ӳ�䵽�����ļ���Ӧid������ϡ�
		 * ����Ĵ��룬��NAME�е�����һ��ӳ�䵽�����ļ���idΪtext1������ϡ�
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

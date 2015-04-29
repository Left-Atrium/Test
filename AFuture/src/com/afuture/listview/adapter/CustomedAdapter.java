package com.afuture.listview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.afuture.R;
import com.afuture.listview.data.GetData;
import com.afuture.listview.data.ViewBean;

public class CustomedAdapter extends BaseAdapter {
	private LayoutInflater minflater;
	Context context;
	ViewBean vb;
	public CustomedAdapter(Context context) {
		this.context = context;
		this.minflater = LayoutInflater.from(context);
	}
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return GetData.getData().size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if(null == convertView){
			vb = new ViewBean();
			convertView = minflater.inflate(R.layout.view, null);
			vb.setBt((Button)convertView.findViewById(R.id.button));
			vb.setInfo((TextView)convertView.findViewById(R.id.info));
			vb.setTitle((TextView)convertView.findViewById(R.id.title));
			vb.setIv((ImageView)convertView.findViewById(R.id.image));
			convertView.setTag(vb);
		}else{
			vb = (ViewBean) convertView.getTag();
		}
		
		vb.getIv().setBackgroundResource((Integer)GetData.getData().get(position).get("image"));
        vb.getTitle().setText((String)GetData.getData().get(position).get("title"));
        vb.getInfo().setText((String)GetData.getData().get(position).get("info"));
        final String info = vb.getInfo().getText().toString();
        vb.getBt().setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(context, info, Toast.LENGTH_SHORT).show();
			}
		});
        
        return convertView;
	}
}

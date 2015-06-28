package dialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.afuture.R;

public class ProgressDialogActivity extends Activity {
	ProgressDialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_progressdialog);
		findViewById(R.id.startdialog).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialog = new ProgressDialog(ProgressDialogActivity.this);
				dialog.setMessage("拼命加载中……");
				dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				dialog.setMax(100);
				dialog.setCancelable(false);
				dialog.show();
				new ProgressAsy().execute(ProgressDialogActivity.this);
			}
		});
	}
	
	class ProgressAsy extends AsyncTask<Context, Integer, String>{
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			System.out.println("开始啦！");
		}
		
		
		
		@Override
		protected String doInBackground(Context... params) {
			for(int i = 1 ; i <= 10; i++ )
			try {
				Thread.sleep(1000);
				publishProgress(i*10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		
		@Override
		protected void onProgressUpdate(Integer... values) {
			dialog.setProgress(values[0]);
			if(100 == values[0])
				dialog.dismiss();
			super.onProgressUpdate(values);
			
			
		}
		
		
		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

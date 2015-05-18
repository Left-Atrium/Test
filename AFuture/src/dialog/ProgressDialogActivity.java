package dialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.afuture.R;

public class ProgressDialogActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_progressdialog);
		findViewById(R.id.startdialog).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ProgressDialog.show(ProgressDialogActivity.this, 
						"请稍后……", "请稍后……", true);
			}
		});
	}
}

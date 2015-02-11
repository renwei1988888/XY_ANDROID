package com.xy.activity;

import android.content.Intent;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.xy.R;
import com.xy.common.BaseActivity;

@EActivity(R.layout.activity_myyjfk)
public class MyYjfkActivity extends BaseActivity {

	private Intent intent;

	@ViewById(R.id.textView1)
	TextView textview1;

	@AfterViews
	public void init() {
		textview1.setText(getResources().getString(R.string.main_left_yjfk_tx));
	}

	// 返回
	@Click(R.id.main_topleft_img)
	public void back() {
		intent = new Intent(this, Main.class);
		startActivity(intent);
		this.finish();
		overridePendingTransition(R.anim.slide_left_in,R.anim.slide_right_out);
	}
	
	@Click(R.id.myyjfk_submit_btn)
	public void submit(){
		this.finish();
	}

}

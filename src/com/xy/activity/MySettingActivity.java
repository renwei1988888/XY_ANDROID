package com.xy.activity;

import android.content.Intent;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.xy.R;
import com.xy.common.BaseActivity;

@EActivity(R.layout.activity_mysetting)
public class MySettingActivity extends BaseActivity {
	private Intent intent;

	@ViewById(R.id.textView1)
	TextView textview1;

	@AfterViews
	public void init() {
		textview1.setText(getResources().getString(R.string.main_left_setting_tx));
	}

	// 返回
	@Click(R.id.main_topleft_img)
	public void back() {
		intent = new Intent(this, Main.class);
		startActivity(intent);
		this.finish();
		overridePendingTransition(R.anim.slide_left_in,R.anim.slide_right_out);
	}
	
	// 注销
	@Click(R.id.mysetting_outlogin_btn)
	public void outLogin(){
		this.finish();
	}

}

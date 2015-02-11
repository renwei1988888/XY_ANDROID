package com.xy.activity;

import android.content.Intent;
import android.webkit.WebView;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.xy.R;
import com.xy.common.BaseActivity;

@EActivity(R.layout.activity_healthtipsdetail)
public class HealthTipsDetailActivity extends BaseActivity {
	
	private Intent intent;
	
	@ViewById(R.id.textView1)
	TextView textView1;
	
	@ViewById(R.id.tip_detail_tv)
	TextView tip_detail_tv;
	
	@AfterViews
	public void init(){
		textView1.setText(R.string.main_health_detail);
		intent = this.getIntent();
		tip_detail_tv.setText(intent.getStringExtra("tipContent"));
	}
	
	// 返回
	@Click(R.id.main_topleft_img)
	public void back() {
		this.finish();
	}
	
}

package com.xy.activity;

import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.xy.R;
import com.xy.common.BaseActivity;

@EActivity(R.layout.activity_myjgzxorder)
public class MyJgxzxOrderActivity extends BaseActivity {

	@ViewById(R.id.textView1)
	TextView textView1;

	@AfterViews
	public void init() {
		textView1.setText(R.string.myjghz_yjyy_tx);
	}

	// 返回
	@Click(R.id.main_topleft_img)
	public void back() {
		this.finish();
	}
	
	// 预约处理
	@Click(R.id.myjgzx_yy_btn)
	public void toOrder(){
		this.finish();
	}

}

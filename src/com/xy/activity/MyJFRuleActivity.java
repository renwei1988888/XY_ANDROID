package com.xy.activity;

import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.xy.R;
import com.xy.common.BaseActivity;

@EActivity(R.layout.activity_myjfrule)
public class MyJFRuleActivity extends BaseActivity {
	
	@ViewById(R.id.textView1)
	TextView textView1;
	
	@AfterViews
	public void init(){
		textView1.setText(R.string.myjf_rule_tx);
	}
	
	// 返回
	@Click(R.id.main_topleft_img)
	public void back(){
		this.finish();
	}

}

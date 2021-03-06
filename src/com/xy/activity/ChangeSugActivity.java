package com.xy.activity;

import android.content.Intent;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.xy.R;
import com.xy.common.BaseActivity;

@EActivity(R.layout.activity_changesug)
public class ChangeSugActivity extends BaseActivity {
	
	@ViewById(R.id.textView1)
	TextView textView1;
	
	@AfterViews
	public void init(){
		textView1.setText(R.string.main_change_plan_txt);
	}
	
	@Click(R.id.main_topleft_img)
	public void back(){
		this.finish();
	}
	
	@Click(R.id.main_change_begin_btn)
	public void beginChange(){
		Intent intent = new Intent(this, ChangeActivity_.class);
		startActivity(intent);
	}

}

package com.xy.activity;

import android.content.Intent;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.xy.R;
import com.xy.common.BaseActivity;

@EActivity(R.layout.activity_change)
public class ChangeActivity extends BaseActivity {
	
	private Intent intent;
	
	@ViewById(R.id.textView1)
	TextView textView1;
	
	@AfterViews
	public void init(){
		textView1.setText(R.string.main_change_title);
	}
	
	@Click(R.id.main_topleft_img)
	public void back(){
		this.finish();
	}
	
	@Click(R.id.main_change_record_ll)
	public void toRecord(){
		intent = new Intent(this, ChangeRecordActivity_.class);
		startActivity(intent);
	}
	
	@Click(R.id.main_change_tell_ll)
	public void toTell(){
		intent = new Intent(this, ChangeTellActivity_.class);
		startActivity(intent);
	}
	
	@Click(R.id.main_change_testinform_ll)
	public void toInform(){
		intent = new Intent(this, ChangeTestInformActivity_.class);
		startActivity(intent);
	}
	
	@Click(R.id.main_change_positive_ll)
	public void toPositive(){
		intent = new Intent(this, ChangePositiveActivity_.class);
		startActivity(intent);
	}
	
}

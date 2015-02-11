package com.xy.activity;

import android.content.Intent;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.xy.R;
import com.xy.common.BaseActivity;

@EActivity(R.layout.activity_myinfo)
public class MyInfoActivity extends BaseActivity {
	
private Intent intent;
	
	@ViewById(R.id.textView1)
	TextView textview1;
	
	@AfterViews
	
	public void init(){
		textview1.setText(getResources().getString(R.string.main_left_myInfo_tx));
	}
	
	@Click(R.id.main_topleft_img)
	public void back(){
		intent = new Intent(this, Main.class);
		startActivity(intent);
		this.finish();
		overridePendingTransition(R.anim.slide_left_in,R.anim.slide_right_out);
	}

}

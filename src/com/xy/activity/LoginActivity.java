package com.xy.activity;

import android.content.Intent;
import android.widget.ImageView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.xy.R;
import com.xy.common.BaseActivity;

@EActivity(R.layout.activity_login)
public class LoginActivity extends BaseActivity {
	
	private boolean isAutoLogin = false;
	
	@ViewById(R.id.is_autoLogin_img)
	ImageView isAuto_img;
	
	@AfterViews
	public void init(){
		
	}
	
	@Click(R.id.login_btn)
	void toLogin(){
		Intent intent = new Intent(this, Main.class);
		startActivity(intent);
	}
	
	@Click(R.id.register_tx)
	public void toRegist(){
		Intent intent = new Intent(this, RegisterActivity_.class);
		startActivity(intent);
	}
	
	@Click(R.id.login_forget_tv)
	public void toChangePwd(){
		Intent intent = new Intent(this, ForPwdActivity_.class);
		startActivity(intent);
	}
	
	@Click(R.id.is_autoLogin_img)
	public void setAutoLogin(){
		if (isAutoLogin == false) {
			isAuto_img.setBackgroundResource(R.drawable.login_isautologin_default);
			isAutoLogin = true;
		} else {
			isAuto_img.setBackgroundResource(R.drawable.login_isautologin_click);
			isAutoLogin = false;
		}
			
	}

}

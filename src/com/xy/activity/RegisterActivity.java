package com.xy.activity;

import org.apache.commons.lang.StringUtils;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.xy.R;
import com.xy.common.BaseActivity;
import com.xy.component.ToastComponent;
import com.xy.util.StringUtil;

/** 
* @ClassName: RegisterActivity 
* @Description: 注册页面 
* @author rw 
* @date 2015-2-11 上午11:08:20 
*
*/ 
@EActivity(R.layout.activity_register)
public class RegisterActivity extends BaseActivity {
	
    @Bean
    ToastComponent toastComponent;
	
	@ViewById(R.id.textView1)
	TextView textView1;
	
	@ViewById(R.id.main_topleft_img)
	ImageView main_topleft_img;
	
	@ViewById(R.id.regist_username_edt)
	EditText regist_username_edt;
	
	@ViewById(R.id.regist_password_et)
	EditText regist_password_et;
	
	@ViewById(R.id.regist_affirm_password_et)
	EditText regist_affirm_password_et;
	
	@ViewById(R.id.regist_email_et)
	EditText regist_email_et;
	
	@ViewById(R.id.regist_age_et)
	EditText regist_age_et;
	
	@AfterViews
	public void init(){
		textView1.setText(R.string.login_register_Txt);
		main_topleft_img.setVisibility(View.GONE);
	}
	
	// 返回
	@Click(R.id.main_topleft_img)
	public void back(){
		this.finish();
	}
	
	// 确认注册
	@Click(R.id.r_submit)
	public void toRegist(){
		String userName = StringUtils.trim(regist_username_edt.getText().toString());
		String password = StringUtils.trim(regist_password_et.getText().toString());
		String affirmPassword = StringUtils.trim(regist_affirm_password_et.getText().toString());
		String email = StringUtils.trim(regist_email_et.getText().toString());
		String age = StringUtils.trim(regist_age_et.getText().toString());
		if (checkRegister(userName, password, affirmPassword, email, age)) {
			
		}
	}

	private boolean checkRegister (String userName , String password , String affirmPassword , String email , String age){
		if (StringUtils.isEmpty(userName)) {
			toastComponent.show("请输入用户名!");
			return false;
		}
		if (StringUtils.isEmpty(password)) {
			toastComponent.show("请输入密码!");
			return false;
		}
		if (StringUtils.isEmpty(affirmPassword)) {
			toastComponent.show("请输入确认密码！");
			return false;
		}
		if (!StringUtils.equals(password, affirmPassword)) {
			toastComponent.show("两次密码不一致！");
			return false;
		}
		if (StringUtils.isEmpty(email)) {
			toastComponent.show("请输入邮箱！");
			return false;
		}
		if (StringUtils.isEmpty(age)) {
			toastComponent.show("请输入你的出身年月！");
			return false;
		}
		return true;
	}
}

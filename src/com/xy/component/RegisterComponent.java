package com.xy.component;

import java.util.Map;

import android.os.AsyncTask;

import com.googlecode.androidannotations.annotations.EBean;

/** 
 * @ClassName: RegisterComponent 
 * @Description: 注册组件
 * @author ls
 * @date 2015-2-11 下午4:40:45 
 */
@EBean
public class RegisterComponent {

	public void executeRegister (String userName , String password , String email , String age){
		
	}

	private Integer Register (String userName , String password , String email , String age) {
		
		return -2;
	}
	abstract class Register extends AsyncTask<String, Void, String>{
		
		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			return null;
		}
	}
}

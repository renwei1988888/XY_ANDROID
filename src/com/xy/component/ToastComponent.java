package com.xy.component;

import android.content.Context;
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;

/** 
 * @ClassName: ToastComponent 
 * @Description: 消息组件
 * @author ls
 * @date 2015-2-11 下午3:46:06 
 */
@EBean
public class ToastComponent {
 
	@RootContext
	Context context;
	
	public void show (String message) {
		Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
	}

	public void showLong (String message) {
		Toast.makeText(context, message, Toast.LENGTH_LONG).show();
	}
	
}

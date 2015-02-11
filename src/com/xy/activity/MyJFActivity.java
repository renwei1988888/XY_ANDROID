package com.xy.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.widget.ListView;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.xy.R;
import com.xy.adapter.MyJFAdapter;
import com.xy.bean.MyJFBean;
import com.xy.common.BaseActivity;

@EActivity(R.layout.activity_myjf)
public class MyJFActivity extends BaseActivity {
	
	private Intent intent;
	
	@ViewById(R.id.textView1) // 标题
	TextView textview1;
	
	@ViewById(R.id.myjf_jf_lv) // 积分列表
	ListView myjf_jf_lv;
	
	MyJFAdapter myJFAdapter; // 积分适配器
	List<MyJFBean> myJFList = new ArrayList<MyJFBean>();// 积分数据
	
	@AfterViews
	public void init(){
		textview1.setText(getResources().getString(R.string.main_left_myjf_tx));
		// 初始化数据开始
		MyJFBean bean1 = new MyJFBean();
		bean1.setJfTime("2014-12-10");
		bean1.setJfSource("完成注册");
		bean1.setJfNum("5");
		MyJFBean bean2 = new MyJFBean();
		bean2.setJfTime("2014-12-10");
		bean2.setJfSource("完成行为评估");
		bean2.setJfNum("10");
		MyJFBean bean3 = new MyJFBean();
		bean3.setJfTime("2014-12-10");
		bean3.setJfSource("完成心理评估");
		bean3.setJfNum("10");
		myJFList.add(bean1);
		myJFList.add(bean2);
		myJFList.add(bean3);
		// 初始化数据结束
		myJFAdapter = new MyJFAdapter(this, myJFList);
		myjf_jf_lv.setAdapter(myJFAdapter);
		
	}
	
	// 返回首页
	@Click(R.id.main_topleft_img)
	public void back(){
		intent = new Intent(this, Main.class);
		startActivity(intent);
		this.finish();
		overridePendingTransition(R.anim.slide_left_in,R.anim.slide_right_out);
	}
	
	// 查看积分规则
	@Click(R.id.myjf_showrule_btn)
	public void showRule(){
		intent = new Intent(this, MyJFRuleActivity_.class);
		startActivity(intent);
	}

}

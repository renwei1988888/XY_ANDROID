package com.xy.activity;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.xy.R;
import com.xy.common.BaseActivity;
import com.xy.common.Constants;
import com.xy.util.StringUtil;

@EActivity(R.layout.activity_myjgzxdetail)
public class MyJgzxDetailActivity extends BaseActivity {

	@ViewById(R.id.textView1)
	TextView textView1;
	
	@ViewById(R.id.myjgzx_bus)
	TextView myjgzx_bus;
	
	@ViewById(R.id.myjgzx_address)
	TextView myjgzx_address;
	
	@ViewById(R.id.myjgzx_phone)
	TextView myjgzx_phone;
	
	@ViewById(R.id.myjgzx_netsite)
	TextView myjgzx_netsite;
	
	@ViewById(R.id.myjgzx_yy_ll)
	LinearLayout myjgzx_yy_ll;

	int groupPositon = 0;
	int childPosition = 0;
	
	@AfterViews
	public void init() {
		textView1.setText(R.string.jgzx_jgjs_tx);
		Intent intent = this.getIntent();
		groupPositon = Integer.parseInt(intent.getStringExtra("groupPositon"));
		childPosition = Integer.parseInt(intent.getStringExtra("childPosition"));
		
		// 设置不同机构的信息
		if (groupPositon == 0 && childPosition == 0) {
			myjgzx_address.setText(StringUtil.toDBC(Constants.MYJGZX_ADDRESS[0]));
			myjgzx_phone.setText(Constants.MYJGZX_PHONE[0]);
			myjgzx_netsite.setText(Constants.MYJGZX_NETSITE[0]);
			myjgzx_bus.setText(StringUtil.toDBC(Constants.MYJGZX_BUS[0]));

		} else if (groupPositon == 0 && childPosition == 1) {
			myjgzx_address.setText(StringUtil.toDBC(Constants.MYJGZX_ADDRESS[1]));
			myjgzx_bus.setText(StringUtil.toDBC(Constants.MYJGZX_BUS[1]));

		} else if (groupPositon == 0 && childPosition == 2) {
			myjgzx_address.setText(StringUtil.toDBC(Constants.MYJGZX_ADDRESS[2]));
			myjgzx_netsite.setText(Constants.MYJGZX_NETSITE[1]);
			myjgzx_yy_ll.setVisibility(View.GONE);

		} else if (groupPositon == 0 && childPosition == 3) {
			myjgzx_address.setText(StringUtil.toDBC(Constants.MYJGZX_ADDRESS[3]));
			myjgzx_phone.setText(Constants.MYJGZX_PHONE[1]);
			myjgzx_yy_ll.setVisibility(View.GONE);

		} else if (groupPositon == 0 && childPosition == 4) {
			myjgzx_address.setText(StringUtil.toDBC(Constants.MYJGZX_ADDRESS[4]));
			myjgzx_phone.setText(Constants.MYJGZX_PHONE[2]);
			myjgzx_yy_ll.setVisibility(View.GONE);

		} else if (groupPositon == 1 && childPosition == 0) {
			myjgzx_address.setText(StringUtil.toDBC(Constants.MYJGZX_ADDRESS[5]));
			myjgzx_phone.setText(Constants.MYJGZX_PHONE[5]);
			myjgzx_yy_ll.setVisibility(View.GONE);

		} else if (groupPositon == 1 && childPosition == 1) {
			myjgzx_address.setText(StringUtil.toDBC(Constants.MYJGZX_ADDRESS[7]));
			myjgzx_phone.setText(Constants.MYJGZX_PHONE[6]);
			myjgzx_yy_ll.setVisibility(View.GONE);

		} else if (groupPositon == 2 && childPosition == 0) {
			myjgzx_address.setText(StringUtil.toDBC(Constants.MYJGZX_ADDRESS[8]));
			myjgzx_phone.setText(Constants.MYJGZX_PHONE[7]);
			myjgzx_yy_ll.setVisibility(View.GONE);

		} else if (groupPositon == 2 && childPosition == 1) {
			myjgzx_address.setText(StringUtil.toDBC(Constants.MYJGZX_ADDRESS[9]));
			myjgzx_phone.setText(Constants.MYJGZX_PHONE[8]);
			myjgzx_yy_ll.setVisibility(View.GONE);

		} else {
			myjgzx_address.setText(StringUtil.toDBC(Constants.MYJGZX_ADDRESS[10]));
			myjgzx_phone.setText(Constants.MYJGZX_PHONE[9]);
			myjgzx_yy_ll.setVisibility(View.GONE);

		}

	}

	// 返回
	@Click(R.id.main_topleft_img)
	public void back() {
		this.finish();
	}
	
	// 一键预约
	@Click(R.id.myjgzx_yy_btn)
	public void goOrder(){
		Intent intent = new Intent(this, MyJgxzxOrderActivity_.class);
		startActivity(intent);
	}

}

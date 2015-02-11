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
import com.xy.adapter.HealthTipsAdapter;
import com.xy.bean.HealthTipsBean;
import com.xy.common.BaseActivity;
import com.xy.common.Constants;

@EActivity(R.layout.activity_healthtips)
public class HealthTipsActivity extends BaseActivity {

	private Intent intent;
	private int modeId = 0;
	HealthTipsAdapter adapter;
	private List<HealthTipsBean> tipList;

	@ViewById(R.id.textView1)
	TextView textView1;
	
	@ViewById(R.id.healthtip_lv)
	ListView healthtip_lv;

	@AfterViews
	public void init() {
		intent = this.getIntent();
		modeId = Integer.parseInt(intent.getStringExtra("modelId"));
		if (modeId == 1) {
			textView1.setText(Constants.MODEL_TITTLES[0]);
			tipList = new ArrayList<HealthTipsBean>();
			for(int i = 0; i < 12; i++){
				HealthTipsBean bean = new HealthTipsBean();
				bean.setModelId(Constants.MODEL_IDS[0]);
				bean.setTipTittle(Constants.TIP1_TITTLES[i]);
				bean.setTipContent(Constants.TIP1_CONTENTS[i]);
				tipList.add(bean);
			}
		} else if (modeId == 2) {
			textView1.setText(Constants.MODEL_TITTLES[1]);
			tipList = new ArrayList<HealthTipsBean>();
			for(int i = 0; i < 4; i++){
				HealthTipsBean bean = new HealthTipsBean();
				bean.setModelId(Constants.MODEL_IDS[1]);
				bean.setTipTittle(Constants.TIP2_TITTLES[i]);
				bean.setTipContent(Constants.TIP2_CONTENTS[i]);
				tipList.add(bean);
			}

		} else if (modeId == 3) {
			textView1.setText(Constants.MODEL_TITTLES[2]);
			tipList = new ArrayList<HealthTipsBean>();
			for(int i = 0; i < 8; i++){
				HealthTipsBean bean = new HealthTipsBean();
				bean.setModelId(Constants.MODEL_IDS[2]);
				bean.setTipTittle(Constants.TIP3_TITTLES[i]);
				bean.setTipContent(Constants.TIP3_CONTENTS[i]);
				tipList.add(bean);
			}

		} else if (modeId == 4) {
			textView1.setText(Constants.MODEL_TITTLES[3]);
			tipList = new ArrayList<HealthTipsBean>();
			for(int i = 0; i < 6; i++){
				HealthTipsBean bean = new HealthTipsBean();
				bean.setModelId(Constants.MODEL_IDS[3]);
				bean.setTipTittle(Constants.TIP4_TITTLES[i]);
				bean.setTipContent(Constants.TIP4_CONTENTS[i]);
				tipList.add(bean);
			}

		} else if (modeId == 5) {
			textView1.setText(Constants.MODEL_TITTLES[4]);
			tipList = new ArrayList<HealthTipsBean>();
			for(int i = 0; i < 7; i++){
				HealthTipsBean bean = new HealthTipsBean();
				bean.setModelId(Constants.MODEL_IDS[4]);
				bean.setTipTittle(Constants.TIP5_TITTLES[i]);
				bean.setTipContent(Constants.TIP5_CONTENTS[i]);
				tipList.add(bean);
			}

		} else {
			textView1.setText(Constants.MODEL_TITTLES[5]);
			tipList = new ArrayList<HealthTipsBean>();
			for(int i = 0; i < 12; i++){
				HealthTipsBean bean = new HealthTipsBean();
				bean.setModelId(Constants.MODEL_IDS[5]);
				bean.setTipTittle(Constants.TIP6_TITTLES[i]);
				bean.setTipContent(Constants.TIP6_CONTENTS[i]);
				tipList.add(bean);
			}

		}
		adapter = new HealthTipsAdapter(this, tipList);
		healthtip_lv.setAdapter(adapter);		
	}

	@Click(R.id.main_topleft_img)
	public void back() {
		this.finish();
	}

}

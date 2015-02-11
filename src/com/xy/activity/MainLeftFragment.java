package com.xy.activity;

import com.xy.R;
import com.xy.common.BaseFragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

@SuppressLint("ValidFragment")
public class MainLeftFragment extends BaseFragment implements OnClickListener {

	private LinearLayout main_left_setting_ll, main_left_yjfk_ll,
			main_left_jgzx_ll, main_left_myjf_ll, main_left_myinfo_ll;
	private Intent intent;

	private void init() {
		FragmentActivity activity = getActivity();
		main_left_setting_ll = (LinearLayout) activity
				.findViewById(R.id.main_left_setting_ll);
		main_left_yjfk_ll = (LinearLayout) activity
				.findViewById(R.id.main_left_yjfk_ll);
		main_left_jgzx_ll = (LinearLayout) activity
				.findViewById(R.id.main_left_jgzx_ll);
		main_left_myjf_ll = (LinearLayout) activity
				.findViewById(R.id.main_left_myjf_ll);
		main_left_myinfo_ll = (LinearLayout) activity
				.findViewById(R.id.main_left_myinfo_ll);
		main_left_setting_ll.setOnClickListener(this);
		main_left_yjfk_ll.setOnClickListener(this);
		main_left_jgzx_ll.setOnClickListener(this);
		main_left_myjf_ll.setOnClickListener(this);
		main_left_myinfo_ll.setOnClickListener(this);

	}

	// 获取数据入口
	@Override
	protected Object onCreateTaskLoadData(Object... params) {
		return null;
	}

	// 控件初始化入口
	@Override
	protected Object onEndTaskAddView(Object result) {

		if (getView() == null) {
			return null;
		}
		((ViewGroup) getView()).removeAllViews();
		((ViewGroup) getView()).addView(inflater.inflate(
				R.layout.main_left_fragment, null));
		init();
		return null;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.main_left_myinfo_ll:
			intent = new Intent(getActivity(), MyInfoActivity_.class);
			startActivity(intent);
			break;
		case R.id.main_left_myjf_ll:
			intent = new Intent(getActivity(), MyJFActivity_.class);
			startActivity(intent);
			break;
		case R.id.main_left_jgzx_ll:
			intent = new Intent(getActivity(), MyJgzxActivity_.class);
			startActivity(intent);
			break;
		case R.id.main_left_yjfk_ll:
			intent = new Intent(getActivity(), MyYjfkActivity_.class);
			startActivity(intent);
			break;
		case R.id.main_left_setting_ll:
			intent = new Intent(getActivity(), MySettingActivity_.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}

}

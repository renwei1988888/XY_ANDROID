package com.xy.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.xy.R;
import com.xy.adapter.MyJGZXAdapter;
import com.xy.common.BaseActivity;

@EActivity(R.layout.activity_myjgzx)
public class MyJgzxActivity extends BaseActivity {

	private Intent intent;

	@ViewById(R.id.jg_expandablelistview)
	ExpandableListView jg_expandablelistview;

	@ViewById(R.id.textView1)
	TextView textview1;

	// 群组名称
	private String[] jc_group = new String[] { "检测机构", "高效抗逆转录病毒治疗机构",
			"长沙市美沙酮门诊" };
	private String[][] groups = new String[][] {
			{ "长沙市疾病预防控制中心", "中南大学湘雅三医院检验科", "湖南省疾病预防控制中心", "左岸彩虹工作组",
					"中大阳光社工服务中心" }, { "长沙市传染病医院", "湘雅二医院" },
			{ "天心区美沙酮门诊", "芙蓉区美沙酮门诊地址", "浏阳市美沙酮门诊地址" } };

	@AfterViews
	public void init() {
		textview1.setText(getResources().getString(R.string.main_left_jgzx_tx));
		MyJGZXAdapter adapter = new MyJGZXAdapter(jc_group, groups, this);
		jg_expandablelistview.setAdapter(adapter);
		// 分组展开
		jg_expandablelistview
				.setOnGroupExpandListener(new OnGroupExpandListener() {
					public void onGroupExpand(int groupPosition) {

					}
				});

		// 分组关闭
		jg_expandablelistview
				.setOnGroupCollapseListener(new OnGroupCollapseListener() {
					public void onGroupCollapse(int groupPosition) {

					}
				});

		// 子项被点击
		jg_expandablelistview.setOnChildClickListener(new OnChildClickListener() {
			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				intent = new Intent();
				intent.setClass(MyJgzxActivity.this, MyJgzxDetailActivity_.class);
				intent.putExtra("groupPositon", String.valueOf(groupPosition));
				intent.putExtra("childPosition", String.valueOf(childPosition));
				startActivity(intent);
				return false;
			}
		});
	}

	@Click(R.id.main_topleft_img)
	public void back() {
		intent = new Intent(this, Main.class);
		startActivity(intent);
		this.finish();
		overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);
	}

}

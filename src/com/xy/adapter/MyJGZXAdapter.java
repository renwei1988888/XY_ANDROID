package com.xy.adapter;
import com.xy.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyJGZXAdapter extends BaseExpandableListAdapter {

	private String[] jc_group;
	private String[][] groups;
	private Context context;
	LayoutInflater inflater;

	public MyJGZXAdapter(String[] jc_group, String[][] groups, Context context) {
		this.jc_group = jc_group;
		this.groups = groups;
		this.context = context;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return groups[groupPosition][childPosition];
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		convertView = inflater.inflate(R.layout.myjgzx_item, null);
		TextView nickTextView = (TextView) convertView
				.findViewById(R.id.buddy_listview_child_nick);

		TextView textView1 = (TextView) convertView
				.findViewById(R.id.textView1);

		if(childPosition < 2 && groupPosition == 0){
			textView1.setText(R.string.jgzx_tgxy_tx);
		}
		nickTextView.setText(getChild(groupPosition, childPosition).toString());

		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return groups[groupPosition].length;
	}

	@Override
	public Object getGroup(int groupPosition) {
		return jc_group[groupPosition];
	}

	@Override
	public int getGroupCount() {
		return jc_group.length;
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup arg3) {
		convertView = inflater
				.inflate(R.layout.myjgzx_parent_item, null);

		TextView groupNameTextView = (TextView) convertView
				.findViewById(R.id.buddy_listview_group_name);

		groupNameTextView.setText(getGroup(groupPosition).toString());

		ImageView image = (ImageView) convertView
				.findViewById(R.id.buddy_listview_image);

		image.setImageResource(R.drawable.ic_open);

		// 判断父列表是否展开，设置相应的图标
		if (!isExpanded) {
			image.setImageResource(R.drawable.ic_close);
		}

		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) { // 判断子列表是否可以被选中
		return true;
	}

}

package com.xy.adapter;

import java.util.List;

import com.xy.R;
import com.xy.bean.MyJFBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyJFAdapter extends BaseAdapter {

	private Context context;
	private List<MyJFBean> myJFList;
	LayoutInflater inflater;

	public MyJFAdapter(Context context, List<MyJFBean> myJFList) {
		this.context = context;
		this.myJFList = myJFList;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return myJFList.size();
	}

	@Override
	public Object getItem(int position) {
		return myJFList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		ViewHolder holder = null;
		MyJFBean myJFBean = myJFList.get(position);

		if (holder == null) {
			holder = new ViewHolder();
			view = inflater.inflate(R.layout.myjf_item, null);
			holder.myjf_time = (TextView) view.findViewById(R.id.myjf_time_txt);
			holder.myjf_source = (TextView) view
					.findViewById(R.id.myjf_source_txt);
			holder.myjf_num = (TextView) view.findViewById(R.id.myjf_num_txt);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		// 设置item的值
		holder.myjf_time.setText(myJFBean.getJfTime());
		holder.myjf_source.setText(myJFBean.getJfSource());
		holder.myjf_num.setText(myJFBean.getJfNum());
		
		return view;
	}

	class ViewHolder {
		public TextView myjf_time;
		public TextView myjf_source;
		public TextView myjf_num;
	}

}

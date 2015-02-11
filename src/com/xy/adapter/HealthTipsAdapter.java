package com.xy.adapter;

import java.util.List;

import com.xy.R;
import com.xy.activity.HealthTipsDetailActivity_;
import com.xy.bean.HealthTipsBean;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class HealthTipsAdapter extends BaseAdapter {

	private Context context;
	private List<HealthTipsBean> tipList;
	LayoutInflater inflater;

	public HealthTipsAdapter(Context context, List<HealthTipsBean> tipList) {
		this.context = context;
		this.tipList = tipList;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return tipList.size();
	}

	@Override
	public Object getItem(int position) {
		return tipList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		final HealthTipsBean tipBean = tipList.get(position);

		if (holder == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.healthtip_item, null);
			holder.healthtip_tittle = (TextView) convertView.findViewById(R.id.healthtip_tittle);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		// 设置item的值
		holder.healthtip_tittle.setText(tipBean.getTipTittle());
		
		convertView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(context, HealthTipsDetailActivity_.class);
				intent.putExtra("tipContent", tipBean.getTipContent());
				context.startActivity(intent);
			}
		});
		
		return convertView;
	}
	
	class ViewHolder{
		TextView healthtip_tittle;		
	}

}

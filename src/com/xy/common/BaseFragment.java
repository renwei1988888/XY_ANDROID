package com.xy.common;

import com.xy.util.AsyncTaskUtil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Title:BaseFragment.class Description: BaseFragment Demo 优化后Fragment 
 * Copyright:Copyright (c) 2014 Company:湖南裕邦
 * 
 * @author yangming.zhang
 * @version 1.0
 * @date 2014-4-25
 */
public abstract class BaseFragment  extends Fragment {

	/**
	 * 数据保存
	 */
	protected Object dataObj;

	/**
	 * 布局解析器
	 */
	protected LayoutInflater inflater;

	protected boolean isShowDialg = false;

	protected boolean isCanCancel = true;

	protected String dialogText = "正在处理,请稍候...";

	protected Object paraData = null;

	private boolean isBaseOnCreate = true;

	// 如果要更改fragment的dialog的相关数据，可以在其实现类里面重写onCreate()
	// 方法，直接修改上面三个数据,然后super.onCreate()执行里面的异步数据操作
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		inflater = LayoutInflater.from(getActivity());
        
		getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		// 进行数据的加载操作
		new AsyncTaskUtil(getActivity(), dialogText, isShowDialg, isCanCancel, paraData)
		{

			@Override
			protected Object backResult(Object result)
			{

				return onEndTaskAddView(result);

			}

			@Override
			protected Object backDataProcess(Object... params)
			{
				dataObj = onCreateTaskLoadData(params);
				return dataObj;
			}
		};
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		// TODO 创建和fragment关联的view hierarchy.
		return new View(getActivity());

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		//onEndTaskAddView(dataObj);

	}

	/**
	 * 数据下载，得到的返回结果用于初始化成员变量 object
	 * 
	 * @return
	 */
	protected abstract Object onCreateTaskLoadData(Object... params);

	/**
	 * 创建并初始化视图
	 */
	protected abstract Object onEndTaskAddView(Object result);

	/**
	 * toast提示信息(带样式)
	 * 
	 * @param message
	 */
	public void toastInfor(final String message)
	{
		getActivity().runOnUiThread(new Runnable()
		{
			@Override
			public void run()
			{
				Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public void onResume()
	{
		super.onResume();
		if (isBaseOnCreate)
		{
			isBaseOnCreate = false;
		}
		else
		{
			onBaseResume();
		}
	}

	/**
	 * onCreate进入时不调用 用于onResume()处理
	 */
	protected void onBaseResume()
	{

	}
}

package com.xy.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.xy.R;

/** 
* @ClassName: Main 
* @Description: Main页面
* @author ls
* @date 2015-2-11 下午4:38:24 
*/
public class Main extends SlidingFragmentActivity implements OnClickListener {
	private int mScreenWidth;
	private int item_width;
	private ImageView main_topleft_img;
	int screenWidth;
	int screenHeight;
	private static TextView ivTitleName;
	
	protected SlidingMenu leftSlidingMenu;
	Fragment mContent;
	Fragment rightFrag;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		initLeftSlidingMenu();
		setContentView(R.layout.activity_main);
		
		ivTitleName = (TextView) this.findViewById(R.id.textView1);
		main_topleft_img = (ImageView) findViewById(R.id.main_topleft_img);
		main_topleft_img.setOnClickListener(this);
		
		DisplayMetrics dm = new DisplayMetrics();
		mScreenWidth = dm.widthPixels;
		item_width = (int) ((mScreenWidth / 5.0 + 0.5f));
		screenWidth = this.getResources().getDisplayMetrics().widthPixels;
		screenHeight = this.getResources().getDisplayMetrics().heightPixels;
	}

	private void initLeftSlidingMenu() {
		mContent = new HomeFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, mContent).commit();
		setBehindContentView(R.layout.main_left_layout);
		FragmentTransaction leftFragementTransaction = getSupportFragmentManager()
				.beginTransaction();
		Fragment leftFrag = new MainLeftFragment();

		leftFragementTransaction.replace(R.id.main_left_fragment, leftFrag);
		leftFragementTransaction.commit();
		// customize the SlidingMenu
		leftSlidingMenu = getSlidingMenu();
		leftSlidingMenu.setMode(SlidingMenu.LEFT_RIGHT);// 设置是左滑还是右滑，还是左右都可以滑，我这里只做了左滑
		leftSlidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);// 设置菜单宽度
		leftSlidingMenu.setFadeDegree(0.35f);// 设置淡入淡出的比例
		leftSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);// 设置手势模式
		// leftSlidingMenu.setShadowDrawable(R.drawable.shadow);// 设置左菜单阴影图片
		// leftSlidingMenu.setFadeEnabled(true);// 设置滑动时菜单的是否淡入淡出
		// leftSlidingMenu.setBehindScrollScale(0.999f);// 设置滑动时拖拽效果

		leftSlidingMenu.setSecondaryMenu(R.layout.main_right_layout);
		FragmentTransaction rightFragementTransaction = getSupportFragmentManager()
				.beginTransaction();
		rightFrag = new MainLeftFragment();
		rightFragementTransaction.replace(R.id.main_right_fragment, rightFrag);
		rightFragementTransaction.commit();
	}
	
	public static void getDataTitle(IDecodeDataBack cb) {
		cb.dataDecodeCallback(ivTitleName);
	};

	public interface IDecodeDataBack {
		public void dataDecodeCallback(TextView textview);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.main_topleft_img:
			leftSlidingMenu.showMenu();
			break;
		default:
			break;
		}
	}

}

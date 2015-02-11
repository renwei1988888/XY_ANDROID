package com.xy.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.xy.R;
import com.xy.common.BaseFragment;
import com.xy.common.Constants;
import com.xy.widget.ScrollLayout;
import com.xy.widget.ScrollLayout.OnViewChangeListener;

public class HomeFragment extends BaseFragment implements OnClickListener {

	ScrollLayout scrollLayout_main; // 主页滑动组件

	private View[] menu_layouts = new View[5];// 主页、健康贴士、健康档案、行为改变、论坛的View数组
	private Intent intent;
	
	/*** 首页  ****/
	private LinearLayout main_hottopic_ll;
	private LinearLayout main_specialinvitation_ll;
	/*** 首页  ****/

	/*** 健康贴士  ****/
	private LinearLayout main_health_hivjc_ll;
	private LinearLayout main_health_aqtsy_ll;
	private RelativeLayout main_health_kbdywzl_ll;
	private LinearLayout main_health_xcbjb_ll;
	private LinearLayout main_health_ywly_ll;
	private LinearLayout main_health_yfxyy_ll;
	/*** 健康贴士  ****/
	
	/*** 健康档案  ****/
	private ViewFlipper main_file_xw_vf;// 试题容器
	private Button main_file_begin_btn;
	private TextView test_model_txt, test_content_txt,main_file_des_tx, main_tab_myjf_txt;
	private RadioButton main_healthfile_rd1, main_healthfile_rd2,
			main_healthfile_rd3, main_healthfile_rd4, main_healthfile_rd5,
			main_healthfile_rd6;
	RadioButton main_healthfile_xw_rd;
	RadioButton main_healthfile_xl_rd;
	RadioButton main_xl_jl_rb;
	RadioButton main_xl_yy_rb;
	RadioButton main_xl_sh_rb;
	RadioButton main_xl_yw_rb;
	RadioButton main_xl_aqt_rb;
	private FragmentActivity activity;
	LayoutInflater flater;// 用于动态加载试题布局
	private boolean isXWPG = false;
	private RadioGroup main_xl_rg;
	/*** 健康档案  ****/
	
	/*** 行为改变  ****/
	private Button main_change_read_btn;
//	private LinearLayout main_change_record_ll;
//	private LinearLayout main_change_tell_ll;
//	private LinearLayout main_change_testinform_ll;
//	private LinearLayout main_change_positive_ll;
	/*** 行为改变  ****/
	
	/*** 论坛  ****/
	private LinearLayout main_bbs_speinv_ll;
	private LinearLayout main_bbs_disgroup_ll;
	private LinearLayout main_bbs_emo_ll;
	private LinearLayout main_bbs_fristudy_ll;
	/*** 论坛   ****/
	
	public void init() {
		activity = getActivity();
		flater = (LayoutInflater) activity.getSystemService(activity.LAYOUT_INFLATER_SERVICE);
		main_file_xw_vf = (ViewFlipper) activity.findViewById(R.id.main_file_xw_vf);
		main_file_begin_btn = (Button) activity.findViewById(R.id.main_file_begin_btn);
		test_model_txt = (TextView) activity.findViewById(R.id.test_model_txt);
		test_content_txt = (TextView) activity.findViewById(R.id.test_content_txt);
		main_tab_myjf_txt = (TextView) activity.findViewById(R.id.main_tab_myjf_txt);
		main_healthfile_rd1 = (RadioButton) activity.findViewById(R.id.main_healthfile_rd1);
		main_healthfile_rd2 = (RadioButton) activity.findViewById(R.id.main_healthfile_rd2);
		main_healthfile_rd3 = (RadioButton) activity.findViewById(R.id.main_healthfile_rd3);
		main_healthfile_rd4 = (RadioButton) activity.findViewById(R.id.main_healthfile_rd4);
		main_healthfile_rd5 = (RadioButton) activity.findViewById(R.id.main_healthfile_rd5);
		main_healthfile_rd6 = (RadioButton) activity.findViewById(R.id.main_healthfile_rd6);
		main_file_begin_btn.setOnClickListener(this);
		main_tab_myjf_txt.setOnClickListener(this);
		
		main_change_read_btn = (Button) activity.findViewById(R.id.main_change_read_btn);
		main_change_read_btn.setOnClickListener(this);
		
		main_hottopic_ll = (LinearLayout) activity.findViewById(R.id.main_hottopic_ll);
		main_specialinvitation_ll = (LinearLayout) activity.findViewById(R.id.main_specialinvation_ll);
		
		main_health_hivjc_ll = (LinearLayout) activity.findViewById(R.id.main_health_hivjc_ll);
		main_health_aqtsy_ll = (LinearLayout) activity.findViewById(R.id.main_health_aqtsy_ll);
		main_health_kbdywzl_ll = (RelativeLayout) activity.findViewById(R.id.main_health_kbdywzl_ll);
		main_health_xcbjb_ll = (LinearLayout) activity.findViewById(R.id.main_health_xcbjb_ll);
		main_health_ywly_ll = (LinearLayout) activity.findViewById(R.id.main_health_ywly_ll);
		main_health_yfxyy_ll = (LinearLayout) activity.findViewById(R.id.main_health_yfxyy_ll);
		
//		main_change_record_ll = (LinearLayout) activity.findViewById(R.id.main_change_record_ll);
//		main_change_tell_ll = (LinearLayout) activity.findViewById(R.id.main_change_tell_ll);
//		main_change_testinform_ll = (LinearLayout) activity.findViewById(R.id.main_change_testinform_ll);
//		main_change_positive_ll = (LinearLayout) activity.findViewById(R.id.main_change_positive_ll);
		
		main_bbs_speinv_ll = (LinearLayout) activity.findViewById(R.id.main_bbs_speinv_ll);
		main_bbs_disgroup_ll = (LinearLayout) activity.findViewById(R.id.main_bbs_disgroup_ll);
		main_bbs_emo_ll = (LinearLayout) activity.findViewById(R.id.main_bbs_emo_ll);
		main_bbs_fristudy_ll = (LinearLayout) activity.findViewById(R.id.main_bbs_fristudy_ll);
		
		main_health_hivjc_ll.setOnClickListener(this);
		main_health_aqtsy_ll.setOnClickListener(this);
		main_health_kbdywzl_ll.setOnClickListener(this);
		main_health_xcbjb_ll.setOnClickListener(this);
		main_health_ywly_ll.setOnClickListener(this);
		main_health_yfxyy_ll.setOnClickListener(this);
		
		main_hottopic_ll.setOnClickListener(this);
		main_specialinvitation_ll.setOnClickListener(this);
		
//		main_change_record_ll.setOnClickListener(this);
//		main_change_tell_ll.setOnClickListener(this);
//		main_change_testinform_ll.setOnClickListener(this);
//		main_change_positive_ll.setOnClickListener(this); 
		
		main_bbs_speinv_ll.setOnClickListener(this);
		main_bbs_disgroup_ll.setOnClickListener(this);
		main_bbs_emo_ll.setOnClickListener(this);
		main_bbs_fristudy_ll.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.main_file_begin_btn:
			int currentIndex = main_file_xw_vf.getDisplayedChild(); // 当前题目的序号
			if (currentIndex == 0) {
				main_file_begin_btn.setText(R.string.main_file_choose_tx);
				View v = flater.inflate(R.layout.layout_main_tab_healthfile_choosetype, null);
				main_healthfile_xw_rd = (RadioButton) v.findViewById(R.id.main_healthfile_xw_rd);
				main_healthfile_xl_rd = (RadioButton) v.findViewById(R.id.main_healthfile_xl_rd);
				main_file_xw_vf.addView(v);
				toNext();
			} else if (currentIndex == 1) {
				if(!main_healthfile_xw_rd.isChecked() && !main_healthfile_xl_rd.isChecked()){
					Toast.makeText(activity, "请选择评估类型", Toast.LENGTH_SHORT).show();
				} else if(main_healthfile_xw_rd.isChecked() && !main_healthfile_xl_rd.isChecked()){
					isXWPG = true;
					main_file_begin_btn.setText(R.string.main_file_next_tx);
					addView(R.layout.layout_main_tab_healthfile_xw_test1,currentIndex,Constants.TESTANSWER1);
				} else{
					isXWPG = false;
					View v = flater.inflate(R.layout.layout_main_tab_healthfile_xl_choosetype, null);
					main_xl_rg = (RadioGroup) v.findViewById(R.id.main_xl_rg);
					main_xl_jl_rb = (RadioButton) v.findViewById(R.id.main_xl_jl_rb);
					main_xl_yy_rb = (RadioButton) v.findViewById(R.id.main_xl_yy_rb);
					main_xl_sh_rb = (RadioButton) v.findViewById(R.id.main_xl_sh_rb);
					main_xl_yw_rb = (RadioButton) v.findViewById(R.id.main_xl_yw_rb);
					main_xl_aqt_rb = (RadioButton) v.findViewById(R.id.main_xl_aqt_rb);
					main_file_xw_vf.addView(v);
					toNext();
				}
			} else if (currentIndex == 2) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test2,currentIndex,Constants.TESTANSWER2);
					}
				}else{
					if(!main_xl_jl_rb.isChecked() && !main_xl_yy_rb.isChecked() && !main_xl_sh_rb.isChecked() && !main_xl_yw_rb.isChecked() && !main_xl_aqt_rb.isChecked()){
						Toast.makeText(activity, "请选择评测类型", Toast.LENGTH_SHORT).show();
					}else{
						main_file_begin_btn.setText(R.string.main_file_begin_tx);
						View v = flater.inflate(R.layout.layout_main_tab_healthfile_begin, null);
						main_file_des_tx = (TextView) v.findViewById(R.id.main_file_des_tx);
						if(main_xl_jl_rb.isChecked()){
							main_file_des_tx.setText(R.string.main_file_xl_jl_tx);
						} else if(main_xl_yy_rb.isChecked()){
							main_file_des_tx.setText(R.string.main_file_xl_yy_tx);
						} else if(main_xl_sh_rb.isChecked()){
							main_file_des_tx.setText(R.string.main_file_xl_sh_tx);
						} else if(main_xl_yw_rb.isChecked()){
							main_file_des_tx.setText(R.string.main_file_xl_yw_tx);
						} else {
							main_file_des_tx.setText(R.string.main_file_xl_aqt_tx);
						}
						main_file_xw_vf.addView(v);
						toNext();
					}
				}
				
			} else if (currentIndex == 3) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test3,currentIndex,Constants.TESTANSWER3);
					}
				} else{
					main_file_begin_btn.setText(R.string.main_file_next_tx);
					if(main_xl_jl_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_JL1_20);
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 4) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test4,currentIndex,Constants.TESTANSWER4);
					}
				} else{
					if(main_xl_jl_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_JL1_20);
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH2);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 5) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test5,currentIndex,Constants.TESTANSWER5);
					}
				} else{
					if(main_xl_jl_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_JL1_20);
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH3);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 6) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test6,currentIndex,Constants.TESTANSWER6);
					}
				} else{
					if(main_xl_jl_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_JL1_20);
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH4);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 7) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test7,currentIndex,Constants.TESTANSWER7);
					}
				} else{
					if(main_xl_jl_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_JL1_20);
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						//addXLView(R.layout.layout_main_tab_healthfile_xl_sh5, currentIndex, Constants.TESTANSWER_SH5);
						View v = flater.inflate(R.layout.layout_main_tab_healthfile_xl_sh5, null);
						TextView test_content_txt = (TextView) v.findViewById(R.id.test_content_txt);
						test_content_txt.setText(Constants.TESTCONTENT_SH[4]);
						main_file_xw_vf.addView(v);
						toNext();
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 8) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test8,currentIndex,Constants.TESTANSWER8);
					}
				} else{
					if(main_xl_jl_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_JL1_20);
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						//addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH6);
						View v = flater.inflate(R.layout.layout_main_tab_healthfile_xl_sh6, null);
						TextView test_content_txt = (TextView) v.findViewById(R.id.test_content_txt);
						test_content_txt.setText(Constants.TESTCONTENT_SH[5]);
						main_file_xw_vf.addView(v);
						toNext();
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
				
			} else if (currentIndex == 9) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test9,currentIndex,Constants.TESTANSWER9);
					}
				} else{
					if(main_xl_jl_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_JL1_20);
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						//addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH7);
						View v = flater.inflate(R.layout.layout_main_tab_healthfile_xl_sh7, null);
						TextView test_content_txt = (TextView) v.findViewById(R.id.test_content_txt);
						test_content_txt.setText(Constants.TESTCONTENT_SH[6]);
						main_file_xw_vf.addView(v);
						toNext();
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 10) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test10,currentIndex,Constants.TESTANSWER10);
					}
				} else{
					if(main_xl_jl_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_JL1_20);
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH8);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 11) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test11,currentIndex,Constants.TESTANSWER11);
					}
				} else{
					if(main_xl_jl_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_JL1_20);
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH9);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 12) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test12,currentIndex,Constants.TESTANSWER12);
					}
				} else{
					if(main_xl_jl_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_JL1_20);
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH10);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 13) {
				if(isXWPG){
//					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked()){
//						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
//					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test13,currentIndex,Constants.TESTANSWER13);
//					}
				} else{
					if(main_xl_jl_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_JL1_20);
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						Toast.makeText(activity, "测试完毕", Toast.LENGTH_SHORT).show();
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 14) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						View v = flater.inflate(R.layout.layout_main_tab_healthfile_xw_test14, null);
						TextView test_content_txt = (TextView) v.findViewById(R.id.test_content_txt);
						TextView test_model_txt = (TextView) v.findViewById(R.id.test_model_txt);
						test_model_txt.setText(Constants.TESTTYPE[1]);
						test_content_txt.setText(Constants.TESTCONTENT[13]);
						main_file_xw_vf.addView(v);
						toNext();
//						addView(R.layout.layout_main_tab_healthfile_xw_test14,currentIndex,Constants.TESTANSWER14);
					}
				} else{
					if(main_xl_jl_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_JL1_20);
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 15) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test15,currentIndex,Constants.TESTANSWER15);
					}
				} else{
					if(main_xl_jl_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_JL1_20);
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 16) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test16,currentIndex,Constants.TESTANSWER16);
					}
				} else{
					if(main_xl_jl_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_JL1_20);
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 17) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test17,currentIndex,Constants.TESTANSWER17);
					}
				} else{
					if(main_xl_jl_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_JL1_20);
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						Toast.makeText(activity, "测试完毕", Toast.LENGTH_SHORT).show();
					}
				}
			} else if (currentIndex == 18) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test18,currentIndex,Constants.TESTANSWER18);
					}
				} else{
					if(main_xl_jl_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_JL1_20);
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 19) {
				if(isXWPG){
//					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked()){
//						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
//					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test19,currentIndex,Constants.TESTANSWER19);
//					}
				} else{
					if(main_xl_jl_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_JL1_20);
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 20) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test20,currentIndex,Constants.TESTANSWER20);
					}
				} else{
					if(main_xl_jl_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_JL1_20);
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 21) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test21,currentIndex,Constants.TESTANSWER21);
					}
				}else{
					if(main_xl_jl_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_JL1_20);
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 22) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test22,currentIndex,Constants.TESTANSWER22);
					}
				}else{
					if(main_xl_jl_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_JL1_20);
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 23) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test23,currentIndex,Constants.TESTANSWER23);
					}
				}else{
					if(main_xl_jl_rb.isChecked()){
						Toast.makeText(activity, "测试完毕", Toast.LENGTH_SHORT).show();
					} else if(main_xl_yy_rb.isChecked()){
						Toast.makeText(activity, "测试完毕", Toast.LENGTH_SHORT).show();
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 24) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test24,currentIndex,Constants.TESTANSWER24);
					}
				}else{
					if(main_xl_jl_rb.isChecked()){
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 25) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test25,currentIndex,Constants.TESTANSWER25);
					}
				}else{
					if(main_xl_jl_rb.isChecked()){
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 26) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test26,currentIndex,Constants.TESTANSWER26);
					}
				}else{
					if(main_xl_jl_rb.isChecked()){
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 27) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test27,currentIndex,Constants.TESTANSWER27);
					}
				}else{
					if(main_xl_jl_rb.isChecked()){
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 28) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test28,currentIndex,Constants.TESTANSWER28);
					}
				}else{
					if(main_xl_jl_rb.isChecked()){
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 29) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test29,currentIndex,Constants.TESTANSWER29);
					}
				}else{
					if(main_xl_jl_rb.isChecked()){
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 30) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test30,currentIndex,Constants.TESTANSWER30);
					}
				}else{
					if(main_xl_jl_rb.isChecked()){
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 31) {
				if(isXWPG){
//					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
//						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
//					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test31,currentIndex,Constants.TESTANSWER31);
//					}
				}else{
					if(main_xl_jl_rb.isChecked()){
					} else if(main_xl_yy_rb.isChecked()){
						addView(R.layout.layout_main_tab_healthfile_xw_test31,currentIndex,Constants.TESTANSWER31);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 32) {
				if(isXWPG){
//					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
//						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
//					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test32,currentIndex,Constants.TESTANSWER32);
//					}
				}else{
					if(main_xl_jl_rb.isChecked()){
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW1_30);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 33) {
				if(isXWPG){
//					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
//						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
//					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test33,currentIndex,Constants.TESTANSWER33);
//					}
				}else{
					if(main_xl_jl_rb.isChecked()){
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW31_33);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 34) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test34,currentIndex,Constants.TESTANSWER34);
					}
				}else{
					if(main_xl_jl_rb.isChecked()){
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW31_33);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 35) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test35,currentIndex,Constants.TESTANSWER35);
					}
				}else{
					if(main_xl_jl_rb.isChecked()){
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW31_33);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 36) {
				if(isXWPG){
//					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
//						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
//					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test36,currentIndex,Constants.TESTANSWER36);
//					}
				}else{
					if(main_xl_jl_rb.isChecked()){
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW31_33);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 37) {
				if(isXWPG){
//					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
//						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
//					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test37,currentIndex,Constants.TESTANSWER37);
//					}
				}else{
					if(main_xl_jl_rb.isChecked()){
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW34_37);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 38) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test38,currentIndex,Constants.TESTANSWER38);
					}
				}else{
					if(main_xl_jl_rb.isChecked()){
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW34_37);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 39) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test39,currentIndex,Constants.TESTANSWER39);
					}
				}else{
					if(main_xl_jl_rb.isChecked()){
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW34_37);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 40) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test40,currentIndex,Constants.TESTANSWER40);
					}
				}else{
					if(main_xl_jl_rb.isChecked()){
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW34_37);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 41) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test41,currentIndex,Constants.TESTANSWER41);
					}
				}else{
					if(main_xl_jl_rb.isChecked()){
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW38_41);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 42) {
				if(isXWPG){
//					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
//						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
//					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test42,currentIndex,Constants.TESTANSWER42);
//					}
				}else{
					if(main_xl_jl_rb.isChecked()){
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW38_41);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 43) {
				if(isXWPG){
//					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
//						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
//					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test43,currentIndex,Constants.TESTANSWER43);
//					}
				}else{
					if(main_xl_jl_rb.isChecked()){
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YW38_41);
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 44) {
				if(isXWPG){
					if(!main_healthfile_rd1.isChecked() && !main_healthfile_rd2.isChecked() && !main_healthfile_rd3.isChecked() && !main_healthfile_rd4.isChecked() && !main_healthfile_rd5.isChecked() && !main_healthfile_rd6.isChecked()){
						Toast.makeText(activity, "请选择答案", Toast.LENGTH_SHORT).show();
					} else {
						addView(R.layout.layout_main_tab_healthfile_xw_test44,currentIndex,Constants.TESTANSWER44);
					}
				}else{
					if(main_xl_jl_rb.isChecked()){
					} else if(main_xl_yy_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_YY1_20);
					} else if(main_xl_sh_rb.isChecked()){
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_SH1);
					} else if(main_xl_yw_rb.isChecked()){
						Toast.makeText(activity, "测试完毕", Toast.LENGTH_SHORT).show();
					} else {
						addXLView(R.layout.layout_main_tab_healthfile_xl_content, currentIndex, Constants.TESTANSWER_AQT1_14);
					}
				}
			} else if (currentIndex == 45) {
				addView(R.layout.layout_main_tab_healthfile_xw_test45,currentIndex,Constants.TESTANSWER45);
			} else if (currentIndex == 46) {
				addView(R.layout.layout_main_tab_healthfile_xw_test46,currentIndex,Constants.TESTANSWER46);
			} else if (currentIndex == 47) {
				addView(R.layout.layout_main_tab_healthfile_xw_test47,currentIndex,Constants.TESTANSWER47);
			} else if (currentIndex == 48) {
				addView(R.layout.layout_main_tab_healthfile_xw_test48,currentIndex,Constants.TESTANSWER48);
			} else if (currentIndex == 49) {
				addView(R.layout.layout_main_tab_healthfile_xw_test49,currentIndex,Constants.TESTANSWER49);
			} else if (currentIndex == 50) {
				addView(R.layout.layout_main_tab_healthfile_xw_test50,currentIndex,Constants.TESTANSWER50);
			} else if (currentIndex == 51) {
				addView(R.layout.layout_main_tab_healthfile_xw_test51,currentIndex,Constants.TESTANSWER51);
			} else if (currentIndex == 52) {
				addView(R.layout.layout_main_tab_healthfile_xw_test52,currentIndex,Constants.TESTANSWER52);
			} else if (currentIndex == 53) {
				addView(R.layout.layout_main_tab_healthfile_xw_test53,currentIndex,Constants.TESTANSWER53);
			} else if (currentIndex == 54) {
				addView(R.layout.layout_main_tab_healthfile_xw_test54,currentIndex,Constants.TESTANSWER54);
			} else if (currentIndex == 55) {
				addView(R.layout.layout_main_tab_healthfile_xw_test55,currentIndex,Constants.TESTANSWER55);
			} else if (currentIndex == 56) {
				addView(R.layout.layout_main_tab_healthfile_xw_test56,currentIndex,Constants.TESTANSWER56);
			} else if (currentIndex == 57) {
				addView(R.layout.layout_main_tab_healthfile_xw_test57,currentIndex,Constants.TESTANSWER57);
			} else if (currentIndex == 58) {
				addView(R.layout.layout_main_tab_healthfile_xw_test58,currentIndex,Constants.TESTANSWER58);
			} else if (currentIndex == 59) {
				addView(R.layout.layout_main_tab_healthfile_xw_test59,currentIndex,Constants.TESTANSWER59);
			} else if (currentIndex == 60) {
				addView(R.layout.layout_main_tab_healthfile_xw_test60,currentIndex,Constants.TESTANSWER60);
			} else if (currentIndex == 61) {
				View v = flater.inflate(R.layout.layout_main_tab_healthfile_xw_test61, null);
				TextView test_content_txt = (TextView) v.findViewById(R.id.test_content_txt);
				TextView test_model_txt = (TextView) v.findViewById(R.id.test_model_txt);
				test_model_txt.setText(Constants.TESTTYPE[6]);
				test_content_txt.setText(Constants.TESTCONTENT[60]);
				CheckBox cb1 = (CheckBox) v.findViewById(R.id.main_healthfile_cb1);
				cb1.setText(Constants.TESTANSWER61[0]);
				CheckBox cb2 = (CheckBox) v.findViewById(R.id.main_healthfile_cb2);
				cb2.setText(Constants.TESTANSWER61[1]);
				CheckBox cb3 = (CheckBox) v.findViewById(R.id.main_healthfile_cb3);
				cb3.setText(Constants.TESTANSWER61[2]);
				CheckBox cb4 = (CheckBox) v.findViewById(R.id.main_healthfile_cb4);
				cb4.setText(Constants.TESTANSWER61[3]);
				CheckBox cb5 = (CheckBox) v.findViewById(R.id.main_healthfile_cb5);
				cb5.setText(Constants.TESTANSWER61[4]);
				CheckBox cb6 = (CheckBox) v.findViewById(R.id.main_healthfile_cb6);
				cb6.setText(Constants.TESTANSWER61[5]);
				main_file_xw_vf.addView(v);
				toNext();
//				addView(R.layout.layout_main_tab_healthfile_xw_test61,currentIndex,Constants.TESTANSWER61);
			} else if (currentIndex == 62) {
				addView(R.layout.layout_main_tab_healthfile_xw_test62,currentIndex,Constants.TESTANSWER62);
			} else if (currentIndex == 63) {
				addView(R.layout.layout_main_tab_healthfile_xw_test63,currentIndex,Constants.TESTANSWER63);
			} else if (currentIndex == 64) {
				addView(R.layout.layout_main_tab_healthfile_xw_test64,currentIndex,Constants.TESTANSWER64);
			} else if (currentIndex == 65) {
				addView(R.layout.layout_main_tab_healthfile_xw_test65,currentIndex,Constants.TESTANSWER65);
			} else if (currentIndex == 66) {
				addView(R.layout.layout_main_tab_healthfile_xw_test66,currentIndex,Constants.TESTANSWER66);
			} else if (currentIndex == 67) {
				addView(R.layout.layout_main_tab_healthfile_xw_test67,currentIndex,Constants.TESTANSWER67);
			} else if (currentIndex == 68) {
				addView(R.layout.layout_main_tab_healthfile_xw_test68,currentIndex,Constants.TESTANSWER68);
			} else if (currentIndex == 69) {
				addView(R.layout.layout_main_tab_healthfile_xw_test69,currentIndex,Constants.TESTANSWER69);
			} else if (currentIndex == 70) {
				addView(R.layout.layout_main_tab_healthfile_xw_test70,currentIndex,Constants.TESTANSWER70);
			} else if (currentIndex == 71) {
				addView(R.layout.layout_main_tab_healthfile_xw_test71,currentIndex,Constants.TESTANSWER71);
			} else if (currentIndex == 72) {
				addView(R.layout.layout_main_tab_healthfile_xw_test72,currentIndex,Constants.TESTANSWER72);
			} else if (currentIndex == 73) {
				View v = flater.inflate(R.layout.layout_main_tab_healthfile_xw_test73, null);
				TextView test_content_txt = (TextView) v.findViewById(R.id.test_content_txt);
				TextView test_model_txt = (TextView) v.findViewById(R.id.test_model_txt);
				test_model_txt.setText(Constants.TESTTYPE[6]);
				test_content_txt.setText(Constants.TESTCONTENT[72]);
				CheckBox cb1 = (CheckBox) v.findViewById(R.id.main_healthfile_cb1);
				cb1.setText(Constants.TESTANSWER73[0]);
				CheckBox cb2 = (CheckBox) v.findViewById(R.id.main_healthfile_cb2);
				cb2.setText(Constants.TESTANSWER73[1]);
				CheckBox cb3 = (CheckBox) v.findViewById(R.id.main_healthfile_cb3);
				cb3.setText(Constants.TESTANSWER73[2]);
				CheckBox cb4 = (CheckBox) v.findViewById(R.id.main_healthfile_cb4);
				cb4.setText(Constants.TESTANSWER73[3]);
				CheckBox cb5 = (CheckBox) v.findViewById(R.id.main_healthfile_cb5);
				cb5.setText(Constants.TESTANSWER73[4]);
				CheckBox cb6 = (CheckBox) v.findViewById(R.id.main_healthfile_cb6);
				cb6.setText(Constants.TESTANSWER73[5]);
				main_file_xw_vf.addView(v);
				toNext();
//				addView(R.layout.layout_main_tab_healthfile_xw_test73,currentIndex,Constants.TESTANSWER73);
			} else if (currentIndex == 74) {
				addView(R.layout.layout_main_tab_healthfile_xw_test74,currentIndex,Constants.TESTANSWER74);
			} else if (currentIndex == 75) {
				addView(R.layout.layout_main_tab_healthfile_xw_test75,currentIndex,Constants.TESTANSWER75);
			} else if (currentIndex == 76) {
				addView(R.layout.layout_main_tab_healthfile_xw_test76,currentIndex,Constants.TESTANSWER76);
			} else if (currentIndex == 77) {
				addView(R.layout.layout_main_tab_healthfile_xw_test77,currentIndex,Constants.TESTANSWER77);
			} else if (currentIndex == 78) {
				addView(R.layout.layout_main_tab_healthfile_xw_test78,currentIndex,Constants.TESTANSWER78);
			} else if (currentIndex == 79) {
				addView(R.layout.layout_main_tab_healthfile_xw_test79,currentIndex,Constants.TESTANSWER79);
			} else if (currentIndex == 80) {
				addView(R.layout.layout_main_tab_healthfile_xw_test80,currentIndex,Constants.TESTANSWER80);
			} else if (currentIndex == 81){
				Toast.makeText(activity, "测试完毕", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.main_tab_myjf_txt:
			intent = new Intent(activity, MyJFActivity_.class);
			startActivity(intent);
			break;
		case R.id.main_change_read_btn:
			intent = new Intent(activity, ChangeSugActivity_.class);
			startActivity(intent);
			break;
		case R.id.main_health_hivjc_ll:
			intent = new Intent(activity, HealthTipsActivity_.class);
			intent.putExtra("modelId", String.valueOf(1));
			startActivity(intent);
			break;
		case R.id.main_health_aqtsy_ll:
			intent = new Intent(activity, HealthTipsActivity_.class);
			intent.putExtra("modelId", String.valueOf(2));
			startActivity(intent);
			break;
		case R.id.main_health_kbdywzl_ll:
			intent = new Intent(activity, HealthTipsActivity_.class);
			intent.putExtra("modelId", String.valueOf(3));
			startActivity(intent);
			break;
		case R.id.main_health_xcbjb_ll:
			intent = new Intent(activity, HealthTipsActivity_.class);
			intent.putExtra("modelId", String.valueOf(4));
			startActivity(intent);
			break;
		case R.id.main_health_ywly_ll:
			intent = new Intent(activity, HealthTipsActivity_.class);
			intent.putExtra("modelId", String.valueOf(5));
			startActivity(intent);
			break;
		case R.id.main_health_yfxyy_ll:
			intent = new Intent(activity, HealthTipsActivity_.class);
			intent.putExtra("modelId", String.valueOf(6));
			startActivity(intent);
			break;
		case R.id.main_hottopic_ll:
			intent = new Intent(activity, HotTopicActivity_.class);
			startActivity(intent);
			break;
		case R.id.main_specialinvation_ll:
			intent = new Intent(activity, SpecialinvitationActivity_.class);
			startActivity(intent);
			break;
		case R.id.main_bbs_speinv_ll:
			intent = new Intent(activity, BBSSpeDisActivity_.class);
			startActivity(intent);
			break;
		case R.id.main_bbs_disgroup_ll:
			intent = new Intent(activity, BBSDisGroupActivity_.class);
			startActivity(intent);
			break;
		case R.id.main_bbs_emo_ll:
			intent = new Intent(activity, BBSEmoActivity_.class);
			startActivity(intent);
			break;
		case R.id.main_bbs_fristudy_ll:
			intent = new Intent(activity, BBSFriStudyActivity_.class);
			startActivity(intent);
			break;
//		case R.id.main_change_record_ll:
//			intent = new Intent(activity, ChangeRecordActivity_.class);
//			startActivity(intent);
//			break;
//		case R.id.main_change_tell_ll:
//			intent = new Intent(activity, ChangeTellActivity_.class);
//			startActivity(intent);
//			break;
//		case R.id.main_change_testinform_ll:
//			intent = new Intent(activity, ChangeTestInformActivity_.class);
//			startActivity(intent);
//			break;
//		case R.id.main_change_positive_ll:
//			intent = new Intent(activity, ChangePositiveActivity_.class);
//			startActivity(intent);
//			break;
		default:
			break;
		}
	}
	
	public void addView(int ResId, int currentIndex, String[] testAnswer){
		View v = (View) flater.inflate(ResId, null);
		initView(v);
		main_file_xw_vf.addView(v, main_file_xw_vf.getChildCount());
		setContent(currentIndex - 1);
		int size = testAnswer.length;
		setAnswer(size, testAnswer);
		toNext();
	}
	
	// 显示下一道心理测试试题
	public void addXLView(int ResId, int currentIndex, String[] testAnswer){
		View v = (View) flater.inflate(ResId, null);
		initView(v);
		main_file_xw_vf.addView(v, main_file_xw_vf.getChildCount());
		setXLContent(currentIndex - 3);
		int size = testAnswer.length;
		setAnswer(size, testAnswer);
		toNext();
	}
	
	// 设置心理评估的试题内容
	public void setXLContent(int position){
		if(main_xl_jl_rb.isChecked()){
			test_content_txt.setText(Constants.TESTCONTENT_JL[position]);
		} else if(main_xl_yy_rb.isChecked()){
			test_content_txt.setText(Constants.TESTCONTENT_YY[position]);
		} else if(main_xl_sh_rb.isChecked()){
			test_content_txt.setText(Constants.TESTCONTENT_SH[position]);
		} else if(main_xl_yw_rb.isChecked()){
			test_content_txt.setText(Constants.TESTCONTENT_YW[position]);
		} else {
			test_content_txt.setText(Constants.TESTCONTENT_AQT[position]);
		}
		
	}
	
	public void initView(View v){
		test_model_txt = (TextView) v.findViewById(R.id.test_model_txt);
		test_content_txt = (TextView) v.findViewById(R.id.test_content_txt);
		main_healthfile_rd1 = (RadioButton) v.findViewById(R.id.main_healthfile_rd1);
		main_healthfile_rd2 = (RadioButton) v.findViewById(R.id.main_healthfile_rd2);
		main_healthfile_rd3 = (RadioButton) v.findViewById(R.id.main_healthfile_rd3);
		main_healthfile_rd4 = (RadioButton) v.findViewById(R.id.main_healthfile_rd4);
		main_healthfile_rd5 = (RadioButton) v.findViewById(R.id.main_healthfile_rd5);
		main_healthfile_rd6 = (RadioButton) v.findViewById(R.id.main_healthfile_rd6);
	}
	
	public void toNext(){
		// 跳转到下一题
		main_file_xw_vf.setInAnimation(AnimationUtils.loadAnimation(
				getActivity(), R.anim.slide_right_in));
		main_file_xw_vf.setOutAnimation(AnimationUtils.loadAnimation(
				getActivity(), R.anim.slide_left_out));
		main_file_xw_vf.showNext();
	}

	public void setContent(int position) {
		if(position > -1 && position < 9){
			test_model_txt.setText(Constants.TESTTYPE[0]);
		} else if (position > 8 && position < 30){
			test_model_txt.setText(Constants.TESTTYPE[1]);
		} else if (position > 29 && position < 34){
			test_model_txt.setText(Constants.TESTTYPE[2]);
		} else if (position > 33 && position < 40){
			test_model_txt.setText(Constants.TESTTYPE[3]);
		} else if (position > 39 && position < 46){
			test_model_txt.setText(Constants.TESTTYPE[4]);
		} else if (position > 45 && position < 54){
			test_model_txt.setText(Constants.TESTTYPE[5]);
		} else if (position > 53 && position < 61){
			test_model_txt.setText(Constants.TESTTYPE[6]);
		} else if (position > 60 && position < 73){
			test_model_txt.setText(Constants.TESTTYPE[7]);
		} else{
			test_model_txt.setText(Constants.TESTTYPE[8]);
		}
		
		test_content_txt.setText(Constants.TESTCONTENT[position]);
	}

	public void setAnswer(int size, String[] answers) {
		if(size == 0){
			main_healthfile_rd1.setVisibility(View.GONE);
			main_healthfile_rd2.setVisibility(View.GONE);
			main_healthfile_rd3.setVisibility(View.GONE);
			main_healthfile_rd4.setVisibility(View.GONE);
			main_healthfile_rd5.setVisibility(View.GONE);
			main_healthfile_rd6.setVisibility(View.GONE);
		}
        if(size == 1){
			main_healthfile_rd1.setText(answers[0]);
			main_healthfile_rd2.setVisibility(View.GONE);
			main_healthfile_rd3.setVisibility(View.GONE);
			main_healthfile_rd4.setVisibility(View.GONE);
			main_healthfile_rd5.setVisibility(View.GONE);
			main_healthfile_rd6.setVisibility(View.GONE);
		}
        if(size == 2){
			main_healthfile_rd1.setText(answers[0]);
			main_healthfile_rd2.setText(answers[1]);
			main_healthfile_rd3.setVisibility(View.GONE);
			main_healthfile_rd4.setVisibility(View.GONE);
			main_healthfile_rd5.setVisibility(View.GONE);
			main_healthfile_rd6.setVisibility(View.GONE);
		}
        if(size == 3){
			main_healthfile_rd1.setText(answers[0]);
			main_healthfile_rd2.setText(answers[1]);
			main_healthfile_rd3.setText(answers[2]);
			main_healthfile_rd4.setVisibility(View.GONE);
			main_healthfile_rd5.setVisibility(View.GONE);
			main_healthfile_rd6.setVisibility(View.GONE);
		}
        if(size == 4){
			main_healthfile_rd1.setText(answers[0]);
			main_healthfile_rd2.setText(answers[1]);
			main_healthfile_rd3.setText(answers[2]);
			main_healthfile_rd4.setText(answers[3]);
			main_healthfile_rd5.setVisibility(View.GONE);
			main_healthfile_rd6.setVisibility(View.GONE);
		}
        if(size == 5){
			main_healthfile_rd1.setText(answers[0]);
			main_healthfile_rd2.setText(answers[1]);
			main_healthfile_rd3.setText(answers[2]);
			main_healthfile_rd4.setText(answers[3]);
			main_healthfile_rd5.setText(answers[4]);
			main_healthfile_rd6.setVisibility(View.GONE);
		}
        if(size == 6){
			main_healthfile_rd1.setText(answers[0]);
			main_healthfile_rd2.setText(answers[1]);
			main_healthfile_rd3.setText(answers[2]);
			main_healthfile_rd4.setText(answers[3]);
			main_healthfile_rd5.setText(answers[4]);
			main_healthfile_rd6.setText(answers[5]);
		} 
	}

	/**
	 * 初始化菜单
	 */
	private void initMenu() {
		menu_layouts[0] = getActivity().findViewById(R.id.menu_tab_1);
		menu_layouts[1] = getActivity().findViewById(R.id.menu_tab_2);
		menu_layouts[2] = getActivity().findViewById(R.id.menu_tab_3);
		menu_layouts[3] = getActivity().findViewById(R.id.menu_tab_4);
		menu_layouts[4] = getActivity().findViewById(R.id.menu_tab_5);

		// 给点击事件加监听
		for (View view : menu_layouts) {
			view.setOnClickListener(menuListener);
		}

		// 给侧滑事件加监听
		scrollLayout_main.SetOnViewChangeListener(new OnViewChangeListener() {
			@Override
			public void OnViewChange(int index) {
				checkMenuItem(index);
			}
		});
		checkMenuItem(0);
	}

	/**
	 * 定义一个类监听视图点击
	 * 
	 * @author Administrator
	 */
	public View.OnClickListener menuListener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			int index = 0;
			switch (v.getId()) {
			case R.id.menu_tab_1:
				index = 0;
				break;

			case R.id.menu_tab_2:
				changeTitle("健康贴士");
				index = 1;
				break;

			case R.id.menu_tab_3:
				changeTitle("健康档案");
				if(main_file_xw_vf.getChildCount() <= 0){
					View view = flater.inflate(R.layout.layout_main_tab_healthfile_begin, null);
					main_file_xw_vf.addView(view);
				}
				index = 2;
				break;

			case R.id.menu_tab_4:
				changeTitle("行为改变");
				index = 3;
				break;

			case R.id.menu_tab_5:
				changeTitle("论坛");
				index = 4;
				break;
			}
			checkMenuItem(index);
			scrollLayout_main.setToScreen(index);
		}
	};

	/**
	 * 设置选中按钮和未选中时按钮的背景
	 * 
	 * @param index
	 * @author Administrator
	 */
	@SuppressWarnings("deprecation")
	private void checkMenuItem(int index) {

		for (int i = 0; i < menu_layouts.length; i++) {
			if (index == i) {// 选中
				// 设置选中背景图片
				Resources res = getResources();
				Drawable drawable = res.getDrawable(R.drawable.main_bottom_bg);
				menu_layouts[i].setBackgroundDrawable(drawable);
			} else {// 未选中
				menu_layouts[i].setBackgroundDrawable(null);
			}
		}

	}

	@Override
	protected Object onCreateTaskLoadData(Object... params) {
		changeTitle("首页");
		return null;
	}

	@Override
	protected Object onEndTaskAddView(Object result) {
		if (getView() == null) {
			return null;
		}
		((ViewGroup) getView()).removeAllViews();
		((ViewGroup) getView()).addView(inflater.inflate(R.layout.fragment_home, null));
		scrollLayout_main = (ScrollLayout) getActivity().findViewById(R.id.scrollLayout_main);
		initMenu();
		init();
		return null;
	}

	public void changeTitle(final String title) {
		Main.getDataTitle(new Main.IDecodeDataBack() {
			@Override
			public void dataDecodeCallback(TextView textview) {
				textview.setText(title);
			}
		});
	}
	
}

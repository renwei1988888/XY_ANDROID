package com.xy.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.util.HashMap;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.app.Application;
import com.xy.R;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.WindowManager;

/**
 * 存放共有的数据
 * 
 * @author hucheng
 * @title YBApplication.java   
 * @package com.yubang.base 
 * @date 2014年4月15日 上午9:31:02  
 * @version 1.0.0.1  
 * Copyright Copyright (c)  2014
 */
public class XYApplication extends Application  {

	/**
	 * 默认壁纸
	 */
	public Bitmap mDefault_Wallpager;
	/**
	 * 默认标题壁纸
	 */
	public Bitmap mDefault_TitleWallpager;
	/**
	 * 默认头像
	 */
	public Bitmap mDefault_Avatar;
	/**
	 * 默认照片
	 */
	public Bitmap mDefault_Photo;
	/**
	 * 壁纸缓存
	 */
	public HashMap<String, SoftReference<Bitmap>> mWallpagersCache = new HashMap<String, SoftReference<Bitmap>>();
	/**
	 * 壁纸名称
	 */
	public String[] mWallpagersName;
	/**
	 * 标题壁纸缓存
	 */
	public HashMap<String, SoftReference<Bitmap>> mTitleWallpagersCache = new HashMap<String, SoftReference<Bitmap>>();
	/**
	 * 标题壁纸名称
	 */
	public String[] mTitleWallpagersName;
	/**
	 * 当前壁纸编号
	 */
	public int mWallpagerPosition = 0;
	/**
	 * 主页搜索框关键字
	 */
	public static  String mainSearchKey = "";
	
	/** @Fields   主页搜索方式--renwei*/ 
	public static int sType = 0;
	private WindowManager.LayoutParams windowParams = new WindowManager.LayoutParams();

	public WindowManager.LayoutParams getWindowParams() {
		return windowParams;
	}
	

	public void onCreate() {
		super.onCreate();
		/**
		 * 初始化默认数据
		 */
		mDefault_Wallpager = BitmapFactory.decodeResource(getResources(),
				R.drawable.cover);
		mWallpagerPosition = (int) (Math.random() * 12);
		/**
		 * 初始化所有的数据信息
		 */
		try {
			mWallpagersName = getAssets().list("wallpaper");
			mTitleWallpagersName = getAssets().list("title_wallpager");
		} catch (IOException e) {
			e.printStackTrace();
		}
//		
//		YBAppException exception = YBAppException.getInstance();
//		exception.init(this);
	}

	/**
	 * 根据壁纸编号获取壁纸
	 */
	public Bitmap getWallpager(int position) {
		try {
			String wallpagerName = mWallpagersName[position];
			Bitmap bitmap = null;
			if (mWallpagersCache.containsKey(wallpagerName)) {
				SoftReference<Bitmap> reference = mWallpagersCache
						.get(wallpagerName);
				bitmap = reference.get();
				if (bitmap != null) {
					return bitmap;
				}
			}
			bitmap = BitmapFactory.decodeStream(getAssets().open(
					"wallpaper/" + wallpagerName));
			mWallpagersCache.put(wallpagerName, new SoftReference<Bitmap>(
					bitmap));
			return bitmap;

		} catch (Exception e) {
			return mDefault_Wallpager;
		}
	}

	/**
	 * 根据壁纸编号获取标题壁纸
	 */
	public Bitmap getTitleWallpager(int position) {
		try {
			String titleWallpagerName = mTitleWallpagersName[position];
			Bitmap bitmap = null;
			if (mTitleWallpagersCache.containsKey(titleWallpagerName)) {
				SoftReference<Bitmap> reference = mTitleWallpagersCache
						.get(titleWallpagerName);
				bitmap = reference.get();
				if (bitmap != null) {
					return bitmap;
				}
			}
			bitmap = BitmapFactory.decodeStream(getAssets().open(
					"title_wallpager/" + titleWallpagerName));
			mTitleWallpagersCache.put(titleWallpagerName,
					new SoftReference<Bitmap>(bitmap));
			return bitmap;
		} catch (Exception e) {
			return mDefault_TitleWallpager;
		}
	}
	
	/**
	 * 判断换成数据是否可读
	 * @param cachefile
	 * @return
	 */
	public boolean isReadDataCache(String cachefile){
		return readObject(cachefile) != null;
	}
	
	/**
	 * 判断缓存是否存在
	 * @param cachefile
	 * @return
	 */
	public boolean isExistDataCache(String cachefile){
		boolean exist = false;
		File data = getFileStreamPath(cachefile);
		if(data.exists())
			exist = true;
		return exist;
	}
	
	/**
	 * 保存对象
	 * @param ser
	 * @param file
	 * @return
	 */
	public boolean saveObject(Serializable ser, String file){
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = openFileOutput(file, MODE_PRIVATE);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(ser);
			oos.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			try {
				oos.close();
			} catch (Exception e) {
			}
			try {
				fos.close();
			} catch (Exception e) {
			}
		}
	}
	
	/**
	 * 读取对象
	 * @param file
	 * @return
	 */
	public Serializable readObject(String file){
		if(!isExistDataCache(file))
			return null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = openFileInput(file);
			ois = new ObjectInputStream(fis);
			return (Serializable)ois.readObject();
		} catch (FileNotFoundException e) {
		} catch (Exception e) {
			e.printStackTrace();
			if(e instanceof InvalidClassException){
				File data = getFileStreamPath(file);
				data.delete();
			}
		}finally{
			try {
				ois.close();
			} catch (IOException e) {
			}
			try {
				fis.close();
			} catch (IOException e) {
			}
		}
		return null;
	}

}

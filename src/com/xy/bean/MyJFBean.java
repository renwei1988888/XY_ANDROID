package com.xy.bean;

public class MyJFBean {
	
	private String jfTime;
	
	private String jfNum;
	
	private String jfSource;

	public String getJfTime() {
		return jfTime;
	}

	public void setJfTime(String jfTime) {
		this.jfTime = jfTime;
	}

	public String getJfNum() {
		return jfNum;
	}

	public void setJfNum(String jfNum) {
		this.jfNum = jfNum;
	}

	public String getJfSource() {
		return jfSource;
	}

	public void setJfSource(String jfSource) {
		this.jfSource = jfSource;
	}

	@Override
	public String toString() {
		return "MyJFBean [jfTime=" + jfTime + ", jfNum=" + jfNum
				+ ", jfSource=" + jfSource + "]";
	}
	
}

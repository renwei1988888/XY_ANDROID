package com.xy.bean;

public class SelectFoodBean {
	private String testId;
	private String testType;
	private String testContent;
	
	
	public String getTestId() {
		return testId;
	}


	public void setTestId(String testId) {
		this.testId = testId;
	}


	public String getTestType() {
		return testType;
	}


	public void setTestType(String testType) {
		this.testType = testType;
	}


	public String getTestContent() {
		return testContent;
	}


	public void setTestContent(String testContent) {
		this.testContent = testContent;
	}


	@Override
	public String toString() {
		return "SelectFoodBean [testId=" + testId + ", testType=" + testType
				+ ", testContent=" + testContent + "]";
	}
	
	
}

package com.xy.domain;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "tb_test_answer")
public class TestAnswer extends Model {
	
	@Column(name = "test_answer_no1")
	public String testAnswerNo1;
	
	@Column(name = "test_answer_no2")
	public String testAnswerNo2;

	@Column(name = "test_answer_no3")
	public String testAnswerNo3;
	
	@Column(name = "test_answer_no4")
	public String testAnswerNo4;
	
	@Column(name = "test_answer_no5")
	public String testAnswerNo5;
	
	@Column(name = "test_answer_no6")
	public String testAnswerNo6;

	@Override
	public String toString() {
		return "TestAnswer [testAnswerNo1=" + testAnswerNo1
				+ ", testAnswerNo2=" + testAnswerNo2 + ", testAnswerNo3="
				+ testAnswerNo3 + ", testAnswerNo4=" + testAnswerNo4
				+ ", testAnswerNo5=" + testAnswerNo5 + ", testAnswerNo6="
				+ testAnswerNo6 + "]";
	}
	
}

package com.xy.domain;

import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

@Table(name = "tb_test_content")
public class TestContent extends Model {

	@Column(name = "test_type")
	public String userId;
	
	@Column(name = "test_content")
	public String testContent;
	
	public List<TestAnswer> testAnswers(){
		return getMany(TestAnswer.class, "id");
	}
	
	@Override
	public String toString() {
		return "TestContent [userId=" + userId
				+ ", testContent=" + testContent + "]";
	}

	/**
	 * 返回试题列表
	 * 
	 * @return
	 */
	public static List<TestContent> queryListByTestId(String testId) {
		return new Select().from(TestContent.class).where("test_id = ?", testId).execute();
	}

}
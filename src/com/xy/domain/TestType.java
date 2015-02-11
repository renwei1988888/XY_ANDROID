package com.xy.domain;

import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "tb_test_type")
public class TestType extends Model {
	
	@Column(name = "test_type_content")
	public String testTypeContent;
	
	public List<TestContent> testContents(){
		return getMany(TestContent.class, "test_type");
	}

}

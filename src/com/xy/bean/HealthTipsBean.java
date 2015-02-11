package com.xy.bean;

public class HealthTipsBean {
	
	private String modelId;
	
	private String tipTittle;
	
	private String tipContent;
	
	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getTipTittle() {
		return tipTittle;
	}

	public void setTipTittle(String tipTittle) {
		this.tipTittle = tipTittle;
	}

	public String getTipContent() {
		return tipContent;
	}

	public void setTipContent(String tipContent) {
		this.tipContent = tipContent;
	}

	@Override
	public String toString() {
		return "HealthTipsBean [modelId=" + modelId + ", tipTittle="
				+ tipTittle + ", tipContent=" + tipContent + "]";
	}
	
}

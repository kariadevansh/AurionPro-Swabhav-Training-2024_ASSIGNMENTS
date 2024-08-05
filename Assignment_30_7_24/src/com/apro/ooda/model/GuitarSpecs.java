
package com.apro.ooda.model;

public class GuitarSpecs {
	private Builder builder;
	private String model;
	private Type type;
	private Wood backWood;
	private Wood frontWood;
	

	public Builder getBuilder() {
		return builder;
	}

	public void setBuilder(Builder builder) {
		this.builder = builder;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Wood getBackWood() {
		return backWood;
	}

	public void setBackWood(Wood backWood) {
		this.backWood = backWood;
	}

	public Wood getFrontWood() {
		return frontWood;
	}

	public void setFrontWood(Wood frontWood) {
		this.frontWood = frontWood;
	}


}

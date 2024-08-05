package com.apro.ooda.model;

public class Guitar {
	private String serialNumber;
	private double price;
	private GuitarSpecs specs;
	private Builder builder;
	private String model;
	private Type type;
	private Wood backWood;
	private Wood frontWood;
	
	
    public Guitar(String serialNumber, double price, Builder builder, String model, Type type, Wood backWood, Wood frontWood) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.frontWood = frontWood;
    }

	public Guitar(String serialNumber, double price, GuitarSpecs specs) {
	this.serialNumber = serialNumber;
	this.price = price;
	this.specs = specs;
}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	public GuitarSpecs getSpecs() {
		return specs;
	}

	public void setSpecs(GuitarSpecs specs) {
		this.specs = specs;
	}

//	@Override
//	public String toString() {
//		return "Guitar [serialNumber=" + serialNumber + ", price=" + price + ", specs=" + specs + "]";
//	}

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

	@Override
	public String toString() {
		return "Guitar [serialNumber=" + serialNumber + ", price=" + price + ", builder=" + builder + ", model=" + model
				+ ", type=" + type + ", backWood=" + backWood + ", frontWood=" + frontWood + "]";
	}	
	
}

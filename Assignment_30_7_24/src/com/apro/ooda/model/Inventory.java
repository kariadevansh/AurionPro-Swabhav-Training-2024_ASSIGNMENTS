package com.apro.ooda.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	private List<Guitar> guitars;

	public Inventory(List<Guitar> guitars) {
		this.guitars = guitars;
	}

	public List<Guitar> getGuitars() {
		return guitars;
	}

	public void setGuitars(List<Guitar> guitars) {
		this.guitars = guitars;
	}
	
    public void addGuitar(String serialNumber, double price, Builder builder, String model, Type type, Wood backWood, Wood frontWood) {
        guitars.add(new Guitar(serialNumber, price, builder, model, type, backWood, frontWood));
    }
	
    public Guitar getGuitar(String serialNumber) {
        for (Guitar guitar : guitars) {
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null; 
    }
    
    public List<Guitar> searchGuitar(Builder builder, String model, Type type, Wood backWood, Wood frontWood) {
        List<Guitar> matchingGuitars = new ArrayList<>();
        
        for (Guitar guitar : guitars) {
            boolean matches = true;
            
            if (builder.toString().toUpperCase() != null && !builder.toString().toUpperCase().equals(guitar.getBuilder())) {
                matches = false;
            }
            if (model.toString().toUpperCase() != null && !model.toString().toUpperCase().equals(guitar.getModel())) {
                matches = false;
            }
            if (type.toString().toUpperCase() != null && !type.toString().toUpperCase().equals(guitar.getType())) {
                matches = false;
            }
            if (backWood.toString().toUpperCase() != null && !backWood.toString().toUpperCase().equals(guitar.getBackWood())) {
                matches = false;
            }
            if (frontWood.toString().toUpperCase() != null && !frontWood.toString().toUpperCase().equals(guitar.getFrontWood())) {
                matches = false;
            }
            
            if (matches) {
                matchingGuitars.add(guitar);
            }
        }
        
        return matchingGuitars;
    }
    
    
	
}

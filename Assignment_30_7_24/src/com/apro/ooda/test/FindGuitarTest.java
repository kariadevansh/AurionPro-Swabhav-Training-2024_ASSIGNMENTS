package com.apro.ooda.test;

import java.util.ArrayList;
import java.util.List;

import com.apro.ooda.model.Builder;
import com.apro.ooda.model.Guitar;
import com.apro.ooda.model.Inventory;
import com.apro.ooda.model.Type;
import com.apro.ooda.model.Wood;

public class FindGuitarTest {

	public static void main(String[] args) {
		List<Guitar> guitarList = new ArrayList<>();
		Inventory inventory = initializeInventory(guitarList );
		
	    List<Guitar> result = inventory.searchGuitar(Builder.FENDER,"Stratocaster",Type.ELECTRIC,Wood.ALDER,Wood.MAPLE);
	    printSearchResult(result);
	    
	    System.out.println("\n------------------(when we only have a few filters) ----------");
	    List<Guitar> result2 = inventory.searchGuitar(Builder.FENDER,null,Type.ELECTRIC,Wood.ALDER,null);
	    printSearchResult(result2);
	    
	    System.out.println("\n-------------(Incase we set all values as null)----------");
	    List<Guitar> result3 = inventory.searchGuitar(null,null,null,null,null);
	    printSearchResult(result3);
	      
	}
	 private static Inventory initializeInventory(List<Guitar> guitarList) {
	        guitarList.add(new Guitar(
	            "SN12345",          
	            1500.00,            
	            Builder.GIBSON,     
	            "Les Paul Standard", 
	            Type.ELECTRIC,     
	            Wood.MAHOGANY,      
	            Wood.MAPLE          
	        ));
	        
	        guitarList.add(new Guitar(
	            "SN67890",          
	            2000.00,            
	            Builder.FENDER,     
	            "Stratocaster",     
	            Type.ELECTRIC,     
	            Wood.ALDER,        
	            Wood.MAPLE         
	        ));
	        
	        guitarList.add(new Guitar(
	            "SN54321",         
	            1200.00,           
	            Builder.MARTIN,    
	            "D-28",            
	            Type.ACOUSTIC,     
	            Wood.INDIAN_ROSEWOOD, 
	            Wood.CEDAR          
	        ));
	        
	        guitarList.add(new Guitar(
	            "SN09876",          
	            1800.00,            
	            Builder.OLSON,      
	            "SJ",               
	            Type.ACOUSTIC,     
	            Wood.ADIRONDACK,   
	            Wood.SITKA         
	        ));
	        
	        guitarList.add(new Guitar(
	                "SN11223",          // Serial Number
	                1300.00,            // Price
	                Builder.FENDER,     // Builder
	                "Telecaster",       // Model
	                Type.ELECTRIC,     // Type
	                Wood.MAPLE,         // Back Wood
	                Wood.MAPLE          // Front Wood
	            ));
	            
	            guitarList.add(new Guitar(
	                "SN22334",          // Serial Number
	                1400.00,            // Price
	                Builder.GIBSON,     // Builder
	                "SG Standard",      // Model
	                Type.ELECTRIC,     // Type
	                Wood.MAHOGANY,      // Back Wood
	                Wood.INDIAN_ROSEWOOD       // Front Wood
	            ));
	            
	            guitarList.add(new Guitar(
	                "SN33445",          // Serial Number
	                1600.00,            // Price
	                Builder.MARTIN,     // Builder
	                "OM-28",            // Model
	                Type.ACOUSTIC,     // Type
	                Wood.INDIAN_ROSEWOOD, // Back Wood
	                Wood.SITKA          // Front Wood
	            ));
	            
	            guitarList.add(new Guitar(
	                "SN44556",          // Serial Number
	                1700.00,            // Price
	                Builder.RYAN,       // Builder
	                "Signature Model",  // Model
	                Type.ACOUSTIC,     // Type
	                Wood.COCOBOLO,       // Back Wood
	                Wood.CEDAR          // Front Wood
	            ));
	            
	            guitarList.add(new Guitar(
	                "SN55667",          // Serial Number
	                1900.00,            // Price
	                Builder.GIBSON,     // Builder
	                "Flying V",         // Model
	                Type.ELECTRIC,     // Type
	                Wood.MAHOGANY,      // Back Wood
	                Wood.MAPLE          // Front Wood
	            ));
	            
	            guitarList.add(new Guitar(
	                "SN66778",          // Serial Number
	                2000.00,            // Price
	                Builder.MARTIN,     // Builder
	                "GPC-16E",          // Model
	                Type.ACOUSTIC,     // Type
	                Wood.MAPLE,         // Back Wood
	                Wood.CEDAR          // Front Wood
	            ));
	            
	            guitarList.add(new Guitar(
	                "SN77889",          // Serial Number
	                2100.00,            // Price
	                Builder.FENDER,     // Builder
	                "Lead",             // Model
	                Type.ELECTRIC,     // Type
	                Wood.ALDER,         // Back Wood
	                Wood.MAPLE          // Front Wood
	            ));
	            
	            guitarList.add(new Guitar(
	                "SN88990",          // Serial Number
	                2200.00,            // Price
	                Builder.GIBSON,     // Builder
	                "ES-335",           // Model
	                Type.ELECTRIC,     // Type
	                Wood.MAPLE,         // Back Wood
	                Wood.INDIAN_ROSEWOOD       // Front Wood
	            ));
	            
	            guitarList.add(new Guitar(
	                "SN99001",          // Serial Number
	                2300.00,            // Price
	                Builder.RYAN,       // Builder
	                "Custom",           // Model
	                Type.ACOUSTIC,     // Type
	                Wood.COCOBOLO,       // Back Wood
	                Wood.SITKA          // Front Wood
	            ));
	            
	            guitarList.add(new Guitar(
	                "SN10012",          // Serial Number
	                2400.00,            // Price
	                Builder.OLSON,      // Builder
	                "Jumbo",            // Model
	                Type.ACOUSTIC,     // Type
	                Wood.MAPLE,         // Back Wood
	                Wood.CEDAR          // Front Wood
	            ));
	            
	            guitarList.add(new Guitar(
	                "SN11023",          // Serial Number
	                2500.00,            // Price
	                Builder.MARTIN,     // Builder
	                "HD-28",            // Model
	                Type.ACOUSTIC,     // Type
	                Wood.INDIAN_ROSEWOOD, // Back Wood
	                Wood.SITKA          // Front Wood
	            ));
	            
	            guitarList.add(new Guitar(
	                "SN12034",          // Serial Number
	                2600.00,            // Price
	                Builder.GIBSON,     // Builder
	                "LP Junior",        // Model
	                Type.ELECTRIC,     // Type
	                Wood.MAHOGANY,      // Back Wood
	                Wood.INDIAN_ROSEWOOD       // Front Wood
	            ));
	            
	            guitarList.add(new Guitar(
	                "SN13045",          // Serial Number
	                2700.00,            // Price
	                Builder.FENDER,     // Builder
	                "Jaguar",           // Model
	                Type.ELECTRIC,     // Type
	                Wood.ALDER,         // Back Wood
	                Wood.MAPLE          // Front Wood
	            ));
	            
	            guitarList.add(new Guitar(
	                "SN14056",          // Serial Number
	                2800.00,            // Price
	                Builder.MARTIN,     // Builder
	                "D-35",             // Model
	                Type.ACOUSTIC,     // Type
	                Wood.CEDAR,         // Back Wood
	                Wood.INDIAN_ROSEWOOD // Front Wood
	            ));
	        
	        return new Inventory(guitarList);
	    }
	 
	 public static void printSearchResult(List<Guitar> result) {
	     if (result.isEmpty()) {
	    	 System.out.println("No guitars found matching the criteria.");
	    	 return;
	           
	        } 
	     System.out.println("Matching guitar: \n");
	     for (Guitar guitar : result) {
             System.out.println(  guitar);
         }
	 }

}

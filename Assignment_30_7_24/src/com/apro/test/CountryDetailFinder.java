package com.apro.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.apro.model.Country;
import com.apro.model.Region;

public class CountryDetailFinder {
	public static void main(String[] args) {
		List<Region> regions = Arrays.asList(
				new Region(1, "Europe")
                ,new Region(2, "Americas")
                ,new Region(3, "Asia")
                ,new Region(4, "Middle East and Africa"));
		
		List<Country> countries = Arrays.asList(
	            new Country("IT", "Italy", 1),
	            new Country("JP", "Japan", 3),
	            new Country("US", "United States of America", 2),
	            new Country("CA", "Canada", 2),
	            new Country("CN", "China", 3),
	            new Country("IN", "India", 3),
	            new Country("AU", "Australia", 3),
	            new Country("ZW", "Zimbabwe", 4),
	            new Country("SG", "Singapore", 3),
	            new Country("UK", "United Kingdom", 1),
	            new Country("FR", "France", 1),
	            new Country("DE", "Germany", 1),
	            new Country("ZM", "Zambia", 4),
	            new Country("EG", "Egypt", 4),
	            new Country("BR", "Brazil", 2),
	            new Country("CH", "Switzerland", 1),
	            new Country("NL", "Netherlands", 1),
	            new Country("MX", "Mexico", 2),
	            new Country("KW", "Kuwait", 4),
	            new Country("IL", "Israel", 4),
	            new Country("DK", "Denmark", 1),
	            new Country("HK", "HongKong", 3),
	            new Country("NG", "Nigeria", 4),
	            new Country("AR", "Argentina", 2),
	            new Country("BE", "Belgium", 1));
		
		
		Map<String, String> countryCodeToNameMap = countries.stream()
				   											.collect(Collectors.toMap(
				   													           country -> country.getCountryCode().toUpperCase(),  
				   													           Country::getCountryName
				   													 ));
		
		 Scanner scanner = new Scanner(System.in);
		 System.out.print("Enter country code to search: ");
		 String searchCode = scanner.nextLine().trim().toUpperCase();
		 
		 String resultCountryName = getCountryName(searchCode, countryCodeToNameMap);
		 printCountryCodeSearchResult(resultCountryName,searchCode);
	        
		 
		 Map<Integer, Region> regionIdToRegionMap = regions.stream()
			        									   .collect(Collectors.toMap(
			        											   				Region::getRegionId, 	
			        											   				Function.identity()));    // using the id as key

	        
		 Map<Integer, List<Country>> regionIdToCountriesMap = countries.stream()
			         												   .collect(Collectors.groupingBy(Country::getCountryId));                 
		 // using id as key and sorting . after that we make a new list of values for the id in which we include all the countries with same id
		  
		 
		 System.out.print("Enter region ID to get countries: ");
		 int regionId = scanner.nextInt();
	     
		 Region region = regionIdToRegionMap.get(regionId);
	        
		 printCountryInRegionIdSearchResult(region,regionId,regionIdToCountriesMap);
		 
		 
		 printCountOfCountriesInEachRegion(regionIdToCountriesMap,regionIdToRegionMap);
		 
	}
	
	private static String getCountryName(String searchCode, Map<String, String> countryCodeToNameMap) {
        return countryCodeToNameMap.getOrDefault(searchCode, "Country not found");
    }
	
	private static void printCountryCodeSearchResult(String resultCountryName, String searchCode) {
        if(resultCountryName.equals("Country not found")) {
        	System.out.println(resultCountryName);
        	return;
        }
        System.out.println("\nCountry name for code " + searchCode + " is " + resultCountryName+"\n");
	}
	
	private static void printCountryInRegionIdSearchResult(Region region,int regionId,Map<Integer, List<Country>> regionIdToCountriesMap) {
		 if (region == null) {
	            System.out.println("Region ID " + regionId + " not found.");
	            return;
	        }
		// Get the countries in the specified region
         List<Country> countriesInRegion = regionIdToCountriesMap.getOrDefault(regionId, Collections.emptyList()); // in default we keep an empty list
         if (countriesInRegion.isEmpty()) {
             System.out.println("No countries found in region ID " + regionId);
             return;
         } 
         System.out.println("\nCountries in region " + region.getRegionName() + ":\n");
         countriesInRegion.forEach(country -> System.out.println(country.getCountryName()));
	}
	
	private static void printCountOfCountriesInEachRegion(Map<Integer, List<Country>> regionIdToCountriesMap, Map<Integer, Region> regionIdToRegionMap) {
		  Map<Integer, Integer> regionIdToCountryCountMap = regionIdToCountriesMap.entrySet().stream()
	                .collect(Collectors.toMap(
	                    Map.Entry::getKey,
	                    entry -> entry.getValue().size()
	                ));
	        
	        // Print the count of countries in each region
	        System.out.println("\nCount of countries in each region:");
	        regionIdToRegionMap.forEach((regionId, regionObj) -> {
	            int count = regionIdToCountryCountMap.getOrDefault(regionId, 0);
	            System.out.println(regionObj.getRegionName() + ": " + count + " countries");
	        });
	}
}


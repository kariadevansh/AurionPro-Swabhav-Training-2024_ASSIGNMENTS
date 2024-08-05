package com.apro.assignment.model;

public class CricketPlayer {
	private int playerId;
	private String name;
	private int numberOfMatches;
	private int runs;
	private int numberOfWickets;
	
	public CricketPlayer() {
		this.playerId = 01;
		this.name = "abc";
		this.numberOfMatches = 5;
		this.runs = 100;
		this.numberOfWickets = 3;
	}
	public CricketPlayer(int playerId, String name, int numberOfMatches, int runs,int numberOfWickets) {
		this.playerId = playerId;
		this.name = name;
		this.numberOfMatches = numberOfMatches ;
		this.runs = runs;
		this.numberOfWickets = numberOfWickets;
	}
	
	public void setName(String name) {
		this.name= name;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public void setNumberOfMatches(int numberOfMatches) {
		this.numberOfMatches = numberOfMatches;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public void setNumberOfWickets (int numberOfWickets ) {
		this.numberOfWickets = numberOfWickets ;
	}
	
	public int getRuns(){
		return this.runs;
	}
	public int getPlayerId(){
		return this.playerId;
	}
	public int getNumberOfWickets(){
		return this.numberOfWickets;
	}
	public int getNumberOfMatches(){
		return this.numberOfMatches;
	}
	public String getName(){
		return this.name;
	}
	
	public void display() {
		System.out.println("Name :"+getName());
		System.out.println("ID :"+getPlayerId());
		System.out.println("No.of Matcher :"+getNumberOfMatches());
		System.out.println("TOtal Runs :"+getRuns());
		System.out.println("No.of Wickets:"+getNumberOfWickets());
	}
	
	public double avgRuns(int runs, int numberOfMatches) {
		double averageRuns = runs/numberOfMatches;
		return averageRuns;
	}
	public void avgRuns() {
		double averageRuns = runs/numberOfMatches;
		System.out.print(averageRuns);
	}
	public double avgWickets(int numberOfWickets, int numberOfMatches) {
		double averageWickets = (double)numberOfWickets/numberOfMatches;
		return averageWickets;
	}
	public void avgWickets() {
		double averageWickets =(double) numberOfWickets/numberOfMatches;
		System.out.print(averageWickets);
	}

}

package com.techelevator;

public class Beverage extends VendingMachineItem {
	private String type = "Drink";
	private String saying = "Glug Glug, Yum!";
	
	public Beverage(String slot, String name, double price, int count) {
		super(slot, name, price, count);
	}

	@Override
	public String getType() {
		return this.type;
	}
	
	@Override
	public String getSaying() {
		return this.saying;
	}
	

}

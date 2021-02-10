package com.techelevator;

public class Candy extends VendingMachineItem {
	private String type = "Candy";
	private String saying = "Munch Munch, Yum!";
	
	public Candy(String slot, String name, double price, int count) {
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

package com.techelevator;

public class Gum extends VendingMachineItem {
	private String type = "Gum";
	private String saying = "Chew Chew, Yum!";
	
	public Gum(String slot, String name, double price, int count) {
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

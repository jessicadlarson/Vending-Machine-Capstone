package com.techelevator;


import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.junit.Test;

public class InventoryTest {
	
	Inventory inventory = new Inventory();

	@Test
	public void testGetInventoryGetSlot_withGoodData_shouldReturnSlot() {
		//arrange
		List<String[]> inventoryList = new ArrayList<>();
		String[] one = { "D4", "Snickers", "1.0", "Candy", "5" };
		String[] two = { "D5", "Kit Kat", "2.0", "Candy", "4" };
		inventoryList.add(one); 
		inventoryList.add(two);
		
		Candy expectedItemOne = new Candy("D4", "Snickers", 1.0, 5);
		Candy expectedItemTwo = new Candy("D5", "Kit Kat", 2.0, 4);
		
		TreeMap<String, VendingMachineItem> expected = new TreeMap<>();
		expected.put("D4", expectedItemOne);
		expected.put("D5", expectedItemTwo);
		
		//act
		TreeMap<String, VendingMachineItem> result = inventory.getInventory(inventoryList);
		
		//assert
		 assertEquals(expected.get("D4").getSlot(), result.get("D4").getSlot());
	} 
	
	@Test
	public void testGetInventoryGetName_withGoodData_shouldReturnName() {
		//arrange
		List<String[]> inventoryList = new ArrayList<>();
		String[] one = { "C1", "Frito", "1.0", "Chip", "5" };
		String[] two = { "D5", "Kit Kat", "2.0", "Candy", "4" };
		inventoryList.add(one); 
		inventoryList.add(two);
		
		Chips expectedItemOne = new Chips("C1", "Frito", 1.0, 5);
		Candy expectedItemTwo = new Candy("D5", "Kit Kat", 2.0, 4);
		
		TreeMap<String, VendingMachineItem> expected = new TreeMap<>();
		expected.put("C1", expectedItemOne);
		expected.put("D5", expectedItemTwo);
		
		//act
		TreeMap<String, VendingMachineItem> result = inventory.getInventory(inventoryList);
		
		//assert
		 assertEquals(expected.get("C1").getName(), result.get("C1").getName());
	} 
	
	@Test
	public void testGetInventoryGetPrice_withGoodData_shouldReturnPrice() {
		//arrange
		List<String[]> inventoryList = new ArrayList<>();
		String[] one = { "C1", "Big Red", "1.0", "Gum", "5" };
		String[] two = { "D5", "Kit Kat", "2.0", "Candy", "4" };
		inventoryList.add(one); 
		inventoryList.add(two);
		
		Gum expectedItemOne = new Gum("C1", "Big Red", 1.0, 5);
		Candy expectedItemTwo = new Candy("D5", "Kit Kat", 2.0, 4);
		
		TreeMap<String, VendingMachineItem> expected = new TreeMap<>();
		expected.put("C1", expectedItemOne);
		expected.put("D5", expectedItemTwo);
		
		//act
		TreeMap<String, VendingMachineItem> result = inventory.getInventory(inventoryList);
		
		double delta = 1.0;
		//assert
		 assertEquals(expected.get("C1").getPrice(), result.get("C1").getPrice(), delta);
	} 
	
	@Test
	public void testGetInventoryGetType_withGoodData_shouldReturnType() {
		//arrange
		List<String[]> inventoryList = new ArrayList<>();
		String[] one = { "C1", "Frito", "1.0", "Chip", "5" };
		String[] two = { "D5", "Kit Kat", "2.0", "Candy", "4" };
		inventoryList.add(one); 
		inventoryList.add(two);
		
		Chips expectedItemOne = new Chips("C1", "Frito", 1.0, 5);
		Candy expectedItemTwo = new Candy("D5", "Kit Kat", 2.0, 4);
		
		TreeMap<String, VendingMachineItem> expected = new TreeMap<>();
		expected.put("C1", expectedItemOne);
		expected.put("D5", expectedItemTwo);
		
		//act
		TreeMap<String, VendingMachineItem> result = inventory.getInventory(inventoryList);
		
		//assert
		 assertEquals(expected.get("C1").getType(), result.get("C1").getType());
	} 
	
	@Test
	public void testGetInventoryGetCount_withGoodData_shouldReturnCount() {
		//arrange
		List<String[]> inventoryList = new ArrayList<>();
		String[] one = { "C1", "Dr. Pepper", "1.0", "Drink", "5" };
		String[] two = { "D5", "Kit Kat", "2.0", "Candy", "4" };
		inventoryList.add(one); 
		inventoryList.add(two);
		
		Beverage expectedItemOne = new Beverage("C1", "Dr. Pepper", 1.0, 5);
		Candy expectedItemTwo = new Candy("D5", "Kit Kat", 2.0, 4);
		
		TreeMap<String, VendingMachineItem> expected = new TreeMap<>();
		expected.put("C1", expectedItemOne);
		expected.put("D5", expectedItemTwo);
		
		//act
		TreeMap<String, VendingMachineItem> result = inventory.getInventory(inventoryList);
		
		//assert
		 assertEquals(expected.get("C1").getCount(), result.get("C1").getCount());
	}  

}

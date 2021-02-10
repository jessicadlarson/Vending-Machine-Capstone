package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BeverageTest {
	//happy path
	@Test
	public void testGetSlot_withGoodData_shouldReturnSlot() {
		//arrange
		Beverage beverage = new Beverage("B4", "Dr. Pepper", 1.0, 5);
		String expected = "B4";
		
		
		//act
		String result = beverage.getSlot();
		
		//assert
		assertEquals(expected, result);
	}
	
	//happy path
	@Test
	public void testGetName_withGoodData_shouldReturnName() {
		//arrange
		Beverage beverage = new Beverage("B4", "Dr. Pepper", 1.0, 5);
		String expected = "Dr. Pepper";
		
		
		//act
		String result = beverage.getName();
		
		//assert
		assertEquals(expected, result);
	}
	
	//happy path
	@Test
	public void testGetPrice_withGoodData_shouldReturnPrice() {
		//arrange
		Beverage beverage = new Beverage("B4", "Dr. Pepper", 1.0, 5);
		double expected = 1.0;
		
		//act
		double result = beverage.getPrice();
		double delta = 1.0;
		
		//assert
		assertEquals(expected, result, delta);
	}
	
	//happy path
	@Test
	public void testGetCount_withGoodData_shouldReturnCount() {
		//arrange
		Beverage beverage = new Beverage("B4", "Dr. Pepper", 1.0, 5);
		int expected = 5;
		
		//act
		int result = beverage.getCount();
		
		
		//assert
		assertEquals(expected, result);
	}
	
	//happy path
	@Test
	public void testGetType_withGoodData_shouldReturnType() {
		//arrange
		Beverage beverage = new Beverage("B4", "Dr. Pepper", 1.0, 5);
		String expected = "Drink";
		
		//act
		String result = beverage.getType();
		
		
		//assert
		assertEquals(expected, result);
	}
	
	//happy path
	@Test
	public void testGetSaying_withGoodData_shouldReturnSaying() {
		//arrange
		Beverage beverage = new Beverage("B4", "Dr. Pepper", 1.0, 5);
		String expected = "Glug Glug, Yum!";
		
		//act
		String result = beverage.getSaying();
		
		
		//assert
		assertEquals(expected, result);
	}
	
	
	
}










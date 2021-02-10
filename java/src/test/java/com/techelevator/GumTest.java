package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GumTest {
	//happy path
	@Test
	public void testGetSlot_withGoodData_shouldReturnSlot() {
		//arrange
		Gum gum = new Gum("B4", "Chicklets", 1.0, 5);
		String expected = "B4";
					
		//act
		String result = gum.getSlot();
		
		//assert
		assertEquals(expected, result);
	}
	
	//happy path
	@Test
	public void testGetName_withGoodData_shouldReturnName() {
		//arrange
		Gum gum = new Gum("B4", "Chicklets", 1.0, 5);
		String expected = "Chicklets";
		
		
		//act
		String result = gum.getName();
		
		//assert
		assertEquals(expected, result);
	}
	
	//happy path
	@Test
	public void testGetPrice_withGoodData_shouldReturnPrice() {
		//arrange
		Gum gum = new Gum("B4", "Chicklets", 1.0, 5);
		double expected = 1.0;
		
		//act
		double result = gum.getPrice();
		double delta = 1.0;
		
		//assert
		assertEquals(expected, result, delta);
	}
	
	//happy path
	@Test
	public void testGetCount_withGoodData_shouldReturnCount() {
		//arrange
		Gum gum = new Gum("B4", "Chicklets", 1.0, 5);
		int expected = 5;
		
		//act
		int result = gum.getCount();
		
		
		//assert
		assertEquals(expected, result);
	}
	
	//happy path
	@Test
	public void testGetType_withGoodData_shouldReturnType() {
		//arrange
		Gum gum = new Gum("B4", "Chicklets", 1.0, 5);
		String expected = "Gum";
		
		//act
		String result = gum.getType();
		
		
		//assert
		assertEquals(expected, result);
	}
	
	//happy path
	@Test
	public void testGetSaying_withGoodData_shouldReturnSaying() {
		//arrange
		Gum gum = new Gum("B4", "Chicklets", 1.0, 5);
		String expected = "Chew Chew, Yum!";
		
		//act
		String result = gum.getSaying();
		
		
		//assert
		assertEquals(expected, result);
	}
	
	
	


}

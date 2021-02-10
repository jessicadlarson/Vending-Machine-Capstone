package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChipsTest {
	//happy path
			@Test
			public void testGetSlot_withGoodData_shouldReturnSlot() {
				//arrange
				Chips chips = new Chips("B4", "Pringles", 1.0, 5);
				String expected = "B4";
							
				//act
				String result = chips.getSlot();
				
				//assert
				assertEquals(expected, result);
			}
			
			//happy path
			@Test
			public void testGetName_withGoodData_shouldReturnName() {
				//arrange
				Chips chips = new Chips("B4", "Pringles", 1.0, 5);
				String expected = "Pringles";
				
				
				//act
				String result = chips.getName();
				
				//assert
				assertEquals(expected, result);
			}
			
			//happy path
			@Test
			public void testGetPrice_withGoodData_shouldReturnPrice() {
				//arrange
				Chips chips = new Chips("B4", "Pringles", 1.0, 5);
				double expected = 1.0;
				
				//act
				double result = chips.getPrice();
				double delta = 1.0;
				
				//assert
				assertEquals(expected, result, delta);
			}
			
			//happy path
			@Test
			public void testGetCount_withGoodData_shouldReturnCount() {
				//arrange
				Chips chips = new Chips("B4", "Pringles", 1.0, 5);
				int expected = 5;
				
				//act
				int result = chips.getCount();
				
				
				//assert
				assertEquals(expected, result);
			}
			
			//happy path
			@Test
			public void testGetType_withGoodData_shouldReturnType() {
				//arrange
				Chips chips = new Chips("B4", "Pringles", 1.0, 5);
				String expected = "Chip";
				
				//act
				String result = chips.getType();
				
				
				//assert
				assertEquals(expected, result);
			}
			
			//happy path
			@Test
			public void testGetSaying_withGoodData_shouldReturnSaying() {
				//arrange
				Chips chips = new Chips("B4", "Pringles", 1.0, 5);
				String expected = "Crunch Crunch, Yum!";
				
				//act
				String result = chips.getSaying();
				
				
				//assert
				assertEquals(expected, result);
			}
			
			
			
		}




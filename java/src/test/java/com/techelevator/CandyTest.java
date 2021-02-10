package com.techelevator;


	
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CandyTest {
		//happy path
		@Test
		public void testGetSlot_withGoodData_shouldReturnSlot() {
			//arrange
			Candy candy = new Candy("B4", "Twix", 1.0, 5);
			String expected = "B4";
						
			//act
			String result = candy.getSlot();
			 
			//assert
			assertEquals(expected, result);
		}
		
		//happy path
		@Test
		public void testGetName_withGoodData_shouldReturnName() {
			//arrange
			Candy candy = new Candy("B4", "Twix", 1.0, 5);
			String expected = "Twix";
			
			
			//act
			String result = candy.getName();
			
			//assert
			assertEquals(expected, result);
		}
		
		//happy path
		@Test
		public void testGetPrice_withGoodData_shouldReturnPrice() {
			//arrange
			Candy candy = new Candy("B4", "Twix", 1.0, 5);
			double expected = 1.0;
			
			//act
			double result = candy.getPrice();
			double delta = 1.0;
			
			//assert
			assertEquals(expected, result, delta);
		}
		
		//happy path
		@Test
		public void testGetCount_withGoodData_shouldReturnCount() {
			//arrange
			Candy candy = new Candy("B4", "Twix", 1.0, 5);
			int expected = 5;
			
			//act
			int result = candy.getCount();
			
			
			//assert
			assertEquals(expected, result);
		}
		
		//happy path
		@Test
		public void testGetType_withGoodData_shouldReturnType() {
			//arrange
			Candy candy = new Candy("B4", "Twix", 1.0, 5);
			String expected = "Candy";
			
			//act
			String result = candy.getType();
			
			
			//assert
			assertEquals(expected, result);
		}
		
		//happy path
		@Test
		public void testGetSaying_withGoodData_shouldReturnSaying() {
			//arrange
			Candy candy = new Candy("B4", "Twix", 1.0, 5);
			String expected = "Munch Munch, Yum!";
			
			//act
			String result = candy.getSaying();
			
			
			//assert
			assertEquals(expected, result);
		}
		
		
		
	}


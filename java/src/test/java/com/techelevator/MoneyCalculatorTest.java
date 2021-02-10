package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.Test;

public class MoneyCalculatorTest {
	MoneyCalculator moneyCalculator = new MoneyCalculator();
		
	//happy path
	@Test
	public void testInsertedMoney_withGoodData_shouldReturnBalance() {
		
		//arrange
		double balance = 0;
		double expected = 5.0;
		
		//act
		double result = moneyCalculator.insertMoney(5.00, balance);
		double delta = 5.0;
		
		
		//assert
		assertEquals(expected, result, delta);
	}
	
	//happy path
		@Test
		public void testChargeMoney_withGoodData_shouldReturnBalance() {
			
			//arrange
			double balance = 10.0;
			double expected = 5.0;
			
			//act
			double result = moneyCalculator.chargeMoney(5.00, balance);
			double delta = 5.0;
			
			
			//assert
			assertEquals(expected, result, delta);
		}
		
	//happy path
			@Test
			public void testMakeChange_withDollarTwentyFive_shouldReturnFiveQuarters() {
				
				//arrange
				double balance = 1.25;
				String expected = "Your change is: \nQuarters: 5 Dimes: 0 Nickels: 0";
				
				//act
				String result = moneyCalculator.makeChange(balance);				
				
				
				//assert
				assertEquals(expected, result);
			}
			
			@Test
			public void testMakeChange_withTwentyCents_shouldReturnTwoDimes() {
				
				//arrange
				double balance = 0.20;
				String expected = "Your change is: \nQuarters: 0 Dimes: 2 Nickels: 0";
				
				//act
				String result = moneyCalculator.makeChange(balance);				
				
				
				//assert
				assertEquals(expected, result);
			}

			@Test
			public void testMakeChange_withFiveCents_shouldReturnOneNickel() {
				
				//arrange
				double balance = 0.05;
				String expected = "Your change is: \nQuarters: 0 Dimes: 0 Nickels: 1";
				
				//act
				String result = moneyCalculator.makeChange(balance);				
				
				
				//assert
				assertEquals(expected, result);
			}


}

package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.techelevator.view.Menu;

public class VendingMachineCLITest {
	
	
	@Test
	public void testGetSalesReportItem_withGoodData_shouldReturnItems() {
		List<String[]> salesReport = new ArrayList<>();
		Gum chosenItem = new Gum("B4", "Chicklets", 1.0, 5);
		String price = String.valueOf(chosenItem.getPrice());
		String[] itemsForSalesReport = { chosenItem.getName(), price };
		salesReport.add(itemsForSalesReport);
		VendingMachineCLI vendingMachineCli = new VendingMachineCLI(null);
		
		String expected = chosenItem.getName() + " | $" + price;
		
		String result = vendingMachineCli.getSalesReportItem(salesReport);
		assertEquals(expected, result);
	}
	
	
	@Test
	public void testGetSalesReportTotalSales_withGoodData_shouldReturnTotalSales() {

		Gum chosenItemOne = new Gum("B4", "Chicklets", 1.0, 5);
		Gum chosenItemTwo = new Gum("B5", "Big Red", 2.0, 5);
		double totalSales = 0.0;
		totalSales += chosenItemOne.getPrice();
		totalSales += chosenItemTwo.getPrice();
		String expected = "Total sales: $"+ String.format("%.2f", totalSales);
		
		VendingMachineCLI vendingMachineCli = new VendingMachineCLI(null);
		
		String result = vendingMachineCli.getSalesReportTotalSales(chosenItemOne, chosenItemTwo);
		assertEquals(expected, result);
	}
	
	// Happy Path
	@Test
	public void testDispenseItem_withGoodData_shouldReturnSaying() {
		//arrange
		Gum chosenItem = new Gum("B4", "Chicklets", 1.0, 5);
		double balance = 5.0;
		String expected = "Chew Chew, Yum!";
		
		VendingMachineCLI vendingMachineCli = new VendingMachineCLI(null);
					
		//act
		String result =  vendingMachineCli.dispenseItem(chosenItem, balance);
		
		//assert
		assertEquals(expected, result);
	}
	
		@Test
		public void testDispenseItem_withTooLowOfCount_shouldReturnSoldOut() {
		//arrange
		Gum chosenItem = new Gum("B4", "Chicklets", 1.0, 0);
		double balance = 5.0;
		String expected = "This item is sold out.";
		
		VendingMachineCLI vendingMachineCli = new VendingMachineCLI(null);
					
		//act
		String result =  vendingMachineCli.dispenseItem(chosenItem, balance);
		
		//assert
		assertEquals(expected, result);
		}
		
		@Test
		public void testDispenseItem_withLowBalance_shouldBalanceIsTooLow() {
		//arrange
		Gum chosenItem = new Gum("B4", "Chicklets", 1.0, 0);
		double balance = 0.0;
		String expected = "Your balance is too low to afford " + chosenItem.getName();
		
		VendingMachineCLI vendingMachineCli = new VendingMachineCLI(null);
					
		//act
		String result =  vendingMachineCli.dispenseItem(chosenItem, balance);
		
		//assert
		assertEquals(expected, result);
		}
	
}

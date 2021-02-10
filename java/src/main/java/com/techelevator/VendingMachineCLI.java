package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	// Main menu
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_OPTION_SALES_REPORT = "Display Sales Report";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT,
			MAIN_MENU_OPTION_SALES_REPORT };

	// Purchase menu
	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_SELECT_ITEM = "Select Product";
	private static final String PURCHASE_MENU_CHECK_OUT = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_SELECT_ITEM, PURCHASE_MENU_CHECK_OUT};

 

	private Menu menu;
	private Inventory inventory = new Inventory(); 
	private TreeMap<String, VendingMachineItem> inventoryItems;
	private LogWriter logWriter = new LogWriter();
	private double totalSales = 0;
	private List <String[]> salesReport = new ArrayList<>();
	

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		
	FileReader fileReader = new FileReader();
	File file = new File("vendingmachine.csv");
	
	try {
		List<String[]> inventoryList = fileReader.getItems(file);
		inventoryItems = inventory.getInventory(inventoryList);
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
	
	}
	
	public void run() throws FileNotFoundException {

		double balance = 0;
		double pastBalance = 0;
		MoneyCalculator moneyCalculator = new MoneyCalculator();
		String itemChoice = null;
		VendingMachineItem chosenItem;
	
		// have to find out if first choice
		boolean inTransaction = true;
		boolean inPurchase = true;
 
		// originally while (true)
		while (inTransaction) {
			String mainMenuChoice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (mainMenuChoice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				for(Map.Entry<String, VendingMachineItem> item : inventoryItems.entrySet()) {
					System.out.println(item.getKey() + " | " + item.getValue().getName() + " | $" + String.format("%.2f", item.getValue().getPrice()) + " | " + item.getValue().getCount() + " available");
				}

			} else if (mainMenuChoice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				inPurchase = true;
				while(inPurchase) {
					// where is purchase menu method being called
					String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

					if(purchaseChoice.equals(PURCHASE_MENU_FEED_MONEY)) {
						// See how much user wants to add
						double insertedMoney = menu.feedMoney();
						pastBalance = balance;
						
						// add money to balance
						balance = moneyCalculator.insertMoney(insertedMoney, balance);
						
						//  write to log that user added money
						try {
							logWriter.writeToLog("FEED MONEY:" + " $" + String.format("%.2f", pastBalance) + " $" + String.format("%.2f", balance) + "\r");
						} catch (IOException e) {
							System.out.println("Error trying to log message."); 
						}
						
						System.out.println("------------------------------------------------------");
						System.out.println("Current Money Provided: $" + String.format("%.2f", insertedMoney));
						System.out.println("Your balance is: $" + String.format("%.2f", balance));
						System.out.println("------------------------------------------------------");
						
					} else if(purchaseChoice.equals(PURCHASE_MENU_SELECT_ITEM)) {
						for(Map.Entry<String, VendingMachineItem> item : inventoryItems.entrySet()) {
							System.out.println(item.getKey() + " | " + item.getValue().getName() + " | $" + String.format("%.2f", item.getValue().getPrice()) + " | " + item.getValue().getCount() + " available");
						}
						// ask user what item they would like to buy
						do {
							try{
								itemChoice = menu.getItemChoice();

								chosenItem = inventoryItems.get(itemChoice);

								// add wanted item to shopping cart
								 
								if(chosenItem.getPrice() > balance) {
									System.out.println("Your balance is too low to afford " + chosenItem.getName());
								} else if(chosenItem.getCount() <= 0) {
									System.out.println("This item is sold out.");
								} else {
									chosenItem.decreaseCount();
									totalSales += chosenItem.getPrice();
									String price = String.valueOf(chosenItem.getPrice());
									String[] reportItem = { chosenItem.getName(), price };
									salesReport.add(reportItem);
									pastBalance = balance;
									balance = moneyCalculator.chargeMoney(chosenItem.getPrice(), balance);
									System.out.println(chosenItem.getSaying());
									System.out.println("Your balance is $" + String.format("%.2f", balance));
									String itemName = chosenItem.getName();
									String itemSlot = chosenItem.getSlot();
									
									try {
										logWriter.writeToLog(itemName + " " + itemSlot + " $" + String.format("%.2f", pastBalance) + " $" + String.format("%.2f", balance) + "\r");
									} catch (IOException e) {
										System.out.println("Error trying to log message.");
									}
								}
							}
							catch(Exception e) {
								System.out.println("Please provide valid choice.");
							}
						} while(itemChoice == null);
					}
					
					else if(purchaseChoice.equals(PURCHASE_MENU_CHECK_OUT)) {
						System.out.println(moneyCalculator.makeChange(balance));
						balance = 0;
						try {
							logWriter.writeToLog("GIVE CHANGE: $" + String.format("%.2f", pastBalance) + " $" + String.format("%.2f", balance) + "\r");
						} catch (IOException e) {
							System.out.println("Error trying to log message.");
						}
						inPurchase = false;
					}
				}



			} else if (mainMenuChoice.equals(MAIN_MENU_OPTION_EXIT)) {
				// exit
				inTransaction = false;
				System.out.println("Come back later!");
			} else if (mainMenuChoice.equals(MAIN_MENU_OPTION_SALES_REPORT)) {
				// Display sales report
				System.out.println("------------------------------------------------------");
				System.out.println("Sales Report:");
				for(String[] item : salesReport) {
					System.out.println(item[0] + " | $" + item[1]);
				}
				System.out.println("Total sales: $"+ String.format("%.2f", totalSales));
				System.out.println("------------------------------------------------------");

			}
		}
	}
	
	public String getSalesReportItem(List<String[]> salesReport) {
		for(String[] item : salesReport) {
			return item[0] + " | $" + item[1];
		}
		return null;
	}
	
	public String getSalesReportTotalSales(VendingMachineItem chosenItemOne, VendingMachineItem chosenItemTwo) {
		double totalSales = 0.0;
		totalSales += chosenItemOne.getPrice();
		totalSales += chosenItemTwo.getPrice();
		
		return "Total sales: $"+ String.format("%.2f", totalSales);
	}
	
	public String dispenseItem(VendingMachineItem chosenItem, double balance) {
		if(chosenItem.getPrice() > balance) {
			return "Your balance is too low to afford " + chosenItem.getName();
		} else if(chosenItem.getCount() <= 0) {
			return "This item is sold out.";
		} else {
			return chosenItem.getSaying();
		}
	}
	
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		try {
			cli.run();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	
	
}

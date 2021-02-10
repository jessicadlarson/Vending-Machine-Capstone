package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	// Supplying print writer and scanner to read and writer
	// Input and output stream are abstract classes
	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}
	
	
	// options = 1 - 4; 
	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		
		if (choice == null) {
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}
		return choice;
	}
	
	

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			if(i != 3) {
				int optionNum = i + 1;
				out.println(optionNum + ") " + options[i]);
			}
		}
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}
	
	public String getItemChoice() {
		System.out.println("Please input an item code:");
		return in.nextLine().toUpperCase();
	}

	
	public double feedMoney() {
		System.out.println("How much money are you inputing: $1, $2, $5, or $10?");
		while(in.hasNextLine()) {
			String choice = in.nextLine();
			// handle input garbage
			if(choice.equals("1")) {
				return 1.00;
			} else if (choice.equals("2")) {
				return 2.00;
			} else if(choice.equals("5")) {
				return 5.00;
			} else if(choice.equals("10")) {
				return 10.00;
			} else {
				out.println("Please enter a valid amount of money.");
				out.flush();
			}
		}
		 return 0.0;
	}
}

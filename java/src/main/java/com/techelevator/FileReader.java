package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
	public List<String[]> getItems(File itemsFile) throws FileNotFoundException{
		List<String[]> itemList = new ArrayList<String[]>();
		try(Scanner dataInput = new Scanner(itemsFile)){
			while(dataInput.hasNextLine()) {
				String data = dataInput.nextLine();
				String[] splitData = data.split("\\|");
				itemList.add(splitData);
			}
		} 
		return itemList;
	}
}

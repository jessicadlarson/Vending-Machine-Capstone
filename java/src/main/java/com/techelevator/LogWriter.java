package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogWriter {
	public void writeToLog(String message) throws IOException {
		File file = new File("log.txt");
		LocalDateTime timeStamp = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		
		boolean appendMode = file.exists() ? true : false;
		
		try(PrintWriter writer = new PrintWriter(new FileOutputStream(file, appendMode))){
			writer.append(formatter.format(timeStamp) + " " + message);
		}
	} 
}

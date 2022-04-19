package ua.lviv.iot.hypermarket.utills;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import ua.lviv.iot.hypermarket.item.Item;

public class ItemWriter {

	private String fileName;
	private static final String DEFAULT_FILE_NAME = "data.csv";

	public ItemWriter() {
	}

	public ItemWriter(String fileName) {
		this.fileName = fileName;
	}

	public void writeToFile(List<Item> items) throws IOException {

		try (BufferedWriter writer = new BufferedWriter(
				new FileWriter(fileName == null ? DEFAULT_FILE_NAME : fileName))) {
			
			for (Item item : items) {
				writer.write(item.toCSV());
				writer.newLine();
			}
		}
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getDefaultFileName() {
		return DEFAULT_FILE_NAME;
	}

}

package ua.lviv.iot.hypermarket.utills;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.hypermarket.item.Item;
import ua.lviv.iot.hypermarket.item.Paint;
import ua.lviv.iot.hypermarket.item.Sink;

public class WriterTest {

	@Test
	void writingTest() throws IOException {
		ItemWriter writer = new ItemWriter();
		String fileName = writer.getDefaultFileName();
		List<Item> items = generateListOfItems();
		writer.writeToFile(items);
		File file = new File(fileName);
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String expected = generateCsv(items);
		StringBuffer actual = new StringBuffer();
		int curr;
		while((curr = reader.read()) != -1) {
			actual.append((char)curr);
		}

		reader.close();
		file.delete();
		assertEquals(expected, actual.toString());
		
		
	}
	
	@Test
	void writingWithSpecificFileNameTest() throws IOException {
		ItemWriter writer = new ItemWriter();
		String fileName = "MyName.csv";
		writer.setFileName(fileName);
		List<Item> items = generateListOfItems();
		writer.writeToFile(items);
		File file = new File(fileName);
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String expected = generateCsv(items);
		StringBuffer actual = new StringBuffer();
		int curr;
		while((curr = reader.read()) != -1) {
			actual.append((char)curr);
		}

		reader.close();
		file.delete();
		assertEquals(expected, actual.toString());
	}
	
	
	private String generateCsv(List<Item> items) {
		String separator = System.getProperty("line.separator");
		StringBuilder builder = new StringBuilder();
		items.forEach(item -> builder.append(item.toCSV()).append(separator));
		
		return builder.toString();
	}
	
	private List<Item> generateListOfItems() {
		PhysicalProperties physicalProperties = new PhysicalProperties(0.5, 0.1, 0.1, 0.2);
		List<Item> items = new ArrayList<>();
		items.add(new Paint("Mat paint", Category.PAINT, 50, physicalProperties, "Black", 50));
		items.add(new Paint("Glossy paint", Category.PAINT, 60, physicalProperties, "Yellow", 30));
		items.add(new Sink("Cheap sink", Category.PLUMBING, 150, physicalProperties, "White", "Plastic"));
		
		return items;
	}
}

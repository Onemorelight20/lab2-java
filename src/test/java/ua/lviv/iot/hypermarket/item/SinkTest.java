package ua.lviv.iot.hypermarket.item;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.StringJoiner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.hypermarket.utills.Category;
import ua.lviv.iot.hypermarket.utills.PhysicalProperties;

public class SinkTest {

	private String sinkName = "Sink pink";
	private Category category = Category.PLUMBING;
	private double price = 150;
	private PhysicalProperties physicalProperties = new PhysicalProperties(1, 2, 0.1, 1.5);
	private String color = "White";
    private String material = "Ceramic";
	private Sink sink;
	
	@BeforeEach
	void initSink() {
		sink = new Sink(sinkName, category, price, physicalProperties, color, material);
	}
	
	@Test
	void getHeadersTest() {
		String expected = "name,category,price,physicalProperties,color,material";
		String actual = sink.getHeaders();
		assertEquals(expected, actual);
	}

	@Test
	void toCSVTest() {
		StringJoiner joiner = new StringJoiner(",");
		String expected = joiner.add(sinkName)
				.add(category.name())
				.add(String.valueOf(price))
				.add(physicalProperties.toString())
				.add(color).add(material)
				.toString();
		String actual = sink.toCSV();
		assertEquals(expected, actual);
	}
	
	@Test
	void basicConstructorWithGettersTest() {
		Sink sinkFromBasicConstructor = new Sink(sinkName, category, price, physicalProperties);
		
		assertEquals(sinkFromBasicConstructor.getMaterial(), null);
		assertEquals(sinkFromBasicConstructor.getColor(), null);
	}
	
	@Test
	void specificParamsSettersTest() {
		Sink sinkFromBasicConstructor = new Sink(sinkName, category, price, physicalProperties);
		
		sinkFromBasicConstructor.setMaterial(material);
		sinkFromBasicConstructor.setColor(color);
		assertEquals(sinkFromBasicConstructor.getMaterial(), material);
		assertEquals(sinkFromBasicConstructor.getColor(), color);
	}
	
	@Test
	void equalsTest() {
		Sink sinkFromBasicConstructor = new Sink(sinkName, category, price, physicalProperties);
		
		assertEquals(sink.equals(sinkFromBasicConstructor), false);
		
		sinkFromBasicConstructor.setMaterial(material);
		sinkFromBasicConstructor.setColor(color);
		assertEquals(sink.equals(sinkFromBasicConstructor), true);
	}
	
	
}
package ua.lviv.iot.hypermarket.item;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.StringJoiner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.hypermarket.utills.Category;
import ua.lviv.iot.hypermarket.utills.PhysicalProperties;

public class DoorTest {

	private String doorName = "Door";
	private Category category = Category.FURNITURE;
	private double price = 1000;
	private PhysicalProperties physicalProperties = new PhysicalProperties(10, 2, 1, 1.5);
	private String typeOfMaterial = "Wood";
	private boolean hasGlass = true;
	private Door door;

	@BeforeEach
	void initDoor() {
		door = new Door(doorName, category, price, physicalProperties, typeOfMaterial, hasGlass);
	}

	@Test
	void getHeadersTest() {
		String expected = "name,category,price,physicalProperties,typeOfMaterial,hasGlass";
		String actual = door.getHeaders();
		assertEquals(expected, actual);
	}

	@Test
	void toCSVTest() {
		StringJoiner joiner = new StringJoiner(",");
		String expected = joiner.add(doorName)
				.add(category.name())
				.add(String.valueOf(price))
				.add(physicalProperties.toString())
				.add(typeOfMaterial).add(String.valueOf(hasGlass))
				.toString();
		String actual = door.toCSV();
		assertEquals(expected, actual);
	}

	@Test
	void basicConstructorWithGettersTest() {
		Door doorFromBasicConstructor = new Door(doorName, category, price, physicalProperties);

		assertEquals(doorFromBasicConstructor.getTypeOfMaterial(), null);
		assertEquals(doorFromBasicConstructor.isHasGlass(), false);
	}

	@Test
	void specificParamsSettersTest() {
		Door doorFromBasicConstructor = new Door(doorName, category, price, physicalProperties);

		doorFromBasicConstructor.setTypeOfMaterial(typeOfMaterial);
		doorFromBasicConstructor.setHasGlass(hasGlass);
		assertEquals(doorFromBasicConstructor.getTypeOfMaterial(), typeOfMaterial);
		assertEquals(doorFromBasicConstructor.isHasGlass(), hasGlass);
	}

	@Test
	void equalsTest() {
		Door doorFromBasicConstructor = new Door(doorName, category, price, physicalProperties);

		assertEquals(door.equals(doorFromBasicConstructor), false);

		doorFromBasicConstructor.setHasGlass(hasGlass);
		doorFromBasicConstructor.setTypeOfMaterial(typeOfMaterial);
		assertEquals(door.equals(doorFromBasicConstructor), true);
	}

}

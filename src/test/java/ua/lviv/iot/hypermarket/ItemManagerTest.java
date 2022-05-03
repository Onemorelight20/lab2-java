package ua.lviv.iot.hypermarket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.hypermarket.item.Door;
import ua.lviv.iot.hypermarket.item.Item;
import ua.lviv.iot.hypermarket.item.Paint;
import ua.lviv.iot.hypermarket.item.Sink;
import ua.lviv.iot.hypermarket.utills.Category;
import ua.lviv.iot.hypermarket.utills.PhysicalProperties;

public class ItemManagerTest {

	private Hypermarket hypermarket;

	@BeforeEach
	void fillInHypermarketData() {
		hypermarket = new Hypermarket(generateListOfItems());
	}

	@AfterEach
	void makeHypermarketNull() {
		hypermarket = null;
	}

	@Test
	void constructorNullArgumentTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			new ItemManager(null);
		});
	}

	@Test
	void constructorTest() {
		ItemManager itemManager = new ItemManager(hypermarket);
		assertEquals(itemManager.getHypermarket().getItems(), generateListOfItems());
	}

	@Test
	void hypermarketSetterTest() {
		ItemManager itemManager = new ItemManager(hypermarket);
		Hypermarket emptyHypermarket = new Hypermarket(new ArrayList<>());
		itemManager.setHypermarket(emptyHypermarket);

		assertEquals(itemManager.getHypermarket(), emptyHypermarket);
	}

	@Test
	void findByCategoriesPaintTest() {
		ItemManager itemManager = new ItemManager(hypermarket);
		List<Category> paintCategory = List.of(Category.PAINT);

		List<Item> receivedItems = itemManager.findByCategories(paintCategory);
		List<Item> expectedItems = generateListOfItems().stream().filter(x -> x.getCategory() == Category.PAINT)
				.toList();

		assertEquals(receivedItems, expectedItems);
	}

	@Test
	void findByCategoryFurnitureAndPriceLessEqual200Test() {

		double price = 200d;
		ItemManager itemManager = new ItemManager(hypermarket);
		List<Item> receivedItems = itemManager.findByPriceAndCategory(Category.FURNITURE, price);
		List<Item> expectedItems = itemManager.getHypermarket().getItems().stream()
				.filter(item -> item.getCategory() == Category.FURNITURE).filter(item -> item.getPrice() <= price)
				.toList();

		assertEquals(receivedItems, expectedItems);
	}

	@Test
	void getItemsSortedByWeightAscTest() {
		ItemManager itemManager = new ItemManager(hypermarket);

		List<Item> receivedItems = itemManager.getSortedByWeightAsc();
		List<Item> expectedItems = generateListOfItems().stream()
				.sorted(Comparator.<Item, Double>comparing(item -> item.getPhysicalProperties().getWeightInKilos()))
				.toList();

		assertEquals(receivedItems, expectedItems);
	}

	@Test
	void getItemsSortedByWeightDescTest() {
		ItemManager itemManager = new ItemManager(hypermarket);
		Comparator<Item> comparator = Comparator.comparing(item -> item.getPhysicalProperties().getWeightInKilos());

		List<Item> receivedItems = itemManager.getSortedByWeightDesc();
		List<Item> expectedItems = generateListOfItems().stream().sorted(comparator.reversed()).toList();

		assertEquals(receivedItems, expectedItems);
	}

	@Test
	void getItemsSortedByWidthAscTest() {
		ItemManager itemManager = new ItemManager(hypermarket);
		Comparator<Item> comparator = Comparator.comparing(item -> item.getPhysicalProperties().getWidthInMeters());

		List<Item> receivedItems = itemManager.getSortedByWidthAsc();
		List<Item> expectedItems = generateListOfItems().stream().sorted(comparator).toList();

		assertEquals(receivedItems, expectedItems);
	}

	@Test
	void getItemsSortedByWidthDescTest() {
		ItemManager itemManager = new ItemManager(hypermarket);
		Comparator<Item> comparator = Comparator.comparing(item -> item.getPhysicalProperties().getWidthInMeters());

		List<Item> receivedItems = itemManager.getSortedByWidthDesc();
		List<Item> expectedItems = generateListOfItems().stream().sorted(comparator.reversed()).toList();

		assertEquals(receivedItems, expectedItems);
	}

	@Test
	void getItemsSortedByPriceAscTest() {
		ItemManager itemManager = new ItemManager(hypermarket);
		Comparator<Item> comparator = Comparator.comparing(item -> item.getPrice());

		List<Item> receivedItems = itemManager.getSortedByPriceAsc();
		List<Item> expectedItems = generateListOfItems().stream().sorted(comparator).toList();

		assertEquals(receivedItems, expectedItems);
	}

	@Test
	void getItemsSortedByPriceDescTest() {
		ItemManager itemManager = new ItemManager(hypermarket);
		Comparator<Item> comparator = Comparator.comparing(item -> item.getPrice());

		List<Item> receivedItems = itemManager.getSortedByPriceDesc();
		List<Item> expectedItems = generateListOfItems().stream().sorted(comparator.reversed()).toList();

		assertEquals(receivedItems, expectedItems);
	}

	private List<Item> generateListOfItems() {
		List<Item> items = new ArrayList<>();
		PhysicalProperties physicalProperties = new PhysicalProperties(0.5, 0.1, 0.1, 0.2);
		items.add(new Paint("Glossy paint", Category.PAINT, 60, physicalProperties, "Yellow", 30));
		items.add(new Paint("Mat paint", Category.PAINT, 50, physicalProperties, "Black", 50));

		PhysicalProperties physicalPropertiesDoor = new PhysicalProperties(5, 2.3, 0.1, 1);
		items.add(new Door("Plastic doors", Category.FURNITURE, 100, physicalPropertiesDoor, "Plastic", true));
		items.add(new Door("Wooden doors", Category.FURNITURE, 250, physicalPropertiesDoor, "Wood", true));
		items.add(new Door("Wooden doors", Category.FURNITURE, 200, physicalPropertiesDoor, "Wood", false));

		PhysicalProperties physicalPropertiesPlumbing = new PhysicalProperties(2, 0.3, 0.5, 1);
		items.add(new Sink("Expensive sink", Category.PLUMBING, 300, physicalPropertiesPlumbing, "Gold", "Ceramic"));
		items.add(new Sink("Cheap sink", Category.PLUMBING, 150, physicalPropertiesPlumbing, "White", "Plastic"));

		return items;
	}

}

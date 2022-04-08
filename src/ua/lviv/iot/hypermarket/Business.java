package ua.lviv.iot.hypermarket;

import ua.lviv.iot.hypermarket.item.Paint;
import ua.lviv.iot.hypermarket.item.Door;
import ua.lviv.iot.hypermarket.item.Item;
import ua.lviv.iot.hypermarket.item.Sink;
import ua.lviv.iot.hypermarket.utills.Category;
import ua.lviv.iot.hypermarket.utills.PhysicalProperties;

import java.util.ArrayList;
import java.util.List;

public class Business {
	
	public static void main(String[] args) {
		Business business = new Business();
		business.doBusiness();
	}
	
	public void doBusiness() {
		Hypermarket hypermarket = new Hypermarket(new ArrayList<>());
		ItemManager itemManager = new ItemManager(hypermarket);

		List<Item> doors = generateListOfDoors();
		doors.forEach(hypermarket::addItem);

		List<Item> sinks = generateListOfSinks();
		sinks.forEach(hypermarket::addItem);

		List<Item> paint = generateListOfPaint();
		paint.forEach(hypermarket::addItem);

		System.out.println("All items: ");
		hypermarket.getItems().forEach(System.out::println);
		System.out.println("\n\n");

		System.out.println("Furniture and plumbing items: ");
		itemManager.findByCategories(List.of(Category.FURNITURE, Category.PLUMBING)).forEach(System.out::println);
		System.out.println("\n\n");

		System.out.println("All items sorted by price ASCENDING: ");
		itemManager.getSortedByPriceAsc().forEach(System.out::println);
		System.out.println("\n\n");
		
		System.out.println("All items sorted by weight DESCENDING: ");
		itemManager.getSortedByWeightDesc().forEach(System.out::println);
		System.out.println("\n\n");
	}

	private List<Item> generateListOfPaint() {
		PhysicalProperties physicalProperties = new PhysicalProperties(0.5, 0.1, 0.1, 0.2);
		List<Item> items = new ArrayList<>();
		items.add(new Paint("Mat paint", Category.PAINT, 50, physicalProperties, "Black", 50));
		items.add(new Paint("Glossy paint", Category.PAINT, 60, physicalProperties, "Yellow", 30));
		items.add(new Paint("Interior paint", Category.PAINT, 40, physicalProperties, "Green", 60));
		items.add(new Paint("Interior paint", Category.PAINT, 14000, physicalProperties, "Purple", 0));
		return items;
	}

	private List<Item> generateListOfSinks() {
		PhysicalProperties physicalProperties = new PhysicalProperties(2, 0.3, 0.5, 1);
		List<Item> items = new ArrayList<>();
		items.add(new Sink("Expensive sink", Category.PLUMBING, 300, physicalProperties, "Gold", "Ceramic"));
		items.add(new Sink("Cheap sink", Category.PLUMBING, 150, physicalProperties, "White", "Plastic"));
		items.add(new Sink("Wooden sink", Category.PLUMBING, 400, physicalProperties, "Grey", "Wood"));
		return items;
	}

	private List<Item> generateListOfDoors() {
		PhysicalProperties physicalProperties = new PhysicalProperties(5, 2.3, 0.1, 1);
		List<Item> items = new ArrayList<>();
		items.add(new Door("Plastic doors", Category.FURNITURE, 100, physicalProperties, "Plastic", true));
		items.add(new Door("Wooden doors", Category.FURNITURE, 200, physicalProperties, "Wood", false));
		items.add(new Door("Wooden doors", Category.FURNITURE, 250, physicalProperties, "Wood", true));
		return items;
	}

}

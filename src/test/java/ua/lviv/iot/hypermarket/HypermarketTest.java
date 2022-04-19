package ua.lviv.iot.hypermarket;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.hypermarket.item.Item;
import ua.lviv.iot.hypermarket.utills.Category;

public class HypermarketTest {

	@Test
	void popItemAndAddItemTest() {
		Hypermarket hypermarket = new Hypermarket(new ArrayList<>());
		Item item = new Item("Item", Category.WOODEN_PRODUCT, 0, null) {};
		
		assertEquals(hypermarket.popItem(item), false);
		hypermarket.addItem(item);
		assertEquals(hypermarket.popItem(item), true);
	}
}

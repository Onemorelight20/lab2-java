package ua.lviv.iot.hypermarket;

import ua.lviv.iot.hypermarket.item.Item;
import ua.lviv.iot.hypermarket.utills.Category;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ItemManager {
	private Hypermarket hypermarket;

	private Comparator<Item> weightComparator = (o1, o2) -> {
		if (o1.getPhysicalProperties().getWeightInKilos() > o2.getPhysicalProperties().getWeightInKilos()) {
			return 1;
		} else if (o1.getPhysicalProperties().getWeightInKilos() < o2.getPhysicalProperties().getWeightInKilos()) {
			return -1;
		}
		return 0;
	};
	
	private Comparator<Item> widthComparator = (o1, o2) -> {
		if (o1.getPhysicalProperties().getWidthInMeters() > o2.getPhysicalProperties().getWidthInMeters()) {
			return 1;
		} else if (o1.getPhysicalProperties().getWidthInMeters() < o2.getPhysicalProperties().getWidthInMeters()) {
			return -1;
		}
		return 0;
	};
	
	private Comparator<Item> priceComparator = (o1, o2) -> {
		if (o1.getPrice() > o2.getPrice()){
			return 1;
		} else if (o1.getPrice() < o2.getPrice()) {
			return -1;
		}
		return 0;
	};

	public ItemManager(Hypermarket hypermarket) {
		this.hypermarket = hypermarket;
	}

	public Hypermarket getHypermarket() {
		return hypermarket;
	}

	public void setHypermarket(Hypermarket hypermarket) {
		this.hypermarket = hypermarket;
	}

	public List<Item> findByCategories(List<Category> categories) {
		return hypermarket.getItems().stream()
				.filter(item -> categories.contains(item.getCategory()))
				.collect(Collectors.toList());
	}

	public List<Item> findByPriceAndCategory(Category category, double price) {
		return hypermarket.getItems().stream()
				.filter(item -> item.getCategory().equals(category) && item.getPrice() <= price)
				.collect(Collectors.toList());
	}

	public List<Item> getSortedByWeightAsc() {
		return hypermarket.getItems().stream().sorted(weightComparator).toList();
	}

	public List<Item> getSortedByWeightDesc() {
		return hypermarket.getItems().stream().sorted(weightComparator.reversed()).toList();
	}

	public List<Item> getSortedByWidthAsc() {
		return hypermarket.getItems().stream().sorted(widthComparator).toList();
	}

	public List<Item> getSortedByWidthDesc() {
		return hypermarket.getItems().stream().sorted(widthComparator.reversed()).toList();
	}

	public List<Item> getSortedByPriceAsc() {
		return hypermarket.getItems().stream().sorted(priceComparator).toList();
	}

	public List<Item> getSortedByPriceDesc() {
		return hypermarket.getItems().stream().sorted(priceComparator.reversed()).toList();
	}

}

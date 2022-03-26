package ua.lviv.iot.hypermarket;

import ua.lviv.iot.hypermarket.item.Item;
import ua.lviv.iot.hypermarket.utills.Category;

import java.util.List;
import java.util.stream.Collectors;

public class ItemManager {
    private Hypermarket hypermarket;

    public ItemManager(Hypermarket hypermarket) {
        this.hypermarket = hypermarket;
    }

    public Hypermarket getHypermarket() {
        return hypermarket;
    }

    public void setHypermarket(Hypermarket hypermarket) {
        this.hypermarket = hypermarket;
    }

    public List<Item> findByCategories(List<Category> categories){
        return hypermarket.getItems().stream()
                .filter(item -> categories.contains(item.getCategory()))
                .collect(Collectors.toList());
    }

    public List<Item> findByPriceAndCategory(Category category, double price) {
        return hypermarket.getItems().stream()
                .filter(item -> item.getCategory().equals(category) && item.getPrice() <= price)
                .collect(Collectors.toList());
    }

    public List<Item> getSortedByWeightAsc(){ return null; }

    public List<Item> getSortedByWeightDesc(){ return null; }

    public List<Item> getSortedByWidthAsc(){ return null; }

    public List<Item> getSortedByWidthDesc(){ return null; }

    public List<Item> getSortedByPriceAsc(){ return null; }

    public List<Item> getSortedByPriceDesc(){ return null; }

}

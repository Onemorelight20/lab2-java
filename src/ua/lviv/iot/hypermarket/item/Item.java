package ua.lviv.iot.hypermarket.item;

import ua.lviv.iot.hypermarket.utills.Category;
import ua.lviv.iot.hypermarket.utills.PhysicalProperties;

public abstract class Item {

    private String name;
    private Category category;
    private double price;
    private PhysicalProperties physicalProperties;

    public Item(String name, Category category, double price, PhysicalProperties physicalProperties){
        this.name = name;
        this.category = category;
        this.price = price;
        this.physicalProperties = physicalProperties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PhysicalProperties getPhysicalProperties() {
        return physicalProperties;
    }

    public void setPhysicalProperties(PhysicalProperties physicalProperties) {
        this.physicalProperties = physicalProperties;
    }
}

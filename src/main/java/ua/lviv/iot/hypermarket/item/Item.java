package ua.lviv.iot.hypermarket.item;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(category, name, physicalProperties, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return category == other.category && Objects.equals(name, other.name)
				&& Objects.equals(physicalProperties, other.physicalProperties)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

	@Override
	public String toString() {
		return "item[name=" + name + ", category=" + 
				category + ", price=" + price + ", physicalProperties=" + physicalProperties + "]";
	}
    
    
}

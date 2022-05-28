package ua.lviv.iot.lab8.entity;
import javax.persistence.*;
import java.util.Objects;


@MappedSuperclass
public abstract class Item {

    private String name;
    private String category;
    private double price;

    public Item(String name, String category, double price){
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Item() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public int hashCode() {
        return Objects.hash(category, name, price);
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
                && Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
    }

    @Override
    public String toString() {
        return "item[name=" + name + ", category=" +
                category + ", price=" + price + "]";
    }


}
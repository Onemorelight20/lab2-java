package ua.lviv.iot.hypermarket.item;

import ua.lviv.iot.hypermarket.utills.Category;
import ua.lviv.iot.hypermarket.utills.PhysicalProperties;

public class Sink extends Item{

    private String color;
    private String material;

    public Sink(String name, Category category, double price, PhysicalProperties physicalProperties) {
        super(name, category, price, physicalProperties);
    }

    public Sink(String name, Category category, double price, PhysicalProperties physicalProperties, String color, String material) {
        super(name, category, price, physicalProperties);
        this.color = color;
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sink sink = (Sink) o;

        if (color != null ? !color.equals(sink.color) : sink.color != null) return false;
        return material != null ? material.equals(sink.material) : sink.material == null;
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + (material != null ? material.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Sink{" + super.toString() + ", " +
                "color='" + color + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}

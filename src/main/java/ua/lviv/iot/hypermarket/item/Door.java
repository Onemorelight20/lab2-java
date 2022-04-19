package ua.lviv.iot.hypermarket.item;

import ua.lviv.iot.hypermarket.utills.Category;
import ua.lviv.iot.hypermarket.utills.PhysicalProperties;

public class Door extends Item {

    private String typeOfMaterial;
    private boolean hasGlass;

    public Door(String name, Category category, double price, PhysicalProperties physicalProperties) {
        super(name, category, price, physicalProperties);
    }

    public Door(String name, Category category, double price, PhysicalProperties physicalProperties, String typeOfMaterial, boolean hasGlass) {
        super(name, category, price, physicalProperties);
        this.typeOfMaterial = typeOfMaterial;
        this.hasGlass = hasGlass;
    }

    public String getTypeOfMaterial() {
        return typeOfMaterial;
    }

    public void setTypeOfMaterial(String typeOfMaterial) {
        this.typeOfMaterial = typeOfMaterial;
    }

    public boolean isHasGlass() {
        return hasGlass;
    }

    public void setHasGlass(boolean hasGlass) {
        this.hasGlass = hasGlass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Door door = (Door) o;

        if (hasGlass != door.hasGlass) return false;
        return typeOfMaterial != null ? typeOfMaterial.equals(door.typeOfMaterial) : door.typeOfMaterial == null;
    }

    @Override
    public int hashCode() {
        int result = typeOfMaterial != null ? typeOfMaterial.hashCode() : 0;
        result = 31 * result + (hasGlass ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Door{" + super.toString() + ", " +
                "typeOfWood='" + typeOfMaterial + '\'' +
                ", hasGlass=" + hasGlass +
                '}';
    }
}

package ua.lviv.iot.lab8.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Door extends Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String typeOfMaterial;
    private boolean hasGlass;


    public Door(String name, String category, double price) {
        super(name, category, price);
    }

    public Door(String name, String category, double price, String typeOfMaterial, boolean hasGlass) {
        super(name, category, price);
        this.typeOfMaterial = typeOfMaterial;
        this.hasGlass = hasGlass;
    }

    public Door() {
        super("Unnamed", "Uncategorized", 0.0);
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

    public boolean hasNullValues(){
        return getName() == null
                || getCategory() == null
                || getPrice() == 0.0
                || typeOfMaterial == null;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Door door = (Door) o;

        if (hasGlass != door.hasGlass) return false;
        return Objects.equals(typeOfMaterial, door.typeOfMaterial);
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
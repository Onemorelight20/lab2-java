package ua.lviv.iot.hypermarket;

import ua.lviv.iot.hypermarket.item.Item;

import java.util.List;

public class Hypermarket {
    private List<Item> items;

    public Hypermarket(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public boolean popItem(Item item){
        if(items.contains(item)){
            return items.remove(item);
        } else {
            return false;
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hypermarket that = (Hypermarket) o;

        return items != null ? items.equals(that.items) : that.items == null;
    }

    @Override
    public int hashCode() {
        return items != null ? items.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Hypermarket{" +
                "items=" + items +
                '}';
    }
}

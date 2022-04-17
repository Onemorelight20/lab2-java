package ua.lviv.iot.hypermarket.item;

import ua.lviv.iot.hypermarket.utills.Category;
import ua.lviv.iot.hypermarket.utills.PhysicalProperties;

import java.util.Objects;

public class Paint extends Item{

    private String typeOfPaint;
    private double maxAreaInMeters;

    public Paint(String name, Category category, double price, PhysicalProperties physicalProperties) {
        super(name, category, price, physicalProperties);
    }

    public Paint(String name, Category category, double price, PhysicalProperties physicalProperties, String typeOfPaint, double maxAreaInMeters) {
        super(name, category, price, physicalProperties);
        this.typeOfPaint = typeOfPaint;
        this.maxAreaInMeters = maxAreaInMeters;
    }

    public String getTypeOfPaint() {
        return typeOfPaint;
    }

    public void setTypeOfPaint(String typeOfPaint) {
        this.typeOfPaint = typeOfPaint;
    }

    public double getMaxAreaInMeters() {
        return maxAreaInMeters;
    }

    public void setMaxAreaInMeters(double maxAreaInMeters) {
        this.maxAreaInMeters = maxAreaInMeters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paint that = (Paint) o;

        if (Double.compare(that.maxAreaInMeters, maxAreaInMeters) != 0) return false;
        return Objects.equals(typeOfPaint, that.typeOfPaint);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = typeOfPaint != null ? typeOfPaint.hashCode() : 0;
        temp = Double.doubleToLongBits(maxAreaInMeters);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "BlackPaint{" + super.toString() + ", " +
                "typeOfPaint='" + typeOfPaint + '\'' +
                ", maxArea=" + maxAreaInMeters +
                '}';
    }
}

package ua.lviv.iot.hypermarket.utills;

public class PhysicalProperties {
    private double weightInKilos;
    private double heightInMeters;
    private double widthInMeters;
    private double lengthInMeters;

    public PhysicalProperties(double weightInKilos, double heightInMeters, double widthInMeters, double lengthInMeters) {
        this.weightInKilos = weightInKilos;
        this.heightInMeters = heightInMeters;
        this.widthInMeters = widthInMeters;
        this.lengthInMeters = lengthInMeters;
    }

    public double getPackagingVolume(){
        return heightInMeters * widthInMeters * lengthInMeters;
    }

    public double getWeightInKilos() {
        return weightInKilos;
    }

    public void setWeightInKilos(double weightInKilos) {
        this.weightInKilos = weightInKilos;
    }

    public double getHeightInMeters() {
        return heightInMeters;
    }

    public void setHeightInMeters(double heightInMeters) {
        this.heightInMeters = heightInMeters;
    }

    public double getWidthInMeters() {
        return widthInMeters;
    }

    public void setWidthInMeters(double widthInMeters) {
        this.widthInMeters = widthInMeters;
    }

    public double getLengthInMeters() {
        return lengthInMeters;
    }

    public void setLengthInMeters(double lengthInMeters) {
        this.lengthInMeters = lengthInMeters;
    }
}

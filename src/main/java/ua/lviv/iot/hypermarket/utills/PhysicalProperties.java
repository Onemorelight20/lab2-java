package ua.lviv.iot.hypermarket.utills;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(heightInMeters, lengthInMeters, weightInKilos, widthInMeters);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhysicalProperties other = (PhysicalProperties) obj;
		return Double.doubleToLongBits(heightInMeters) == Double.doubleToLongBits(other.heightInMeters)
				&& Double.doubleToLongBits(lengthInMeters) == Double.doubleToLongBits(other.lengthInMeters)
				&& Double.doubleToLongBits(weightInKilos) == Double.doubleToLongBits(other.weightInKilos)
				&& Double.doubleToLongBits(widthInMeters) == Double.doubleToLongBits(other.widthInMeters);
	}

	@Override
	public String toString() {
		return "[weightInKilos=" + weightInKilos + ", heightInMeters=" + heightInMeters
				+ ", widthInMeters=" + widthInMeters + ", lengthInMeters=" + lengthInMeters + "]";
	}
	
	
    
}

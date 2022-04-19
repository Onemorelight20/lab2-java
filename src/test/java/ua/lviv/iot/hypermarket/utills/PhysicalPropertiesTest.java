package ua.lviv.iot.hypermarket.utills;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PhysicalPropertiesTest {

	private PhysicalProperties physicalProperties;
	private double weightInKilos;
	private double heightInMeters;
	private double widthInMeters;
	private double lengthInMeters;
	
	@BeforeEach
	void initPhysicalProperties() {
		weightInKilos = generageDouble();
		heightInMeters = generageDouble();
		widthInMeters = generageDouble();
		lengthInMeters = generageDouble();
		
		physicalProperties = new PhysicalProperties(weightInKilos, heightInMeters, widthInMeters, lengthInMeters);
	}
	
	@Test
	void testVolume() {
		double expected = heightInMeters * widthInMeters * lengthInMeters;
		assertEquals(physicalProperties.getPackagingVolume(), expected);
	}
	
	@Test
	void testEquals() {
		PhysicalProperties sameProperties = new PhysicalProperties(weightInKilos, heightInMeters, widthInMeters, lengthInMeters);
		assertEquals(physicalProperties, sameProperties);
		assertEquals(physicalProperties, physicalProperties);
		assertEquals(physicalProperties.equals(null), false);
		assertEquals(physicalProperties.equals(new Object()), false);
	}
	
	private double generageDouble() {
		Random random = new Random();
		return random.nextDouble(0.1, 10);
	}
}

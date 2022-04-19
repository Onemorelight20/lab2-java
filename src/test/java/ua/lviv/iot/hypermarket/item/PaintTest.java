package ua.lviv.iot.hypermarket.item;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.hypermarket.utills.Category;
import ua.lviv.iot.hypermarket.utills.PhysicalProperties;

public class PaintTest {

	private String paintName = "Paint";
	private Category category = Category.PAINT;
	private double price = 100;
	private PhysicalProperties physicalProperties = new PhysicalProperties(1, 0.2, 0.1, 1.5);
	private String typeOfPaint = "Water";
	private double maxAreaInMeters = 100;
	private Paint paint;
	
	@BeforeEach
	void initPaint() {
		paint = new Paint(paintName, category, price, physicalProperties, typeOfPaint, maxAreaInMeters);
	}
	
	@Test
	void basicConstructorWithGettersTest() {
		Paint paintFromBasicConstructor = new Paint(paintName, category, price, physicalProperties);
		
		assertEquals(paintFromBasicConstructor.getTypeOfPaint(), null);
		assertEquals(paintFromBasicConstructor.getMaxAreaInMeters(), 0.0);
	}
	
	@Test
	void specificParamsSettersTest() {
		Paint paintFromBasicConstructor = new Paint(paintName, category, price, physicalProperties);
		
		paintFromBasicConstructor.setTypeOfPaint(typeOfPaint);
		paintFromBasicConstructor.setMaxAreaInMeters(maxAreaInMeters);
		assertEquals(paintFromBasicConstructor.getTypeOfPaint(), typeOfPaint);
		assertEquals(paintFromBasicConstructor.getMaxAreaInMeters(), maxAreaInMeters);
	}
	
	@Test
	void equalsTest() {
		Paint paintFromBasicConstructor = new Paint(paintName, category, price, physicalProperties);
		
		assertEquals(paint.equals(paintFromBasicConstructor), false);
		
		paintFromBasicConstructor.setMaxAreaInMeters(maxAreaInMeters);
		paintFromBasicConstructor.setTypeOfPaint(typeOfPaint);
		assertEquals(paint.equals(paintFromBasicConstructor), true);
	}
	
	
}

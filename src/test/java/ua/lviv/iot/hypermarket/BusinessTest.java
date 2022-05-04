package ua.lviv.iot.hypermarket;

import org.junit.jupiter.api.Test;

public class BusinessTest {

	@Test
	void busnessWorkingProperlyTest() {
		Business business = new Business();
		business.doBusiness();
	}
}

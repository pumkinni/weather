package zerobase.weather;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.junit.jupiter.api.Assertions.*;


@EnableTransactionManagement
@SpringBootTest
class WeatherApplicationTests {

	@Test
	void equalTest() {
		assertEquals(1,1);
	}

	@Test
	void nullTest() {
		assertNull(null);
	}

	@Test
	void trueTest() {
	    assertTrue(1==1);
	}

}

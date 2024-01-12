package in.cdac.epramaan.unitTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import in.cdac.epramaan.utility.Calculator;

//@SpringBootTest
class CalculatorTest {
	Calculator cal = new Calculator();
	
	@Test
	void testAdd() {
		int expected = 20;
		int actual = cal.doAdd(10, 10);
		assertThat(actual).isEqualTo(expected);
	}
	
	@Test
	void testMultiply() {
		int expected = 15;
		int actual = cal.doMultiply(3, 5);
		assertThat(actual).isEqualTo(expected);
	}
	
	@Test
	void testCompare() {
		Boolean a = true;
		assertThat(a).isTrue();
	}
	
	@Test
	void testCompare1() {
		Integer a = 10;
		Integer b = 10;
		assertThat(a).isEqualByComparingTo(b);
	}
}

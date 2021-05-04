package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {
	@ParameterizedTest
	@ValueSource(strings = {"hi", "bye", "four", "hello"})
	void testShortNames() {
		assertDoesNotThrow(() -> new CarName("pass"));
	}

	@ParameterizedTest
	@ValueSource(strings = {"abcdef", "abcdefg"})
	void testLongNames(String testName) {
		assertThrows(IllegalArgumentException.class, () -> new CarName(testName));
	}
}

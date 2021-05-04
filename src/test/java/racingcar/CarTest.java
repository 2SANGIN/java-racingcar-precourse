package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
	@ParameterizedTest
	@DisplayName("자동차 멈춰")
	@ValueSource(ints = {0, 1, 2, 3})
	void testNotMove(int fuel) {
		Car car = new Car();
		car.start(fuel);
		assertThat(car.getMileage()).isEqualTo(0);
	}

	@ParameterizedTest
	@DisplayName("자동차 전진")
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	void testMove(int fuel) {
		Car car = new Car();
		car.start(fuel);
		assertThat(car.getMileage()).isEqualTo(1);
	}

	@Test
	void testMoves() {
		int[] fuels = {1, 0, 5, 2, 9, 4, 0};
		Car car = new Car();
		for (int fuel : fuels) {
			car.start(fuel);
		}
		assertThat(car.getMileage()).isEqualTo(3);
	}
}

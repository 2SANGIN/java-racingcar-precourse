package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class CarRacingTest {
	@Test
	void testCarRacing() {
		// given
		String names = "r8,k3,520d";
		int repeat = 3;
		CarRacing carRacing = new CarRacing(names, new CyclicSupplier(new int[] {4, 3, 5, 6, 7, 2}));

		// when
		carRacing.startRacing(repeat);
		List<Car> cars = carRacing.getCars();
		assertThat(cars).hasSize(3).map(Car::getMileage).isEqualTo(Arrays.asList(3, 1, 2));
	}

}

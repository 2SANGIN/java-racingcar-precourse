package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class CarRacingHostTest {
	@Test
	void testCarRacing() {
		Car kia = new Car("kia");
		kia.start(5);
		kia.start(3);
		kia.start(9);
		Car bmw = new Car("bmw");
		bmw.start(1);
		bmw.start(2);
		bmw.start(3);
		Car audi = new Car("audi");
		audi.start(5);
		audi.start(5);
		audi.start(5);

		assertThat(CarRacingHost.getWinners(Arrays.asList(kia, bmw, audi))).isEqualTo(Collections.singletonList(audi));
	}

	@Test
	void testTripleWinner() {
		Car k3 = new Car("k3");
		k3.start(5);
		k3.start(3);
		k3.start(9);
		Car k5 = new Car("k5");
		k5.start(3);
		k5.start(5);
		k5.start(9);
		Car k8 = new Car("k8");
		k8.start(9);
		k8.start(3);
		k8.start(5);

		assertThat(CarRacingHost.getWinners(Arrays.asList(k3, k5, k8))).isEqualTo(Arrays.asList(k3, k5, k8));
	}

	@Test
	void testSoloRacing() {
		Car kia = new Car("kia");
		kia.start(5);
		kia.start(3);
		kia.start(9);

		assertThat(CarRacingHost.getWinners(Collections.singletonList(kia))).isEqualTo(Collections.singletonList(kia));
	}

	@Test
	void testNoCars() {
		assertThatIllegalArgumentException().isThrownBy(() -> CarRacingHost.getWinners(Collections.emptyList()))
			.withMessage("우승자가 없습니다.");
	}
}

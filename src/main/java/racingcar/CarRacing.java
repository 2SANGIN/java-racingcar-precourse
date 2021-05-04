package racingcar;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntSupplier;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

public class CarRacing {
	private final List<Car> cars;
	private final IntSupplier gasStation;  // 테스트를 위해서 선언한 필드

	public CarRacing(List<Car> cars) {
		this.cars = cars;
		this.gasStation = () -> RandomUtils.nextInt(0, 10);
	}

	CarRacing(String names, IntSupplier gasStation) {
		String[] carNames = StringUtils.split(names, ",");
		this.cars = Arrays.stream(carNames)
			.map(Car::new)
			.collect(collectingAndThen(toList(), Collections::unmodifiableList));
		this.gasStation = gasStation;
	}

	public void play(int repeat) {
		for (int i = 0; i < repeat; i++) {
			cars.forEach(car -> car.start(gasStation.getAsInt()));
		}
	}

	public List<Car> getCars() {
		return this.cars;
	}
}

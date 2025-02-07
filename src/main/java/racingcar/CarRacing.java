package racingcar;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntSupplier;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

public class CarRacing {
	private final List<Car> cars;
	private final IntSupplier gasStation;  // 테스트를 위해서 선언한 필드

	public CarRacing(String names) {
		this.cars = mapCars(names);
		this.gasStation = () -> RandomUtils.nextInt(0, 10);
	}

	CarRacing(String names, IntSupplier gasStation) {
		this.cars = mapCars(names);
		this.gasStation = gasStation;
	}

	private List<Car> mapCars(String names) {
		String[] carNames = StringUtils.split(names, ",");
		return Arrays.stream(carNames)
			.map(Car::new)
			.collect(collectingAndThen(toList(), Collections::unmodifiableList));
	}

	public RacingResult startRacing(int repeat) {
		List<Record> records = new ArrayList<>();
		for (int i = 0; i < repeat; i++) {
			records.add(getRecord());
		}
		return new RacingResult(records);
	}

	private Record getRecord() {
		cars.forEach(car -> car.start(gasStation.getAsInt()));
		return new Record(this.cars);
	}

	public List<Car> getCars() {
		return this.cars;
	}
}

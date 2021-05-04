package racingcar;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarRacingHost {
	public static List<Car> getWinners(List<Car> cars) {
		Map<Integer, List<Car>> records = getRecords(cars);
		int maxMileage = findMaxMileage(records);
		return records.get(maxMileage);
	}

	private static Map<Integer, List<Car>> getRecords(List<Car> cars) {
		return cars.stream().collect(Collectors.groupingBy(Car::getMileage));
	}

	private static int findMaxMileage(Map<Integer, List<Car>> records) {
		return records.keySet()
			.stream()
			.max(Comparator.naturalOrder())
			.orElseThrow(() -> new IllegalArgumentException("우승자가 없습니다."));
	}
}

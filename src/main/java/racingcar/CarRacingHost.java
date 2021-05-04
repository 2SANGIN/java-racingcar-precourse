package racingcar;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarRacingHost {
	public static List<Car> getWinners(List<Car> cars) {
		Map<Integer, List<Car>> rankings = cars.stream()
			.collect(Collectors.groupingBy(Car::getMileage));
		int maxMileage = rankings.keySet()
			.stream()
			.max(Comparator.naturalOrder())
			.orElseThrow(() -> new IllegalArgumentException("우승자가 없습니다."));
		return rankings.get(maxMileage);
	}
}

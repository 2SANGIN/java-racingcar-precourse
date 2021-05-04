package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class LapStatus {
	List<String> lapStatuses;

	public LapStatus(List<Car> cars) {
		this.lapStatuses = cars.stream().map(Car::toString).collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return lapStatuses.stream().map(lapStatus -> lapStatus + '\n').collect(Collectors.joining());
	}
}

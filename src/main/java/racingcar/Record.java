package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Record {
	List<String> lapStatuses;

	public Record(List<Car> cars) {
		this.lapStatuses = cars.stream().map(Car::toString).collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return lapStatuses.stream().map(lapStatus -> lapStatus + '\n').collect(Collectors.joining());
	}
}

package racingcar;

import org.apache.commons.lang3.StringUtils;

public class Car {
	private final CarName carName;
	private int mileage = 0;

	public Car(String name) {
		this.carName = new CarName(name);
	}

	public void start(final int fuel) {
		if (fuel >= 4) {
			this.mileage++;
		}
	}

	public int getMileage() {
		return this.mileage;
	}

	@Override
	public String toString() {
		return this.carName + " : " + StringUtils.repeat('-', this.mileage);
	}

	public String getName() {
		return this.carName.toString();
	}
}

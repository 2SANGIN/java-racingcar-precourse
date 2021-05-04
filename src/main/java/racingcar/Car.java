package racingcar;

import org.apache.commons.lang3.StringUtils;

public class Car {
	private String name;
	private int mileage = 0;

	public Car(String name) {
		this.name = name;
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
		return this.name + " : " + StringUtils.repeat('-', this.mileage);
	}
}

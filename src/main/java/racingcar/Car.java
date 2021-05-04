package racingcar;

public class Car {
	private int mileage = 0;

	public void start(final int fuel) {
		if (fuel >= 4) {
			this.mileage++;
		}
	}

	public int getMileage() {
		return this.mileage;
	}
}

package racingcar;

import org.apache.commons.lang3.StringUtils;

public class CarName {
	private static final int CAR_NAME_LIMIT = 5;
	private final String name;

	public CarName(String name) {
		validateNameLength(name);
		this.name = name;
	}

	private void validateNameLength(String name) {
		if (StringUtils.length(name) > CAR_NAME_LIMIT) {
			throw new IllegalArgumentException("자동차 이름은 5자 이하로만 입력 가능합니다.");
		}
	}

	@Override
	public String toString() {
		return this.name;
	}
}

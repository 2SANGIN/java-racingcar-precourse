package racingcar;

import org.apache.commons.lang3.StringUtils;

public class CarName {
	private final String name;

	public CarName(String name) {
		if (StringUtils.length(name) > 5) {
			throw new IllegalArgumentException("자동차 이름은 5자 이하로만 입력 가능합니다.");
		}
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}

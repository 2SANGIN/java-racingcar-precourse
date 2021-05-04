package racingcar;

import java.util.function.IntSupplier;

import org.apache.commons.lang3.ArrayUtils;

class CyclicSupplier implements IntSupplier {
	private final int[] numberSource;
	private int cycle = 0;

	CyclicSupplier(int[] numberSource) {
		assert ArrayUtils.isNotEmpty(numberSource);
		this.numberSource = numberSource;
	}

	@Override
	public int getAsInt() {
		return numberSource[cycle++ % numberSource.length];
	}
}

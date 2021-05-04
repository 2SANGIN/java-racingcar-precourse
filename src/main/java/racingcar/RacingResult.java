package racingcar;

import java.util.List;

public class RacingResult {
	private List<Record> records;

	public RacingResult(List<Record> records) {
		this.records = records;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Record record : records) {
			builder.append(record.toString());
			builder.append('\n');
		}
		return builder.toString();
	}
}

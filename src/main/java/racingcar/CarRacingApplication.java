package racingcar;

import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class CarRacingApplication {
	public static final int MOVING_THRESHOLD = 4;
	public static final int RANDOM_END_RANGE = 10;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
		String names = sc.next();
		System.out.println("시도할 횟수는 몇 회인가요?");
		int repeat = sc.nextInt();

		CarRacing carRacing = new CarRacing(names);
		RacingResult result = carRacing.startRacing(repeat);
		System.out.println("\n실행 결과");
		System.out.print(result);
		System.out.println(getWinnerText(carRacing) + "가 최종 우승했습니다.");
	}

	private static String getWinnerText(CarRacing carRacing) {
		List<Car> winners = CarRacingHost.getWinners(carRacing.getCars());
		StringJoiner winnersName = new StringJoiner(", ");
		for (Car car : winners) {
			winnersName.add(car.getName());
		}
		return winnersName.toString();
	}
}

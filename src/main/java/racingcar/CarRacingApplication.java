package racingcar;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRacingApplication {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
		String names = sc.next();
		System.out.println("시도할 횟수는 몇 회인가요?");
		int repeat = sc.nextInt();

		CarRacing carRacing = new CarRacing(names);
		List<LapStatus> lapStatuses = carRacing.startRacing(repeat);
		System.out.println("\n실행 결과");
		lapStatuses.forEach(System.out::println);

		String winners = CarRacingHost.getWinners(carRacing.getCars())
			.stream()
			.map(Car::getName)
			.collect(Collectors.joining(", "));
		System.out.println(winners + "가 최종 우승했습니다.");
	}
}

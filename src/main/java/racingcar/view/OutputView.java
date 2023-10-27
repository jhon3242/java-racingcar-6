package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printResult(Cars cars) {
        System.out.println(cars);
    }

    public static void printWinner(List<Car> winner) {
        String winnerStr = winner.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.printf("최종 우승자 : %s", winnerStr);
    }
}

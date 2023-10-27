package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.TrialCount;
import racingcar.message.ViewMessage;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainController {

    public void run() {
        Cars cars = initCars();
        TrialCount trialCount = initTrialCount();
        proceedGame(cars, trialCount);
        endGame(cars);
    }

    private Cars initCars() {
        List<Car> carList = Converter.splitByDelimiter(InputView.inputString(ViewMessage.INPUT_CAR_NAME), ",")
                .stream()
                .map(Car::new)
                .toList();
        return new Cars(carList);
    }

    private TrialCount initTrialCount() {
        int count = InputView.inputInteger(ViewMessage.INPUT_TRIAL_COUNT);
        return new TrialCount(count);
    }

    private void proceedGame(Cars cars, TrialCount trialCount) {
        int moveCount  = 0;
        OutputView.printMessage(ViewMessage.GAME_RESULT);
        while (moveCount++ < trialCount.count()) {
            cars.moveRandomly();
            OutputView.printResult(cars);
        }
    }

    private void endGame(Cars cars) {
        List<Car> winner = cars.getWinnerList();
        OutputView.printWinner(winner);
    }
}

package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Position;
import racingcar.message.ErrorMessage;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "pobi", "a2", "abcd", "1234"})
    void CarNameSuccessTest(String name) {
        Car car = new Car(new CarName(name));

        Assertions.assertThat(car.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "         ", "12345", "thisIsMoreThenFour"})
    void CarNameFailTest(String name) {
        Assertions.assertThatThrownBy(() -> {
                    new Car(new CarName(name));
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_CAR_NAME);
    }
}

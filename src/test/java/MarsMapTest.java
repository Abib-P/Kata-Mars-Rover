import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sncf.oui.io.kata_mars_rover.MarsMap;
import sncf.oui.io.kata_mars_rover.Rover;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MarsMapTest {
    private MarsMap marsMap;

    @BeforeEach
    void setup() {
        this.marsMap = new MarsMap();
    }

    @Test
    void should_be_in_the_right_position_given_complex_command() {

        final var response = marsMap.moveRover("LLFFFRBB");

        assertThat(response).isEqualTo("W:2:-3");
    }

    @ParameterizedTest
    @CsvSource({
            "F,N:0:1",
            "RF,E:1:0",
            "LFF,W:-2:0"
    })
    void should_be_moving_forward_given_F_command(final String value, final String expectedResponse) {

        final var response = marsMap.moveRover(value);

        assertThat(response).isEqualTo(expectedResponse);
    }

    @ParameterizedTest
    @CsvSource({
            "B,N:0:-1",
            "RB,E:-1:0",
            "LBB,W:2:0",
            "LLBLB,E:-1:1"
    })
    void should_be_moving_backward_given_B_command(final String value, final String expectedResponse) {

        final var response = marsMap.moveRover(value);

        assertThat(response).isEqualTo(expectedResponse);
    }

}

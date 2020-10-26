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
        this.marsMap = new MarsMap(5,5);
    }

    @Test
    void should_be_in_the_right_position_given_complex_command() {

        final var response = marsMap.moveRover("LLFFFRBB");

        assertThat(response).isEqualTo("W:3:2");
    }

    @ParameterizedTest
    @CsvSource({
            "B,N:0:4",
            "RB,E:4:0"
    })
    void should_be_moving_backward_given_B_command(final String value, final String expectedResponse) {

        final var response = marsMap.moveRover(value);

        assertThat(response).isEqualTo(expectedResponse);
    }

}

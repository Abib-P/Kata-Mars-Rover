import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sncf.oui.io.kata_mars_rover.Rover;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * actualiseFacingDirection = (String) -> char
 * String "" = "N"
 * String "R" = "E"
 * String "RR" = "S"
 * String "RRR" = "W"
 * String "L" = "W"
 * String "LL" = "S"
 * String "LLL" = "E"
 */
class RoverTest {
    private Rover rover;

    @BeforeEach
    void setup() {
        this.rover = new Rover();
    }

    @ParameterizedTest
    @CsvSource({
            " ,N"
    })
    void should_no_value_to_character_N_given_no_value(final String value, final Character expectedResponse) {

        final var response = rover.move(value);

        assertThat(response).isEqualTo(expectedResponse);
    }

    @ParameterizedTest
    @CsvSource({
            "R,E",
            "RR,S",
            "RRR,W",
            "RRRR,N"
    })
    void should_value_to_direction_given_string(final String value, final Character expectedResponse) {

        final var response = rover.move(value);

        assertThat(response).isEqualTo(expectedResponse);
    }


}

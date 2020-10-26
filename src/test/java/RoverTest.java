import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

    @Test
    void should_not_change_orientation_given_null_command() {

        final var response = rover.move(null);

        assertThat(response).isEqualTo('N');
    }

    @Test
    void should_not_change_orientation_given_empty_command() {

        final var response = rover.move("");

        assertThat(response).isEqualTo('N');
    }

    @Test
    void should_not_change_orientation_given_blank_command() {

        final var response = rover.move("   ");

        assertThat(response).isEqualTo('N');
    }

    @ParameterizedTest
    @CsvSource({
            "R,E",
            "RR,S",
            "RRR,W",
            "RRRR,N"
    })
    void should_turn_right_given_R_command(final String value, final Character expectedResponse) {

        final var response = rover.move(value);

        assertThat(response).isEqualTo(expectedResponse);
    }

    @ParameterizedTest
    @CsvSource({
            "L,W",
            "LL,S",
            "LLL,E",
            "LLLL,N"
    })
    void should_turn_left_given_L_command(final String value, final Character expectedResponse) {

        final var response = rover.move(value);

        assertThat(response).isEqualTo(expectedResponse);
    }

    @ParameterizedTest
    @CsvSource({
            "LLLRRLRL,S"
    })
    void should_face_the_right_direction_given_complex_command(final String value, final Character expectedResponse) {

        final var response = rover.move(value);

        assertThat(response).isEqualTo(expectedResponse);
    }

}

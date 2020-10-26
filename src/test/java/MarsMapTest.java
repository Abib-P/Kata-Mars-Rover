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
        boolean map[][];
        map = new boolean[5][5];
        map[0][1] = true;
        map[2][2] = true;
        this.marsMap = new MarsMap(5,5,map);
    }

    @Test
    void should_be_in_the_right_position_given_complex_command() {

        final var response = marsMap.moveRover("LLFFFRBB");

        assertThat(response).isEqualTo("W:2:2");
    }

    @ParameterizedTest
    @CsvSource({
            "F,N:0:0",
            "RFFLFF,N:2:1"
    })
    void should_not_be_moving_forward_given_F_command(final String value, final String expectedResponse) {

        final var response = marsMap.moveRover(value);

        assertThat(response).isEqualTo(expectedResponse);
    }

}

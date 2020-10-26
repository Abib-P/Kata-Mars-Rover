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

        assertThat(response).isEqualTo("E:0:5");
    }

}

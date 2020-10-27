import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sncf.oui.io.kata_mars_rover.marsmap.MarsMap;
import sncf.oui.io.kata_mars_rover.marsobstacle.MarsObstacle;
import sncf.oui.io.kata_mars_rover.marsobstacle.MarsObstacleRock;
import sncf.oui.io.kata_mars_rover.marsobstacle.MarsObstacleXSlide;
import sncf.oui.io.kata_mars_rover.marsobstacle.MarsObstacleYSlide;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MarsMapTest {
    private MarsMap marsMap;

    @BeforeEach
    void setup() {
        MarsObstacle[][] map = new MarsObstacle[5][5];
        map[0][1] = new MarsObstacleRock();
        map[2][2] = new MarsObstacleRock();
        map[4][4] = new MarsObstacleRock();
        map[2][1] = new MarsObstacleYSlide(1);
        map[3][0] = new MarsObstacleYSlide(1);
        map[3][0] = new MarsObstacleXSlide(1);
        this.marsMap = new MarsMap(5,5,map);
    }

    @Test
    void should_be_in_the_right_position_given_complex_command() {

        final var response = marsMap.moveRover("LLFFFRBB");

        assertThat(response).isEqualTo("W:1:2");
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

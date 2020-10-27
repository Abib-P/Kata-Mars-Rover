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
        map[3][0] = new MarsObstacleYSlide(-1);
        map[1][3] = new MarsObstacleXSlide(1);
        map[4][2] = new MarsObstacleXSlide(-1);
        this.marsMap = new MarsMap(5,5,map);
    }

    @Test
    void should_be_in_the_right_position_given_complex_command() {

        final var response = marsMap.moveRover("FFRBBFRFFFRFFRFF");

        assertThat(response).isEqualTo("N:2:3");
    }

    @Test
    void should_slide_when_on_a_MarsObstacleXSlide() {

        final var response = marsMap.moveRover("RFLFFF");

        assertThat(response).isEqualTo("N:2:3");
    }

    @Test
    void should_slide_to_the_right_direction_when_on_a_MarsObstacleXSlide() {

        final var response = marsMap.moveRover("RFLFFFRFFLB");

        assertThat(response).isEqualTo("N:3:2");
    }

    @Test
    void should_stay_in_the_grid_when_on_a_MarsObstacleYSlide() {

        final var response = marsMap.moveRover("RFFF");

        assertThat(response).isEqualTo("E:3:4");
    }

    @Test
    void should_stay_on_MarsObstacleYSlide_when_block_by_MarsObstacleRock() {

        final var response = marsMap.moveRover("RFFLF");

        assertThat(response).isEqualTo("N:2:1");
    }
}

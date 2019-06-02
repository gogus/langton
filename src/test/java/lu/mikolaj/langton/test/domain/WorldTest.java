package lu.mikolaj.langton.test.domain;

import lu.mikolaj.langton.domain.Cell;
import lu.mikolaj.langton.domain.Color;
import lu.mikolaj.langton.domain.World;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorldTest {
    @Test
    public void testAddRemoveBlackCell() {
        World world = new World();
        Cell cell = new Cell(Color.BLACK, 1, 1);
        world.addBlackCell(cell);
        assertThat(world.findBlackCell(1, 1)).isEqualTo(cell);
        world.removeBlackCell(cell);
        assertThat(world.findBlackCell(1, 1)).isNull();
    }
}

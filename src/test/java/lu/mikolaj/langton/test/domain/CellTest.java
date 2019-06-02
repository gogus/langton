package lu.mikolaj.langton.test.domain;

import lu.mikolaj.langton.domain.Cell;
import lu.mikolaj.langton.domain.Color;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CellTest {
    @Test
    public void testTurnColorWhite() {
        Cell cell = new Cell(Color.WHITE, 0, 0);
        cell.turnColor();

        assertThat(cell.getColor()).isEqualTo(Color.BLACK);
    }

    @Test
    public void testTurnColorBlack() {
        Cell cell = new Cell(Color.BLACK, 0, 0);
        cell.turnColor();

        assertThat(cell.getColor()).isEqualTo(Color.WHITE);
    }
}

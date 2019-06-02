package lu.mikolaj.langton.test.domain;

import lu.mikolaj.langton.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AntTest {
    @Mock
    private Cell currentCell;

    @InjectMocks
    private Ant ant;

    @Test
    public void testTurnDirectionWhiteSouth() {
        when(this.currentCell.getColor()).thenReturn(Color.WHITE);
        this.ant.turnDirection();
        assertThat(this.ant.getDirection()).isEqualTo(Direction.SOUTH);
    }

    @Test
    public void testTurnDirectionWhiteWest() {
        when(this.currentCell.getColor()).thenReturn(Color.WHITE);
        this.ant.turnDirection();
        this.ant.turnDirection();
        assertThat(this.ant.getDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    public void testTurnDirectionWhiteNorth() {
        when(this.currentCell.getColor()).thenReturn(Color.WHITE);
        this.ant.turnDirection();
        this.ant.turnDirection();
        this.ant.turnDirection();
        assertThat(this.ant.getDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    public void testTurnDirectionWhiteEast() {
        when(this.currentCell.getColor()).thenReturn(Color.WHITE);
        this.ant.turnDirection();
        this.ant.turnDirection();
        this.ant.turnDirection();
        this.ant.turnDirection();
        assertThat(this.ant.getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    public void testTurnDirectionBlackNorth() {
        when(this.currentCell.getColor()).thenReturn(Color.BLACK);
        this.ant.turnDirection();
        assertThat(this.ant.getDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    public void testTurnDirectionBlackEast() {
        when(this.currentCell.getColor()).thenReturn(Color.BLACK);
        this.ant.turnDirection();
        this.ant.turnDirection();
        assertThat(this.ant.getDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    public void testTurnDirectionBlackSouth() {
        when(this.currentCell.getColor()).thenReturn(Color.BLACK);
        this.ant.turnDirection();
        this.ant.turnDirection();
        this.ant.turnDirection();
        assertThat(this.ant.getDirection()).isEqualTo(Direction.SOUTH);
    }

    @Test
    public void testTurnDirectionBlackWest() {
        when(this.currentCell.getColor()).thenReturn(Color.BLACK);
        this.ant.turnDirection();
        this.ant.turnDirection();
        this.ant.turnDirection();
        this.ant.turnDirection();
        assertThat(this.ant.getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    public void testStartDirection() {
        assertThat(this.ant.getDirection()).isEqualTo(Direction.EAST);
    }
}

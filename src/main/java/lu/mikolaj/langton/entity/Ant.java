package lu.mikolaj.langton.entity;

import java.util.HashMap;

public class Ant {
    private Direction direction;
    private Cell currentCell;

    public Ant(Cell currentCell) {
        this.direction = Direction.EAST;
        this.currentCell = currentCell;
    }

    public void turnDirection() {
        HashMap<Direction, Direction> turnMap = new HashMap<>();

        if (this.currentCell.getColor().equal(Color.WHITE))
        {
            turnMap.put(Direction.EAST, Direction.SOUTH);
            turnMap.put(Direction.SOUTH, Direction.WEST);
            turnMap.put(Direction.WEST, Direction.NORTH);
            turnMap.put(Direction.NORTH, Direction.EAST);

            this.direction = turnMap.get(this.direction);
        }


        if (this.currentCell.getColor().equal(Color.BLACK))
        {
            turnMap.put(Direction.EAST, Direction.NORTH);
            turnMap.put(Direction.SOUTH, Direction.EAST);
            turnMap.put(Direction.WEST, Direction.SOUTH);
            turnMap.put(Direction.NORTH, Direction.WEST);

            this.direction = turnMap.get(this.direction);
        }
    }

    public void moveForward() {
        Integer coordinateX = this.currentCell.getCoordinateX();
        Integer coordinateY = this.currentCell.getCoordinateY();

        if (this.direction.equals(Direction.WEST)) {
            coordinateX = coordinateX - 1;
        }

        if (this.direction.equals(Direction.EAST)) {
            coordinateX = coordinateX + 1;
        }

        if (this.direction.equals(Direction.NORTH)) {
            coordinateY = coordinateY + 1;
        }

        if (this.direction.equals(Direction.SOUTH)) {
            coordinateY = coordinateY - 1;
        }

        this.currentCell.turnColor();
        this.currentCell = new Cell(Color.WHITE, coordinateX, coordinateY);
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }
}

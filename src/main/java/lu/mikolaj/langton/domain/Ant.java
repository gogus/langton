package lu.mikolaj.langton.domain;

import java.util.HashMap;

public class Ant {
    private Direction direction;
    private Cell currentCell;

    Ant(Cell currentCell) {
        this.direction = Direction.EAST;
        this.currentCell = currentCell;
    }

    public void turnDirection() {
        HashMap<Direction, Direction> turnMap = new HashMap<>();

        if (this.currentCell.getColor().equals(Color.WHITE))
        {
            turnMap.put(Direction.EAST, Direction.SOUTH);
            turnMap.put(Direction.SOUTH, Direction.WEST);
            turnMap.put(Direction.WEST, Direction.NORTH);
            turnMap.put(Direction.NORTH, Direction.EAST);

            this.direction = turnMap.get(this.direction);
        }


        if (this.currentCell.getColor().equals(Color.BLACK))
        {
            turnMap.put(Direction.EAST, Direction.NORTH);
            turnMap.put(Direction.SOUTH, Direction.EAST);
            turnMap.put(Direction.WEST, Direction.SOUTH);
            turnMap.put(Direction.NORTH, Direction.WEST);

            this.direction = turnMap.get(this.direction);
        }
    }

    public void moveForward(World world) {
        int coordinateX = this.currentCell.getCoordinateX();
        int coordinateY = this.currentCell.getCoordinateY();

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
        if (this.currentCell.getColor().equals(Color.BLACK)) {
            world.addBlackCell(this.getCurrentCell());
        } else {
            world.removeBlackCell(this.getCurrentCell());
        }

        Cell existingCell = world.findBlackCell(coordinateX, coordinateY);
        if (existingCell != null) {
            this.currentCell = existingCell;
        } else {
            this.currentCell = new Cell(Color.WHITE, coordinateX, coordinateY);
        }
    }

    Cell getCurrentCell() {
        return currentCell;
    }
}

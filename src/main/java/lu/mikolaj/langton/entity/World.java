package lu.mikolaj.langton.entity;

import java.util.ArrayList;

public class World {
    private ArrayList<Cell> visitedCells;
    private Ant ant;

    public World() {
        Cell firstCell = new Cell(Color.WHITE, 0, 0);

        this.visitedCells = new ArrayList<>();
        this.visitedCells.add(firstCell);

        this.ant = new Ant(firstCell);
    }

    public ArrayList<Cell> getVisitedCells() {
        return visitedCells;
    }

    public Cell findCell(int coordinateX, int coordinateY) {
        for (Cell cell : this.visitedCells) {
            if (cell.getCoordinateX() == coordinateX && cell.getCoordinateY() == coordinateY) {
                return cell;
            }
        }

        return null;
    }

    public Ant getAnt() {
        return ant;
    }

    public void addVisitedCell(Cell cell) {
        Cell foundCell = this.findCell(ant.getCurrentCell().getCoordinateX(), ant.getCurrentCell().getCoordinateY());

        if (foundCell != null) {
            this.visitedCells.remove(foundCell);
        }

        this.visitedCells.add(cell);
    }
}

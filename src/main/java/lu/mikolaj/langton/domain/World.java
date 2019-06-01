package lu.mikolaj.langton.domain;

import java.util.ArrayList;

public class World {
    private ArrayList<Cell> blackCells;
    private Ant ant;

    public World() {
        Cell firstCell = new Cell(Color.WHITE, 0, 0);

        this.blackCells = new ArrayList<>();
        this.blackCells.add(firstCell);

        this.ant = new Ant(firstCell);
    }

    public ArrayList<Cell> getBlackCells() {
        return blackCells;
    }

    Cell findBlackCell(int coordinateX, int coordinateY) {
        for (Cell cell : this.blackCells) {
            if (cell.getCoordinateX() == coordinateX && cell.getCoordinateY() == coordinateY) {
                return cell;
            }
        }

        return null;
    }

    public Ant getAnt() {
        return ant;
    }

    void addBlackCell(Cell cell) {
        Cell foundCell = this.findBlackCell(ant.getCurrentCell().getCoordinateX(), ant.getCurrentCell().getCoordinateY());

        if (foundCell != null) {
            this.blackCells.remove(foundCell);
        }

        this.blackCells.add(cell);
    }

    void removeBlackCell(Cell cell) {
        Cell foundCell = this.findBlackCell(cell.getCoordinateX(), cell.getCoordinateY());

        if (foundCell != null) {
            this.blackCells.remove(foundCell);
        }
    }
}

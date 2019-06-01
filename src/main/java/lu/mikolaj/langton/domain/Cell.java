package lu.mikolaj.langton.domain;

public class Cell {
    private int coordinateX;
    private int coordinateY;
    private Color color;

    Cell(Color color, int coordinateX, int coordinateY) {
        this.color = color;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    void turnColor() {
        if (this.color.equals(Color.WHITE)) {
            this.color = Color.BLACK;
        } else {
            this.color = Color.WHITE;
        }
    }

    Color getColor() {
        return color;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }
}

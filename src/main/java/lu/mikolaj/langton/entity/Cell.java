package lu.mikolaj.langton.entity;

public class Cell {
    private int coordinateX;
    private int coordinateY;
    private Color color;

    public Cell(Color color, int coordinateX, int coordinateY) {
        this.color = color;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public void turnColor() {
        if (this.color.equal(Color.WHITE)) {
            this.color = Color.BLACK;
        } else {
            this.color = Color.WHITE;
        }
    }

    public Color getColor() {
        return color;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }
}

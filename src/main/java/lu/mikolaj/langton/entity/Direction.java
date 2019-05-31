package lu.mikolaj.langton.entity;

public enum Direction {
    EAST("East"),
    SOUTH("South"),
    WEST("West"),
    NORTH("North");

    private String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public boolean equals(Direction direction) {
        return direction.toString().equals(this.toString());
    }

    @Override
    public String toString() {
        return this.direction;
    }
}

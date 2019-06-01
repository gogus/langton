package lu.mikolaj.langton.domain;

public enum Direction {
    EAST("East"),
    SOUTH("South"),
    WEST("West"),
    NORTH("North");

    private String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return this.direction;
    }
}

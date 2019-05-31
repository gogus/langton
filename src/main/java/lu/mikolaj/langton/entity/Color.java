package lu.mikolaj.langton.entity;

public enum Color {
    WHITE("White"),
    BLACK("Black");

    private String color;

    Color(String color) {
        this.color = color;
    }

    public boolean equal(Color color) {
        return this.toString().equals(color.toString());
    }

    @Override
    public String toString() {
        return this.color;
    }
}

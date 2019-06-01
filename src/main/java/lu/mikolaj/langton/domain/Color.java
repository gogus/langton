package lu.mikolaj.langton.domain;

public enum Color {
    WHITE("White"),
    BLACK("Black");

    private String color;

    Color(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return this.color;
    }
}

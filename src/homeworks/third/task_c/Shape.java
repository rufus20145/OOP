package homeworks.third.task_c;

public abstract class Shape {

    private int color;

    protected Shape() {

    }

    protected Shape(int color) {
        this.color = color;
    }

    public abstract void draw();

    public boolean equals(Shape other) {
        return other.color == color;
    }

    public int getColor() {
        return color;
    }
}

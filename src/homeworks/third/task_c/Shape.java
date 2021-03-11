package src.homeworks.third.task_c;

public abstract class Shape {

    int color;

    protected Shape() {

    }

    protected Shape(int color) {
        this.color = color;
    }

    public abstract void draw();

    public boolean equals(Shape other) {
        return this.color == other.color;
    }
}

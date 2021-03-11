package src.homeworks.third.task_c;

public class Rectangle extends Shape {

    double aX;
    double aY;
    double bX;
    double bY;

    public Rectangle() {
    }

    public Rectangle(double aX, double aY, double bX, double bY, int color) {
        super(color);
        this.aX = aX;
        this.aY = aY;
        this.bX = bX;
        this.bY = bY;
    }

    public void draw() {
        System.out.println("Rectangle was created.");
    }

    public boolean equals(Rectangle other) {
        return other.aX == aX && other.aY == aY && other.bX == bX && other.bY == bY && other.color == color;
    }
}

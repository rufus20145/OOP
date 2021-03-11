package src.homeworks.third.task_c;

public class Circle extends Shape {

    double centerX;
    double centerY;
    double radius;

    public Circle() {
    }

    public Circle(double centerX, double centerY, double radius, int color) {
        super(color);
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public void draw() {
        System.out.println("Circle was created.");
    }

    public boolean equals(Circle other) {
        return other.centerX == centerX && other.centerY == centerY && other.radius == radius && other.color == color;
    }
}

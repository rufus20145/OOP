package homeworks.third.task_c;

public class Circle extends Shape {

    private double centerX;
    private double centerY;
    private double radius;

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
        return other.centerX == this.centerX && other.centerY == this.centerY && other.radius == this.radius && other.getColor() == this.getColor();
    }
}

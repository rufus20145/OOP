package homeworks.third.task_c;

public class Rectangle extends Shape {

    private double aX;
    private double aY;
    private double bX;
    private double bY;

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
        return other.aX == this.aX && other.aY == this.aY && other.bX == this.bX && other.bY == this.bY && other.getColor() == this.getColor();
    }
}

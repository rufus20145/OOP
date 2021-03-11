package src.homeworks.third.task_c;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(1.1, 1.20, 1.543, 010101);
        Rectangle rectangle = new Rectangle(1, 1, 2, 2, 101010);
        Shape[] shapes = new Shape[] { circle, rectangle };

        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}

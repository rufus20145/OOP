package homeworks.third.task_c;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(1.1, 1.2, 1.543, 010101);
        Circle circle2 = new Circle(1.1, 1.2, 1.543, 010101);
        Rectangle rectangle = new Rectangle(1, 1, 2, 2, 101010);
        Rectangle rectangle2 = new Rectangle(1, 1, 2, 2, 101010);
        Shape[] shapes = new Shape[] { circle, rectangle };

        for (Shape shape : shapes) {
            shape.draw();
        }
        System.out.println(rectangle.equals(rectangle2));
        System.out.println();
        System.out.println(circle.equals(circle2));

    }
}

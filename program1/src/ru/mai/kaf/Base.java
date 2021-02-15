package program1.src.ru.mai.kaf;

public class Base {
    private int width;
    private long height;
    private int numberOfLegs;

    public Base(int width, long height, int numberOfLegs) {
        this.width = width;
        this.height = height;
        this.numberOfLegs = numberOfLegs;
    }

    public void print() {
        System.out.println(
                // "My width: " + width + " My height: " + height + " My number of legs: " + numberOfLegs);
                String.format("My width is %d\nMy height is %d\nMy numberOfLegs is %d\n", width, height, numberOfLegs));
    }
}

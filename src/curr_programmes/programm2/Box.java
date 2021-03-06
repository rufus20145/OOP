package src.curr_programmes.programm2;

public class Box {
    double width;
    double length;
    double height;

    public Box() {

    }

    public Box(double width, double length, double height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return width * length * height;
    }

    public void printAll(String objectName) {
        System.out.println(objectName + "`s sizes are: " + width + " x " + length + " x " + width + " meters.");
    }
}

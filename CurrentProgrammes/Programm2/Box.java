package CurrentProgrammes.Programm2;

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
}

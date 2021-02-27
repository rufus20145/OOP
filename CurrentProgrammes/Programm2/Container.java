package CurrentProgrammes.Programm2;

public class Container extends Box {

    double weight;

    public Container() {
        super(1, 2, 3);
    }

    public Container(double width, double length, double height, double weight) {
        super(width, length, height);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public double getDensity() {
        return weight / (getVolume());
    }
}

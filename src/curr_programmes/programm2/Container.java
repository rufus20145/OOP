package curr_programmes.programm2;

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

    @Override
    public void printAll(String objectName) {
        super.printAll(objectName);
        System.out.println(objectName + "`s weight is " + weight);
    }
}

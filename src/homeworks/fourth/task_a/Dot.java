package homeworks.fourth.task_a;

import java.util.Locale;

public class Dot {

    private double x;
    private double y;
    private double z;

    public Dot() {

    }

    public Dot(boolean makeRandom) {

        this(Math.random() * 1000, Math.random() * 1000, Math.random() * 1000);

        StringBuilder tempStringBuilder = new StringBuilder("Random dot was generated with such coordinates:");
        tempStringBuilder.append(String.format(Locale.PRC, "%.4f", x)).append(", ").append(String.format("%.4f", y))
                .append(", ").append(String.format("%.4f", z)).append(".");
        System.out.println(tempStringBuilder.toString());

    }

    public Dot(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static double calcTheDistance(Dot firstDot, Dot secondDot) {
        return Math.sqrt(Math.pow(firstDot.getX() - secondDot.getX(), 2)
                + Math.pow(firstDot.getY() - secondDot.getY(), 2) + Math.pow(firstDot.getZ() - secondDot.getZ(), 2));
    }

    public void setCoordinate(double coordinate, int numberOfDimension) {

        switch (numberOfDimension) {
        case 1:
            this.x = coordinate;
            break;
        case 2:
            this.y = coordinate;
            break;
        case 3:
            this.z = coordinate;
            break;
        default:
            System.out.println("Неверный номер измерения");
            break;
        }
    }

    public String getAllInfo() {
        StringBuilder output = new StringBuilder(String.format(Locale.PRC, "x = %.2f, y = %.2f, z = %.2f", x, y, z));
        return output.toString();
    }

    public String getCoordinates() {
        StringBuilder temp = new StringBuilder();
        temp.append("(").append(String.format("%.0f", x)).append(", ").append(String.format("%.0f", y)).append(", ")
                .append(String.format("%.0f", z)).append(") ");
                return temp.toString();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

}

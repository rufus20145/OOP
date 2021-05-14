package homeworks.fourth.task_b;

import java.util.Locale;

public class Dot {

    private double x;
    private double y;

    public Dot() {

    }

    public Dot(boolean makeRandom) {

        this(Math.random() * 1000, Math.random() * 1000);

        StringBuilder tempStringBuilder = new StringBuilder("Random dot was generated with such coordinates:");
        tempStringBuilder.append(String.format(Locale.PRC, "%.4f", x)).append(", ").append(String.format("%.4f", y))
                .append(".");
        System.out.println(tempStringBuilder.toString());
        if(makeRandom) {
            System.out.println("It`s truly random.");
        }

    }

    public Dot(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * метод для подсчета расстояния между двумя точками на плоскости
     * @param firstDot координаты первой точки 
     * @param secondDot координаты второй точки
     * @return расстояние между точками
     */
    public static double calcTheDistance(Dot firstDot, Dot secondDot) {
        return Math.sqrt(Math.pow(firstDot.getX() - secondDot.getX(), 2)
                + Math.pow(firstDot.getY() - secondDot.getY(), 2));
    }

    public void setCoordinate(double coordinate, int numberOfDimension) {

        switch (numberOfDimension) {
        case 1:
            this.x = coordinate;
            break;
        case 2:
            this.y = coordinate;
            break;
        default:
            System.out.println("Неверный номер измерения");
            break;
        }
    }

    public String getAllInfo() {
        StringBuilder output = new StringBuilder(String.format(Locale.PRC, "x = %.2f, y = %.2f", x, y));
        return output.toString();
    }

    public String getCoordinates() {
        StringBuilder temp = new StringBuilder();
        temp.append("(").append(String.format("%.0f", x)).append(", ").append(String.format("%.0f", y)).append(") ");
        return temp.toString();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}

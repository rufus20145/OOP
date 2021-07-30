package src.homeworks.fourth.task_a;

public class Dot {
    private static final int EXPONENT = 2;
    /**
     * константа с номером измерения X
     */
    private static final int X_DIMENSION = 1;
    /**
     * константа с номером измерения Y
     */
    private static final int Y_DIMENSION = 2;
    /**
     * константа с номером измерения Z
     */
    private static final int Z_DIMENSION = 3;

    private double x;
    private double y;
    private double z;

    public Dot() {

    }

    public Dot(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static double calcTheDistance(Dot firstDot, Dot secondDot) {
        return Math.sqrt(Math.pow(firstDot.getX() - secondDot.getX(), EXPONENT)
                + Math.pow(firstDot.getY() - secondDot.getY(), EXPONENT)
                + Math.pow(firstDot.getZ() - secondDot.getZ(), EXPONENT));
    }

    public void setCoordinate(double coordinate, int numberOfDimension) {

        switch (numberOfDimension) {
            case X_DIMENSION:
                this.x = coordinate;
                break;
            case Y_DIMENSION:
                this.y = coordinate;
                break;
            case Z_DIMENSION:
                this.z = coordinate;
                break;
            default:
                System.out.println("Неверный номер измерения");
                break;
        }
    }

    public String getAllInfo() {
        StringBuilder output = new StringBuilder(String.format("x = %.2f, y = %.2f, z = %.2f", x, y, z));
        return output.toString();
    }

    public String getCoordinates() {

        return new StringBuilder().append("(").append(String.format("%.0f", x)).append(", ")
                .append(String.format("%.0f", y)).append(", ").append(String.format("%.0f", z)).append(") ").toString();
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

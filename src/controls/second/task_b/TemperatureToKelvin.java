package controls.second.task_b;

public class TemperatureToKelvin implements Converter{

    public static double convertTemperature(double degree) {
        return degree + 273.15;
    }

}

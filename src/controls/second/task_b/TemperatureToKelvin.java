package src.controls.second.task_b;

import src.controls.second.task_b.Converter;

public class TemperatureToKelvin implements Converter{

    public static double convertTemperature(double degree) {
        return degree + 273.15;
    }

}

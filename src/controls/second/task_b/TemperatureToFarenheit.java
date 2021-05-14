package src.controls.second.task_b;

public class TemperatureToFarenheit implements Converter{
    
    public static double convertTemperature(double degree) {
        return degree * 9 / 5 + 32;
    }
}

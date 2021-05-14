package src.controls.second.task_b;

public class TemperatureToNeuton implements Converter{
    
    public static double convertTemperature(double degree) {
        return degree * 33 / 100;
    }
}

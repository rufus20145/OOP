package controls.second.task_b;

import java.util.Scanner;

/**
 * Реализуйте интерфейс Converter из градусов по Цельсию в Кельвины (K)​,
 * ​Фаренгейты​(F) и Ньютона(N). Для каждой шкалы свой класс. Напишите главный
 * класс, в котором main будет принимать 2 входных параметра: В какой градус
 * конвертировать (K, F, N) и сколько градусов по Цельсию
 */

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String digit = input.nextLine();
        double degree = input.nextDouble();

        switch (digit) {
        case "K":
            System.out.println(String.format("%.2f", TemperatureToKelvin.convertTemperature(degree)));
            break;
        case "F":
            System.out.println(String.format("%.2f", TemperatureToFarenheit.convertTemperature(degree)));
            break;
        case "N":
            System.out.println(String.format("%.2f",TemperatureToNeuton.convertTemperature(degree)));
            break;
        default:
            System.out.println("ошибка ввода");
            break;
        }
        input.close();
    }
}

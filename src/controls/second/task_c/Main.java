package src.controls.second.task_c;

public class Main {
    public static void main(String[] args) {
        // 123
    }

    public static <T> T[] filter(T[] array, Filter<String> filter) {
        return filter.apply("123"); //todo пересмотреть запись контрольной с разбором задачи
    }
}

package controls.second.task_c;

public class Main {
    public static void main(String[] args) {
        String[] tmp = {"1", "2"};
        Filter<String> temp = new FilterForString<>();
        filter(tmp, temp);
        // 123
    }

    public static <T> T[] filter(T[] array, Filter<String> filter) {
        for (T t : array) {
            System.out.println(t);
        }
        return filter.apply("test") ? null : array; //todo пересмотреть запись контрольной с разбором задачи
    }
}

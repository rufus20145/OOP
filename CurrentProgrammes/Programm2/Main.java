package CurrentProgrammes.Programm2;

public class Main {
    public static void main(String[] args) {
        Box emptyBox = new Box();

        System.out.println(emptyBox.getWidth());

        Box box = new Box(2, 4, 6);

        System.out.println(box.getVolume());
    }
}

package curr_programmes.programm2;

public class Main {
    public static void main(String[] args) {
        Box emptyBox = new Box();

        // System.out.println(emptyBox.getWidth());
        System.out.println("Volume of emptyBox: " + emptyBox.getVolume());
        System.out.println("Empty box is:" + emptyBox);
        Box box = new Box(2, 4, 6);

        // System.out.println(box.getVolume());
        System.out.println("Box width is:" + box.getWidth());
        System.out.println("Box height is:" + box.getHeight());
        System.out.println("Box width is:" + box.getWidth());
        System.out.println("Box volume is:" + box.getVolume());

        Container emptyContainer = new Container();

        System.out.println("Empty Container:" + emptyContainer.getHeight() + " " + emptyContainer.getWeight());

        Container bigContainer = new Container(1,2,3,6);

        System.out.println("Big container" + " " + bigContainer.getDensity());

        Box castBox = new Container(10, 10, 10, 20);
        System.out.println("castBox`s weight is " + ((Container) castBox).getWeight());

        bigContainer.printAll("bigContainer");
    }
}

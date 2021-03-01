package src.curr_programmes.programm3;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Пушок");
        Dog dog = new Dog("Мухтар");
        Cow cow = new Cow();

        // System.out.println("First part");
        // Animals[] animals = new Animals[] { cat, dog };
        // for (Animals animal : animals) {
        // animal.voice();
        // animal.run();
        // animal.walk();
        // }

        // System.out.println("2nd part");
        // Sound[] sounds = new Sound[] { cat, dog, cow };
        // for (Sound sound : sounds) {
        // sound.voice();
        // if (sound instanceof Animals) {
        // ((Animals) sound).run();
        // } else if (sound instanceof Cow) {
        // ((Cow) sound).run();
        // }
        // }

        System.out.println("3rd part.");
        Feeder feeder = new Feeder();
        feeder.feed(cat);
        feeder.feed(dog);
        feeder.feed(cow);

        System.out.println("4th part.");
        int a = 0;
        System.out.println(a++);
        System.out.println(a);
        System.out.println(++a);// test
        // test
    }
}

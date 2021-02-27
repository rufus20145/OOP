package currentProgrammes.programm3;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Animals[] animals = new Animals[] { cat, dog };
        for (Animals animal : animals) {
            animal.voice();
            animal.run();
            animal.walk();
        }
        System.out.println("2nd part");

        Cow cow = new Cow();
        Sound[] sounds = new Sound[] { cat, dog, cow };
        for (Sound sound : sounds) {
            sound.voice();

        }
    }
}

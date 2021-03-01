package currentProgrammes.programm3;

public class Feeder {

    // public void feed(Cat cat) {
    //     System.out.println(cat.getName() + " was fed.");
    // }

    // public void feed(Dog dog) {
    //     System.out.println(dog.getName() + " was fed.");
    // }

    public void feed(Cow cow) {
        System.out.println("Cow was fed.");
    }

    public void feed(Animals animal) {
        System.out.println(animal.getName() + " was fed.");
    }

}

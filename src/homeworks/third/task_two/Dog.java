package src.homeworks.third.task_two;

public class Dog extends Animal {

    String name;
    String breed;

    public Dog() {
        super("nullFood", "nullLocation");
        name = "nullDog";
    }

    public Dog(String name, String food, String location) {
        super(food, location);
        this.name = name;
    }

    @Override
    public void makeNoise() {
        System.out.println("You have awakened cat " + name);
    }

    @Override
    public void eat() {
        System.out.println("Dog " + name + " eats.");
    }

    public String getName() {
        return name;
    }

}

package src.homeworks.third.task_two;

public class Cat extends Animal {

    String name;
    String breed;

    public Cat() {
        super("nullFood", "nullLocation");
        name = "nullCat";
    }

    public Cat(String name, String food, String location) {
        super(food, location);
        this.name = name;
    }

    @Override
    public void makeNoise() {
        System.out.println("You have awakened cat " + name);
    }

    @Override
    public void eat() {
        System.out.println("Cat " + name + " eats.");
    }

    public String getName() {
        return name;
    }
}

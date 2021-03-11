package src.homeworks.third.task_b;

public class Horse extends Animal {

    String name;
    String breed;

    public Horse() {
        super("nullFood", "nullLocation");
        name = "nullHorse";
    }

    public Horse(String name, String food, String location) {
        super(food, location);
        this.name = name;
    }

    @Override
    public void makeNoise() {
        System.out.println("You have awakened cat " + name);
    }

    @Override
    public void eat() {
        System.out.println("Horse " + name + " eats.");
    }

    public String getName() {
        return name;
    }
}

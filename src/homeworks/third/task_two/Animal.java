package src.homeworks.third.task_two;

public class Animal {

    String food;
    String location;

    public Animal() {

    }

    public Animal(String food, String location) {
        this.food = food;
        this.location = location;
    }

    public void makeNoise() {
        System.out.println("You have awakened some animal.");
    }

    public void eat() {
        System.out.println("Some animal eats.");
    }

    public void sleep() {
        System.out.println("Some animal sleeps.");
    }

    public String getFood() {
        return food;
    }

    public String getLocation() {
        return location;
    }

}

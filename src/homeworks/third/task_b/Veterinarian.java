package src.homeworks.third.task_b;

public class Veterinarian {

    public static void treatAnimal(Animal animal) {

        StringBuilder sb = new StringBuilder();

        sb.append("Animal eats ");
        sb.append(animal.getFood());
        sb.append(" ");
        sb.append(animal.getLocation());

        System.out.println(sb.toString());
    }
}

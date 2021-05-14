package src.homeworks.third.task_b;

/**
 * Создать класс Animal и расширяющие его классы Dog, Cat, Horse. Класс Animal
 * содержит переменные food, location и методы makeNoise, eat, sleep. Метод
 * makeNoise, например, может выводить на консоль "Такое-то животное спит". Dog,
 * Cat, Horse переопределяют методы makeNoise, eat. Добавьте переменные в классы
 * Dog, Cat, Horse, характеризующие только этих животных. Создайте класс
 * Ветеринар, в котором определите метод void treatAnimal(Animal animal). Пусть
 * этот метод распечатывает food и location пришедшего на прием животного. В
 * методе main создайте массив типа Animal, в который запишите животных всех
 * имеющихся у вас типов. В цикле отправляйте их на прием к ветеринару.
 */

public class Main {
    public static void main(String[] args) {

        Cat cat = new Cat("Мурка", "рыбу", "дома");
        Dog dog = new Dog("Щарик", "мясо", "в будке");
        Horse horse = new Horse("Уголек", "травку", "на лугу");

        Animal[] animals = new Animal[] { cat, dog, horse };

        for (Animal animal : animals) {
            Veterinarian.treatAnimal(animal);
        }

    }
}

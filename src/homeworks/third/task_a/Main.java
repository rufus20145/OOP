package homeworks.third.task_a;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;

/**
 * Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер
 * группы, успеваемость (массив из пяти элементов). Создайте массив из N
 * элементов такого типа (порядок чтения данных из консоли фамилия и инициалы,
 * номер группы, успеваемость (массив из пяти элементов). Добавьте возможность
 * вывода фамилии и номеров групп студентов, имеющих оценки, равные только 9 или
 * 10.
 */

public class Main {
    public static void main(String[] args) {

        final int NUMBER_OF_MARKS = 5;

        int numberOfStudents = 1;
        Student[] students;
        boolean exceptionCaught = false;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of students: ");
        do {
            try {
                numberOfStudents = input.nextInt();
                exceptionCaught = false;
            } catch (InputMismatchException e) {
                System.out.println("You must enter a valid integer value. Try again.");
                exceptionCaught = true;
                input.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("You didn't enter any text. Try again.");
                exceptionCaught = true;
                input.nextLine();
            } catch (IllegalStateException e) {
                System.out.println("Scanner was closed before input. Try again.");
                input.nextLine();
                exceptionCaught = true;
            }
        } while (exceptionCaught);
        input.nextLine();
        students = new Student[numberOfStudents];

        System.out.println("Now enter students credentials.");
        for (int currStudent = 0; currStudent < numberOfStudents; ++currStudent) {

            String fio = null;
            String groupNumber = null;
            float[] marks = new float[NUMBER_OF_MARKS];

            input = new Scanner(System.in);

            System.out.println("Enter " + (currStudent + 1) + " student fio: ");
            do {
                try {
                    fio = input.nextLine();
                    exceptionCaught = false;
                } catch (NoSuchElementException e) {
                    System.out.println("You didn't enter any text. Try again.");
                    input.nextLine();
                    exceptionCaught = true;
                } catch (IllegalStateException e) {
                    System.out.println("Something went wrong. Try again.");
                    exceptionCaught = true;
                }
            } while (exceptionCaught);
            System.out.println("Enter student number of group: ");
            do {
                try {
                    groupNumber = input.nextLine();
                    exceptionCaught = false;
                } catch (NoSuchElementException e) {
                    System.out.println("You didn't enter any text. Try again.");
                    input.nextLine();
                    exceptionCaught = true;
                } catch (IllegalStateException e) {
                    System.out.println("Something went wrong. Try again.");
                    exceptionCaught = true;
                }
            } while (exceptionCaught);
            System.out.println("Enter student marks: ");

            for (int currMark = 0; currMark < NUMBER_OF_MARKS; ++currMark) {
                do {
                    try {
                        marks[currMark] = input.nextFloat();
                        exceptionCaught = false;
                        if (marks[currMark] < 0) {
                            System.out.println("Entered value is too low. Try again.");
                        }
                        if (marks[currMark] > 10) {
                            System.out.println("Entered value is too big. Try again.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("You must enter a valid float value. Try again.");
                        exceptionCaught = true;
                        input.nextLine();
                    } catch (NoSuchElementException e) {
                        System.out.println("You didn't enter any text. Try again.");
                        exceptionCaught = true;
                        input.nextLine();
                    } catch (IllegalStateException e) {
                        System.out.println("Scanner was closed before input. Try again.");
                        input.nextLine();
                        exceptionCaught = true;
                    }

                } while (exceptionCaught);
            }

            students[currStudent] = new Student(fio, groupNumber, marks);

        }
        input.close();

        for (Student student : students) {
            boolean hasOnlyGoodMarks = true;

            for (float mark : student.marks) {
                if (mark >= 9) {
                    hasOnlyGoodMarks = false;
                    break;
                }
            }

            if (hasOnlyGoodMarks) {
                System.out.println(student.getStudentInfo());
            }

        }

    }
}

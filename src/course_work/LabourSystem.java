package src.course_work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LabourSystem {
    private static final int NUM_OF_ARGS_FOR_FILE = 2;
    private static final String YES_STRING = "yes";
    private static final String NO_STRING = "no";
    private static final String MENU_STRING = "Доступные команды:\ncreate-vacancy - создать вакансию\ncreate-resume - создать резюме\nget - получение пар работник-работодатель";
    private static final int MAX_NUMBER_OF_ITERATIONS = 4096;
    private static final String END_STRING = "end";
    private static final String VACANCY_CREATION = "CREATE-VACANCY";
    private static final String RESUME_CREATION = "CREATE-RESUME";
    private static final String GETTING_PAIRS = "GET";
    private static List<User> users = new ArrayList<>();
    private static List<Vacancy> workerRequests = new ArrayList<>();
    private static List<Vacancy> employerRequests = new ArrayList<>();

    public static void main(String[] args) {

        Deque<String> commandsFromFile = new LinkedList<>();
        Deque<String> enteredCommands = new LinkedList<>();
        Deque<String> internalCommands = new LinkedList<>();
        User currentUser;
        String command;
        int iteration = 0;
        Scanner in = new Scanner(System.in);

        if (args.length == NUM_OF_ARGS_FOR_FILE
                && (args[0].equalsIgnoreCase("-f") || args[0].equalsIgnoreCase("--file"))) {
            System.out.println("Вы хотите считать последовательность команд из файла?");
            if (getStringValue(in).equalsIgnoreCase(YES_STRING)) {
                try (BufferedReader bufReader = new BufferedReader(new FileReader(args[1]))) {
                    String s;
                    while ((s = bufReader.readLine()) != null) {
                        commandsFromFile.add(s);
                    }
                } catch (IOException e) {
                    System.out.println("Файл не найден. Проверьте правильность имени и повторите попытку.");
                }
            } else {
                System.out.println("Считывание команд из файла отменено.");
            }
        }

        do {
            ++iteration;
            if (!commandsFromFile.isEmpty()) {
                command = commandsFromFile.pollFirst();
                System.out.println(command); // todo remove before send
            } else {
                System.out.println(MENU_STRING);
                command = getStringValue(in);
            }
            if (command.equalsIgnoreCase(END_STRING)) {
                break;
            }
            switch (command.toUpperCase()) {
                case VACANCY_CREATION:
                    System.out.println("У вашей компании уже есть аккаунт?");
                    String currCommand = getStringValue(in);
                    if (currCommand.equalsIgnoreCase(END_STRING)) {
                        break;
                    }
                    internalCommands.add(currCommand);
                    if (currCommand.equalsIgnoreCase(YES_STRING)) {
                        currentUser = login();
                    } else {
                        currentUser = createCompany();
                    }

                    int type;
                    String title;
                    int payment;
                    int hoursInWeek;
                    System.out.println("Введите числовой код требуемой специальности:");
                    if (!in.hasNextInt()) {
                        currCommand = getStringValue(in);
                        if (currCommand.equalsIgnoreCase(END_STRING)) {
                            break;
                        }
                    } else {
                        type = getIntValue(in);
                    }s
                    enteredCommands.addAll(internalCommands);
                    break;
                case RESUME_CREATION:
                    System.out.println("Добавление резюме");
                    // todo
                    enteredCommands.addAll(internalCommands);
                    break;
                case GETTING_PAIRS:
                    System.out.println("Режим сопоставления");
                    // todo
                    enteredCommands.addAll(internalCommands);
                    break;
                default:
                    System.out.println("Введенная команда отсутствует в списке возможных действий. Повторите попытку.");
                    break;
            }
            internalCommands.clear();
        } while (iteration < MAX_NUMBER_OF_ITERATIONS);

        System.out.println("Сохранить все введенные команды в файл?");
        if (in.nextLine().equalsIgnoreCase(YES_STRING)) {
            DateTimeFormatter timeStampPattern = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
            File myFile = new File("result_" + timeStampPattern.format(java.time.LocalDateTime.now()) + ".txt");

        }

        in.close();
    }

    private static Company createCompany() {
        return null;
    }

    private static User login() {
        return null;
    }

    private static User findUser(String login, String password) {
        for (User user : users) {
            if (user.enter(login, password)) {
                return user;
            }
        }
        return null;
    }

    private static void clearWorkerRequests(Applicant worker) {
        // todo
    }

    private static void processRequests() {
        // todo
    }

    private static String getStringValue(Scanner in) {
        boolean exceptionCaught = false;
        String inputString = null;

        do {
            exceptionCaught = false;
            try {
                inputString = in.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("Вы не ввели ничего. Повторите попытку.");
                exceptionCaught = true;
                in.next();
            } catch (IllegalStateException e) {
                System.out.println("Система ввода оказалась в некорректном состоянии. Повторите попытку.");
                exceptionCaught = true;
                in = new Scanner(System.in);
                in.nextLine();
            }
        } while (exceptionCaught);
        return inputString;
    }

    private static int getIntValue(Scanner in) {
        int value = 0;
        boolean exceptionCaught = false;

        do {
            exceptionCaught = false;
            try {
                value = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Введенное значение не является целым числом. Повторите попытку.");
                exceptionCaught = true;
                in.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("Вы не ввели ничего. Повторите попытку.");
                exceptionCaught = true;
                in.next();
            } catch (IllegalStateException e) {
                System.out.println("Система ввода оказалась в некорректном состоянии. Повторите попытку.");
                exceptionCaught = true;
                in = new Scanner(System.in);
                in.nextLine();
            }
        } while (exceptionCaught);
        return value;
    }
}

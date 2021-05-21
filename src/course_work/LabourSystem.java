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
import java.util.regex.Pattern;

public class LabourSystem {
    private static final String YES_STRING = "yes";
    private static final String NO_STRING = "no";
    private static final String MENU_STRING = "Доступные команды:\ncreate-vacancy - создать вакансию\ncreate-resume - создать резюме\nget - получение пар работник-работодатель";
    private static final int MAX_NUMBER_OF_ITERATIONS = 4096;
    private static final String END_STRING = "end";
    private static final String VACANCY_CREATION = "CREATE-VACANCY";
    private static final String RESUME_CREATION = "CREATE-RESUME";
    private static final String GETTING_PAIRS = "GET";
    private static List<User> users = new ArrayList<>();
    private static List<Request> workerRequests = new ArrayList<>();
    private static List<Request> employerRequests = new ArrayList<>();
    private static Deque<String> commandsFromFile = new LinkedList<>();
    private static Deque<String> enteredCommands = new LinkedList<>();

    public static void main(String[] args) {

        User currentUser;
        String command;
        int iteration = 0;
        Scanner in = new Scanner(System.in);

        System.out.println("Вы хотите считать последовательность команд из файла?");
        if (getStringValue(in).equalsIgnoreCase(YES_STRING)) {
            if (args.length == 2 && (args[0].equalsIgnoreCase("-f") || args[0].equalsIgnoreCase("--file"))) {
                try (BufferedReader bufReader = new BufferedReader(new FileReader(args[1]))) {
                    String s;
                    while ((s = bufReader.readLine()) != null) {
                        commandsFromFile.add(s);
                    }
                } catch (IOException e) {
                    System.out.println("Файл не найден. Проверьте правильность имени и повторите попытку.");
                }
            }
        } else {
            System.out.println("Считывание команд из файла отменено.");
        }

        do {
            ++iteration;
            if (!commandsFromFile.isEmpty()) {
                command = commandsFromFile.pollFirst();
                System.out.println(command);
            } else {
                System.out.println(MENU_STRING);
                command = getStringValue(in);
            }
            if (command.equalsIgnoreCase(END_STRING)) {
                break;
            }
            switch (command.toUpperCase()) {
                case VACANCY_CREATION:
                    System.out.println("Введите название вакансии");
                    String companyName = getStringValue(in);
                    if (companyName.equalsIgnoreCase(END_STRING)) {
                        break;
                    }
                    System.out.println("Введите логин для аккаунта вашей компании");
                    String login = getStringValue(in);
                    if (login.equalsIgnoreCase(END_STRING)) {
                        break;
                    }
                    System.out.println("Введите пароль от аккаунта вашей компании");
                    String password = getStringValue(in);
                    if (password.equalsIgnoreCase(END_STRING)) {
                        break;
                    }
                    System.out.println("Введите числовой код специальности, по которой вы ищете сотрудника");
                    if (in.hasNext(Pattern.compile(END_STRING))) {
                        getStringValue(in);
                        break;
                    }
                    int type = getIntValue(in);
                    getStringValue(in);
                    System.out.println("Вакансия успешно создана");
                    break;
                case RESUME_CREATION:
                    System.out.println("Добавление вакансии");
                    // todo
                    break;
                case GETTING_PAIRS:
                    System.out.println("Режим сопоставления");
                    // todo
                    break;
                default:
                    System.out.println("Введенная команда отсутствует в списке возможных действий. Повторите попытку.");
                    break;
            }
        } while (iteration < MAX_NUMBER_OF_ITERATIONS);

        System.out.println("Сохранить все введенные команды в файл?");
        if (in.nextLine().equals(YES_STRING)) {
            DateTimeFormatter timeStampPattern = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
            File myFile = new File("result_" + timeStampPattern.format(java.time.LocalDateTime.now()) + ".txt");

        }

        in.close();
    }

    private static void addUser(String name, String login, String password, String repeation, int type) {// создание
                                                                                                         // клиента

    }

    private static User findUser(String login, String password) {
        for (User user : users) {
            if (user.enter(login, password)) {
                return user;
            }
        }
        return null;
    }

    private static void save() {
        // todo
    }

    private static void load() {
        // todo
    }

    private static void clearWorkerRequests(Client worker) {
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
                in.nextLine();
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

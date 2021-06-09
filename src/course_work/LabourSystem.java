package src.course_work;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;

public class LabourSystem {
    private static final int TIME_TO_SLEEP = 50;
    private static final int NUM_OF_ARGS_FOR_FILE = 2;
    private static final String YES_STRING = "YES";
    private static final String NO_STRING = "NO";
    private static final String MENU_STRING = "Доступные команды:\ncreate-vacancy - создать вакансию\ncreate-resume - создать резюме\nget - получение пар работник-работодатель";
    private static final int MAX_NUMBER_OF_ITERATIONS = 4096;
    private static final String END_STRING = "END";
    private static final String VACANCY_CREATION = "CREATE-VACANCY";
    private static final String RESUME_CREATION = "CREATE-RESUME";
    private static final String GETTING_PAIRS = "GET";
    private static final String INTEGER_REGEX = "^[\\d]+$";

    private static Map<String, Company> companies = new HashMap<>();
    private static Map<String, Applicant> applicants = new HashMap<>();
    private static Queue<String> commandsFromFile = new LinkedList<>();
    private static Queue<String> internalCommands = new LinkedList<>();
    private static Map<Vacancy, Resume> resultPairs = new HashMap<>();

    private static Scanner in = new Scanner(System.in);
    private static boolean exitFromBranch;
    private static List<Vacancy> allVacancies = new ArrayList<>();
    private static List<Resume> allResumes = new ArrayList<>();

    public static void main(String[] args) {
        Queue<String> enteredCommands = new LinkedList<>();
        String command;
        int iteration = 0;
        readCommandsFromFile(args);

        do {
            ++iteration;
            exitFromBranch = false;
            System.out.println(MENU_STRING);
            command = getStringValue();

            if (command.equalsIgnoreCase(END_STRING)) {
                break;
            }
            switch (command.toUpperCase()) {
                case VACANCY_CREATION: // * режим создания вакансии
                    Company currCompany;
                    System.out.println("У вашей компании уже есть аккаунт?");
                    command = getStringValue();
                    if (command.equalsIgnoreCase(END_STRING)) {
                        break;
                    }

                    if (command.equalsIgnoreCase(YES_STRING)) { // входим в существующий аккаунт
                        currCompany = loginCompany();
                    } else if (command.equalsIgnoreCase(NO_STRING)) { // начинаем регистрацию новой компании
                        currCompany = registerCompany();
                    } else {
                        System.out.println("Неизвестная команда. Выход в меню.");
                        break;
                    }

                    if (!exitFromBranch) {
                        assert currCompany != null;
                        createVacancy(currCompany);
                    }

                    if (!exitFromBranch) {
                        enteredCommands.addAll(internalCommands);
                    }
                    break;
                case RESUME_CREATION: // * режим создания резюме
                    Applicant currApplicant;
                    System.out.println("Добавление резюме");
                    System.out.println("У вас уже есть аккаунт соискателя?");
                    command = getStringValue();
                    if (command.equalsIgnoreCase(END_STRING)) {
                        break;
                    }

                    if (command.equalsIgnoreCase(YES_STRING)) { // входим в существующий аккаунт
                        currApplicant = loginApplicant();
                    } else if (command.equalsIgnoreCase(NO_STRING)) { // начинаем регистрацию нового соискателя
                        currApplicant = registerApplicant();
                    } else {
                        System.out.println("Неизвестная команда. Выход в меню.");
                        break;
                    }

                    if (!exitFromBranch) {
                        assert currApplicant != null;
                        createResume(currApplicant);
                    }

                    if (!exitFromBranch) {
                        enteredCommands.addAll(internalCommands);
                    }
                    break;
                case GETTING_PAIRS:
                    processRequests();
                    printResult();
                    enteredCommands.addAll(internalCommands);
                    break;
                default:
                    System.out.println("Введенная команда отсутствует в списке возможных действий. Повторите попытку.");
                    break;
            }
            internalCommands.clear();
            if (iteration == MAX_NUMBER_OF_ITERATIONS) {
                System.out
                        .println("Достигнут предел количества вводимых команд. Будет произведён принудительный выход.");
            }
        } while (iteration < MAX_NUMBER_OF_ITERATIONS);

        System.out.println("Сохранить все введенные команды в файл?");
        if (getStringValue().equalsIgnoreCase(YES_STRING)) {
            DateTimeFormatter timeStampPattern = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
            File myFile = new File("result_" + timeStampPattern.format(java.time.LocalDateTime.now()) + ".txt");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(myFile));) {
                for (String string : enteredCommands) {
                    writer.write(string + "\n");
                }
            } catch (IOException e) {
                System.out.println("Произошла какая-то ошибка. Вот информация о ней:");
                e.printStackTrace();
            }
        }
        in.close();
    }

    private static void printResult() {
        for (Vacancy vacancy : resultPairs.keySet()) {
            System.out.println(new StringBuilder().append(resultPairs.get(vacancy).getAuthor().getFio())
                    .append(", вы получили предложение работать в компании ").append(vacancy.getAuthor().getName())
                    .append(" на вакансии ").append(vacancy.getTitle()).append(". Ваша зарплата: ")
                    .append(Math.max(vacancy.getPayment(), resultPairs.get(vacancy).getPayment())));
        }
    }

    private static void createResume(Applicant currApplicant) {
        int type;
        int payment;
        int hoursInWeek;

        System.out.println("Введите числовой код вашей специальности:");
        String typeToParse = getStringValue();
        if (typeToParse.equalsIgnoreCase(END_STRING)) {
            exitFromBranch = true;
            return;
        } else if (typeToParse.matches(INTEGER_REGEX)) {
            type = Integer.parseInt(typeToParse);
        } else {
            System.out.println("Неизвестная команда. Выход в меню.");
            exitFromBranch = true;
            return;
        }

        System.out.println("Введите размер зарплаты");
        String paymentToParse = getStringValue();
        if (paymentToParse.equalsIgnoreCase(END_STRING)) {
            exitFromBranch = true;
            return;
        } else if (paymentToParse.matches(INTEGER_REGEX)) {
            payment = Integer.parseInt(paymentToParse);
        } else {
            System.out.println("Неизвестная команда. Выход в меню.");
            exitFromBranch = true;
            return;
        }

        System.out.println("Введите число рабочих часов в неделю");
        String hoursToParse = getStringValue();
        if (hoursToParse.equalsIgnoreCase(END_STRING)) {
            exitFromBranch = true;
            return;
        } else if (hoursToParse.matches(INTEGER_REGEX)) {
            hoursInWeek = Integer.parseInt(hoursToParse);
        } else {
            System.out.println("Неизвестная команда. Выход в меню.");
            exitFromBranch = true;
            return;
        }

        System.out.println(
                new StringBuilder("Подтвердите создание резюме по специальности ").append(type).append(" с зарплатой ")
                        .append(payment).append(" и количеством рабочих часов в неделю ").append(hoursInWeek));
        String choose = getStringValue();
        if (choose.equalsIgnoreCase(END_STRING)) {
            exitFromBranch = true;
            return;
        }
        if (choose.equalsIgnoreCase(YES_STRING)) {
            Resume resume = new Resume(currApplicant, payment, hoursInWeek, type);
            allResumes.add(resume);
            currApplicant.addResume(resume);
            System.out.println("Резюме успешно создано.");
        } else {
            System.out.println("Создание резюме отменено");
        }
    }

    private static Applicant registerApplicant() {
        System.out.println("Регистрируем новый аккаунт.\nВведите ФИО одной строкой");
        String fio = getStringValue();
        if (fio.equalsIgnoreCase(END_STRING)) {
            exitFromBranch = true;
            return null;
        }

        System.out.println("Введите логин");
        String login = getStringValue();
        if (login.equalsIgnoreCase(END_STRING)) {
            exitFromBranch = true;
            return null;
        }

        System.out.println("Введите пароль");
        String password = getStringValue();

        if (password.equalsIgnoreCase(END_STRING)) {
            exitFromBranch = true;
            return null;
        }

        Applicant currApplicant = new Applicant(fio, login, password);
        applicants.put(login, currApplicant);
        return currApplicant;
    }

    private static Applicant loginApplicant() {
        System.out.println("Введите ваш логин:");
        String login = getStringValue();
        if (login.equalsIgnoreCase(END_STRING)) {
            exitFromBranch = true;
            return null;
        }
        if (applicants.containsKey(login)) {
            System.out.println("Введите ваш пароль:");
            String password = getStringValue();
            if (password.equalsIgnoreCase(END_STRING)) {
                exitFromBranch = true;
                return null;
            }
            if (applicants.get(login).enter(login, password)) {
                System.out.println("Успешная авторизация. Переход к созданию резюме.");
                return (applicants.get(login));
            } else {
                System.out.println("Неправильный пароль. Выход в меню.");
                exitFromBranch = true;
                return null;
            }
        } else {
            System.out.println("Такой логин не найден в базе. Выход в меню.");
            exitFromBranch = true;
            return null;
        }
    }

    private static void createVacancy(Company currCompany) {
        int type;
        String title;
        int payment;
        int hoursInWeek;

        System.out.println("Введите числовой код требуемой специальности:");
        String typeToParse = getStringValue();
        if (typeToParse.equalsIgnoreCase(END_STRING)) {
            exitFromBranch = true;
            return;
        } else if (typeToParse.matches(INTEGER_REGEX)) {
            type = Integer.parseInt(typeToParse);
        } else {
            System.out.println("Неизвестная команда. Выход в меню.");
            exitFromBranch = true;
            return;
        }

        System.out.println("Введите заголовок вакансии");
        title = getStringValue();
        if (title.equalsIgnoreCase(END_STRING)) {
            exitFromBranch = true;
            return;
        }

        System.out.println("Введите размер зарплаты");
        String paymentToParse = getStringValue();
        if (paymentToParse.equalsIgnoreCase(END_STRING)) {
            exitFromBranch = true;
            return;
        } else if (paymentToParse.matches(INTEGER_REGEX)) {
            payment = Integer.parseInt(paymentToParse);
        } else {
            System.out.println("Неизвестная команда. Выход в меню.");
            exitFromBranch = true;
            return;
        }

        System.out.println("Введите число рабочих часов в неделю");
        String hoursToParse = getStringValue();
        if (hoursToParse.equalsIgnoreCase(END_STRING)) {
            exitFromBranch = true;
            return;
        } else if (hoursToParse.matches(INTEGER_REGEX)) {
            hoursInWeek = Integer.parseInt(hoursToParse);
        } else {
            System.out.println("Неизвестная команда. Выход в меню.");
            exitFromBranch = true;
            return;
        }

        System.out.println(new StringBuilder("Подтвердите создание вакансии \"").append(title)
                .append("\" по специальности ").append(type).append(" с зарплатой ").append(payment)
                .append(" и количеством рабочих часов в неделю ").append(hoursInWeek));
        String choose = getStringValue();
        if (choose.equalsIgnoreCase(END_STRING)) {
            exitFromBranch = true;
            return;
        }
        if (choose.equalsIgnoreCase(YES_STRING)) {
            Vacancy newVacancy = new Vacancy(currCompany, payment, hoursInWeek, type, title);
            currCompany.addVacancy(newVacancy);
            allVacancies.add(newVacancy);
            System.out.println("Вакансия успешно создана.");
        } else {
            System.out.println("Создание вакансии отменено");
        }
    }

    private static Company registerCompany() {
        System.out.println("Регистрируем новый аккаунт.\nВведите название вашей компании:");
        String name = getStringValue();
        if (name.equalsIgnoreCase(END_STRING)) {
            exitFromBranch = true;
            return null;
        }

        System.out.println("Введите логин");
        String login = getStringValue();
        if (login.equalsIgnoreCase(END_STRING)) {
            exitFromBranch = true;
            return null;
        }

        System.out.println("Введите пароль");
        String password = getStringValue();
        if (password.equalsIgnoreCase(END_STRING)) {
            exitFromBranch = true;
            return null;
        }

        System.out.println("Введите номер в единой регистрационной системе:");
        String idNumberToParse = getStringValue();
        int regNumber;
        if (idNumberToParse.equalsIgnoreCase(END_STRING)) {
            exitFromBranch = true;
            return null;
        } else if (idNumberToParse.matches(INTEGER_REGEX)) {
            regNumber = Integer.parseInt(idNumberToParse);
        } else {
            System.out.println("Неизвестная команда. Выход в меню.");
            exitFromBranch = true;
            return null;
        }

        Company currCompany = new Company(login, password, name, regNumber);
        companies.put(login, currCompany);
        return currCompany;
    }

    private static Company loginCompany() {
        System.out.println("Введите ваш логин:");
        String login = getStringValue();
        if (login.equalsIgnoreCase(END_STRING)) {
            exitFromBranch = true;
            return null;
        }
        if (companies.containsKey(login)) {
            System.out.println("Введите ваш пароль:");
            String password = getStringValue();
            if (password.equalsIgnoreCase(END_STRING)) {
                exitFromBranch = true;
                return null;
            }
            if (companies.get(login).enter(login, password)) {
                System.out.println("Успешная авторизация. Переход к созданию вакансии.");
                return (companies.get(login));
            } else {
                System.out.println("Неправильный пароль. Выход в меню.");
                exitFromBranch = true;
                return null;
            }
        } else {
            System.out.println("Такой логин не найден в базе. Выход в меню.");
            exitFromBranch = true;
            return null;
        }
    }

    private static void processRequests() {
        for (Vacancy vacancy : allVacancies) {
            if (vacancy.isActual()) {
                for (Resume resume : allResumes) {
                    if (resume.isActual() && vacancy.getType() == resume.getType()
                            && vacancy.getHoursInWeek() <= resume.getHoursInWeek()
                            && vacancy.getPayment() >= resume.getPayment()) {
                        resultPairs.put(vacancy, resume);
                        vacancy.makeInactive();
                        resume.makeInactive();
                        resume.getAuthor().clearRequests();
                    }
                }
            }
        }
    }

    private static String getStringValue() {
        String command = null;
        if (!commandsFromFile.isEmpty()) {
            command = commandsFromFile.poll();
            System.out.println(command);
            try {
                Thread.sleep(TIME_TO_SLEEP);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поймано исключение. Продолжаем работу");
            }
        } else {
            boolean exceptionCaught;
            do {
                exceptionCaught = false;
                try {
                    command = in.nextLine();
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
            // internalCommands.add(command);//todo раскомментировать перед отправкой
        }
        internalCommands.add(command);// todo удалить перед отправкой
        return command;
    }

    private static void readCommandsFromFile(String[] args) {
        if (args.length == NUM_OF_ARGS_FOR_FILE
                && (args[0].equalsIgnoreCase("-f") || args[0].equalsIgnoreCase("--file"))) {
            try (BufferedReader bufReader = new BufferedReader(new FileReader(args[1]))) {
                String s;
                while ((s = bufReader.readLine()) != null) {
                    commandsFromFile.add(s);
                }
            } catch (IOException e) {
                System.out.println("Файл не был найден. Проверьте правильность имени и повторите попытку.");
            }
        }
    }
}

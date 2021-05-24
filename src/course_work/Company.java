package src.course_work;

import java.util.ArrayList;
import java.util.List;

public class Company extends User {
    private String name;
    private int registryNumber;
    private List<Vacancy> vacancies;

    public Company(String login, String password, String name, int registryNumber) {
        super(login, password);
        this.name = name;
        this.registryNumber = registryNumber;
        vacancies = new ArrayList<>();
    }

    public void addVacancy(Vacancy newVacancy) {
        vacancies.add(newVacancy);
    }

    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public String getCompanyInfo() {
        return new StringBuilder().append("Копания \"").append(this.name).append("\" с регистрационным номером ")
                .append(this.registryNumber).toString();
    }
}

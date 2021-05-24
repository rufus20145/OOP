package src.course_work;

public class Applicant extends User {
    private String fio;
    private int idNumber;

    public Applicant(String fio, String login, String password, int idNumber) {
        super(login, password);
        this.fio = fio;
        this.idNumber = idNumber;
    }

    public void takeResult(Vacancy request) {
        // todo
    }

    public String getFio() {
        return fio;
    }

}

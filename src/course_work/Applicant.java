package src.course_work;

import java.util.ArrayList;
import java.util.List;

public class Applicant extends User {
    private String fio;
    private List<Resume> resumes;

    public Applicant(String fio, String login, String password) {
        super(login, password);
        this.fio = fio;
        resumes = new ArrayList<>();
    }

    public void addResume(Resume resume) {
        resumes.add(resume);
    }

    public void clearRequests() {
        for (Resume resume : resumes) {
            resume.makeInactive();
        }
    }

    public String getFio() {
        return fio;
    }

}

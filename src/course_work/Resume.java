package src.course_work;

public class Resume extends Request {

    public Resume(Applicant author, int payment, int hoursInWeek, int type) {
        super(author, payment, hoursInWeek, type);
    }

    @Override
    public Applicant getAuthor() {
        return (Applicant) super.getAuthor();
    }

}

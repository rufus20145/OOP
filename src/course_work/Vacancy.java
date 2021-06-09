package src.course_work;

public class Vacancy extends Request {
    private String title;

    public Vacancy(Company author, int payment, int hoursInWeek, int type, String title) {
        super(author, payment, hoursInWeek, type);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public Company getAuthor() {
        return (Company) super.getAuthor();
    }

}

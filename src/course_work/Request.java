package src.course_work;

public class Request {

    private User author;
    private int payment;
    private int hoursInWeek;
    private int type;
    private boolean isActual;

    public Request(User author, int payment, int hoursInWeek, int type) {
        this.author = author;
        this.payment = payment;
        this.hoursInWeek = hoursInWeek;
        this.type = type;
        this.isActual = true;
    }

    public void makeInactive() {
        isActual = false;
    }

    public boolean isActual() {
        return isActual;
    }

    public User getAuthor() {
        return author;
    }

    public int getPayment() {
        return payment;
    }

    public int getHoursInWeek() {
        return hoursInWeek;
    }

    public int getType() {
        return type;
    }
}

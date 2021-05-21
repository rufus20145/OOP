package src.course_work;

public class Request {
    private Client requester;
    private String job;
    private int payment;
    private int hoursInWeek;
    private int type;

    public Request(Client requester, String job, int payment, int hoursInWeek, int type) {
        this.requester = requester;
        this.job = job;
        this.payment = payment;
        this.hoursInWeek = hoursInWeek;
        this.type = type;
    }

    public Client getRequester() {
        return requester;
    }

    public String getJob() {
        return job;
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

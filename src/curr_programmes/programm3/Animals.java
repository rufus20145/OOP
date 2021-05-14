package curr_programmes.programm3;

public abstract class Animals implements TypeOfTransport, Sound {

    private String name;

    public Animals(String name) {
        this.name = name;
    }

    public abstract void voice();

    public void run() {
        System.out.println("Running.");
    }

    public void walk() {
        System.out.println("Walking.");
    }

    public String getName() {
        return name;
    }
}

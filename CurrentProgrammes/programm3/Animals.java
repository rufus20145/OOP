package currentProgrammes.programm3;

public abstract class Animals implements TypeOfTransport, Sound {

    public abstract void voice();

    public void run() {
        System.out.println("Running.");
    }

    public void walk() {
        System.out.println("Walking.");
    }
}

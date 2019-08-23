public class Task {
    protected String name;
    protected boolean isDone;

    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }
    public String currentStatus() {
        return ((isDone ? "[✓] " : "[✗] ")); //return tick or X symbols
    }
    public String overallStatus() {
        return currentStatus() + name;
    }

    public String getName() {
        return (name);
    }

    public void printname() {
        System.out.println("    ____________________________________________________________\n" +
                "     added: "+ name +"\n" +
                "    ____________________________________________________________");
    }
    public void completed() {
        isDone = true;
    }
}
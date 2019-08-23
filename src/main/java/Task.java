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

    public String getname() {
    return name;
    }
    public void completed() {
        isDone = true;
    }
}
public class Deadlines extends Task {

    protected String by;

    public Deadlines(String name, String by) {
        super(name);
        this.by = by;
    }
    @Override
    public String overallStatus() {
        return "[D]" + currentStatus() + name + "(by:" + by + ")";
    }
}

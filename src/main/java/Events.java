public class Events extends Task{

    protected String at;

    public Events(String name,String at) {
        super(name);
        this.at = at;
    }
    @Override
    public String overallStatus() {
        return "[E]" + currentStatus() + name + "(at:" + at + ")";
    }
}

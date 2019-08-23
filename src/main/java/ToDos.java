public class ToDos extends Task {
    public ToDos(String name) {
        super(name);
    }

    @Override
    public String overallStatus() {
        return "[T]"+ currentStatus() + name;
    }
}

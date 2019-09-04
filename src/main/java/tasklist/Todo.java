package tasklist;

public class Todo extends Task {

    public Todo(String description, boolean completionStatus) {
        super(description,completionStatus);
    }

    @Override
    public String getOverallStatus() {
        return "[T]" + getCurrentStatus() + description;
    }

    @Override
    public String encodeForStorage() {
        int myInt = isDone ? 1 : 0;
        return "todo [" + myInt + "]" + description;
    }
}

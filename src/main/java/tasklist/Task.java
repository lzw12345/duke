package tasklist;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Task {
    protected String description;
    protected boolean isDone;
    protected LocalDateTime date;
    protected static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("dd MMMM hhmm a");

    public Task(String description, boolean completionStatus, LocalDateTime date) {
        this.description = description;
        this.isDone = completionStatus;
        this.date = date;
    }

    public Task(String description, boolean completionStatus) {
        this.description = description;
        this.isDone = completionStatus;
    }

    public String getCurrentStatus() {
        return ((isDone ? "[✓] " : "[✗] ")); //return tick or X symbols
    }

    public abstract String getOverallStatus();

    public void completeTask() {
        isDone = true;
    }

    public abstract String encodeForStorage();
}
package tasklist;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    public Deadline(String name, boolean completionStatus, LocalDateTime date) {
        super(name,completionStatus, date);
    }

    @Override
    public String getOverallStatus() {
        return "[D]" + getCurrentStatus() + description + "(by:" + date.format(OUTPUT_FORMAT) + ")";
    }

    @Override
    public String encodeForStorage() {
        int myInt = isDone ? 1 : 0;
        return "deadline [" + myInt + "]" + description + "/by"
                + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm"));
    }

}

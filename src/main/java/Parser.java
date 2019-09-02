import java.util.Date;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private CommandType commandType;
    private boolean isDone;
    private String description;
    private String date = "";
    private boolean isSafe = true;

    public Parser(String fullCommand) {
        Pattern command_format = Pattern.compile("(?<commandWord>\\w+)"
                + "\\s*(?<completionstatus>(\\[[01]\\])?)"
                + "\\s*(?<description>([\\w\\s\\d]+)?)"
                + "(?:(/by|/at))?(?<date>([\\w\\s\\d/]+)?)");
        Matcher matcher = command_format.matcher(fullCommand);
        if (!matcher.find()) {
            System.out.println("    ____________________________________________________________\n" +
                    "     ☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n" +
                    "    ____________________________________________________________");
            isSafe= false;
        }else {
            switch (matcher.group("commandWord")) {
            case "list":
                commandType = CommandType.LIST;
                break;
            case "todo":
                commandType = CommandType.ADDTODO;
                break;
            case "deadline":
                commandType = CommandType.ADDDEADLINE;
                break;
            case "event":
                commandType = CommandType.ADDEVENT;
                break;
            case "delete":
                commandType = CommandType.DELETE;
                break;
            case "done":
                commandType = CommandType.COMPLETE;
                break;
            default:
                System.out.println("    ____________________________________________________________\n" +
                        "     ☹ OOPS!!! I'm sorry, but I don't know that task :-(\n" +
                        "    ____________________________________________________________");
                isSafe = false;
            }
            isDone = matcher.group("completionstatus").equals("[1]");
            description = matcher.group("description").trim();
            if (!matcher.group("date").isEmpty()) {
                date = matcher.group("date").trim();
            }
        }

    }

    public CommandType getCommandType() {
        return commandType;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public boolean isSafe() {
        return isSafe;
    }
}


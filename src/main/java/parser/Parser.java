package parser;

import Ui.TextUi;
import tasklist.TaskList;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.time.LocalTime.parse;

public class Parser {
    String command;
    private boolean isDone;
    String description;
    private LocalDateTime date;
    private boolean isSafe;
    private TextUi ui;

    public Parser(){
        ui = new TextUi();
    };

    public void parse(String fullCommand, TaskList scheduler , boolean isLoading){
        isSafe = true;
        Pattern command_format = Pattern.compile("(?<commandWord>\\w+)"
                + "\\s*(?<completionStatus>(\\[[01]\\])?)"
                + "\\s*(?<description>([\\w\\s\\d]+)?)"
                + "(?:(/by|/at))?(?<date>([\\w\\s\\d/]+)?)");
        Matcher matcher = command_format.matcher(fullCommand);
        if (matcher.find()) {
            command = matcher.group("commandWord");
            isDone = matcher.group("completionStatus").equals("[1]");
            description = matcher.group("description").trim();
            if (!matcher.group("date").isEmpty()) {
                try {
                    // Parsing the date
                    DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
                    date = LocalDateTime.parse(matcher.group("date").trim(), inputFormat);
                } catch (DateTimeParseException e) {
                    ui.printWrongDate();
                    isSafe = false;
                }
            }
            if (isSafe) {
                switch (command) {
                case "todo":
                case "deadline":
                case "event":
                    scheduler.addTask(command, description, isDone, date);
                    if (!isLoading) {
                        scheduler.printnewtask();
                    }
                    break;
                case "list":
                    scheduler.listTasks();
                    break;
                case "done":
                    scheduler.completeTask(description);
                    break;
                case "delete":
                    scheduler.removeTask(description);
                    break;
                default:
                    ui.printErrorMsg1();
                    isSafe = false;
                }
            }
        } else {
            ui.printErrorMsg2();
            isSafe = false;
        }

    }


    public boolean isSafe() {
        return isSafe;
    }

    public String command() {
        return command;
    }
}



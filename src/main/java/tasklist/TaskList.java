package tasklist;

import ui.TextUi;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class TaskList {
    protected LinkedList<Task> taskList;
    private TextUi ui;

    public TaskList() {
        taskList = new LinkedList<Task>();
        ui = new TextUi();
    }


    public TaskList(LinkedList<Task> loadedList) {
        taskList = loadedList;
        ui = new TextUi();
    }


    public void printnewtask() {
        ui.printAddedTask(taskList.getLast().getOverallStatus(),taskList.size());
    }

    public void listTasks() {
        ui.printTaskList(taskList);
    }

    public void completeTask(String completedtask) {
        int taskNumber = Integer.parseInt(completedtask);
        taskList.get(taskNumber - 1).completeTask();
        ui.printCompletedTask(taskList.get(taskNumber - 1).getOverallStatus());
    }

    public void addTask(String taskType, String description, boolean completionStatus, LocalDateTime date) {
        switch (taskType) {
        case "todo":
            taskList.addLast(new Todo(description,completionStatus));
            break;
        case "deadline":
            taskList.addLast(new Deadline(description, completionStatus, date));
            break;
        case "event":
            taskList.addLast(new Event(description, completionStatus, date));
            break;
        default:
            // not necessary as tasktype can only be the above 3
        }
    }


    public void removeTask(String deletedEvent) {
        int taskTodDelete = Integer.parseInt(deletedEvent);
        ui.printRemovedTask(taskList.get(taskTodDelete - 1).getOverallStatus(),taskList.size());
        taskList.remove(taskTodDelete - 1);
    }

    public LinkedList<Task> getTaskList() {
        return taskList;
    }

}

package tasklist;

import ui.TextUi;

import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 * Represents an entire tasklist and contains methods to edit and display the list.
 */
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

    /**
     * prints the ui after adding a new task.
     */
    public void printNewTask() {
        ui.printAddedTask(taskList.getLast().getOverallStatus(),taskList.size());
    }

    /**
     * prints the ui for listing tasks.
     */
    public void listTasks() {
        ui.printTaskList(taskList);
    }

    /**
     * Changes the completion status of the task.
     * @param completedtask tells the method which task has been completed
     */
    public void completeTask(String completedtask) {
        int taskNumber = Integer.parseInt(completedtask);
        taskList.get(taskNumber - 1).completeTask();
        ui.printCompletedTask(taskList.get(taskNumber - 1).getOverallStatus());
    }

    /**
     * Method to add a task to the tasklist according to the correct type.
     * @param taskType determines type of task to add
     * @param description description of the task
     * @param completionStatus sets the completion status of the task
     * @param date sets the date of the task
     */
    public void addTask(String taskType, String description, boolean completionStatus, LocalDateTime date) {
        assert !description.isEmpty() : "description should not be empty";
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

    /**
     * Deletes the task as specified by user.
     * @param deletedEvent determines the task to be deleted
     */
    public void removeTask(String deletedEvent) {
        int taskTodDelete = Integer.parseInt(deletedEvent);
        ui.printRemovedTask(taskList.get(taskTodDelete - 1).getOverallStatus(),taskList.size());
        taskList.remove(taskTodDelete - 1);
    }

    public LinkedList<Task> getTaskList() {
        return taskList;
    }

    /**
     * Searches through whole tasklist to try and find a match with the user input.
     * @param search the string to search for
     */
    public void findTasks(String search) {
        LinkedList<String> foundtasks = new LinkedList<>();
        for (Task task: taskList) {
            if (task.getOverallStatus().contains(search)) {
                foundtasks.addLast(task.getOverallStatus());
            }
        }
        ui.printFoundTasks(foundtasks);
    }

}

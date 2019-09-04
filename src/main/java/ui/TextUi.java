package ui;

import tasklist.Task;

import java.util.LinkedList;

public class TextUi {
    private static final String DIVIDER = "    ____________________________________________________________";
    private static final String LOGO = " ____         _        \n"
                                     + "|  _ \\ _   _| | _____ \n"
                                     + "| | | | | | | |/ / _ \\\n"
                                     + "| |_| | |_| |   <  __/\n"
                                     + "|____/ \\__,_|_|\\_\\___|\n";

    public TextUi(){
    }

    public void printAddedTask(String task, int size) {
        System.out.println(DIVIDER + "\n"
                + "     Got it. I've added this task:\n"
                + "       " + task + "\n"
                + "     Now you have " + size + " tasks in the list.\n"
                + DIVIDER);
    }

    public void printTaskList(LinkedList<Task> taskList) {
        int i = 0;
        System.out.println(DIVIDER
                + "\n"
                + "     Here are the tasks in your list:");
        while (i < taskList.size()) {
            System.out.println("     " + (i + 1) + ". " + taskList.get(i).getOverallStatus());
            i++;
        }
        System.out.println(DIVIDER);
    }

    public void printCompletedTask(String completedtask) {
        System.out.println(DIVIDER + "\n"
                + "     Nice! I've marked this task as done: \n"
                + "       " + completedtask + "\n" + DIVIDER);
    }

    public void printRemovedTask(String task, int size) {
        System.out.println(DIVIDER + "\n"
                + "     Noted. I've removed this task: \n"
                + "       " + task + "\n"
                + "     Now you have " + (size - 1) + " tasks in the list.\n"
                + "    ____________________________________________________________");
    }

    public void printIntroduction() {
        System.out.println(LOGO + DIVIDER + "\n"
                + "     Hello! I'm Duke\n"
                + "     What can I do for you?\n"
                + DIVIDER);
    }

    public void printGoodByeMsg() {
        System.out.println(DIVIDER + "\n"
                + "     Bye. Hope to see you again soon!\n"
                + DIVIDER);
    }

    public void printErrorMsg1() {
        System.out.println(DIVIDER + "\n"
                + "     ☹ OOPS!!! I'm sorry, but I don't know that command :-(\n"
                + DIVIDER);
    }

    public void printErrorMsg2() {
        System.out.println(DIVIDER + "\n"
                + "     ☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n"
                + DIVIDER);
    }

    public void printLoadingError(int tasknumber) {
        System.out.println("    ____________________________________________________________\n"
                + "     ☹ OOPS!!! I'm sorry, but loading task "
                + tasknumber
                + " has failed, it will be removed\n"
                + "    ____________________________________________________________");
    }

    public void printWrongDate() {
        System.out.println(DIVIDER + "\n"
                + "     ☹ OOPS!!! I'm sorry, but I don't understand that date :-(\n"
                + DIVIDER);
    }

    public void printNeedDate() {
        System.out.println(DIVIDER + "\n"
                + "     ☹ OOPS!!! I'm sorry, but I need a date :-(\n"
                + DIVIDER);
    }

}
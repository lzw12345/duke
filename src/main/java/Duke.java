import com.sun.source.tree.WhileLoopTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo + "    ____________________________________________________________\n" +
                "     Hello! I'm Duke\n" +
                "     What can I do for you?\n" +
                "    ____________________________________________________________");

        Scanner input = new Scanner(System.in);
        TaskList taskList = new TaskList("tasklist");
        String user = input.nextLine();

        String[] cases = {"list","done","todo","deadline","event"};

        while (!user.equals("bye")) {
            int i = 0;
            for(i = 0; i < cases.length; i++) {
                if (user.contains(cases[i])) break;
            }
            try {
                switch (i) {
                    case 0:
                        taskList.listTasks();
                        break;
                    case 1:
                        taskList.completetask(user);
                        break;
                    case 2:
                        taskList.addtodo(user.split(" ", 2)[1]);
                        break;
                    case 3:
                        taskList.adddeadline(user.split(" ", 2)[1]);
                        break;
                    case 4:
                        taskList.addevent(user.split(" ", 2)[1]);
                        break;
                    default:
                        System.out.println("    ____________________________________________________________\n" +
                                "     ☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n" +
                                "    ____________________________________________________________");
                }
            }catch (IndexOutOfBoundsException e){
                System.out.println("    ____________________________________________________________\n" +
                        "     ☹ OOPS!!! The description of a task cannot be empty.\n" +
                        "    ____________________________________________________________");
            }
            user = input.nextLine();
        }
        System.out.println("    ____________________________________________________________\n" +
                "     Bye. Hope to see you again soon!\n" +
                "    ____________________________________________________________");
    }
}

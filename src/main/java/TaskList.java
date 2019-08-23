import java.util.LinkedList;

public class TaskList {
    private String listname;
    private LinkedList<Task> list;

    public TaskList(String listname) {
        this.listname = listname;
        list = new LinkedList<Task>();
    }

    public void addtask(String taskname) {
        list.addLast(new Task(taskname));
        list.getLast().printname();
    }

    public void listTasks() {
        int i = 0;
        System.out.println("    ____________________________________________________________\n" +
                "     Here are the tasks in your list:");
        while (i < list.size()) {
            System.out.println("     "+ (i+1) + ". " +list.get(i).overallStatus());
            i++;
        }
        System.out.println("    ____________________________________________________________");
    }
    public void completetask(String userinput){
        int tasknumber = Integer.parseInt(userinput.split(" ")[1]);
        list.get(tasknumber-1).completed();
        System.out.println("    ____________________________________________________________\n" +
                "     Nice! I've marked this task as done: \n" +
                "       "+ list.get(tasknumber-1).overallStatus() +"\n" +
                "    ____________________________________________________________");
    }

}
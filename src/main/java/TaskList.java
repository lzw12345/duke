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
        System.out.println("    ____________________________________________________________");
        while (i < list.size()) {
            System.out.println("     "+ (i+1) + ". " +list.get(i).name);
            i++;
        }
        System.out.println("    ____________________________________________________________");
    }
1
}
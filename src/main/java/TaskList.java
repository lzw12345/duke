import java.util.LinkedList;

public class TaskList {
    private String listname;
    private LinkedList<Task> list;

    public void printnewtask(){
        System.out.println("    ____________________________________________________________\n" +
                "     Got it. I've added this task: \n" +
                "       " + list.getLast().overallStatus() + "\n" +
                "     Now you have " + list.size() + " tasks in the list.\n" +
                "    ____________________________________________________________");
    }

    public TaskList(String listname) {
        this.listname = listname;
        list = new LinkedList<Task>();
    }

    public void addtask(String taskname) {
        list.addLast(new Task(taskname));
        System.out.println("    ____________________________________________________________\n" +
                "     added: "+ list.getLast().getname() +"\n" +
                "    ____________________________________________________________");
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
    public void addtodo(String todoname){
        list.addLast(new ToDos(todoname));
        printnewtask();
    }
    public void adddeadline(String deadname) {
        list.addLast(new Deadlines((deadname.split("/")[0]), (deadname.split("/by")[1])));
        printnewtask();
    }
    public void addevent(String eventname){
        list.addLast(new Events((eventname.split("/")[0]), (eventname.split("/at")[1])));
        printnewtask();
    }


}
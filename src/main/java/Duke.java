import ui.TextUi;
import storage.Storage;
import tasklist.TaskList;
import parser.Parser;

import java.io.IOException;
import java.util.Scanner;

public class Duke {
    private Storage saveFile;
    private TextUi ui;

    public Duke(String filepath) throws IOException {
        saveFile = new Storage(filepath);
        ui = new TextUi();
    }

    public void run() throws IOException {
        ui.printIntroduction();
        Scanner input = new Scanner(System.in);
        String user = input.nextLine();
        TaskList scheduler;
        Parser parser = new Parser();

        while (!user.equals("bye")) {
            scheduler = new TaskList(saveFile.loadData());
            parser.parse(user, scheduler,false);
            saveFile.storeData(scheduler.getTaskList());
            user = input.nextLine();
        }

        ui.printGoodByeMsg();

    }


    public static void main(String[] args) throws IOException {
        new Duke("tasklist.txt").run();
    }
}

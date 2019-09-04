package storage;


import ui.TextUi;
import tasklist.Task;
import tasklist.TaskList;
import parser.Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Storage {
    private String filePath;
    private TextUi ui;

    public Storage(String filePath) throws IOException {
        this.filePath = filePath;
        ui = new TextUi();
    }

    public void storeData(LinkedList<Task> toStore) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        StringBuilder fullList = new StringBuilder();
        for (Task task : toStore) {
            fullList.append(task.encodeForStorage()).append("\n");
        }
        fileWriter.write(fullList.toString());
        fileWriter.close();
    }

    public LinkedList<Task> loadData() throws IOException {
        FileReader reader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(reader);
        TaskList storedData = new TaskList();
        Parser parser = new Parser();
        String line;
        int tasknumber = 1;

        while ((line = bufferedReader.readLine()) != null) {
            parser.parse(line,storedData,true);
            if (!parser.isSafe()) {
                ui.printLoadingError(tasknumber);
            }
            tasknumber++;
        }
        bufferedReader.close();
        return storedData.getTaskList();
    }

}



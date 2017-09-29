import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Tasks {

    private final String FILE_NAME = "Tasklist.txt";
    private List<String> allToDo = new ArrayList<>();
    //private int num;

    public void printUsage() {
        System.out.println("\n" +"Java myTodo application\n" +
                "=======================\n" +
                "\n" +
                "Command line arguments:\n" +
                " -l   Lists all the tasks\n" +
                " -a   Adds a new task\n" +
                " -r   Removes an task\n" +
                " -c   Completes an task");
    }
    public void listTasks() {
        Path filePath = Paths.get(FILE_NAME);
        try {
            allToDo = Files.readAllLines(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (allToDo.size() == 0) {
            System.out.println("No todos for today.");
        }
        else {
            for (int i = 0; i < allToDo.size(); i++) {
                System.out.println(i + 1 + " - " +  allToDo.get(i));
            }
        }
    }

    public void addTasks(String task) {
        Path path1 = Paths.get(FILE_NAME);

        try {
            allToDo = Files.readAllLines(path1);
            allToDo.add("[ ]" + " " + task);
            Files.write(path1, allToDo);

        } catch (Exception e) {
            System.out.println("Unable to add: no task provided");
        }
    }
    public void removeTasks(int num) {
        Path todoFile = Paths.get(FILE_NAME);
        try {

            allToDo = Files.readAllLines(todoFile);
            allToDo.remove(num - 1);
            Files.write(todoFile, allToDo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void checkTasks(int num) {
        Path path = Paths.get(FILE_NAME);
        try {
            allToDo = Files.readAllLines(path);
            String temp = allToDo.get(num-1);
            allToDo.remove(num-1);
            temp = new StringBuffer(temp).replace(1, 2,"X").toString();
            allToDo.add(num-1,temp);
            Files.write(path, allToDo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

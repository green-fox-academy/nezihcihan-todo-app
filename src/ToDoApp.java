public class ToDoApp {
    public static void main(String[] args) {
        Tasks functions = new Tasks();

        if (args.length == 0) {
            functions.printUsage();
        }
        else if (args[0].equals("-l")) {
            functions.listTasks();
        }
        else if (args[0].equals("-a")) {
            if(args.length == 1) {
                System.out.println("Unable to add: no task provided!");
                System.exit(0);
            }
            else {
                functions.addTasks(args[1]);
            }
        }
        else if (args[0].equals("-r")) {
            functions.removeTasks(Integer.parseInt(args[1]));
        }
        else if (args[0].equals("-c")) {
            functions.checkTasks(Integer.parseInt(args[1]));
        }
    }
}

import java.util.ArrayList; // import the lib for lists
import java.util.Scanner; //import the lib to capture data

public class ToDoList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();
        boolean again = true;
        String checkResponse;
        int option;
        
        while(again){
            System.out.println("\nOptions to select:");

            System.out.println("type '1' to list the tasks saved ");
            System.out.println("type '2' to insert a new task");
            System.out.println("type '3' to delete a task");
            System.out.println("type '4' to exit the ToDoList");

            System.out.print("Insert your option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    listTasks(tasks);
                    break;
                case 2:
                    checkResponse = capNewTask(tasks, scanner);

                    if(checkResponse != ""){
                        tasks.add(checkResponse);
                    }
                    break;
                case 3:
                    checkResponse = capTaskDel(tasks, scanner);

                    if(checkResponse != ""){
                        tasks.remove(checkResponse);
                    }
                    break;
                case 4:
                    System.out.print("Ok, thanks!");
                    again = false;
                    break;
                default:
                    System.out.println("INSERT A VALID NUMBER!\n");
                    break;
            }
        }

        scanner.close();
    }

    static void listTasks(ArrayList<String> tasks){
        if(tasks.size() == 0){
            System.out.println("\nThere's any task saved");
        } else {
            System.out.println("\nTasks saved:");
            for (String task : tasks) {
                System.out.println(task);
            }
        }
    }

    static String capNewTask(ArrayList<String> tasks, Scanner scanner){
        System.out.println("\nInsert the new task (type 'exit' to cancel): ");
        String newTask = scanner.next();
        
        if(newTask == "exit"){
            return "";
        }else {
            return newTask;
        }
    }

    static String capTaskDel(ArrayList<String> tasks, Scanner scanner){
        if(tasks.size() > 0){
            System.out.println("\nTasks you can delete: ");
            listTasks(tasks);

            System.out.println("\nInsert the task you want to delete (type 'exit' to cancel): ");
            String taskToDel = scanner.next();
            
            if(taskToDel == "exit"){
                return "";
            }else {
                return taskToDel;
            }
        } else {
            System.out.println("\nThere's any task to delete");
            return "";
        }
    }
}
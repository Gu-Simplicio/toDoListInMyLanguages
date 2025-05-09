import java.util.ArrayList; // import the lib for lists
import java.util.Scanner; //import the lib to capture data

public class ToDoList { //start the ToDoList class
    public static void main(String[] args) { //main method of the class
        Scanner scanner = new Scanner(System.in); //create a new scanner to capture the inputs
        ArrayList<String> tasks = new ArrayList<>(); //create the list where the tasks will be saved in
        boolean again = true; //boolean variable that will check if the program will start again
        String checkResponse; //variable that will check the response of the methods
        int option; ///variable that represents the option of the user
        
        while(again){ //start the program while again == true
            //show the options
            System.out.println("\nOptions to select:");

            System.out.println("type '1' to list the tasks saved "); //1 to listTasks
            System.out.println("type '2' to insert a new task"); //2 to capNewTask
            System.out.println("type '3' to delete a task"); //3 to capTaskDel 
            System.out.println("type '4' to exit the ToDoList"); //4 to again == false

            //capture the option in a int
            System.out.print("Insert your option: "); 
            option = scanner.nextInt();

            //switch case that check wich method will be used
            switch (option) {
                //case 1, list the tasks
                case 1:
                    listTasks(tasks);
                    break;
                //case 2, insert a new task
                case 2:
                    //capture the new task with this method
                    checkResponse = capNewTask(tasks, scanner);

                    //if the response wasn't null (or "")  
                    if(checkResponse != ""){
                        //add the task inserted in tasks
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

        scanner.close(); //close the scanner
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
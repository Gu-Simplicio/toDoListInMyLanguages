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
                    System.out.println("\nTasks saved:"); //show this message
                    listTasks(tasks); //start the method listTasks 
                    break;
                //case 2, insert a new task
                case 2:
                    //capture the new task with this method
                    checkResponse = capNewTask(scanner);

                    //if the response wasn't null (or "")  
                    if(checkResponse != ""){
                        //add the task inserted in tasks
                        tasks.add(checkResponse);
                    }
                    break;
                //case 3, delete a task
                case 3: 
                    //capture the task with this method
                    checkResponse = capTaskDel(tasks, scanner);

                    //if the response wasn't null (or "")
                    if(checkResponse != ""){
                        //remove the task
                        tasks.remove(checkResponse);
                    }
                    break;
                //case 4, exit the program
                case 4:
                    //show a message
                    System.out.print("Ok, thanks!");
                    //again == false (to stop the while loop)
                    again = false;
                    break;
                //if the user inserted an invalid number
                default:
                    //show the error
                    System.out.println("INSERT A VALID NUMBER!\n");
                    break;
            }
        }

        scanner.close(); //close the scanner
    }

    //method that list the tasks saved, receiving the tasks
    static void listTasks(ArrayList<String> tasks){
        //if has no task
        if(tasks.size() == 0){
            //show this message
            System.out.println("\nThere's any task saved");
        } else { //if has at least one task
            //show the tasks with a foreach
            for (String task : tasks) {
                System.out.println(task);
            }
        }
    }

    //method that capture the new task to insert
    static String capNewTask(Scanner scanner){
        //ask the task the user want to insert
        System.out.println("\nInsert the new task (type 'exit' to cancel): ");
        //capture the task 
        String newTask = scanner.next();
        
        if(newTask == "exit"){ //if the input was "exit"
            return ""; //return null (or "")
        }else { //if wasn't
            //show that was inserted
            System.out.println("Task inserted!");
            //return the newTask
            return newTask;
        }
    }

    //method that capture the task to delete
    static String capTaskDel(ArrayList<String> tasks, Scanner scanner){
        //if has at least one task saved
        if(tasks.size() > 0){
            //show the tasks saved with the method listTasks
            System.out.println("\nTasks you can delete: ");
            listTasks(tasks);

            //ask the task that will be removed
            System.out.println("\nInsert the task you want to delete (type 'exit' to cancel): ");
            String taskToDel = scanner.next(); //capture the task
            
            //if the String inserted doesn't exists and is not "exit"
            while(!tasks.contains(taskToDel) && taskToDel != "exit"){ //enter in a loop 
                //show the error
                System.out.println("Insert an existing task!");

                //as the task to delete
                System.out.println("Insert the task you want to delete (type 'exit' to cancel): ");
                //capture the task
                taskToDel = scanner.next();
            }

            //if the String inserted == "exit"
            if(taskToDel == "exit"){
                return ""; //return null (or "")
            }else { //if isn't "exit"
                //show that was a success
                System.out.println("Task deleted!");
                //return the task to delete
                return taskToDel;
            }
        } else { //if has no task saved
            //show this message
            System.out.println("\nThere's any task to delete");
            return ""; //return null (or "")
        }
    }
}
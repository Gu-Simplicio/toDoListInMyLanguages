import java.util.ArrayList; // import the lib for lists
import java.util.Scanner; //import the lib to capture data

public class ToDoList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks;
        boolean again = true;
        int option;
        
        while(again){
            System.out.println("Options to select:");

            System.out.println("type '1' to list the tasks saved ");
            System.out.println("type '2' to insert a new task");
            System.out.println("type '3' to delete a task");
            System.out.println("type '4' to exit the ToDoList");

            System.out.print("Insert your option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
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
}

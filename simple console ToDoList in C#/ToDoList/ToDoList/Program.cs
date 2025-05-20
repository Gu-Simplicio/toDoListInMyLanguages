using System;
using System.Collections.Generic;

namespace ToDoList
{
    internal class Program
    {
        static List<string> tasks = new List<string>();
        static void Main(string[] args)
        {
            int choice;
            bool still = true;
            Console.WriteLine("Welcome to the C# toDoList!");
            do 
            {
                Console.WriteLine("Type '1' to list the tasks saved");
                Console.WriteLine("Type '2' to insert a new task");
                Console.WriteLine("Type '3' to delete a task");
                Console.WriteLine("Type '4' to exit the ToDoList");

                choice = int.Parse(Console.ReadLine()); 

                switch (choice)
                {
                    case 1:
                        Console.WriteLine("Tasks saved:");
                        ListTasks();
                        break;
                    case 2:
                        InsertTask();   
                        break;
                    case 3:
                        deleteTask();
                        break;
                    case 4:
                        Console.WriteLine("Ok, bye!");
                        still = false;
                        break;
                    default:
                        Console.WriteLine("Insert one of the options!"); 
                        break;
                }
            } while(still);
        }

        static void ListTasks()
        { 
            if(tasks.Count == 0)
            {
                Console.WriteLine("\nThere's no task to list!\n");
            } else
            {
                foreach(string task in tasks)
                {
                    Console.WriteLine(task);
                }
            }
        }
    
        static void InsertTask()
        {
            Console.Write("Insert the new task (type 'exit' to cancel): ");
            string newTask = Console.ReadLine();

            if(newTask != "exit")
            {
                tasks.Add(newTask);
                Console.WriteLine(newTask + " inserted successfuly!");
            }
        }
   
        static void deleteTask()
        {
            if(tasks.Count == 0)
            {
                Console.WriteLine("\nThere's no task to delete!\n");
            } else
            {
                Console.WriteLine("Tasks already saved:");
                ListTasks();

                Console.Write("Insert the task you want to delete (type 'exit' to cancel): ");
                string taskToDelete = Console.ReadLine();

                if(taskToDelete != "exit")
                {
                    tasks.Remove(taskToDelete);
                    Console.WriteLine(taskToDelete + " deleted successfuly!");
                }
            }
        }
    }
}

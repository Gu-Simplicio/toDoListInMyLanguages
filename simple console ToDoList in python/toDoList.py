tasks = [] #list where the tasks will be inserted

#function that list the tasks saved
def list_tasks():
    if(len(tasks) == 0): #if has no task saved
        print("There's no task saved yet!")
    else: #if has
        #show the tasks
        print("\nTASKS SAVED:")
        for task in tasks:
            print(task)

    show_capture_opt()#reset the program

#function that insert a new task
def insert_task():
    #capture the new task
    new_task = input("Insert your task (type 'exit' to cancel): ")

    #check if the user will exit the function
    if(new_task != "exit"): #if will not exit
        tasks.append(new_task) #insert the new task
        print(f"task '{new_task}' inserted")
    else: #if will exit
        #show that the operation was canceled
        print("\noperation canceled")

    show_capture_opt() #reset the program

def delete_task():
    #capture the task to delete
    task_to_delete = input("Insert the task you want to delete (type 'exit' to cancel): ")

    if(task_to_delete != "exit"): #iff will not exit
        for task in tasks: #loop for that search for the task inserted
            if(task == task_to_delete): #when found the task 
                tasks.remove(task) #remove the task
                print(f"\n{task} removed!") #show the task removed
                break #stop the for
    else: #if will exit
        #show that the operation was canceled
        print("\noperation canceled")

    show_capture_opt() #reset the program

#function that show and capture the options
def show_capture_opt():
    #PRINT THE OPTIONS
    print("\nOptions to select:")

    print("List tasks saved [type 1]") #1 to list tasks
    print("Insert a new task [type 2]") #2 to insert a task 
    print("Delete a task [type 3]") #3 to delete a task
    print("Exit [type 4]") #4 to stop the program

    #variable that will check if the user inserted an wrong number
    wrong = True

    while(wrong): #while wrong == True
        #capture the option
        optionSelected = int(input("Insert the option you want: "))
    
        #check if the option is valid
        if(optionSelected < 0 or optionSelected > 4): #if isn't valid
            wrong = True #wrong == True
            print("INSERT AN VALID NUMBER!")
        else: #if is valid 
            wrong = False #wrong == False

    if(optionSelected == 1): #if the option was 1
        list_tasks() #start the function to list
    elif(optionSelected == 2): #if the option was 2
        insert_task() #start the function to insert
    elif(optionSelected == 3): #if the option was 3
        delete_task() #start the function to delete 
    else: #if the option was 4
        print("Thanks!") #show a message
            
#start the program
show_capture_opt()
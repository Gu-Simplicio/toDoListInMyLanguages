//create a class for the tasks
class Task{
    //constructor of the class, receiving the name and the description
    constructor(name, description){
        //insert the id with the method getNewId
        this.id = this.getNewId();
        this.name = name; //insert the name with the name received
        this.description = description; //insert the description with the description received

        this.saveTask();//already starts the method saveTask()
    }    

    //method that get the new id
    getNewId(){
        //if hasn't any task saved in the localStorage
        if(!localStorage.getItem("tasks")){
            //return the first id
            return 1;
        } else { // have any task saved
            //capture all the tasks saved
            let tasksSaved = JSON.parse(localStorage.getItem("tasks"));
            //capture the last id
            let lastID = tasksSaved[tasksSaved.length - 1].id;

            //return the last id + 1
            return lastID + 1;
        }
    }

    //method that save the task in localStorage
    saveTask(){
        //if has any task already saved
        if(localStorage.getItem("tasks")){
            //capture all the tasks saved
            let tasks = JSON.parse(localStorage.getItem("tasks"));

            //insert the task on the array
            tasks.push(this);
            
            //insert the tasks on localStorage
            localStorage.setItem("tasks", JSON.stringify(tasks))
        } else { //if hasn't any task saved
            //create an array
            let arrayTask = Array();
            //insert this task on the array
            arrayTask.push(this)
            //insert the task on localStorage
            localStorage.setItem("tasks", JSON.stringify(arrayTask));
        }
    }
}

export default Task; //export the class Task
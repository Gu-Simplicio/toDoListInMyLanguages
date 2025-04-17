class Task{
    constructor(name, description){
        this.id = this.getNewId();
        this.name = name;
        this.description = description;

        this.saveTask();
    }    

    getNewId(){
        if(!localStorage.getItem("tasks")){
            return 1;
        } else {
            let tasksSaved = JSON.parse(localStorage.getItem("tasks"));
            let lastID = tasksSaved[tasksSaved.length - 1].id;

            return lastID + 1;
        }
    }

    saveTask(){
        if(localStorage.getItem("tasks")){
            let tasks = JSON.parse(localStorage.getItem("tasks"));

            tasks.push(
                {
                    id: this.id,
                    name: this.name,
                    description: this.description
                }
            );

            localStorage.setItem("tasks", JSON.stringify(tasks))
        } else {
            let taskToSave = {
                id: this.id,
                name: this.name,
                description: this.description
            }

            let arrayTask = Array();
            arrayTask.push(taskToSave)

            localStorage.setItem("tasks", JSON.stringify(arrayTask));
        }
    }
}

export default Task;
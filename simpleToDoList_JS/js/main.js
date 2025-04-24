
import Task from "./Task.js"; //imports the Task object

//function that will insert the tasks in the table
function insertInTable(){
    //a constant that have the tasksTable element
    const tasksTable = document.querySelector("#tasksTable");

    //capture the tasksSaved in the localStorage
    let tasksSaved = JSON.parse(localStorage.getItem("tasks"));

    if(localStorage.getItem("tasks")){ //if already exists tasks saved
        //a forEach that insert a task in each line
        tasksSaved.forEach((task) => {
            //create a tr element
            let tr = document.createElement("tr");
            
            //create the td's elements that will contain the data of the task
            let tdName = document.createElement("td")
            let tdDescription = document.createElement("td")
            let tdExclude = document.createElement("td");
            
            //create a input that will check which task exclude
            let ckExclude = document.createElement("input");

            //insert the text in the td that have just text
            tdName.textContent = task.name;
            tdDescription.textContent = task.description;

            //configure the ckExclude
            ckExclude.type = "checkbox"; //insert the type
            ckExclude.id = task.id; //insert the id (to exclude easily)
            ckExclude.classList.add("btCheck") //insert the class

            //insert ckExlude in tdExclude
            tdExclude.appendChild(ckExclude)

            //insert the td's in the lines
            tr.appendChild(tdName);
            tr.appendChild(tdDescription);
            tr.appendChild(tdExclude);

            //insert the row in the table
            tasksTable.appendChild(tr);
        });
    } else { //if doesn't have any task saved
        //create a h1 element
        const h1 = document.createElement("h1");
        //insert a text in the h1
        h1.textContent = "No tasks to complete yet!";

        //insert the h1 in the table
        tasksTable.appendChild(h1)
    }
}

//capture the form that add a new task
const formAddTask = document.querySelector("#formAddTask");

//insert a function on the submit event of the form
formAddTask.addEventListener("submit", ()=> {
    //create a const with the value of the input taskName
    const taskName = document.querySelector("#taskName").value;
    //create a const with the value of the input taskDescription
    const taskDescription = document.querySelector("#taskDescription").value;

    //create a new Task with the name and description 
    new Task(taskName, taskDescription);
})

//capture the button that exclude a task
const btExcludeTask = document.querySelector("#btExcludeTask");

//insert a click event on the button
btExcludeTask.addEventListener("click", ()=> {
    //capture all the checkboxes with the class .btCheck, transforming in a array
    let checksElements = [...document.querySelectorAll(".btCheck")];
    //make a filter in the checkboxes, capturing just the checkboxes checkeds
    let checkeds = checksElements.filter((check) => check.checked);
    
    //if have more than 0 checkboxes checkeds, and the user really wants to exclude..
    if(checkeds.length > 0 && confirm("Are you sure?")){
        //capture the tasks already saved
        let tasksSaved = JSON.parse(localStorage.getItem("tasks"));
        //remove the tasks from the localStorage
        localStorage.removeItem("tasks");

        //create a array with the tasks to keep
        let tasksToKeep = Array();

        //forEach in the checkboxes checkeds
        checkeds.forEach((check) => {
            //capture the id of the checkbox
            let idToExclude = check.id

            //forEach on the tasks already savede
            tasksSaved.forEach((task, i) => {
                //transform the task with the same id in null
                if(task != null && task.id == idToExclude) {
                    tasksSaved[i] = null
                }
            });
        });

        //forEach in the tasks already saved
        tasksSaved.forEach((task) => {
            //if the task isn't null, insert on tasksToKeep
            if(task != null) tasksToKeep.push(task);
        })

        //if tasksToKeep have more than 0 elements, insert all the array on localStorage
        if(tasksToKeep.length > 0) localStorage.setItem("tasks", JSON.stringify(tasksToKeep));

        location.reload(); //reload the page
    }
});


//constant that contains the input that check all others
const checkAll = document.querySelector("#checkAll")
checkAll.checked = false; //make checkAll false on default
//insert a event listener every time the input changes
checkAll.addEventListener("change", () => {
    //get all the checkboxes
    let checks = document.querySelectorAll(".btCheck");
    
    //create a forEach that make all the checkboxes be equal
    checks.forEach((check) => {
        check.checked = checkAll.checked;
    })
});


insertInTable(); //calls the function insertInTable
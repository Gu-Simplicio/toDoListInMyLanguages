
import Task from "./Task.js"; //imports the Task object

//function that will insert the tasks in the table
function insertInTable(){
    //a constant that have the tasksTable element
    const tasksTable = document.querySelector("#tasksTable");

    //capture the tasksSaved in the localStorage
    let tasksSaved = JSON.parse(localStorage.getItem("tasks"));

    if(localStorage.getItem("tasks")){
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
    } else {
        const h1 = document.createElement("h1");

        h1.textContent = "No tasks to complete yet!";

        tasksTable.appendChild(h1)
    }
}


const formAddTask = document.querySelector("#formAddTask");
formAddTask.addEventListener("submit", ()=> {
    const taskName = document.querySelector("#taskName").value;
    const taskDescription = document.querySelector("#taskDescription").value;

    new Task(taskName, taskDescription);
})

const btExcludeTask = document.querySelector("#btExcludeTask");

btExcludeTask.addEventListener("click", ()=> {
    let checks = document.querySelectorAll(".btCheck")

    let tasksSaved = JSON.parse(localStorage.getItem("tasks"));
    localStorage.removeItem("tasks");

    let tasksToKeep = Array();

    checks.forEach((check) => {
        if(check.checked == true){
            let idToExclude = check.id

            tasksSaved.forEach((task, i) => {
                if(task != null && task.id == idToExclude) {
                    tasksSaved[i] = null
                }
            });
        }
    })

    tasksSaved.forEach((task) => {
        if(task != null) tasksToKeep.push(task);
    })

    if(tasksToKeep.length > 0) localStorage.setItem("tasks", JSON.stringify(tasksToKeep));

    location.reload();
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
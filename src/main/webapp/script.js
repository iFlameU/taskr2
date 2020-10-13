function main() {
    getTasks();
}

function getTasks() {
    const Http = new XMLHttpRequest();
    const url='api/tasks';
    Http.open("GET", url);
    Http.send();

    Http.onreadystatechange = () => {
        if(Http.readyState == 4) {
            if(Http.status == 200) {
                const taskContainer = document.getElementById('tasks-container');
                taskContainer.innerHTML = "";
                JSON.parse(Http.responseText).forEach(task => {
                    taskContainer.innerHTML = taskContainer.innerHTML + createTaskComponent(task);
                });
            }
        }
    }
}

function createTaskComponent(task) {
    return "<p>" + task.name +"</p>";
}

function addTask() {
    const taskName = document.getElementById("task-name").value;

    const Http = new XMLHttpRequest();
    const url='api/tasks';
    Http.open("POST", url, true);
    Http.setRequestHeader("Content-Type", "application/json");
    Http.send( JSON.stringify({name: taskName}));

    Http.onreadystatechange = () => {
        console.log(Http.readyState);
        if(Http.readyState == 4) {
            getTasks();
        }
    }
}
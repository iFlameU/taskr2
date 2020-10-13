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
    return "<div id='task-" + task.id + "'><span>" + task.name +"</span>" +
        "<button onclick='toggleChangeTaskOn(" + task.id + ")'>Change</button></div>" +
        "<div id='change-task-" + task.id + "' hidden>" +
        "<input type='text' id='change-task-name-" + task.id + "' value='" + task.name + "'>" +
        "<button onclick='changeTask(" + task.id + ")'>Change</button>" +
        "<button onclick='toggleChangeTaskOff(" + task.id + ")'>Cancel</button>" +
        "</div>";
}

function addTask() {
    const taskName = document.getElementById("task-name").value;
    document.getElementById("task-name").value = "";

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

function toggleChangeTaskOn(id) {
    document.getElementById("task-" + id).hidden = true;
    document.getElementById("change-task-" + id).hidden = false;
}

function toggleChangeTaskOff(id) {
    document.getElementById("task-" + id).hidden = false;
    document.getElementById("change-task-" + id).hidden = true;
}

function changeTask(id) {
    const taskName = document.getElementById("change-task-name-" + id).value;

    const Http = new XMLHttpRequest();
    const url='api/tasks';
    Http.open("PUT", url, true);
    Http.setRequestHeader("Content-Type", "application/json");
    Http.send( JSON.stringify({id: id, name: taskName}));

    Http.onreadystatechange = () => {
        console.log(Http.readyState);
        if(Http.readyState == 4) {
            getTasks();
        }
    }

    toggleChangeTaskOff(id);
}
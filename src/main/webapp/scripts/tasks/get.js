function getTasks(taskContainer) {
    const Http = new XMLHttpRequest();
    const url='api/tasks';
    Http.open("GET", url);
    Http.send();

    Http.onreadystatechange = () => {
        if(Http.readyState == 4) {
            if(Http.status == 200) {
                console.log(Http.responseText);
            }
        }
    }
}
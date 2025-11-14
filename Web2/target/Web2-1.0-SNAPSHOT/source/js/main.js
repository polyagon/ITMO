var components = {
    x: document.getElementById("X_input"),
    y: document.getElementById("Y_input"),
    r: document.querySelectorAll('input[class="r"]'),
    submit: document.getElementById("check_button"),
    clear: document.getElementById("clear_button")
};

var choosen = {
    x: null,
    y: null,
    r: null
};

// массив попавших точек для каждого радиуса
var pointsContainer = [];
var resultsTable = document.getElementById("results-content");


$(document).ready(function () {
    console.log("get table by session")
    getTableBySession();

    initialize_table(pointsContainer);
    redrawGraph(choosen.r);
});

components.x.addEventListener("change", checkEnteredX);
function checkEnteredX(){
    let xValue = components.x.value;

    if (xValue === "" || xValue === null) {
        selectX.setCustomValidity("Please select X value");
        selectX.reportValidity();
        return false;
    }


    const xMin = -3.0;
    const xMax = 5.0;
    let x = parseFloat(xValue);
    if (isNaN(x) || xMin >= x || x >= xMax) {
        updateSubmitLock();
        return;
    }

    choosen.x = x;
    components.x.setCustomValidity("");
    updateSubmitLock();
    redrawGraph(choosen.r);
}

components.y.onblur = function checkEnteredY(){
    const yMin = -5.0;
    const yMax = 3.0;
    let y = components.y.value;
    let parsedY;
    choosen.y = null;
    console.log("CHECK Y", y)

    if(isNaN(y.trim()) || !y.match('[\-\+]?([0-5]?.[0-9]*)')){
        updateSubmitLock();
        return;
    }
    parsedY = parseFloat(y);
    if (isNaN(parsedY) || yMin >= parsedY || parsedY >= yMax) {
        updateSubmitLock();
        return;
    }
    choosen.y = y;
    updateSubmitLock();
    redrawGraph(choosen.r);
}

components.r.forEach(rd => rd.addEventListener("change", checkEnteredR));
function checkEnteredR(){
    console.log("checkEnteredR");
    choosen.r = null;
    for (let rd of components.r) {
        if (rd.checked){
            choosen.r = rd.value;
        }
    }
    console.log("r=", choosen.r);
    updateSubmitLock();
    redrawGraph();
}

components.submit.addEventListener("click", () => {
    let [x, y, r] = validateAndParse(choosen.x, choosen.y, choosen.r)
    let result = validate_values(x, y, r);
    if (result) {
        sendForm(x, y, r);
    }
});

components.clear.addEventListener("click", () => {
    console.log("send request to clear");
    clean_table();
    console.log("table cleaned");
    //sleep(500);
    //getTableBySession();
    redrawGraph(choosen.r);
});


document.addEventListener('click', (ev)=>this.handleClick(ev));
function handleClick(event) {
    // Получаем координаты точки, куда нажал пользователь
    let x = event.clientX;
    let y = event.clientY;
    let one = 30;

    if (x > canvasRect.left && x < canvasRect.right &&
        y < canvasRect.bottom && y > canvasRect.top) {

        //пересчитываем значения в локальные координаты
        x = (x - canvasRect.left - (canvasRect.width/2))/one;
        y = ((canvasRect.height/2) - y + canvasRect.top)/one;

        //console.log("click point = ", x, y);
        if(choosen.r !== null){
            sendForm(x.toFixed(3).toString(), y.toFixed(3).toString(), choosen.r);
        }

    }
}

function updateSubmitLock(){
    components.submit.disabled = choosen.x == null || choosen.y == null || choosen.r == null;
}
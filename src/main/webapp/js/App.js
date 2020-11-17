const init = () => {
    let documentationButton = document.querySelector("#documentation");
    documentationButton.onclick = addDropDown;
}


const addDropDown = event => {
    let extraInfo = document.getElementById("extraInfo");
    if (extraInfo.style.display === "none") {
        extraInfo.style.display = "block";
    } else {
        extraInfo.style.display = "none";
    }
}

window.onload = init;
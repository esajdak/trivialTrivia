/**
 * module controls logic for Trivia api form submission,
 * @returns {boolean}
 * @constructor
 */
export const TriviaApi = () => {
    event.preventDefault();

    // get search form from dom
    const searchForm = document.getElementById("form-api").elements;

    // create url with params from form elements
    const url = "/TrivialTrivia/api/trivia/request/?" + $.param({
        triviaCategory: searchForm.namedItem("triviaCategory").value,
        triviaAmount: searchForm.namedItem("triviaAmount").value,
        triviaDifficulty: searchForm.namedItem("triviaDifficulty").value,
        triviaType: searchForm.namedItem("triviaType").value,
    });

    // send request for trivia, pass results to results showResults
    fetch(url, {headers: {'Content-type': 'application/json; charset=UTF-8', 'Accept': 'application/json'}})
        .then(response => response.json()) // parse response as json
        .then(data => showResults(data))// pass data to call back function
        .catch(error => alert("Error sending request, try again." + " url: " + url));

    return false;
};

/**
 * grabs template and builds results then outputs to dom
 * @param data
 */
const showResults = data => {
    // build list container
    const elementToAppend = document.querySelector("#resultsContainer");
    const list = document.createElement("ul");
    list.id = "results";
    list.className = "list-unstyled col-12 d-flex flex-wrap my-0 p-0";

    list.appendChild(document.createTextNode("["));

    if (data.map.hasOwnProperty("trivia")) {
        for (const trivia of data.map.trivia) {
            const listItem = document.createElement("li");
            listItem.className = "col-12"
            listItem.textContent = JSON.stringify(trivia);

            list.appendChild(listItem);
        }

        elementToAppend.replaceChild(list, elementToAppend.querySelector("#results"));
    } else if (data.map.hasOwnProperty("error")) {
        alert("Error: " + data.map.error);
    }

    list.appendChild(document.createTextNode("]"));
}

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

document.querySelector("form").addEventListener("submit", TriviaApi);
window.onload = init;
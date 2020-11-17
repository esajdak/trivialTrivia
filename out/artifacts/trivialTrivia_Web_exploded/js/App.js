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
        triviaAmount: searchForm.namedItem("triviaAmount").value,
        triviaCategory: searchForm.namedItem("triviaCategory").value,
        triviaDifficulty: searchForm.namedItem("triviaDifficulty").value,
        triviaType: searchForm.namedItem("triviaType").value,
    });

    // // send request for trivia, pass results to results showResults
    // fetch(url, {headers: {'Content-type': 'application/json; charset=UTF-8', 'Accept': 'application/json'}})
    //     .then(response => response.json()) // parse response as json
    //     .then(data => showResults(data))// pass data to call back function
    //     .catch(error => alert("Error sending request, try again." + " url: " + url));
    const data = "";
    showResults(data)
    return false;
};

/**
 * grabs template and builds results then outputs to dom
 * @param data
 */
const showResults = data => {
    const test_data = {
        triviaObjects: [
            {category: "category", type: "type", difficulty: "difficulty", answer: "answer", question: "question"},
            {category: "category", type: "type", difficulty: "difficulty", answer: "answer", question: "question"},
            {category: "category", type: "type", difficulty: "difficulty", answer: "answer", question: "question"},
        ]
    }

    // build list container
    const elementToAppend = document.querySelector("#resultsContainer");
    const list = document.createElement("ul");
    list.id = "results";
    list.className = "list-unstyled col-12 d-flex flex-wrap my-0 p-0";

    list.appendChild(document.createTextNode("["));

    if (Object.keys(test_data).length > 0) {
        for (const trivia of test_data.triviaObjects) {
            const listItem = document.createElement("li");
            listItem.className = "col-12"
            listItem.textContent = JSON.stringify(trivia);

            list.appendChild(listItem);
        }

        elementToAppend.replaceChild(list, elementToAppend.querySelector("#results"));
    }
    list.appendChild(document.createTextNode("]"));
}


document.querySelector("form").addEventListener("submit", TriviaApi);
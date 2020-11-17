<div><button id="documentation" style="width:100%; border:none; background-color:white; text-decoration:underline; font-size:1em;">Click for Trivia API Documentation</button></div>

<div id="extraInfo" style="display:none; text-align:center;">
    <br>
    <br>
    <h1>How to use this API:</h1>
    <p>
        To use this api you will need to add these query parameters:
        <ul>
            <li>category(optional) <b>use id number</b> - choices: Any Category (no param needed); 9 General Knowledge; 10 Entertainment: Books;
                11 Entertainment: Film; 12 Entertainment: Music; 13 Entertainment: Musicals &amp; Theatres; 14 Entertainment: Television;
                15 Entertainment: Video Games; 16 Entertainment: Board Games; 17 Science &amp; Nature; 18 Science: Computers;
                19 Science: Mathematics; 20 Mythology; 21 Sports; 22 Geography; 23 History; 24 Politics; 25 Art;
                26 Celebrities; 27 Animals; 28 Vehicles; 29 Entertainment: Comics; 30 Science: Gadgets;
                31 Entertainment: Japanese Anime &amp; Manga; 32 Entertainment: Cartoon &amp; Animations
            </li>
            <li>type(optional)- choices: "multiple", "boolean" (true/false), "any" (no param needed)</li>
            <li>difficulty(optional)- choices: "easy", "medium", "hard", "any" (no param needed)</li>
            <li>amount(required)- choices: any number 1 through 50</li>
        </ul>
    </p>
    <p>
        <b>How to use the query parameters with the url:</b><br>
        You will add them onto the end of the url like so /?category=9&type=boolean&difficulty=easy&amount=10<br>
        If you choose to not specify any of the optional parameters all you would need is /?amount= and whatever amount of questions
    </p>
    <p>
        <b>How will the data come back?</b><br>
        After your request is made, the API will return JSON formatted trivia questions and answers. From here you can build this information
        into your webapp and select only the information you'd like to display.
    </p>
    <h1>What this API does:</h1><br>
    <p>This api takes the params entered (from the form locally or from the url with AWS version) and sends a request with those params built onto a base url to return json formatted data like so:</p>
    <p style="margin:auto; border-style:solid; width:50%; text-align:left; padding:1em;">
        [<br>
        {"category":"category","type":"type","difficulty":"difficulty","answer":"answer","question":"question"}<br>
        {"category":"category","type":"type","difficulty":"difficulty","answer":"answer","question":"question"}<br>
        {"category":"category","type":"type","difficulty":"difficulty","answer":"answer","question":"question"}<br>
        ]
    </p>
    <p>
        If you select a specific category, all categories will be the same. If any is selected you will get a random set of categories.<br>
        Type and Difficulty will act the same as described for category.
    </p>
    <br>
    <b>To use this API you will need to fill out the form: </b><br><br>
    For number of questions you can choose a number 1 through 50. <br>
    You can choose any of the options for category, or by choosing "any" you will be returned random categories. <br>
    When choosing difficulty you can choose easy, medium, hard, or any. Again, any will return a random difficulty level of questions. <br>
    Lastly, you may choose to receieve multiple choice or true/false questions. If you pick any, you will receive a combination of both. <br><br>

    After submitting the form, it will return JSON formatted trivia questions and answers. From here you can build this information
    into your webapp and select only the information you'd like to display.
</div>
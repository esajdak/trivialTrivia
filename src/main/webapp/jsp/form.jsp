<div class="p-3">
    <form action="#" method="post" id="form-api" class="border p-2">
        <fieldset>
            <legend class="text-center">Api Results</legend>

            <div class="form-group">
                <label for="trivia-amount">Number of Questions:</label>
                <input type="number" name="triviaAmount" id="trivia-amount" class="form-control" min="1" max="50" value="10">
            </div>

            <div class="form-group">
                <label for="trivia-category">Select Category: </label>
                <select name="triviaCategory" id="trivia-category" class="form-control">
                    <option value="">Any Category</option>
                    <option value="9">General Knowledge</option>
                    <option value="10">Entertainment: Books</option>
                    <option value="11">Entertainment: Film</option>
                    <option value="12">Entertainment: Music</option>
                    <option value="13">Entertainment: Musicals &amp; Theatres</option>
                    <option value="14">Entertainment: Television</option>
                    <option value="15">Entertainment: Video Games</option>
                    <option value="16">Entertainment: Board Games</option>
                    <option value="17">Science &amp; Nature</option>
                    <option value="18">Science: Computers</option>
                    <option value="19">Science: Mathematics</option>
                    <option value="20">Mythology</option>
                    <option value="21">Sports</option>
                    <option value="22">Geography</option>
                    <option value="23">History</option>
                    <option value="24">Politics</option>
                    <option value="25">Art</option>
                    <option value="26">Celebrities</option>
                    <option value="27">Animals</option>
                    <option value="28">Vehicles</option>
                    <option value="29">Entertainment: Comics</option>
                    <option value="30">Science: Gadgets</option>
                    <option value="31">Entertainment: Japanese Anime &amp; Manga</option>
                    <option value="32">Entertainment: Cartoon &amp; Animations</option>
                </select>
            </div>

            <div class="form-group">
                <label for="trivia-difficulty">Select Difficulty: </label>
                <select name="triviaDifficulty" id="trivia-difficulty" class="form-control">
                    <option value="">Any Difficulty</option>
                    <option value="easy">Easy</option>
                    <option value="medium">Medium</option>
                    <option value="hard">Hard</option>
                </select>
            </div>

            <div class="form-group">
                <label for="trivia-type">Select Type: </label>
                <select name="triviaType" id="trivia-type" class="form-control">&gt;
                    <option value="">Any Type</option>
                    <option value="multiple">Multiple Choice</option>
                    <option value="boolean">True / False</option>
                </select>
            </div>
        </fieldset>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Get Trivia</button>
    </form>
</div>

<div class="p-3 my-1">
    <section class="border rounded shadow p-3 bg-light" id="resultsContainer">
        <ul class="list-unstyled col-12 d-flex flex-wrap my-0 p-0" id="results">
        </ul>
    </section>
</div>

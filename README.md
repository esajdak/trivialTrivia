# Project Planning


## App Flow


### Classes
* Trivia
    * Properties
        * String question
        * String category
        * String type
        * String difficulty
        * String answer
    * Methods:
        * getters/setters

* TriviaDao
    * Properties
        * Properties properties
    * Methods:
        * validate()
        * requestTriviaObject()
            * Load in url from properties
            * Send request 
            * Process response
            * Object map
            * Return collection of TriviaObjects

* Request Service Class
    * Properties:
    * Methods:
        * validate()
        * getTriviaObject()
            * Return response

### Testing
* TriviaDaoTestClass
    * methods:
* RequestServiceTestClass
    * methods:


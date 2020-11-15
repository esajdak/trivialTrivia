<%--
  User: Elizabeth Sajdak
  Date: 11/15/20
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trivia API</title>
</head>
<script src="js/documentation.js"></script>
<body>
    <div><button id="documentation">Click for Trivia API Documentation</button></div>

    <div id="extraInfo" style="display:none;">
        To use this API you will need to fill out the form:
        For number of questions you can choose a number 1 through 50.
        You can choose any of the options for category, or by choosing "any" you will be returned random categories.
        When choosing difficulty you can choose easy, medium, hard, or any. Again, any will return a random difficulty level of questions.
        Lastly, you may choose to receieve multiple choice or true/false questions. If you pick any, you will receive a combination of both.

        After submitting the form, it will return JSON formatted trivia questions and answers. From here you can build this information
        into your webapp and select only the information you'd like to display.
    </div>
</body>
</html>

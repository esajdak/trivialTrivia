package com.trivialTrivia.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriviaApiTest {

    @Test
    void testGetTrivia() {
        TriviaApi triviaApi = new TriviaApi();

        triviaApi.getTrivia("9", "multiple", "medium", "10");
    }
}
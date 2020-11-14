package java.com.trivialTrivia.api;

import com.trivialTrivia.api.TriviaApi;
import com.trivialTrivia.entity.Trivia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Trivia api test.
 */
class TriviaApiTest {

    TriviaApi triviaApi;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        triviaApi = new TriviaApi();
    }

    /**
     * Test get trivia.
     */
    @Test
    void testGetTrivia() {
        Trivia[] triviaSet = triviaApi.getTrivia("", "multiple", "medium", "10");

        assertEquals(10, triviaSet.length);
    }

    /**
     * Gets all categories.
     */
    @Test
    void getAllCategories() {
        assertEquals(24, triviaApi.getAllCategories().length);
    }
}
package com.trivialTrivia.persistence;

import com.trivialTrivia.entity.Trivia;
import jdk.jfr.ContentType;
import org.junit.jupiter.api.Test;
import java.util.*;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.*;

class TriviasTest {

    /**
     * Gets trivias success.
     */
    @Test
    void getTriviasSuccess() {
        Trivias trivias = new Trivias();
        Response response = trivias.getTrivias("any","10", "easy", "multiple");
        assertNotNull(response);
    }
}
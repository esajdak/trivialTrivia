package com.trivialTrivia.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trivialTrivia.entity.Category;
import com.trivialTrivia.entity.Trivia;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;
import util.PropertiesLoader;

/**
 * The type Trivia api.
 */
public class TriviaApi implements PropertiesLoader {

    private final Logger logger = LogManager.getLogger(this.getClass());
    protected Properties properties;

    /**
     * Gets all categories.
     *
     * @return the all categories
     */
    public Category[] getAllCategories() {
        properties = this.loadProperties("/api.properties");
        String url = properties.getProperty("trivia.url.base") + properties.getProperty("trivia.url.addon.categories.all");

        WebTarget target = ClientBuilder.newClient().target(url);

        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        //json object
        JSONArray categoriesJson = responseToJsonArray(response,"trivia_categories");

        Category[] categories = null;

        //try to convert response to category array catch json processing exception
        try {
            //map location, location.locationCategories, location.locationAddresses
            categories = createObjectMapper().readValue(categoriesJson.toString(), Category[].class);

            for (Object trivia : categories) { logger.info(trivia.toString()); }
        } catch (JsonProcessingException e) {
            logger.error("Trivia request error:", e);
        }

        logger.info("size: " + categories.length);

        return categories;
    }

    /**
     * make request to trivia api using category, number of questions and type
     * returns collection of trivia objects
     *
     * @param categoryId   the category id
     * @param questionType the question type
     * @param difficulty   the difficulty
     * @param amount       the amount
     * @return array list of trivia objects
     */
    public Trivia[] getTrivia(String categoryId, String questionType, String difficulty, String amount) {

        WebTarget target = buildRequestTarget(categoryId, questionType, difficulty, amount);

        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        //json object
        JSONArray questions = responseToJsonArray(response,"results");

        Trivia[] triviaSet = null;

        //try to convert response to trivia array catch json processing exception
        try {
            //map location, location.locationCategories, location.locationAddresses
            triviaSet = createObjectMapper().readValue(questions.toString(), Trivia[].class);
        } catch (JsonProcessingException e) {
            logger.error("Trivia request error:", e);
        }

        return triviaSet;
    }

    /**
     * takes params needed for a trivia request and returns a web target with the params
     *
     * @param category category for question
     * @param questionType type of question answer
     * @param difficulty difficulty of question
     * @param amount amount of questions
     * @return webtarget url
     */
    private WebTarget buildRequestTarget(String category, String questionType, String difficulty, String amount) {
        properties = this.loadProperties("/api.properties");
        String url = properties.getProperty("trivia.url.base") + properties.getProperty("trivia.url.addon.questions");

        Client client = ClientBuilder.newClient();

        return client.target(url)
            .queryParam(properties.getProperty("trivia.url.addon.amount"), amount)
            .queryParam(properties.getProperty("trivia.url.addon.difficulty"), difficulty)
            .queryParam(properties.getProperty("trivia.url.addon.type"), questionType)
            .queryParam(properties.getProperty("trivia.url.addon.categories"), category);
    }

    /**
     * takes string response and collection key value and returns json array
     * @param response string json
     * @param collectionKey name of key of collection in json
     * @return JsonArray
     */
    private JSONArray responseToJsonArray(String response, String collectionKey) {
        return new JSONObject(response).getJSONArray(collectionKey);
    }

    /**
     * instnatiate and return object mapper with ignoring uneeded properties by default and using json array for
     * deserialization
     * @return object mapper
     */
    private ObjectMapper createObjectMapper() {
        return new ObjectMapper().configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

}

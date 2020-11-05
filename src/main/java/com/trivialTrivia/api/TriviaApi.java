package com.trivialTrivia.api;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trivialTrivia.entity.Trivia;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import util.PropertiesLoader;

public class TriviaApi implements PropertiesLoader {
    private final Logger logger = LogManager.getLogger(this.getClass());
    protected Properties properties;

    public ArrayList<String> getAllCategories() {
        ArrayList<String> categories = new ArrayList<>();
        return categories;
    }

    public ArrayList<String> getAllTypes() {
        ArrayList<String> types = new ArrayList<>();
        return types;
    }

    public ArrayList<String> getAllDifficulties() {
        ArrayList<String> difficulties = new ArrayList<>();
        return difficulties;
    }

    /**
     * make request to trivia api using category, number of questions and type
     * returns collection of trivia objects
     * @return array list of trivia objects
     */
    public void getTrivia(String categoryId, String questionType, String difficulty, String amount) {

        String stringRegex = "\\w+";

        WebTarget target = buildRequestTarget(
            Integer.parseInt(categoryId) > 9 && Integer.parseInt(categoryId) < 33 ? categoryId : null,
            questionType.matches(stringRegex) ? questionType : null,
            difficulty.matches(stringRegex) ? difficulty : null,
            Integer.parseInt(amount) > 0 && Integer.parseInt(amount) < 51 ? amount : null
        );

        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        logger.info(target);
        logger.info(response);
//        //json object
//        JSONArray businesses = new JSONObject(response).getJSONArray("businesses");
//
//        genericDao = new GenericDao(Location.class);
//
//        //instantiate and configure object mapper to use java array
//        ObjectMapper mapper = new ObjectMapper();
//
//        //configure mapper to use array and not fail on unused properties
//        mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true)
//                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//
//        Location[] locations = null;
//
//        //try to convert response to GeoSearch array catch json processing exception
//        try {
//            //map location, location.locationCategories, location.locationAddresses
//            locations = mapper.readValue(businesses.toString(), Location[].class);
//
//            //add locations, locationCategories, and locationAdresses to db
//            Arrays.stream(locations).forEach(genericDao::insert);
//        } catch (JsonProcessingException e) {
//            logger.error("GeoSearch request error:", e);
//        }
//
//        return locations;
    }

    private WebTarget buildRequestTarget(String category, String questionType, String difficulty, String amount) {
        properties = this.loadProperties("/api.properties");
        String url = properties.getProperty("trivia.url.base");

        Client client = ClientBuilder.newClient();

        return client.target(url)
            .queryParam(properties.getProperty("trivia.url.addon.amount"), amount)
            .queryParam(properties.getProperty("trivia.url.addon.difficulty"), difficulty)
            .queryParam(properties.getProperty("trivia.url.addon.type"), questionType)
            .queryParam(properties.getProperty("trivia.url.addon.categories"), category);
    }
}

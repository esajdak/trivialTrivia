package com.trivialTrivia.persistence;

import com.trivialTrivia.api.TriviaApi;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.PropertiesLoader;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.Properties;



public class apiDao implements PropertiesLoader {
    private final Logger logger = LogManager.getLogger(this.getClass());
    protected Properties properties;


    public TriviaApi[] getTrivia (String category, String type, String difficulty){
        properties = this.loadProperties("/api.properties");
        String url = properties.getProperty("trivia.url.base");

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url).queryParam();

    }
}

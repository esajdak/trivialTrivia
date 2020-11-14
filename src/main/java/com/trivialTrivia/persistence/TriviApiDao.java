package com.trivialTrivia.persistence;


public class TriviApiDao implements PropertiesLoader {

    private final  Logger logger =LogManager.getLogger(this.getClass());
    protected  Properties properties;


    public Trivia[] getTrivia(String category, String type, String difficulty) {

        properties = this.loadProperties("/api.properties");
        String url = properties.getProperty("trivia.url.base ");

        Client client = ClientBulider,newClient();
        WebTarget target = client.target(url).queryParam("category", category).queryParam("difficulty", difficulty).queryParam("type", type);

        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        //json object
        JSONArray questions = new JSONObject(response).getJSONArray("questions");

        //instantiate and configure object mapper to use java array
        ObjectMapper mapper = new ObjectMapper();

        //configure mapper to use array and not fail on unused properties
        mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


        trivia[] trivias = null;

        try {
            trivias = mapper.readValue(questions.toString(), Trivia[].class);

            Arrays.stream(questions).forEach();
        }catch(JsonProceesingException e){
            logger.error("trivia question request error " +  e)
        }
        return  questions;
    }


}

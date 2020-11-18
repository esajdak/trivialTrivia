package com.trivialTrivia.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter @Setter @NoArgsConstructor
@ToString @EqualsAndHashCode
public class Trivia {

    @JsonProperty("category")
    private String category;
    @JsonProperty("type")
    private String type;
    @JsonProperty("difficulty")
    private String difficulty;
    @JsonProperty("correct_answer")
    private String answer;
    @JsonProperty("question")
    private String question;

}

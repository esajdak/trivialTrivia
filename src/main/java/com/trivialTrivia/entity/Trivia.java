package com.trivialTrivia.entity;

import lombok.*;

@Getter @Setter @NoArgsConstructor
@ToString @EqualsAndHashCode @RequiredArgsConstructor
public class Trivia {

    private int numberOfQuestions;
    private String category;
    private String type;
    private String difficulty;
    private String answer;
    private String question;


}

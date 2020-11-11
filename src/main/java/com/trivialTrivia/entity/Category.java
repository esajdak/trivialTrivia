package com.trivialTrivia.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@Getter @Setter @ToString
@EqualsAndHashCode
public class Category{

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private int id;

}
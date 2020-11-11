package com.trivialTrivia.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter @Setter @ToString
public class Category{

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private int id;

}
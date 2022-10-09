package com.example.demo.Movie.infraestructure.Request;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class MovieRequest {
    private String Title;
    private String Year;
    private String Genre;
    private String Director;
    private String Rating;
}

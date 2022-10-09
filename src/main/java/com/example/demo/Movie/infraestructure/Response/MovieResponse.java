package com.example.demo.Movie.infraestructure.Response;

import com.example.demo.Movie.Domain.Entity.Movie;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class MovieResponse {

    private List<Movie> movieList;
    private BasicResponse basicResponse;
}

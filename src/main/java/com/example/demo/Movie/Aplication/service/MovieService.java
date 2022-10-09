package com.example.demo.Movie.Aplication.service;

import com.example.demo.Movie.infraestructure.Request.MovieRequest;
import com.example.demo.Movie.infraestructure.Response.BasicResponse;
import com.example.demo.Movie.infraestructure.Response.MovieResponse;

public interface MovieService {



    public BasicResponse addUser(MovieRequest request);

    public MovieResponse getAll();

    public MovieResponse getById(String Id);

    public BasicResponse updateMovie(MovieRequest request, String Id);

    public BasicResponse deleteMovie(String id);
}

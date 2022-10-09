package com.example.demo.Movie.Aplication.service;


import com.example.demo.Movie.Domain.Entity.Movie;
import com.example.demo.Movie.infraestructure.Repository.MovieRepository;
import com.example.demo.Movie.infraestructure.Request.MovieRequest;
import com.example.demo.Movie.infraestructure.Response.BasicResponse;
import com.example.demo.Movie.infraestructure.Response.MovieResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Log4j2
@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public BasicResponse addUser(MovieRequest request)
    {
        try {
            movieRepository.save(this.BuildMovieFromRequest(request));
            return BasicResponse.whenSuccess();
        }
        catch(Exception e){
            log.error(e.getMessage());
            return BasicResponse.whenError(e.getMessage());
        }
    }

    @Override
    public MovieResponse getAll()
    {
        List<Movie> personList= movieRepository.findAll();

        if(personList.isEmpty()) {
            return MovieResponse.builder()
                    .movieList(null)
                    .basicResponse(BasicResponse.whenNoDataFound("movie"))
                    .build();
        }

        return MovieResponse.builder()
                .movieList(personList)
                .basicResponse(BasicResponse.whenSuccess())
                .build();
    }

    @Override
    public MovieResponse getById(String Id)
    {
        try{
            Movie movie = movieRepository.findByID(Id);

            if(movie != null){
                return MovieResponse.builder()
                        .movieList(List.of(movie))
                        .basicResponse(BasicResponse.whenSuccess())
                        .build();
            }else{
                return MovieResponse.builder()
                        .movieList(null)
                        .basicResponse(BasicResponse.whenNoDataFound("Movie"))
                        .build();
            }
        }catch(Exception e){
            return MovieResponse.builder()
                    .movieList(null)
                    .basicResponse(BasicResponse.whenError(e.getMessage()))
                    .build();
        }
    }

    @Transactional
    @Override
    public BasicResponse updateMovie(MovieRequest request, String Id)
    {
        try{
            //Validar que exista la moviel dentro de nuestra base de datos
            Movie movie = movieRepository.findByID(Id);

            if(movie == null){
                return BasicResponse.whenNoDataFound("movie con id "+Id);
            }else{
                //Validar que la clave sea correcta


                movie.setTitle(request.getTitle()!=null && !request.getTitle().isBlank() ? request.getTitle() : movie.getTitle());
                movie.setYear(request.getYear()!=null && !request.getYear().isBlank() ? request.getYear() : movie.getYear());
                movie.setGenre(request.getGenre()!=null && !request.getGenre().isBlank() ? request.getGenre() : movie.getGenre());
                movie.setDirector(request.getDirector()!= null && !request.getDirector().isBlank() ? request.getDirector(): movie.getDirector());
                movie.setRating(request.getRating()!= null && !request.getDirector().isBlank() ? request.getDirector():movie.getRating());

                    return BasicResponse.whenSuccess();

            }
        }catch (Exception e){
            return BasicResponse.whenError(e.getMessage());
        }
    }

    public BasicResponse deleteMovie(String id){
        try{
            Movie movie = movieRepository.findByID(id);

            if(movie == null){
                return BasicResponse.whenNoDataFound("movie con id "+id);
            }else{
                movieRepository.delete(movie);
                return BasicResponse.whenSuccess();
            }
        }catch (Exception e){
            return BasicResponse.whenError(e.getMessage());
        }
    }

    public Movie BuildMovieFromRequest (MovieRequest request)
    {
        return Movie.builder()
                .Title(request.getTitle())
                .Year(request.getYear())
                .Genre(request.getGenre())
                .Director(request.getDirector())
                .Rating(request.getRating())
                .build();
    }

}

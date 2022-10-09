package com.example.demo.Movie.infraestructure.Repository;

import com.example.demo.Movie.Domain.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    public Movie findByID(String dni);
}

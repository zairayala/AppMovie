package com.example.demo.Movie.infraestructure.Controller;

import com.example.demo.Movie.Aplication.service.MovieService;
import com.example.demo.Movie.infraestructure.Request.MovieRequest;
import com.example.demo.Movie.infraestructure.Response.BasicResponse;
import com.example.demo.Movie.infraestructure.Response.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;


    @GetMapping
    @RequestMapping("/getall")
    public MovieResponse getAll() { return movieService.getAll();}

    @GetMapping
    @RequestMapping("/getbyId")
    public MovieResponse getById (@RequestParam String Id){return movieService.getById(Id);}

    @GetMapping
    @RequestMapping("/addMovie")
    public ResponseEntity<BasicResponse> addMoive (@RequestBody MovieRequest request)
    {
        BasicResponse response =movieService.addUser(request);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @PutMapping
    @RequestMapping("/updateMovie")
    public ResponseEntity<BasicResponse> updateMovie (@RequestBody MovieRequest request , @RequestParam String id)
    {
        BasicResponse response = movieService.updateMovie(request,id);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @DeleteMapping
    @RequestMapping("/deleteMovie")
    public ResponseEntity<BasicResponse> deleteUser(@RequestParam String id)
    {
        BasicResponse response = movieService.deleteMovie(id);
        return ResponseEntity.status(response.getCode()).body(response);
    }
}

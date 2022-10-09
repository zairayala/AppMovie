package com.example.demo.Movie.Domain.Entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;



@Entity(name="Movie")
@Table(name="tbl_movie",
        uniqueConstraints = {
                @UniqueConstraint(name="movie_ID_unique", columnNames = "ID"),
        })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @SequenceGenerator(
            name ="movie_sequence",
            sequenceName = "movie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator ="movie_sequence"
    )
    @Id
    Long Id;
    String Title;
    String Year;
    String Genre;
    String Director;
    String Rating;


}

package com.kafein.moviemanager.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "MOVIES", uniqueConstraints = {
        @UniqueConstraint(columnNames = "EXT_MOVIE_ID")
})
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MOVIE_ID")
    private long id;
    @Column(name = "EXT_MOVIE_ID")
    private int extMovieId;
    @Column(name = "MOVIE_TITLE")
    private String movieTitle;
    @Column(name = "MOVIE_POSTER_PATH")
    private String moviePosterPath;
}

package com.kafein.moviemanager.repository;

import com.kafein.moviemanager.model.entity.Movies;
import org.springframework.data.repository.CrudRepository;

public interface MoviesRepository extends CrudRepository<Movies,Integer> {
}

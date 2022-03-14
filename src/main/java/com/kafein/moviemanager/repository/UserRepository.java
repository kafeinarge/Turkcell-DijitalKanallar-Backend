package com.kafein.moviemanager.repository;

import com.kafein.moviemanager.model.entity.Movies;
import com.kafein.moviemanager.model.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface UserRepository extends CrudRepository<User,Integer> {

}

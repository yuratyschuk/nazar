package com.project.krutiy_nazar.repository;

import com.project.krutiy_nazar.model.film.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {
    List<Film> findAll();
}
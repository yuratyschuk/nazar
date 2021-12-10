package com.project.krutiy_nazar.repository;

import com.project.krutiy_nazar.model.film.FilmSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmSessionRepository extends CrudRepository<FilmSession, Long> {

    List<FilmSession> findAll();
}
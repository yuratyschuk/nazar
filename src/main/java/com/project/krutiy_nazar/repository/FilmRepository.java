package com.project.krutiy_nazar.repository;

import com.project.krutiy_nazar.model.film.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends PagingAndSortingRepository<Film, Long> {
    Page<Film> findByNameContains(String name, Pageable pageable);
}
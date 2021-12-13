package com.project.krutiy_nazar.service;

import com.project.krutiy_nazar.model.film.Film;
import com.project.krutiy_nazar.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepository filmRepository;

    public Optional<Film> getById(Long id) {
        return filmRepository.findById(id);
    }

    public Long save(Film film) {
        return filmRepository.save(film).getId();
    }

    public Page<Film> findByName(String name, int page, int size) {
        return filmRepository.findByNameContains(name, PageRequest.of(page, size));
    }

    public Page<Film> getAll(int page, int size) {
        return filmRepository.findAll(PageRequest.of(page, size));
    }
}
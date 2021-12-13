package com.project.krutiy_nazar.service;

import com.project.krutiy_nazar.model.film.Film;
import com.project.krutiy_nazar.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepository filmRepository;

    public Page<Film> findByName(String name, int page, int size) {
        return filmRepository.findByNameContains(name, PageRequest.of(page, size));
    }

    public Page<Film> getAll(int page, int size) {
        return filmRepository.findAll(PageRequest.of(page, size));
    }
}
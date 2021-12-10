package com.project.krutiy_nazar.service;

import com.project.krutiy_nazar.model.film.Film;
import com.project.krutiy_nazar.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepository filmRepository;

    public List<Film> getAll() {
        return filmRepository.findAll();
    }

    public Optional<Film> getById(Long id) {
        return filmRepository.findById(id);
    }
}
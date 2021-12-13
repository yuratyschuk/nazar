package com.project.krutiy_nazar.service;

import com.project.krutiy_nazar.model.film.FilmSession;
import com.project.krutiy_nazar.repository.FilmSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilmSessionService {

    private final FilmSessionRepository filmSessionRepository;

    public List<FilmSession> getAll() {
        return filmSessionRepository.findAll();
    }

    public Optional<FilmSession> getById(long id) {
        return filmSessionRepository.findById(id);
    }

    public FilmSession save(FilmSession filmSession) {
        return filmSessionRepository.save(filmSession);
    }

    public void delete(long id) {
        filmSessionRepository.deleteById(id);
    }
}
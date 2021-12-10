package com.project.krutiy_nazar.service;

import com.project.krutiy_nazar.model.film.Film;
import com.project.krutiy_nazar.model.film.FilmSession;
import com.project.krutiy_nazar.repository.FilmSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilmSessionService {

    private final FilmService filmService;
    private final FilmSessionRepository filmSessionRepository;

    public List<FilmSession> getAll() {
        return filmSessionRepository.findAll();
    }

    public Optional<FilmSession> getById(long id) {
        return filmSessionRepository.findById(id);
    }

    public void save(FilmSession filmSession) {
        FilmSession filmSessionToSave = getById(filmSession.getId()).orElse(new FilmSession());
        Film filmToFetch = filmService.getById(filmSession.getFilm().getId()).orElse(null);

        filmSessionToSave.setFilm(filmToFetch);
        filmSessionToSave.setDate(filmSession.getDate());
        filmSessionRepository.save(filmSessionToSave);
    }

    public void delete(long id) {
        filmSessionRepository.deleteById(id);
    }
}
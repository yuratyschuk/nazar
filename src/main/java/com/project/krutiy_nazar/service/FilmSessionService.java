package com.project.krutiy_nazar.service;

import com.project.krutiy_nazar.model.film.Film;
import com.project.krutiy_nazar.model.film.FilmSession;
import com.project.krutiy_nazar.repository.FilmSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Long save(FilmSession filmSession) {
        if(filmSession.getFilm().getId() != 0) {
            Film film = filmService.getById(filmSession.getFilm().getId()).orElse(new Film());
            filmService.save(film);
        }

        return filmSessionRepository.save(filmSession).getId();
    }

    public void delete(long id) {
        filmSessionRepository.deleteById(id);
    }
}
package com.project.krutiy_nazar.controller;

import com.project.krutiy_nazar.model.film.FilmSession;
import com.project.krutiy_nazar.service.FilmSessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Film session controller")
@RestController
@RequiredArgsConstructor
@RequestMapping("/film-session")
public class FilmSessionController {

    private final FilmSessionService filmSessionService;

    @GetMapping("/")
    @ApiOperation(value = "Film session controller", notes = "Get all sessions")
    public List<FilmSession> getAll() {
        return filmSessionService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Film session controller", notes = "Get sessions by id")
    public FilmSession getById(@PathVariable Long id) {
        return filmSessionService.getById(id).orElse(null);
    }

    @PutMapping("/")
    @ApiOperation(value = "Film session controller", notes = "Updates session")
    public Long update(@RequestBody FilmSession filmSession) {
        return filmSessionService.save(filmSession);
    }

    @PostMapping("/")
    @ApiOperation(value = "Film session controller", notes = "Creates film session")
    public Long create(@RequestBody FilmSession filmSession) {
        return filmSessionService.save(filmSession);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Film session controller", notes = "Deletes session using id")
    public void deleteById(@PathVariable Long id) {
        filmSessionService.delete(id);
    }
}
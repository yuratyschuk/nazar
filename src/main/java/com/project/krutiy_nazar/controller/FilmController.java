package com.project.krutiy_nazar.controller;

import com.project.krutiy_nazar.model.film.Film;
import com.project.krutiy_nazar.service.FilmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Film controller")
@RestController
@RequestMapping("/film")
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @GetMapping
    @ApiOperation(value = "Film controller", notes = "Get all films")
    public Page<Film> getAll(@RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "3") int size) {
        return filmService.getAll(page, size);
    }

    @GetMapping("/byName")
    @ApiOperation(value = "Film controller", notes = "Get films that contains parameter as name")
    public Page<Film> filterByName(@RequestParam String name,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "3") int size) {
        return filmService.findByName(name, page, size);
    }

    @PostMapping
    @ApiOperation(value = "Film controller", notes = "Save film")
    public Long create(@RequestBody Film film) {
        return filmService.save(film);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Film controller", notes = "Get film by id")
    public Film getById(@PathVariable Long id) {
        return filmService.getById(id).orElse(null);
    }
}
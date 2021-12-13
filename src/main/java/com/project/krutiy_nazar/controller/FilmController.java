package com.project.krutiy_nazar.controller;

import com.project.krutiy_nazar.model.film.Film;
import com.project.krutiy_nazar.service.FilmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
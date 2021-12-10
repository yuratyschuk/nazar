package com.project.krutiy_nazar.config;

import com.project.krutiy_nazar.repository.FilmRepository;
import com.project.krutiy_nazar.service.FilmService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class ServiceConfig {

    @Bean
    @Scope("prototype")
    public FilmService filmService(FilmRepository filmRepository) {
        return new FilmService(filmRepository);
    }
}
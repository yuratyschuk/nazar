package com.project.krutiy_nazar.controller;

import com.project.krutiy_nazar.model.film.FilmSession;
import com.project.krutiy_nazar.model.film.Place;
import com.project.krutiy_nazar.model.user.User;
import com.project.krutiy_nazar.service.FilmService;
import com.project.krutiy_nazar.service.FilmSessionService;
import com.project.krutiy_nazar.service.PlaceService;
import com.project.krutiy_nazar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class CinemaController {

    private static final String REDIRECT_PATH = "redirect:/";

    private final FilmService filmService;
    private final UserService userService;
    private final PlaceService placeService;
    private final FilmSessionService filmSessionService;

    @GetMapping("/")
    public ModelAndView getIndexPage() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("filmSessionList", filmSessionService.getAll());

        return modelAndView;
    }

    @GetMapping("/session/ticket/{placeId}")
    public ModelAndView getPlacePage(@PathVariable long placeId) {
        ModelAndView modelAndView = new ModelAndView();

        Place place = placeService.getById(placeId).orElse(null);
        if (place == null || !place.isAvailable()) {
            modelAndView.setViewName(REDIRECT_PATH);
            return modelAndView;
        }

        modelAndView.setViewName("place");
        modelAndView.addObject(place);
        return modelAndView;
    }

    @PostMapping("/session/ticket/{placeId}")
    public ModelAndView buyTicket(@PathVariable Long placeId) {
        ModelAndView modelAndView = new ModelAndView(REDIRECT_PATH);

        Place place = placeService.getById(placeId).orElse(null);
        User user = userService.getById(1L).orElse(null);

        if (user == null || place == null || !place.isAvailable()) {
            return modelAndView;
        }

        placeService.processBuying(place, user);
        return modelAndView;
    }

    @GetMapping(value = {"/session/page", "/session/page/{sessionId}"})
    public ModelAndView getEditOrCreatePage(@PathVariable(required = false) String sessionId) {
        ModelAndView modelAndView = new ModelAndView("filmSessionEditCreate");

        FilmSession filmSession;
        if (sessionId == null) {
            filmSession = new FilmSession();
        } else {
            filmSession = filmSessionService.getById(Long.parseLong(sessionId)).orElse(new FilmSession());
        }

        modelAndView.addObject("films", filmService.getAll());
        modelAndView.addObject("filmSession", filmSession);
        return modelAndView;
    }

    @PostMapping("/session/page")
    public ModelAndView editOrCreateFilmSession(@ModelAttribute FilmSession filmSession) {
        filmSessionService.save(filmSession);

        return new ModelAndView(REDIRECT_PATH);
    }

    @GetMapping("/session/delete/{sessionId}")
    public ModelAndView delete(@PathVariable long sessionId) {
        filmSessionService.delete(sessionId);

        return new ModelAndView(REDIRECT_PATH);
    }
}
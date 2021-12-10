package com.project.krutiy_nazar.service;

import com.project.krutiy_nazar.model.film.Place;
import com.project.krutiy_nazar.model.user.User;
import com.project.krutiy_nazar.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class PlaceService {

    private PlaceRepository placeRepository;

    public Optional<Place> getById(long id) {
        return placeRepository.findById(id);
    }

    public void processBuying(Place place, User user) {
        if (!place.isAvailable()) {
            throw new IllegalArgumentException("Place can't be not available");
        }
        BigDecimal balanceAfterPayment = user.getMoney().subtract(BigDecimal.valueOf(place.getPrice()));

        if (balanceAfterPayment.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Not enough money!");
        }

        user.setMoney(balanceAfterPayment);
        place.setAvailable(!place.isAvailable());
        place.setUser(user);

        placeRepository.save(place);
    }

    @Autowired
    public void setPlaceRepository(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }
}
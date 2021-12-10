package com.project.krutiy_nazar.repository;

import com.project.krutiy_nazar.model.film.Place;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Long> {
}
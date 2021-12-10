package com.project.krutiy_nazar.model.film;

import com.project.krutiy_nazar.model.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String cinemaHall;

    @Column(nullable = false)
    private int numberOfThePlace;

    @Column(nullable = false)
    private int numberOfTheRow;

    private int price;

    @ManyToOne
    @ToString.Exclude
    private FilmSession filmSession;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private boolean available;
}
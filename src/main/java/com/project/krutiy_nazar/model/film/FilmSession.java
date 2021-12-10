package com.project.krutiy_nazar.model.film;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class FilmSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime date;

    @ManyToOne
    @ToString.Exclude
    private Film film = new Film();

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "film_session_id")
    private List<Place> placeList;
}
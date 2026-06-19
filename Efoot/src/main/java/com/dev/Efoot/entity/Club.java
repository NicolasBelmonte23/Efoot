package com.dev.Efoot.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "club_seq")
    @SequenceGenerator(name= "club_seq", sequenceName = "club_seq", allocationSize = 1)
    private Long id;
    private String name;
    private LocalDate founded;
    private String urlImg;
    @OneToOne
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;

    @OneToMany(mappedBy = "club")
    private List<Player> players;
}

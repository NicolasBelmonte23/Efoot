package com.dev.Efoot.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class Scope {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "scope_seq")
    @SequenceGenerator(name= "scope_seq", sequenceName = "scope_seq", allocationSize = 1)
    private Long id;
    private String name;

}

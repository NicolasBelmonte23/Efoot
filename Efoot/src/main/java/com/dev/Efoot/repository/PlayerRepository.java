package com.dev.Efoot.repository;

import com.dev.Efoot.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {


    List<Player> findClubById(Long id);
}

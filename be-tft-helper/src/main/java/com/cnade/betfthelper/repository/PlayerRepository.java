package com.cnade.betfthelper.repository;

import com.cnade.betfthelper.entity.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Optional<Player> findByPlayerName(String playerName);

}

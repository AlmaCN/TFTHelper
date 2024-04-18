package com.cnade.betfthelper.repository;

import com.cnade.betfthelper.entity.dto.MatchWithCompsDTOOut;
import com.cnade.betfthelper.entity.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Integer> {
    List<Match> findByPlayer_PlayerName(String playerName);

}

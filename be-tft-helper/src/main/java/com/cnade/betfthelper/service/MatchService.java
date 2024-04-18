package com.cnade.betfthelper.service;

import com.cnade.betfthelper.entity.model.Match;
import com.cnade.betfthelper.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public void save(Match match) {
        matchRepository.save(match);
    }

    public List<Match> findByPlayerName(String playerName) {
        return matchRepository.findByPlayer_PlayerName(playerName);
    }

}

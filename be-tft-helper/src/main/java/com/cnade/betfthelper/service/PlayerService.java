package com.cnade.betfthelper.service;

import com.cnade.betfthelper.entity.dto.PlayerDTOIn;
import com.cnade.betfthelper.entity.model.Player;
import com.cnade.betfthelper.exception.PlayerAlreadyPresentException;
import com.cnade.betfthelper.exception.PlayerNameAlreadyTaken;
import com.cnade.betfthelper.exception.PlayerNotFoundException;
import com.cnade.betfthelper.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public void save(PlayerDTOIn playerDTOIn) {
        Optional<Player> optionalPlayer = playerRepository.findByPlayerName(playerDTOIn.getName());
        if(optionalPlayer.isPresent()) {
            throw new PlayerAlreadyPresentException();
        }
        Player player = new Player();
        player.setPlayerName(playerDTOIn.getName());
        player.setLeague(playerDTOIn.getLeague());
        player.setLeagueTier(playerDTOIn.getLeagueTier());
        player.setLpPlayer(playerDTOIn.getLp());
        playerRepository.save(player);
    }

    public void saveModel(Player player) {
        playerRepository.save(player);
    }

    public Player findByPlayerName(String name) {
        Optional<Player> optionalPlayer = playerRepository.findByPlayerName(name);
        if(optionalPlayer.isEmpty()) {
            throw new PlayerNotFoundException();
        } else {
            return optionalPlayer.get();
        }
    }

    public Player findById(Integer id) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if(optionalPlayer.isEmpty()) {
            throw new PlayerNotFoundException();
        } else {
            return optionalPlayer.get();
        }
    }

    public boolean findName(String name) {
        Optional<Player> optionalPlayer = playerRepository.findByPlayerName(name);
        return optionalPlayer.isPresent();
    }

}

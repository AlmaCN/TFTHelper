package com.cnade.betfthelper.command;

import com.cnade.betfthelper.entity.dto.MatchDTOIn;
import com.cnade.betfthelper.entity.model.Comp;
import com.cnade.betfthelper.entity.model.Match;
import com.cnade.betfthelper.entity.model.Player;
import com.cnade.betfthelper.entity.resource.LeagueResource;
import com.cnade.betfthelper.service.CompService;
import com.cnade.betfthelper.service.MatchService;
import com.cnade.betfthelper.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CreateMatchCommand {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private CompService compService;
    @Autowired
    private MatchService matchService;

    private final MatchDTOIn matchDTOIn;

    CreateMatchCommand(MatchDTOIn matchDTOIn) {
        this.matchDTOIn = matchDTOIn;
    }

    public LeagueResource doExecute() {
        Player player = playerService.findByPlayerName(matchDTOIn.getPlayerName());
        int lp;
        String league = player.getLeague();
        int tier = player.getLeagueTier();
        Comp comp = compService.findByCompName(matchDTOIn.getCompName());
        int winsNumber = comp.getWins();
        if(matchDTOIn.isVictory()) {
            lp = player.getLpPlayer() + matchDTOIn.getLpMatch();
            winsNumber++;
        } else {
            lp = player.getLpPlayer() + matchDTOIn.getLpMatch();
        }

        if(lp >= 100) {
            if(tier != 0) {
                tier--;
                lp = lp - 100;
            }
            if(tier == 0){
                tier = 4;
                league = switch (league) {
                    case "Iron" -> "Bronze";
                    case "Bronze" -> "Silver";
                    case "Silver" -> "Gold";
                    case "Gold" -> "Platinum";
                    case "Platinum" -> "Emerald";
                    case "Emerald" -> "Diamond";
                    case "Diamond" -> "Master";
                    case "Master" -> "GrandMaster";
                    case "GrandMaster" -> "Challenger";
                    default -> league;
                };
            }
        }

        if(player.getLpPlayer() == 0 && !matchDTOIn.isVictory()) {
            if(tier != 0) {
                tier = tier + 1;
            }
        }

        player.setLeague(league);
        player.setLpPlayer(lp);
        player.setLeagueTier(tier);
        playerService.saveModel(player);
        comp.setWins(winsNumber);
        compService.save(comp);
        Match match = new Match();
        match.setVictory(matchDTOIn.isVictory());
        match.setLpMatch(matchDTOIn.getLpMatch());
        match.setComp(comp);
        match.setPlayer(player);
        matchService.save(match);

        LeagueResource leagueResource = new LeagueResource();
        leagueResource.setPlayerName(player.getPlayerName());
        leagueResource.setLeague(league);
        leagueResource.setLeagueTier(tier);
        leagueResource.setLpPlayer(lp);
        return leagueResource;
    }

}

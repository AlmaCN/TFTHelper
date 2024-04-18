package com.cnade.betfthelper.command;

import com.cnade.betfthelper.entity.dto.FirstMatchDTOIn;
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
public class CreateFirstMatchCommand {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private CompService compService;
    @Autowired
    private MatchService matchService;

    private final FirstMatchDTOIn firstMatchDTOIn;

    CreateFirstMatchCommand(FirstMatchDTOIn firstMatchDTOIn) {
        this.firstMatchDTOIn = firstMatchDTOIn;
    }

    public LeagueResource doExecute() {
        Player player = playerService.findByPlayerName(firstMatchDTOIn.getPlayerName());
        String league = player.getLeague();
        int tier = player.getLeagueTier();
        Comp comp = compService.findByCompName(firstMatchDTOIn.getCompName());
        int winsNumber = comp.getWins();
        if(firstMatchDTOIn.isVictory()) {
            winsNumber++;
        }
        player.setLeague(firstMatchDTOIn.getLeague());
        player.setLpPlayer(firstMatchDTOIn.getLpMatch());
        player.setLeagueTier(firstMatchDTOIn.getLeagueTier());
        playerService.saveModel(player);
        comp.setWins(winsNumber);
        compService.save(comp);
        Match match = new Match();
        match.setVictory(firstMatchDTOIn.isVictory());
        match.setLpMatch(firstMatchDTOIn.getLpMatch());
        match.setComp(comp);
        match.setPlayer(player);
        matchService.save(match);

        LeagueResource leagueResource = new LeagueResource();
        leagueResource.setPlayerName(player.getPlayerName());
        leagueResource.setLeague(firstMatchDTOIn.getLeague());
        leagueResource.setLeagueTier(firstMatchDTOIn.getLeagueTier());
        leagueResource.setLpPlayer(firstMatchDTOIn.getLpMatch());
        return leagueResource;
    }

}

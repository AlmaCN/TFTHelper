package com.cnade.betfthelper.command;

import com.cnade.betfthelper.entity.model.Comp;
import com.cnade.betfthelper.entity.model.Match;
import com.cnade.betfthelper.entity.model.Player;
import com.cnade.betfthelper.entity.resource.MatchResource;
import com.cnade.betfthelper.entity.resource.PlayerMatchCompResource;
import com.cnade.betfthelper.factory.MatchFactory;
import com.cnade.betfthelper.service.CompService;
import com.cnade.betfthelper.service.MatchService;
import com.cnade.betfthelper.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GetPlayerMatchCompCommand {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private CompService compService;
    @Autowired
    private MatchService matchService;

    private final String playerName;

    GetPlayerMatchCompCommand(String playerName) {
        this.playerName = playerName;
    }

    public PlayerMatchCompResource doExecute() {
        Player player = playerService.findByPlayerName(playerName);

        List<Match> matches = matchService.findByPlayerName(playerName);
        matches.forEach(m -> m.setComp(compService.findByPlayerNameAndMatchId(player.getPlayerName(), m.getMatchId())));

        List<MatchResource> matchResources = new ArrayList<>();
        for (Match match : matches) {
            matchResources.add(MatchFactory.fromMatchModelToMatchResource(match));
        }

        PlayerMatchCompResource pmcr = new PlayerMatchCompResource();
        pmcr.setPlayerName(player.getPlayerName());
        pmcr.setLeague(player.getLeague());
        pmcr.setLpPlayer(player.getLpPlayer());
        pmcr.setMatches(matchResources);

        return pmcr;
    }

}

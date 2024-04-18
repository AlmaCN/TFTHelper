package com.cnade.betfthelper.factory;

import com.cnade.betfthelper.entity.model.Match;
import com.cnade.betfthelper.entity.resource.MatchResource;
import org.springframework.stereotype.Service;

@Service
public class MatchFactory {

    public static MatchResource fromMatchModelToMatchResource(Match match) {
        return new MatchResource(match.isVictory(),
                CompFactory.fromModelToResource(match.getComp()));
    }

}

package com.cnade.betfthelper.command;

import com.cnade.betfthelper.entity.model.Comp;
import com.cnade.betfthelper.entity.model.Player;
import com.cnade.betfthelper.entity.resource.CompResource;
import com.cnade.betfthelper.entity.resource.PlayerResource;
import com.cnade.betfthelper.mapper.CompMapper;
import com.cnade.betfthelper.service.CompService;
import com.cnade.betfthelper.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GetPlayerByIdWithCompsCommand {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private CompService compService;

    private final Integer id;
    @Autowired
    private CompMapper compMapper;

    GetPlayerByIdWithCompsCommand(Integer id) {
        this.id = id;
    }

    public PlayerResource doExecute() {
        Player player = playerService.findById(id);
        PlayerResource res = new PlayerResource();
        res.setPlayerName(player.getPlayerName());
        res.setLeague(player.getLeague());
        res.setLpPlayer(player.getLpPlayer());
        List<Comp> comps = compService.findByPlayerName(player.getPlayerName());
        List<CompResource> compResources = comps.stream().map(compMapper::toCompResource).toList();
        res.setComps(compResources);
        return res;
    }

}

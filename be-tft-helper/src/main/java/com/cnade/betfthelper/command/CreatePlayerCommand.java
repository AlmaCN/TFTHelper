package com.cnade.betfthelper.command;

import com.cnade.betfthelper.entity.dto.PlayerDTOIn;
import com.cnade.betfthelper.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CreatePlayerCommand {

    @Autowired
    private PlayerService playerService;

    public void doExecute(PlayerDTOIn playerDTOIn) {
        playerService.save(playerDTOIn);
    }

}

package com.cnade.betfthelper.command;

import com.cnade.betfthelper.exception.PlayerNameAlreadyTaken;
import com.cnade.betfthelper.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ValidateNameCommand {

    @Autowired
    private PlayerService playerService;
    private final String name;

    ValidateNameCommand(String name) {
        this.name = name;
    }

    public String doExecute() {
        boolean isTaken = playerService.findName(name);
        if(!isTaken) {
            return "Name available";
        } else {
            throw new PlayerNameAlreadyTaken();
        }
    }

}

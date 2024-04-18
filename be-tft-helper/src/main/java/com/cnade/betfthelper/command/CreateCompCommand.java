package com.cnade.betfthelper.command;

import com.cnade.betfthelper.entity.dto.CompDTOIn;
import com.cnade.betfthelper.entity.model.Comp;
import com.cnade.betfthelper.entity.model.Player;
import com.cnade.betfthelper.service.CompService;
import com.cnade.betfthelper.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CreateCompCommand {

    @Autowired
    private CompService compService;
    @Autowired
    private PlayerService playerService;

    private final CompDTOIn compDTOIn;

    CreateCompCommand(CompDTOIn compDTOIn) {
        this.compDTOIn = compDTOIn;
    }

    public void doExecute() {
        Comp comp = new Comp();
        comp.setCompName(compDTOIn.getCompName());
        comp.setStartChamp1(compDTOIn.getStartChamps().get(0));
        comp.setStartChamp2(compDTOIn.getStartChamps().get(1));
        comp.setStartChamp3(compDTOIn.getStartChamps().get(2));
        comp.setStartChamp4(compDTOIn.getStartChamps().get(3));
        comp.setActiveOnM(true);
        comp.setTier(compDTOIn.getTier());
        Player player = playerService.findByPlayerName(compDTOIn.getPlayerName());
        comp.setPlayer(player);
        compService.save(comp);
    }

}

package com.cnade.betfthelper.factory;

import com.cnade.betfthelper.entity.model.Comp;
import com.cnade.betfthelper.entity.resource.CompResource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompFactory {

    public static CompResource fromModelToResource(Comp comp) {
        CompResource compResource = new CompResource();
        compResource.setCompName(comp.getCompName());
        List<String> champs = new ArrayList<>();
        champs.add(comp.getStartChamp1());
        champs.add(comp.getStartChamp2());
        champs.add(comp.getStartChamp3());
        champs.add(comp.getStartChamp4());
        compResource.setStartChamps(champs);
        compResource.setActiveOnM(comp.isActiveOnM());
        compResource.setWins(comp.getWins());
        compResource.setTier(comp.getTier());
        return compResource;
    }

}

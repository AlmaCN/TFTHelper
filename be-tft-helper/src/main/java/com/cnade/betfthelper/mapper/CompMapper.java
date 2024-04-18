package com.cnade.betfthelper.mapper;

import com.cnade.betfthelper.entity.model.Comp;
import com.cnade.betfthelper.entity.resource.CompResource;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CompMapper {
    @Mapping(target = "compName", source = "compName")
    @Mapping(target = "startChamps", source = "comp", qualifiedByName = "getStartChamps")
    @Mapping(target = "activeOnM", source = "activeOnM")
    @Mapping(target = "wins", source = "wins")
    @Mapping(target = "tier", source = "tier")
    CompResource toCompResource(Comp comp);

    @Named("getStartChamps")
    @BeanMapping(ignoreByDefault = true)
    default List<String> getStartChamps(Comp comp) {
        List<String> champs = new ArrayList<>();
        champs.add(comp.getStartChamp1());
        champs.add(comp.getStartChamp2());
        champs.add(comp.getStartChamp3());
        champs.add(comp.getStartChamp4());
        return champs;
    }

}

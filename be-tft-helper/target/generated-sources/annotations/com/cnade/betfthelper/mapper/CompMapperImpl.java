package com.cnade.betfthelper.mapper;

import com.cnade.betfthelper.entity.model.Comp;
import com.cnade.betfthelper.entity.resource.CompResource;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-29T15:41:18+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Eclipse Adoptium)"
)
@Component
public class CompMapperImpl implements CompMapper {

    @Override
    public CompResource toCompResource(Comp comp) {
        if ( comp == null ) {
            return null;
        }

        CompResource compResource = new CompResource();

        compResource.setCompName( comp.getCompName() );
        compResource.setStartChamps( getStartChamps( comp ) );
        compResource.setActiveOnM( comp.isActiveOnM() );
        compResource.setWins( comp.getWins() );
        compResource.setTier( comp.getTier() );

        return compResource;
    }
}

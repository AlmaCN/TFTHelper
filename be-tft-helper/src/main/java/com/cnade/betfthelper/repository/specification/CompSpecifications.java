package com.cnade.betfthelper.repository.specification;


import com.cnade.betfthelper.entity.dto.GetAllCompsDTO;
import com.cnade.betfthelper.entity.model.Comp;
import com.cnade.betfthelper.util.Utility;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

public class CompSpecifications {

    public static Specification<Comp> buildForComp(GetAllCompsDTO dto) {
        Specification<Comp> spec = Specification.where(null);
        if(!ObjectUtils.isEmpty(dto.getPlayerName())) {
            spec = spec.and(Utility.equalsSpecification("player", "playerName", dto.getPlayerName()));
        }
        return spec;
    }

}

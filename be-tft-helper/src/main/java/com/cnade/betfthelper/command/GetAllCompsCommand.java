package com.cnade.betfthelper.command;

import com.cnade.betfthelper.entity.dto.GetAllCompsDTO;
import com.cnade.betfthelper.entity.model.Comp;
import com.cnade.betfthelper.entity.resource.CompResource;
import com.cnade.betfthelper.exception.CompNotFoundException;
import com.cnade.betfthelper.mapper.CompMapper;
import com.cnade.betfthelper.service.CompService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GetAllCompsCommand {

    @Autowired
    private CompService compService;
    @Autowired
    private CompMapper compMapper;

    private final Pageable pageable;
    private final GetAllCompsDTO dto;

    GetAllCompsCommand(GetAllCompsDTO dto, Pageable pageable) {
        this.dto = dto;
        this.pageable = pageable;
    }

    public Page<CompResource> doExecute() {
        Page<Comp> page = compService.getAllComps(dto, pageable);
        if(page.isEmpty()) {
            throw new CompNotFoundException();
        }
        List<CompResource> compResources = page.map(compMapper::toCompResource).toList();
        return new PageImpl<>(compResources, pageable, page.getTotalPages());
    }

}

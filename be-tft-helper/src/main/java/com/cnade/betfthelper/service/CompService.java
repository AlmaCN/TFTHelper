package com.cnade.betfthelper.service;

import com.cnade.betfthelper.entity.dto.GetAllCompsDTO;
import com.cnade.betfthelper.entity.model.Comp;
import com.cnade.betfthelper.entity.resource.CompResource;
import com.cnade.betfthelper.exception.CompNotFoundException;
import com.cnade.betfthelper.mapper.CompMapper;
import com.cnade.betfthelper.repository.CompRepository;
import com.cnade.betfthelper.repository.specification.CompSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompService {

    @Autowired
    private CompRepository compRepository;

    public void save(Comp comp) {
        compRepository.save(comp);
    }

    public List<Comp> findByPlayerName(String name) {
        return compRepository.findByPlayer_PlayerName(name);
    }

    public Page<Comp> getAllComps(GetAllCompsDTO dto, Pageable pageable) {
        Specification<Comp> spec = CompSpecifications.buildForComp(dto);
        return compRepository.findAll(spec, pageable);
    }

    public Comp findByCompName(String compName) {
        Optional<Comp> optionalComp = compRepository.findByCompName(compName);
        if(optionalComp.isEmpty()) {
            throw new CompNotFoundException();
        } else {
            return optionalComp.get();
        }
    }

    public Comp findByPlayerNameAndMatchId(String playerName, Integer matchId) {
        Optional<Comp> optionalComp = compRepository.findByPlayer_PlayerNameAndMatches_MatchId(playerName, matchId);
        if(optionalComp.isEmpty()) {
            throw new CompNotFoundException();
        } else {
            return optionalComp.get();
        }
    }

}

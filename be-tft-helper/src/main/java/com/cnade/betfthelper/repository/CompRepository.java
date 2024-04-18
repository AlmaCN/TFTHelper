package com.cnade.betfthelper.repository;

import com.cnade.betfthelper.entity.model.Comp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface CompRepository extends JpaRepository<Comp, Integer>, JpaSpecificationExecutor<Comp> {

    List<Comp> findByPlayer_PlayerName(String playerName);

    Optional<Comp> findByCompName(String compName);

    Optional<Comp> findByPlayer_PlayerNameAndMatches_MatchId(String playerName, Integer matchId);


}

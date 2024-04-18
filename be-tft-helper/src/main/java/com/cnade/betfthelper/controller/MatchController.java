package com.cnade.betfthelper.controller;

import com.cnade.betfthelper.command.CreateFirstMatchCommand;
import com.cnade.betfthelper.command.CreateMatchCommand;
import com.cnade.betfthelper.entity.dto.FirstMatchDTOIn;
import com.cnade.betfthelper.entity.dto.MatchDTOIn;
import com.cnade.betfthelper.entity.resource.LeagueResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private BeanFactory beanFactory;

    @PostMapping("/create-first")
    @Operation(summary = "Create first match")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Match created")
    })
    public ResponseEntity<LeagueResource> createFirstMatch(@RequestBody FirstMatchDTOIn firstMatchDTOIn) {
        LeagueResource leagueResource = beanFactory.getBean(CreateFirstMatchCommand.class, firstMatchDTOIn).doExecute();
        return ResponseEntity.status(HttpStatus.CREATED).body(leagueResource);
    }

    @PostMapping("/create")
    @Operation(summary = "Create new match")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Match created")
    })
    public ResponseEntity<LeagueResource> createMatch(@RequestBody MatchDTOIn matchDTOIn) {
        LeagueResource leagueResource = beanFactory.getBean(CreateMatchCommand.class, matchDTOIn).doExecute();
        return ResponseEntity.status(HttpStatus.CREATED).body(leagueResource);
    }

}

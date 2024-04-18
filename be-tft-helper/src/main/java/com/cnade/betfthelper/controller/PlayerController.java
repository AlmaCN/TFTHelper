package com.cnade.betfthelper.controller;

import com.cnade.betfthelper.command.CreatePlayerCommand;
import com.cnade.betfthelper.command.GetPlayerByIdWithCompsCommand;
import com.cnade.betfthelper.command.GetPlayerMatchCompCommand;
import com.cnade.betfthelper.command.ValidateNameCommand;
import com.cnade.betfthelper.entity.dto.PlayerDTOIn;
import com.cnade.betfthelper.entity.resource.PlayerMatchCompResource;
import com.cnade.betfthelper.entity.resource.PlayerResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private BeanFactory beanFactory;

    @PostMapping("/create")
    @Operation(summary = "Create new player")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Player created"),
            @ApiResponse(responseCode = "409", description = "Player already present")
    })
    public ResponseEntity<Void> createPlayer(@RequestBody PlayerDTOIn playerDTOIn) {
        beanFactory.getBean(CreatePlayerCommand.class).doExecute(playerDTOIn);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "Get player by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Player found"),
            @ApiResponse(responseCode = "404", description = "Player not found")
    })
    public ResponseEntity<PlayerResource> getPlayerByIdWithComps(@PathParam(value = "id") Integer id) {
        PlayerResource playerResource = beanFactory.getBean(GetPlayerByIdWithCompsCommand.class, id).doExecute();
        return ResponseEntity.ok(playerResource);
    }

    @GetMapping("/get")
    @Operation(summary = "Get player with match with comp")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Player found"),
            @ApiResponse(responseCode = "404", description = "Player not found")
    })
    public ResponseEntity<PlayerMatchCompResource> getPlayerMatchComp(@RequestParam String playerName) {
        PlayerMatchCompResource pmcr = beanFactory.getBean(GetPlayerMatchCompCommand.class, playerName).doExecute();
        return ResponseEntity.ok(pmcr);
    }

    @GetMapping("/validate-name")
    @Operation(summary = "Validate player name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Name available"),
            @ApiResponse(responseCode = "409", description = "Name already taken")
    })
    public ResponseEntity<String> validateName(@RequestParam String playerName) {
        String result = beanFactory.getBean(ValidateNameCommand.class, playerName).doExecute();
        return ResponseEntity.ok(result);
    }

}

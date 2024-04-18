package com.cnade.betfthelper.controller;

import com.cnade.betfthelper.command.CreateCompCommand;
import com.cnade.betfthelper.command.GetAllCompsCommand;
import com.cnade.betfthelper.entity.dto.CompDTOIn;
import com.cnade.betfthelper.entity.dto.GetAllCompsDTO;
import com.cnade.betfthelper.entity.resource.CompResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comp")
public class CompController {

    @Autowired
    private BeanFactory beanFactory;

    @PostMapping("/create")
    @Operation(summary = "Create new comp")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Comp created")
    })
    public ResponseEntity<Void> createComp(@RequestBody CompDTOIn compDTOIn) {
        beanFactory.getBean(CreateCompCommand.class, compDTOIn).doExecute();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/getAll")
    @Operation(summary = "Get all comps")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comp found"),
            @ApiResponse(responseCode = "404", description = "Comp not found")
    })
    public ResponseEntity<Page<CompResource>> getAllComps(@ParameterObject GetAllCompsDTO dto, @PageableDefault(size = 5) Pageable pageable) {
        Page<CompResource> page = beanFactory.getBean(GetAllCompsCommand.class, dto, pageable).doExecute();
        return ResponseEntity.ok(page);
    }

}

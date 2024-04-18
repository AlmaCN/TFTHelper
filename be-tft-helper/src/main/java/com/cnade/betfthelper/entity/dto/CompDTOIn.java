package com.cnade.betfthelper.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompDTOIn {
    private String playerName;
    private String compName;
    private List<String> startChamps;
    private char tier;
}

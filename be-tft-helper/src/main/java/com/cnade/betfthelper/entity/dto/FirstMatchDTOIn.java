package com.cnade.betfthelper.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirstMatchDTOIn {
    private String league;
    private int leagueTier;
    private boolean victory;
    private int lpMatch;
    private String compName;
    private String playerName;
}
